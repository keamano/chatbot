package com.example.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entity.QuestionAndAnswer;
import com.example.service.ChatBotAdminService;

@Controller
@RequestMapping("/chatBotAdmin")
public class ChatBotAdminController {

    private final ChatBotAdminService chatBotAdminService;

    // EmployeeServiceをDIする（@Autowiredは省略）
    public ChatBotAdminController(ChatBotAdminService chatBotAdminService) {
        this.chatBotAdminService = chatBotAdminService;
    }

    /**
     * 一覧画面に遷移する。
     */
    @GetMapping("/index")
    public String index(Model model) {
        List<QuestionAndAnswer> questionAndAnswerList = chatBotAdminService.findAll();
        model.addAttribute("questionAndAnswerList", questionAndAnswerList);

        return "chatBotAdmin/index";
    }

    /**
     * 一覧画面に遷移する。
     */
    @GetMapping("/edit")
    public String edit(@RequestParam(name = "id", required = false) Integer id, Model model) {
        QuestionAndAnswer questionAndAnswer;
        if (id == null) {
            questionAndAnswer = new QuestionAndAnswer("", "");
        } else {
            questionAndAnswer = chatBotAdminService.findById(id);
        }

        model.addAttribute("questionAndAnswer", questionAndAnswer);

        return "chatBotAdmin/edit";
    }

    /**
     * 入力を受け取り、新規登録処理を実行する。 処理完了後は、一覧画面にリダイレクトする。
     */
    @PostMapping(value = "/complete", params = "insert")
    public String insertCmplete(QuestionAndAnswerForm questionAndAnswerForm) {
        QuestionAndAnswer questionAndAnswer = questionAndAnswerForm.convertToEntity();

        chatBotAdminService.insert(questionAndAnswer);

        return "redirect:index";
    }

    /**
     * 入力を受け取り、更新処理を実行する。 処理完了後は、一覧画面にリダイレクトする。
     */
    @PostMapping(value = "/complete", params = "update")
    public String updateCmplete(QuestionAndAnswerForm questionAndAnswerForm) {
        QuestionAndAnswer questionAndAnswer = questionAndAnswerForm.convertToEntity();

        chatBotAdminService.update(questionAndAnswer);

        return "redirect:index";
    }

    /**
     * 入力を受け取り、削除処理を実行する。 処理完了後は、一覧画面にリダイレクトする。
     */
    @PostMapping(value = "/complete", params = "delete")
    public String deleteCmplete(QuestionAndAnswerForm questionForm) {
        QuestionAndAnswer question = questionForm.convertToEntity();

        chatBotAdminService.delete(question);

        return "redirect:index";
    }
}
