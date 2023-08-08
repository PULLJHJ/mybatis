package com.gaem.mapper;

import java.util.List;

import com.gaem.vo.TestInfoVO;

public interface TestInfoMapper {

	List<TestInfoVO> selectTestInfoList(TestInfoVO test);
}
