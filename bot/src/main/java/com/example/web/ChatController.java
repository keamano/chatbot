package com.example.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entity.ChatHistory;
import com.example.service.ChatService;

@Controller
@RequestMapping("/chat")
public class ChatController {

    private final ChatService chatService;

    // EmployeeServiceをDIする（@Autowiredは省略）
    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    /**
     * 一覧画面に遷移する。
     */
    @GetMapping("/index")
    public String index(Model model) {
        List<ChatHistory> chatHistoryList = chatService.findAllHistory();
        model.addAttribute("chatHistoryList", chatHistoryList);
        return "chat/index";
    }

    /**
     * 質問に対する回答を取得する。
     * 回答取得後は一覧画面にリダイレクトする。
     */
    @PostMapping("/ask")
    public String ask(ChatForm chatForm) {
        chatService.ask(chatForm.getQuestion());

        return "redirect:index";
    }
}
