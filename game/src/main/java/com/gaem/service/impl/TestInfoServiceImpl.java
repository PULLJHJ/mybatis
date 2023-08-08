package com.gaem.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.gaem.common.MybatisSqlSessionFactory;
import com.gaem.mapper.TestInfoMapper;
import com.gaem.service.TestInfoService;
import com.gaem.vo.TestInfoVO;

public class TestInfoServiceImpl implements TestInfoService{
	private SqlSessionFactory ssf = MybatisSqlSessionFactory.getSqlSessionFactory();

	@Override
	public List<TestInfoVO> selectTestInfoList(TestInfoVO testInfo) {
		try(SqlSession session = ssf.openSession()){
			TestInfoMapper tiMapper = session.getMapper(TestInfoMapper.class);
			return tiMapper.selectTestInfoList(testInfo);
		}catch(Exception e) {
			throw e;
		}
	}
}
