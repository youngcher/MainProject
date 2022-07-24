package com.mac.demo.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mac.demo.mappers.UserMapper;
import com.mac.demo.model.User;

@Controller
@RequestMapping("/user")
public class UserController {
	
	//유저 맵퍼
	@Autowired
	private UserMapper dao;

//	계정추가폼
	@GetMapping("/add")
	public String add() {
		
		return "thymeleaf/mac/addForm";
	}
	
//	계정추가
	@PostMapping
	@ResponseBody
	public Map<String,Object> add(User user) {
		
		Map<String,Object> map=new HashMap<String,Object>();
		
		boolean add=dao.add(user)>0;
		map.put("add", add);
		
		return map;
	}
	
//	계정 삭제
	@PostMapping("/delete")
	@ResponseBody
	public Map<String,Object> delete(@PathVariable("uid")String uid, HttpSession session ,Model model) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		boolean deleted = dao.delete(uid);
		model.addAttribute("board", dao.delete(uid));
		return map;
	}
	
//	마이페이지
	@GetMapping("/detail/{uid}")
	public String mypage(@PathVariable("uid") String uid, Model model) {
		
		User user = new User();
		user.setUid(uid);
		model.addAttribute("user", dao.getMypage(uid));
		return "thymeleaf/mac/mypage";
	}
	
//  유저 업데이트폼
	@GetMapping("/update/{uid}")
	public String update(@PathVariable("uid") String uid, Model model) {

		User user = new User();
		user.setUid(uid);
		model.addAttribute("board", dao.edit(user));
		
		return "thymeleaf/mac/mypage2";
	}
//  유저 정보 수정
	@GetMapping("/edit/{num}")
	@ResponseBody
	public Map<String, Object> edit(@PathVariable("uid") String uid, User newUser, Model model) {

		newUser.setUpw(uid);
		newUser.setUpw(newUser.getUpw());
		newUser.setEmail(newUser.getEmail());
		newUser.setCity(newUser.getCity());
		newUser.setTown(newUser.getTown());
		newUser.setVillage(newUser.getVillage());

		Map<String, Object> map = new HashMap<String, Object>();
		boolean updated = dao.edit(newUser)>0;
		map.put("updated", updated);
		return map;
	}
	
	
}
