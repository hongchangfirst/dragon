package com.zhclab.dragon.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
    public @ResponseBody
    String getStock(@RequestParam String name, HttpServletRequest request) {
		return name;
	}

}
