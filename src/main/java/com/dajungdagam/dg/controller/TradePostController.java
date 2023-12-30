package com.dajungdagam.dg.controller;

import com.dajungdagam.dg.dto.TradePostDto;
import com.dajungdagam.dg.service.TradePostService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TradePostController {

	private TradePostService tradePostService;

	public TradePostController(TradePostService tradePostService) {
		this.tradePostService = tradePostService;
	}

	@GetMapping("/trade/")
	public String list(Model model) {
		List<TradePostDto> tradePostDtoList = tradePostService.getPostlist();
		model.addAttribute("TradePostList", tradePostDtoList);
		return "list";
	}

	@GetMapping("/trade/posts")
	public String saveForm() {
		return "save";
	}

//	@GetMapping("/trade/like-posts")
//	public String saveForm2() {
//		return "save";
//	}

	@PostMapping("/trade/posts")
    public String write(TradePostDto tradePostDto) {
		tradePostService.savePost(tradePostDto);
		return "redirect:/";
	}

	@GetMapping("/trade/posts/{id}")
	public String detail(@PathVariable Long id, Model model) {
		TradePostDto tradePostDto = tradePostService.getPost(id);

		model.addAttribute("tradepostDto", tradePostDto);
		return "detail";
	}

	@GetMapping("/trade/posts/update/{id}")
	public String edit(@PathVariable Long id, Model model) {
		TradePostDto tradePostDto = tradePostService.getPost(id);

		model.addAttribute("tradepostDto", tradePostDto);
		return "update.html";
	}

	@PatchMapping("/trade/posts/update/{id}")
	public String update(@PathVariable Long id, TradePostDto tradePostDto, HttpServletResponse response) {
		tradePostDto.setId(id);
		tradePostService.savePost(tradePostDto);

		response.setHeader(HttpHeaders.ALLOW, "GET, POST, PUT, PATCH, DELETE");

		return "redirect:/";
	}

	@DeleteMapping("trade/posts/{id}")
	public String delete(@PathVariable Long id) {
		tradePostService.deletePost(id);

		return "redirect:/";
	}

}