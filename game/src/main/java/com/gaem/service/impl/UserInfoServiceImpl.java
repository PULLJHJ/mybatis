package com.gaem.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.gaem.common.MybatisSqlSessionFactory;
import com.gaem.dao.UserInfoDAO;
import com.gaem.dao.impl.UserInfoDAOImpl;
import com.gaem.mapper.UserInfoMapper;
import com.gaem.service.UserInfoService;
import com.gaem.vo.UserInfoVO;
import com.google.gson.Gson;

public class UserInfoServiceImpl implements UserInfoService {
	private UserInfoDAO uiDAO = new UserInfoDAOImpl();
	private SqlSessionFactory ssf = MybatisSqlSessionFactory.getSqlSessionFactory();
	
	@Override
	public List<UserInfoVO> selectUserInfoList(UserInfoVO userInfo) {
		try(SqlSession session = ssf.openSession()){
			UserInfoMapper uiMapper = session.getMapper(UserInfoMapper.class);
			return uiMapper.selectUserInfoList(userInfo);
		}catch(Exception e) {
			throw e;
		}
	}

	@Override
	public Map<String, String> selectUserInfo(String uiNum) {
		return uiDAO.selectUserInfo(uiNum);
	}

	@Override
	public int insertUserInfo(Map<String, String> userInfo) {
		return uiDAO.insertUserInfo(userInfo);
	}

	@Override
	public int updateUserInfo(Map<String, String> userInfo) {
		return uiDAO.updateUserInfo(userInfo);
	}

	@Override
	public int deleteUserInfo(String uiNum) {
		return uiDAO.deleteUserInfo(uiNum);
	}

	@Override
	public Map<String,String> login(String uiId) {
		return uiDAO.selectUserInfoById(uiId);
	}

}