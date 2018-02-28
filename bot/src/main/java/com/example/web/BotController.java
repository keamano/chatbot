package com.example.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entity.BotQa;
import com.example.form.BotForm;
import com.example.service.BotService;

@Controller
@RequestMapping("/bot")
public class BotController {

    private final BotService botService;

    // ServiceをDIする（@Autowiredは省略）
    public BotController(BotService botService) {
        this.botService = botService;
    }

    /**
     * 一覧画面に遷移する。
     */
    @GetMapping("/index")
    public String index(Model model) {
        List<BotQa> botQaList = botService.findAll();
        model.addAttribute("botQaList", botQaList);

        return "bot/index";
    }

    /**
     * 一覧画面に遷移する。
     */
    @GetMapping("/edit")
    public String edit(@RequestParam(name = "id", required = false) Integer id, Model model) {
        BotQa botQa;
        if (id == null) {
            botQa = new BotQa("", "");
        } else {
            botQa = botService.findById(id);
        }

        model.addAttribute("botQa", botQa);

        return "bot/edit";
    }

    /**
     * 入力を受け取り、新規登録処理を実行する。 処理完了後は、一覧画面にリダイレクトする。
     */
    @PostMapping(value = "/complete", params = "insert")
    public String insertCmplete(BotForm botForm) {
        BotQa botQa = botForm.convertToEntity();

        botService.insert(botQa);

        return "redirect:index";
    }

    /**
     * 入力を受け取り、更新処理を実行する。 処理完了後は、一覧画面にリダイレクトする。
     */
    @PostMapping(value = "/complete", params = "update")
    public String updateCmplete(BotForm botForm) {
        BotQa botQa = botForm.convertToEntity();

        botService.update(botQa);

        return "redirect:index";
    }

    /**
     * 入力を受け取り、削除処理を実行する。 処理完了後は、一覧画面にリダイレクトする。
     */
    @PostMapping(value = "/complete", params = "delete")
    public String deleteCmplete(BotForm botForm) {
        BotQa botQa = botForm.convertToEntity();

        botService.delete(botQa);

        return "redirect:index";
    }
}
