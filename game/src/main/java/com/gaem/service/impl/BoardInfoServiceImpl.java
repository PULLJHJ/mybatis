package com.gaem.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.gaem.common.MybatisSqlSessionFactory;
import com.gaem.dao.BoardInfoDAO;
import com.gaem.dao.impl.BoardInfoDAOImpl;
import com.gaem.mapper.BoardInfoMapper;
import com.gaem.service.BoardInfoService;
import com.gaem.vo.BoardInfoVO;

public class BoardInfoServiceImpl implements BoardInfoService {
	private BoardInfoDAO biDAO = new BoardInfoDAOImpl();
	private SqlSessionFactory ssf = MybatisSqlSessionFactory.getSqlSessionFactory();

	@Override
	public List<BoardInfoVO> selectBoardInfoList(BoardInfoVO board) {
		try(SqlSession session = ssf.openSession()){
			BoardInfoMapper biMapper = session.getMapper(BoardInfoMapper.class);
			return biMapper.selectBoardInfoList(board);
		}catch(Exception e) {
			throw e;
		}
	}

	@Override
	public BoardInfoVO selectBaordInfo(String biNum) {
		try(SqlSession session = ssf.openSession()){
			BoardInfoMapper biMapper = session.getMapper(BoardInfoMapper.class);
			return biMapper.selectBoardInfo(biNum);
		}catch(Exception e) {
			throw e;
		}
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
