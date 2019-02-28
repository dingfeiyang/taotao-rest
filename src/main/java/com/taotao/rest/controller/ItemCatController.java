package com.taotao.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.MappingJsonFactory;
import com.taotao.common.util.JsonUtils;
import com.taotao.rest.pojo.CatResult;
import com.taotao.rest.service.ItemCatService;
/**
 * 
 * Create by dingfeiyang
 *
 * 2018年10月29日
 * 
 * 商品分类列表
 */
@Controller
public class ItemCatController {

	@Autowired
	private ItemCatService itemCatService;
	
	/**
	 * 第一种方法
	 */
	/*@RequestMapping(value="/itemcat/list",produces=MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
	@ResponseBody
	public String getItemCatList(String callback){
		CatResult catResult = itemCatService.getItemCatList();
		//将pojo装换成json
		String json = JsonUtils.objectToJson(catResult);
		//拼装返回值
		String result = callback +"("+json+");";
		
		return result;
	}*/
	
	/**
	 * 第二种方法
	 */
	@RequestMapping(value="/itemcat/list")
	@ResponseBody
	public Object getItemCatList(String callback){
		CatResult catResult = itemCatService.getItemCatList();
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(catResult);
		mappingJacksonValue.setJsonpFunction(callback);
		return mappingJacksonValue;
	}
	
}
