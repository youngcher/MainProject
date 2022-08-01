package com.mac.demo.service;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.mac.demo.mappers.BoardMapper;
import com.mac.demo.model.Board;
import com.mac.demo.model.Comment;

@Service
public class BoardService {

	@Autowired
	private BoardMapper dao;

	public Page<Board> getListByPage(Pageable pageable) {
		return null;
	}
	
	public boolean save(Board board){
		return 0 < dao.save(board);
	}
	
	public List<Board> getList(){
		return dao.getList();
	}
	
	public List<Comment> getCommentList(int num){
		return dao.getCommentList(num);		
	}
	
	public Board getDetail(int num) {
		return dao.getDetail(num);
	}
	
	public boolean delete(int num) {
		return 0 < dao.delete(num);
	}
	
	public boolean edit(Board board) {
		return 0 < dao.edit(board);
	}
	
	public boolean commentsave(Comment comment) {
		return 0 < dao.commentsave(comment);	
	}
}
