package com.example.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.entity.ChatQa;
import com.example.service.ChatService;

@Controller // (1)@Controller
public class RootController {

	private ChatService chatService;

	public RootController(ChatService chatService) {
		this.chatService = chatService;
	}
	
	@GetMapping("/") // (2)@GetMapping
	public String root() {
		return "redirect:chat/index";
	}

	@GetMapping("/index") // (2)@GetMapping
	public String index(Model model) {

		// Serviceからデータを取得し、Viewへ渡す処理
		if (chatService != null) {
			List<ChatQa> chatQaList = chatService.findAll();
			model.addAttribute("chatQaList", chatQaList);
		}

		return "index";
	}
}
