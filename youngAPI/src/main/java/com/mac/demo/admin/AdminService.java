package com.mac.demo.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.mac.demo.mappers.BoardMapper;
import com.mac.demo.model.Board;
import com.mac.demo.model.Comment;
import com.mac.demo.model.User;

@Service
public class AdminService {
	
	@Autowired 
	private AdminMapper dao;
	


	public List<User> findAllUser() {
		return dao.findAllUser();
		
	}

	public List<Board> findAllFreeBord() {
		
		return dao.findAllFreeBoard();
	}

	public List<Board>findAllAdsBoard() {
	
		return dao.findAllAdsBoard();
	}

	public boolean freeBordDeleted(int numMac) {
		return dao.freeBordDeleted(numMac);
	}

	public boolean adsBoardDeleted(int numMac) {
	
		return  dao.adsBordDeleted(numMac);
	}

	public boolean userDeleted(int numMac) {
		
		return dao.userDeleted(numMac);
	}

	public int save(Board board) {
		
		return dao.saveNotice(board);
	}

	public List<Board> findAllNoticeBoard() {

		return dao.findAllNoticeBoard();
	}

	public boolean noticeBordDeleted(int numMac) {
	
		return dao.noticeBoardDeleted(numMac);
	}

	public List<Comment> findAllCommentBoard() {
		
		return dao.findAllCommentBoard();
	}

	public boolean commentBordDeleted(int numMac) {
		
		return dao.commentBoardDeleted(numMac);
	}


}