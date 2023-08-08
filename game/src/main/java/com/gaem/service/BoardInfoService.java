package com.gaem.service;

import java.util.List;
import java.util.Map;

import com.gaem.vo.BoardInfoVO;

public interface BoardInfoService {
	
	List<BoardInfoVO> selectBoardInfoList(BoardInfoVO board);
	BoardInfoVO selectBaordInfo(String biNum);
	int insertBoardInfo(Map<String,String> board);
	int updateBaordInfo(Map<String,String> baord);
	int deleteBaordInfo(String biNum);

}
