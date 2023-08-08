package com.gaem.mapper;

import java.util.List;

import com.gaem.vo.UserInfoVO;

public interface UserInfoMapper {	
	List<UserInfoVO> selectUserInfoList(UserInfoVO user);
	
}
