package com.example.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entity.Question;
import com.example.service.QuestionAdminService;

import java.util.List;

@Controller
@RequestMapping("/questionAdmin")
public class QuestionAdminController {

	private final QuestionAdminService questionAdminService;

	// EmployeeServiceをDIする（@Autowiredは省略）
	public QuestionAdminController(QuestionAdminService questionAdminService) {
		this.questionAdminService = questionAdminService;
	}

	/**
	 * 一覧画面に遷移する。
	 */
	@GetMapping("/index")
	public String index(Model model) {
		List<Question> questionList = questionAdminService.findAll();
		model.addAttribute("questionList", questionList);
		return "questionAdmin/index";
	}
	
	/**
	 * 一覧画面に遷移する。
	 */
	@GetMapping("/edit")
	public String edit(@RequestParam(name = "id", required = false) Integer id, Model model) {
		Question question;
		if (id == null) {
			question = new Question("", "");
		} else {
			question = questionAdminService.findById(id);
		}
	
		QuestionForm questionForm = new QuestionForm();
		questionForm.setId(question.getId());
		questionForm.setQuestion(question.getQuestion());
		questionForm.setAnswer(question.getAnswer());
		model.addAttribute("question", question);
		
		return "questionAdmin/edit";
	}

	/**
	 * 入力を受け取り、新規登録処理を実行する。 処理完了後は、一覧画面にリダイレクトする。
	 */
	@PostMapping(value = "/complete", params = "insert")
	public String insertCmplete(QuestionForm questionForm) {
		Question question = questionForm.convertToEntity();

		questionAdminService.insert(question);

		return "redirect:index";
	}

	/**
	 * 入力を受け取り、更新処理を実行する。 処理完了後は、一覧画面にリダイレクトする。
	 */
	@PostMapping(value = "/complete", params = "update")
	public String updateCmplete(QuestionForm questionForm) {
		Question question = questionForm.convertToEntity();

		questionAdminService.update(question);

		return "redirect:index";
	}

	/**
	 * 入力を受け取り、削除処理を実行する。 処理完了後は、一覧画面にリダイレクトする。
	 */
	@PostMapping(value = "/complete", params = "delete")
	public String deleteCmplete(QuestionForm questionForm) {
		Question question = questionForm.convertToEntity();

		questionAdminService.delete(question);

		return "redirect:index";
	}
}
