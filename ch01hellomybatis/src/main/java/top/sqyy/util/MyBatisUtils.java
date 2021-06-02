package top.sqyy.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Classname MyBatisUtils
 * @Created by HCJ
 * @Date 2021/6/2 14:14
 */
public class MyBatisUtils {
    private static SqlSessionFactory  factory = null;


    static {
        InputStream in =null;
        String  config = "mybatis-config.xml";
        try {
            in =  Resources.getResourceAsStream(config);
//            创建
            factory= new SqlSessionFactoryBuilder().build(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSession getSqlSession (){
        SqlSession sqlSession =null;
        if (factory!=null){
//            非自动提交
            sqlSession = factory.openSession();
        }

        return sqlSession;
    }
}
