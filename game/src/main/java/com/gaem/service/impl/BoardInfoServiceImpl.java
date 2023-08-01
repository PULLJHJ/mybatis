package com.gaem.service.impl;

import java.util.List;
import java.util.Map;

import com.gaem.dao.BoardInfoDAO;
import com.gaem.dao.impl.BoardInfoDAOImpl;
import com.gaem.service.BoardInfoService;

public class BoardInfoServiceImpl implements BoardInfoService {
	private BoardInfoDAO biDAO = new BoardInfoDAOImpl();

	@Override
	public List<Map<String, String>> selectBoardInfoList(Map<String, String> board) {
		return biDAO.selectBoardInfoList(board);
	}

	@Override
	public Map<String, String> selectBaordInfo(String biNum) {
		return biDAO.selectBaordInfo(biNum);
	}

	@Override
	public int insertBoardInfo(Map<String, String> board) {
		return biDAO.insertBoardInfo(board);
	}

	@Override
	public int updateBaordInfo(Map<String, String> baord) {
		return biDAO.updateBaordInfo(baord);
	}

	@Override
	public int deleteBaordInfo(String biNum) {
		return biDAO.deleteBaordInfo(biNum);
	}

}
