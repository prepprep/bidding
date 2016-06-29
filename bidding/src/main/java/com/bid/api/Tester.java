package com.bid.api;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bid.domain.Item;

@Controller
public class Tester {

	@RequestMapping("/")
	public String test(Model model) {
		Item item = new Item();
		
		item.setDateCreated(LocalDateTime.now());
		item.setItemName("MacBook Pro");
		
		model.addAttribute("person", item);
		
		return "index";
	}
}
