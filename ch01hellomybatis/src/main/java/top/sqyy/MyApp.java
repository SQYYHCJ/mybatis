package top.sqyy;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import top.sqyy.domain.Student;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Classname MyApp
 * @Created by HCJ
 * @Date 2021/6/2 12:42
 */
public class MyApp {
    public static void main(String[] args) {
//        访问mybatis
//        定义主配置文件
        InputStream in =null;
        String config = "mybatis-config.xml";
//        读取文件
        try {
            in =  Resources.getResourceAsStream(config);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

        SqlSessionFactory factory = builder.build(in);
//        获取sqlSession对象
        SqlSession sqlSession = factory.openSession();
        String sqlId = "top.sqyy.dao.StudentDao."+"selectStudents";
//        执行sql
        List<Student> studentList =  sqlSession.selectList(sqlId);
         studentList.forEach(stu -> System.out.println(stu));
        sqlSession.close();



    }
}
