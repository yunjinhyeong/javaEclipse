package com.exam.dao;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtils {

	private static SqlSessionFactory sqlSessionFactory;
	
	// static 초기화 블럭
	static {
		
//		InputStream is = null;
		
		// 자바 7버전부터 try-with-resources 문법 제공
		try (InputStream is = Resources.getResourceAsStream("mybatis-config.xml")) {
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		
		
//		try {
//			Resources.getResourceAsStream("mybatis-config.xml");
//			sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				is.close();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
	} // static

	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
	
}
