package top.sqyy;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import top.sqyy.domain.Student;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Classname TestMybatis
 * @Created by HCJ
 * @Date 2021/6/2 13:54
 */
public class TestMybatis {

    @Test
    public void testInsertStudent(){
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
        String sqlId = "top.sqyy.dao.StudentDao."+"insertStudent";
//        执行sql
        Student student = new Student();
        student.setId(1004);
        student.setName("花京院典明");
        student.setEmail("kakouyin@jojo.com");
        student.setAge(25);

        Integer result =  sqlSession.insert(sqlId,student);
//        手动提交事务
        sqlSession.commit();
        System.out.println("结果是"+result);
        sqlSession.close();


    }
}
