package top.sqyy.dao;

import top.sqyy.domain.Student;

import java.util.List;

/**
 * @Classname StudentDao
 * @Created by HCJ
 * @Date 2021/6/2 10:55
 */

//操作接口
public interface StudentDao {

//    查询所有数据
    public List<Student> selectStudents();
    public int insertStudent(Student student);

}
