package com.example.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entity.ChatQa;
import com.example.form.ChatForm;
import com.example.service.ChatService;

@Controller
@RequestMapping("/chat")
public class ChatController {

    private final ChatService chatService;

    // ServiceをDIする（@Autowiredは省略）
    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    /**
     * 一覧画面に遷移する。
     */
    @GetMapping("/index")
    public String index(Model model) {
        List<ChatQa> chatQaList = chatService.findAll();
        model.addAttribute("chatQaList", chatQaList);
        model.addAttribute("chatForm", new ChatForm());

        return "chat/index";
    }

    /**
     * 質問に対する回答を取得する。
     * 回答取得後は一覧画面にリダイレクトする。
     */
    @PostMapping("/ask")
    public String ask(@Validated ChatForm chatForm, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            List<ChatQa> chatQaList = chatService.findAll();
            model.addAttribute("chatQaList", chatQaList);

            return "chat/index";
        }

        chatService.ask(chatForm.getQuestion());

        return "redirect:index";
    }
}
