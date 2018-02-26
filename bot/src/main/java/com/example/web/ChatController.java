package com.example.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entity.Bot;
import com.example.entity.Chat;
import com.example.service.BotService;
import com.example.service.ChatService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/chat")
public class ChatController {

    private final ChatService chatService;
    
    private final BotService botService;

    // EmployeeServiceをDIする（@Autowiredは省略）
    public ChatController(ChatService chatService, BotService botService) {
        this.chatService = chatService;
        this.botService = botService;
    }

    /**
     * 一覧画面に遷移する。
     */
    @GetMapping("/index")
    public String index(Model model) {
        List<Chat> chatList = chatService.findAll();
        
		List<ChatForm> chatFormList = new ArrayList<ChatForm>();
		for (Chat chat : chatList) {
			ChatForm chatForm = new ChatForm();
			chatForm.setQuestion(chat.getQuestion());
			chatForm.setAnswer(chat.getAnswer());
			chatFormList.add(chatForm);
		}
        
        model.addAttribute("chatList", chatFormList);
        return "chat/index";
    }

    /**
     * 入力を受け取り、追加を実行する。
     * 追加処理完了後は、一覧画面にリダイレクトする。
     */
    @PostMapping("/complete")
    public String complete(ChatForm chatForm) {
        Chat chat = chatForm.convertToEntity();
        
		Bot bot = botService.findByQuestion(chat.getQuestion());
        chat.setAnswer(bot.getAnswer());
		chatService.insert(chat);

        return "redirect:index";
    }
}