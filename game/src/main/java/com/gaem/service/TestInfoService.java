package com.gaem.service;

import java.util.List;

import com.gaem.vo.TestInfoVO;

public interface TestInfoService {

	List<TestInfoVO> selectTestInfoList(TestInfoVO testInfo);
}
