	package com.gaem.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.gaem.mapper.UserInfoMapper;
import com.gaem.vo.UserInfoVO;

public class MybatisSqlSessionFactory {
	
	private static SqlSessionFactory SSF;
	private final static String CONFIG_PATH = "config/mybatis-config.xml";
	static {
		try {
			InputStream is = Resources.getResourceAsStream(CONFIG_PATH); 
			SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
			SSF = ssfb.build(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static SqlSessionFactory getSqlSessionFactory() {
		return SSF;
	}
	public static void main(String[] args) {
		SqlSessionFactory ssf = MybatisSqlSessionFactory.getSqlSessionFactory();
		SqlSession session = ssf.openSession();
		UserInfoMapper uiMapper = session.getMapper(UserInfoMapper.class);
		List<UserInfoVO> list = uiMapper.selectUserInfoList(null);
		System.out.println(list);
	}
}
