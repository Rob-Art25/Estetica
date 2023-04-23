package com.estetica.memo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController 
{

	@GetMapping({"/index", "/principal","/HOME"})
	public String index()
	{
		return "index";
	}
}
