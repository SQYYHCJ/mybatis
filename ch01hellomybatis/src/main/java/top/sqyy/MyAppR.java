package top.sqyy;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import top.sqyy.domain.Student;
import top.sqyy.util.MyBatisUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Classname MyApp
 * @Created by HCJ
 * @Date 2021/6/2 12:42
 */
public class MyAppR {
    public static void main(String[] args) {

        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        String sqlId = "top.sqyy.dao.StudentDao."+"selectStudents";
//        执行sql
        List<Student> studentList =  sqlSession.selectList(sqlId);
         studentList.forEach(stu -> System.out.println(stu));
        sqlSession.close();



    }
}
