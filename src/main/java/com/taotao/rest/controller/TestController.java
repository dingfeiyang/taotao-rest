package com.taotao.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.TaotaoResult;

@Controller
public class TestController {

	@RequestMapping(value="/test/list",method=RequestMethod.POST)
	@ResponseBody
	public TaotaoResult getTest(String username, String password){
		List<String> list = new ArrayList<String>();
		list.add(username);
		list.add(password);
		return TaotaoResult.ok(list);
	}
}
