package com.kh.springDB.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.kh.springDB.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@GetMapping("boardList")
	public String displayBoardList(Model model) {
		model.addAttribute("boards",boardService.getAllBoard());
		return "boardList";
	}
}
