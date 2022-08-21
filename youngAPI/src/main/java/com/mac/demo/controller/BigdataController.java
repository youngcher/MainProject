package com.mac.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mac.demo.service.BigdataService;

@Controller
@RequestMapping("/big")
public class BigdataController {

	@Autowired
	private BigdataService svc;
	
	@GetMapping("/location")
	public String location(Model model) {
		List<String> silist = svc.getsi();
		model.addAttribute("silist", silist);
		return "thymeleaf/mac/bigdata/location";
	}
	
	@PostMapping("/dong")
	@ResponseBody
	public Map<String,Object> dong(@RequestParam("si")String si) {
		Map<String, Object> map = new HashMap<>();
		List<String> donglist = svc.getdong(si);
		List<String> donglist2 = new ArrayList<>();
		for(int i=0; i<donglist.size(); i++) {
			String dong2 = "<option>"+donglist.get(i)+"</option>";
			donglist2.add(dong2);
		}
		map.put("donglist", donglist2);
		return map;
	}
	
	@PostMapping("/gil")
	@ResponseBody
	public Map<String,Object> gil(@RequestParam("dong")String dong) {
		Map<String, Object> map = new HashMap<>();
		List<String> gillist = svc.getgil(dong);
		List<String> gillist2 = new ArrayList<>();
		for(int i=0; i<gillist.size(); i++) {
			String dong2 = "<option>"+gillist.get(i)+"</option>";
			gillist2.add(dong2);
		}
		map.put("donglist", gillist2);
		return map;
	}
}
