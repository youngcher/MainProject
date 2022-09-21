package com.mac.demo.admin;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mac.demo.model.Attach;
import com.mac.demo.model.Board;
import com.mac.demo.model.Comment;
import com.mac.demo.model.User;

@Mapper
public interface AdminMapper {

	List<User> findAllUser();

	List<Board> findAllFreeBoard();

	List<Board> findAllAdsBoard();
	
	List<Board> findAllNoticeBoard();
	
	List<Comment> findAllCommentBoard();

	boolean boardDeleted(int numMac);

	

	boolean userDeleted(int numMac);

	int saveNotice(Board board);
	int insertNoticeMultiAttach(List<Attach> attList);


	boolean noticeBoardDeleted(int numMac);
	
	boolean commentBoardDeleted(int numMac);
	//광고 검색
	List<Board> getAdsListByKeyword(String keyword);
	List<Board> getAdsListByNickName(String nickNameMac);
	
	List<Board> getfreeListByKeyword(String keyword);
	List<Board> getfreeListByNickName(String nickNameMac);
	
    //공지사항 검색
	List<Board> getNoticeListByKeyword(String keyword);
	

	//댓글 검색
	List<Comment> getCommentListByKeyword(String keyword);
	List<Comment> getCommentListByNickName(String keyword);

	//유저 검색
	List<User> getUserListByKeyword(String keyword);
	
	
	
	//메인서비스의 공지사항 서비스
	Board getNoticeDetail(int num);
	List<Attach> getNoticeFileList(int pcodeMac);
	String getNoticeFname(int num);

}