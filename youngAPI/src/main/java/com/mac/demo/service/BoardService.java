package com.mac.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.mac.demo.mappers.BoardMapper;
import com.mac.demo.mappers.UserMapper;
import com.mac.demo.model.Board;
import com.mac.demo.model.Comment;
import com.mac.demo.model.User;

@Service
public class BoardService {

	@Autowired
	private BoardMapper boardDao;
	
	@Autowired
	private UserMapper userDao;
	
	
	public List<Board> getFreeList(){
		return boardDao.getFreeList();
	}
	
	public List<Board> getNoticeList() {
		return boardDao.getNoticeList();
	}
	
	public List<Board> getAdsList() {
		return boardDao.getAdsList();
	}

//	------------------id로 유저정보 가져오기-------------------    
	public User getOne(String idMac) {
		return userDao.getOne(idMac);
	}
	
	public boolean saveToFree(Board board){
		return 0 < boardDao.saveToFree(board);
	}
	public boolean saveToAds(Board board){
		return 0 < boardDao.saveToAds(board);
	}
	
	
	public Board getDetail(int num) {
		return boardDao.getDetail(num);
	}
	
	public boolean delete(int num) {
		return 0 < boardDao.delete(num);
	}
	
	public boolean edit(Board board) {
		return 0 < boardDao.edit(board);
	}
//	-----------------------댓글-----------------------
	public List<Comment> getCommentList(int num){
		return boardDao.getCommentList(num);		
	}
	
	public boolean commentsave(Comment comment) {
		return 0 < boardDao.commentsave(comment);	
	}
	
	public boolean commentdelete(int numMac) {
		return 0 < boardDao.commentdelete(numMac);
	}

//	-----------------------검색-----------------------	
	public List<Board> getFreeListByKeyword(String titleMac){
		return boardDao.getFreeListByKeyword(titleMac);
	}

	public List<Board> getFreeListByNickName(String nickNameMac) {
		return boardDao.getFreeListByNickName(nickNameMac);
	}

	
	
//	------------------------------------------------
	public int[] getLinkRange(Page<Board> pageInfo) {
		int start = 0;
		int end = 0;
		
		if (pageInfo.getNumber() - 2 < 0) {
			start = 0;
		} else {
			start = pageInfo.getNumber() - 2;
		}
		
		if (pageInfo.getTotalPages() < (start + 4)) {
			end = pageInfo.getTotalPages();
			start = (end - 4) < 0 ? 0 : (end - 4);
		} else {
			end = start + 4;
		}
		return new int[] { start, end };
	}


}
