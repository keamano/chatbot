package com.example.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entity.Bot;
import com.example.service.BotService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/bot")
public class BotController {

	private final BotService botService;

	// EmployeeServiceをDIする（@Autowiredは省略）
	public BotController(BotService botService) {
		this.botService = botService;
	}

	/**
	 * 一覧画面に遷移する。
	 */
	@GetMapping("/index")
	public String index(Model model) {
		List<Bot> botList = botService.findAll();
		
		List<BotForm> botFormList = new ArrayList<BotForm>();
		for (Bot bot : botList) {
			BotForm botForm = new BotForm();
			botForm.setId(bot.getId());
			botForm.setQuestion(bot.getQuestion());
			botForm.setAnswer(bot.getAnswer());
			botFormList.add(botForm);
		}
		
		model.addAttribute("botList", botFormList);
		
		return "bot/index";
	}
	
	/**
	 * 一覧画面に遷移する。
	 */
	@GetMapping("/edit")
	public String edit(@RequestParam(name = "id", required = false) Integer id, Model model) {
		Bot bot;
		if (id == null) {
			bot = new Bot("", "");
		} else {
			bot = botService.findById(id);
		}
	
		BotForm botForm = new BotForm();
		botForm.setId(bot.getId());
		botForm.setQuestion(bot.getQuestion());
		botForm.setAnswer(bot.getAnswer());
		model.addAttribute("bot", bot);
		
		return "bot/edit";
	}

	/**
	 * 入力を受け取り、新規登録処理を実行する。 処理完了後は、一覧画面にリダイレクトする。
	 */
	@PostMapping(value = "/complete", params = "insert")
	public String insertCmplete(BotForm botForm) {
		Bot bot = botForm.convertToEntity();

		botService.insert(bot);

		return "redirect:index";
	}

	/**
	 * 入力を受け取り、更新処理を実行する。 処理完了後は、一覧画面にリダイレクトする。
	 */
	@PostMapping(value = "/complete", params = "update")
	public String updateCmplete(BotForm botForm) {
		Bot bot = botForm.convertToEntity();

		botService.update(bot);

		return "redirect:index";
	}

	/**
	 * 入力を受け取り、削除処理を実行する。 処理完了後は、一覧画面にリダイレクトする。
	 */
	@PostMapping(value = "/complete", params = "delete")
	public String deleteCmplete(BotForm botForm) {
		Bot bot = botForm.convertToEntity();

		botService.delete(bot);

		return "redirect:index";
	}
}
