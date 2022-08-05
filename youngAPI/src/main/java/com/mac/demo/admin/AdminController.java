package com.mac.demo.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mac.demo.model.Board;
import com.mac.demo.model.Comment;
import com.mac.demo.model.User;

@Controller
public class AdminController {
	

	@Autowired
	private AdminService svc;
	
	
	
	//관리자 페이지 메인
		@GetMapping("/admin")
		public String adminMain() {
			return "thymeleaf/mac/admin/adminMain";
		}
		

		@GetMapping("/admin/loginForm")
		public String adminLogin() {
		
			
			return "thymeleaf/mac/admin/adminLoginForm";
		}
	
	
	@GetMapping("/err")
	public String adminLogin(@RequestParam("error") String err,Model model) {
		model.addAttribute("msg", err);
		
		return "thymeleaf/mac/admin/adminLoginForm";
	}
	
	
	
    //모든 유저 정보
	@GetMapping("/admin/allUser")
	public String allUser(Model model,@RequestParam(name="page", required = false,defaultValue ="1") int page) {
		
		//페이지를 설정하면 처음으로 뜰 화면을 기본1로 설정하여 startPage에 넣어준다
	     PageHelper.startPage(page, 2);
			//startPage시작하는 페이지 넘버와 그 페이지에 얼마의 글이 들어갈지를 정한다.
			PageInfo<User> pageInfo = new PageInfo<>(svc.findAllUser());
			List<User> list= pageInfo.getList();
			 model.addAttribute("pageInfo", pageInfo);
             return "thymeleaf/mac/admin/allUser";
	}
	
	//모든 자유게시판
	@GetMapping("/admin/allFreeBoard")
	public String allFreeBord(Model model,@RequestParam(name="page", required = false,defaultValue ="1") int page) {
		//페이지를 설정하면 처음으로 뜰 화면을 기본1로 설정하여 startPage에 넣어준다
	     PageHelper.startPage(page, 2);
			//startPage시작하는 페이지 넘버와 그 페이지에 얼마의 글이 들어갈지를 정한다.
			PageInfo<Board> pageInfo = new PageInfo<>(svc.findAllFreeBord());
			List<Board> list= pageInfo.getList();
			 model.addAttribute("pageInfo", pageInfo);
		return "thymeleaf/mac/admin/allFreeBoard";
	}
	
	//모든 광고게시판
	@GetMapping("/admin/allAdsBoard")
	public String allAdsBoard(Model model,@RequestParam(name="page", required = false,defaultValue ="1") int page) {
		//페이지를 설정하면 처음으로 뜰 화면을 기본1로 설정하여 startPage에 넣어준다
	     PageHelper.startPage(page, 2);
			//startPage시작하는 페이지 넘버와 그 페이지에 얼마의 글이 들어갈지를 정한다.
			PageInfo<Board> pageInfo = new PageInfo<>(svc.findAllAdsBoard());
			List<Board> list= pageInfo.getList();
			 model.addAttribute("pageInfo", pageInfo);
		return "thymeleaf/mac/admin/allAdsBoard";
	}
	
	
	
	@GetMapping("/admin/userDeleted/{numMac}")
	@ResponseBody
	public Map<String,Object> UserDeleted(@PathVariable("numMac")int numMac, HttpSession session) {
		Map<String, Object> map = new HashMap<>();
		boolean result = svc.userDeleted(numMac);
		map.put("result", result);
		return map;
	}
	
//	계정 삭제
	@GetMapping("/admin/freeBoardDeleted/{numMac}")
	@ResponseBody
	public Map<String,Object> freeBoardDeleted(@PathVariable("numMac")int numMac, HttpSession session) {
		Map<String, Object> map = new HashMap<>();
		System.out.println("1111");
		
		boolean result = svc.freeBordDeleted(numMac);
		map.put("result", result);
		return map;
	}
//	계정 삭제
	@GetMapping("/admin/adsBoardDeleted/{numMac}")
	@ResponseBody
	public Map<String,Object> adsBoardDeleted(@PathVariable("numMac")int numMac, HttpSession session) {
		Map<String, Object> map = new HashMap<>();
		
		boolean result = svc.adsBoardDeleted(numMac);
		map.put("result", result);
		return map;
	}
	
	@GetMapping("/admin/writeNotice")
	public String writeNotice() {
	
		
		return "thymeleaf/mac/admin/writeNotice";
	}
	@PostMapping("/admin/save")
	@ResponseBody
	public Map<String, Object> save(Board board) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("saved",svc.save(board)>0);
		return map;
	}
	
	//모든 광고게시판
	@GetMapping("/admin/allNoticeBoard")
	public String allNoticeBoard(Model model,@RequestParam(name="page", required = false,defaultValue ="1") int page) {
		//페이지를 설정하면 처음으로 뜰 화면을 기본1로 설정하여 startPage에 넣어준다
	     PageHelper.startPage(page, 2);
			//startPage시작하는 페이지 넘버와 그 페이지에 얼마의 글이 들어갈지를 정한다.
			PageInfo<Board> pageInfo = new PageInfo<>(svc.findAllNoticeBoard());
			List<Board> list= pageInfo.getList();
			 model.addAttribute("pageInfo", pageInfo);
		return "thymeleaf/mac/admin/allNoticeBoard";
	}
	
//	계정 삭제
	@GetMapping("/admin/noticeBoardDeleted/{numMac}")
	@ResponseBody
	public Map<String,Object> noticeBoardDeleted(@PathVariable("numMac")int numMac, HttpSession session) {
		Map<String, Object> map = new HashMap<>();
		
		boolean result = svc.noticeBordDeleted(numMac);
		map.put("result", result);
		return map;
	}
	
	
	//모든 광고게시판
		@GetMapping("/admin/allCommentBoard")
		public String allCommentBoard(Model model,@RequestParam(name="page", required = false,defaultValue ="1") int page) {
			//페이지를 설정하면 처음으로 뜰 화면을 기본1로 설정하여 startPage에 넣어준다
		     PageHelper.startPage(page, 2);
				//startPage시작하는 페이지 넘버와 그 페이지에 얼마의 글이 들어갈지를 정한다.
				PageInfo<Comment> pageInfo = new PageInfo<>(svc.findAllCommentBoard());
				List<Comment> list= pageInfo.getList();
				 model.addAttribute("pageInfo", pageInfo);
			return "thymeleaf/mac/admin/allCommentBoard";
		}
		
//		계정 삭제
		@GetMapping("/admin/commentBoardDeleted/{numMac}")
		@ResponseBody
		public Map<String,Object> commentBoardDeleted(@PathVariable("numMac")int numMac, HttpSession session) {
			Map<String, Object> map = new HashMap<>();
			
			boolean result = svc.commentBordDeleted(numMac);
			map.put("result", result);
			return map;
		}

}