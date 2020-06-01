package com.has.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.has.model.Sample;

@Controller
public class DemoController
{
	@GetMapping("/demoPage")
	public String demoPage(Model model)
	{
		model.addAttribute("sample", new Sample());
		return "demo";
	}
	
	
	@GetMapping("/dataPage")
	public String dataPage(@ModelAttribute("sample")Sample sample)
	{
		System.out.println("Sample" + sample.toString());
		return null;
	}
}
