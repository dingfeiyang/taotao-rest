package com.taotao.rest.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import redis.clients.jedis.JedisCluster;

import com.taotao.common.util.JsonUtils;
import com.taotao.mapper.TbContentMapper;
import com.taotao.pojo.TbContent;
import com.taotao.pojo.TbContentExample;
import com.taotao.pojo.TbContentExample.Criteria;
import com.taotao.rest.dao.JedisClient;
import com.taotao.rest.service.ContentService;

@Service
public class ContentServiceImpl implements ContentService{

	@Autowired
	private TbContentMapper contentMapper;
	
//	@Autowired
	private JedisClient jedisClient;
	
	@Value("${INDEX_CONTENT_REDIS_KEY}")
	private String INDEX_CONTENT_REDIS_KEY;
	
	
	@Override
	public List<TbContent> getContentList(Long contentCid) {
		
		//从缓存中中取内容
//		try{
//			String result = jedisClient.hget(INDEX_CONTENT_REDIS_KEY, contentCid+"");
//			if(!StringUtils.isBlank(result)){
//				//将string转换成list
//				List<TbContent> contentList = JsonUtils.jsonToList(result, TbContent.class);
//				return contentList;
//			}
//		}catch(Exception e){
//			e.printStackTrace();
//		}
		
		TbContentExample example = new TbContentExample();
		Criteria cri = example.createCriteria();
		cri.andCategoryIdEqualTo(contentCid);
		
		List<TbContent> list = contentMapper.selectByExample(example);
		
//		//向缓存中添加内容
//		try{
//			//把list转换成String
//			String resultList = JsonUtils.objectToJson(list);
//			jedisClient.hset(INDEX_CONTENT_REDIS_KEY, contentCid+"", resultList);
//		}catch(Exception e){
//			e.printStackTrace();
//		}
		
		return list;
	}

}
