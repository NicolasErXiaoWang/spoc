package cn.edu.tit.idao;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.edu.tit.bean.Accessory;
import cn.edu.tit.bean.Course;
import cn.edu.tit.bean.Student;
import cn.edu.tit.bean.Task;
import cn.edu.tit.bean.Teacher;
import cn.edu.tit.bean.VirtualClass;

@Component
public interface ITeacherDao {

	//public void createCourse(Course course);	//创建课程模块，不再为教师提供该功能
	//public void deleteCourse(Integer courseId);	//删除课程模块，不再为教师提供该功能
	public void createVirtualClass(VirtualClass virtualClass);		//创建虚拟班级模块
	//public void updateCourse(Course course);	//修改课程模块，不再为教师提供该功能
	public List<Integer> courseIdList(String employeeNum);		//课程id列表模块
	public List<Course>	 courseList(List<Integer> courseIds);	//根据课程ID列表查询课程实体列表
	public List<Student> studentList(List<String> classNums);		//学生列表模块
	public Student searchStudent(String studentId);		//查看学生信息模块
	public List<String> searchRealClassNum(String virtualClassNum);		//查询虚拟班级对应的自然班列表模块
	public void mapVirtualRealClass(@Param("realClassNum")String realClassNum,@Param("virtualClassNum")String virtualClassNUm);	//创建虚拟班和自然班映射模块

	public Teacher teacherLoginByEmployeeNum(String employeeNum);	//通过职工号登录教师
	public Teacher teacherLoginByTelephone(String telephone);	//通过手机号登录教师
	public Teacher teacherLoginByEmail(String email);	//通过邮件登录教师
	
	public void createTask(Task task);	//创建任务
	public void stopTask(String taskId);	//截止任务
	public void restartTask(String taskId);	//重新启动任务，任务未过期
	public void restartTaskSetEndTime(@Param("taskId")String taskId,@Param("taskEndTime")Timestamp taskEndTime);	//重新启动任务，任务过期
	public void deleteTask(String taskId);	//删除任务
	public void mapClassTask(@Param("virtualClassNum")String virtualClassNum,@Param("taskId")String taskId);	//把任务映射到班级任务表中
	public void addAccessory(List<Accessory> accessoris);	//添加附件
	public List<String> searchTaskId(String virtualClassNum);//查找班级对应的taskid号
	public List<Task> TaskList(List<String> taskIds);	//显示所有任务列表
	public Task searchTask(String taskId);	//查看单个任务详情
	public Accessory searchAccessory(String taskId);	//查询任务附件
	public void createSignInPoint(@Param("taskId")String taskId,@Param("signPoint")String signPoint);	//wei实现

	/**
	 * 更新教师模块
	 * */
	public void UpdateTeacher(Teacher teacher);
}
