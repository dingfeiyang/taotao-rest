package com.taotao.rest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.util.ExceptionUtil;
import com.taotao.rest.dao.JedisClient;
import com.taotao.rest.service.RedisServer;
/**
 *缓存同步
 * 
 * Create by dingfeiyang
 *
 * 2018年11月12日
 */
@Service
public class RedisServiceImpl implements RedisServer {

//	@Autowired
//	private JedisClient jedisClient;
	
	@Value("${INDEX_CONTENT_REDIS_KEY}")
	private String INDEX_CONTENT_REDIS_KEY;
	
//	@Override
	public TaotaoResult syncContent(Long contentCid) {
//		try{
//			jedisClient.hdel(INDEX_CONTENT_REDIS_KEY,contentCid+"");
//		}catch(Exception e){
//			e.printStackTrace();
//			return TaotaoResult.build(500,ExceptionUtil.getStackTrace(e));
//		}
		return TaotaoResult.ok();
	}

}
