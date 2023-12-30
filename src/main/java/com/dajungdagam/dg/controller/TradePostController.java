package com.dajungdagam.dg.controller;

import com.dajungdagam.dg.dto.TradePostDto;
import com.dajungdagam.dg.service.TradePostService;
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

	@PostMapping("/trade/posts")
    public String write(TradePostDto tradePostDto) {
		tradePostService.savePost(tradePostDto);
		return "redirect:/";
	}

	@GetMapping("/trade/posts/{id}")
	public String detail(@PathVariable Long id, Model model) {
		TradePostDto tradePostDto = tradePostService.getPost(id);

		model.addAttribute("tradepostDto", tradePostDto);
		return "detail.html";
	}


//	@GetMapping("/trade/like-posts")
//	public String getTradeLikePosts() {
//		return "likeposts";
//	}



//	@PatchMapping("/trade/posts/{id}")
//	public String partiallyUpdateTradePost(@PathVariable int id, @RequestBody Map<String, Object> updates) {
//	    return "Trade post partially updated successfully";
//	}
//
//	@DeleteMapping("/trade/posts/{id}")
//    public String deleteTradePost(@PathVariable int id) {
//        return "Trade post with ID " + id + " deleted successfully";
//    }

}