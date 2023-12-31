package com.gaem.dao;

import java.util.List;
import java.util.Map;

public interface BoardInfoDAO {		
		List<Map<String,String>> selectBoardInfoList(Map<String,String> board);
		Map<String,String> selectBaordInfo(String biNum);
		int insertBoardInfo(Map<String,String> board);
		int updateBaordInfo(Map<String,String> baord);
		int deleteBaordInfo(String biNum);
}
