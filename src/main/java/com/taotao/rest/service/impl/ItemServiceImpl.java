package com.taotao.rest.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.util.JsonUtils;
import com.taotao.mapper.TbItemDescMapper;
import com.taotao.mapper.TbItemMapper;
import com.taotao.mapper.TbItemParamItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemDesc;
import com.taotao.pojo.TbItemParamItem;
import com.taotao.pojo.TbItemParamItemExample;
import com.taotao.pojo.TbItemParamItemExample.Criteria;
import com.taotao.rest.dao.JedisClient;
import com.taotao.rest.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private TbItemMapper itemMapper;
	
//	@Autowired
	private JedisClient jedisClient;
	
	@Value("${REDIS_ITEM_KEY}")
	private String REDIS_ITEM_KEY;
	
	@Value("${REDIS_ITEM_EXPIRE}")
	private Integer REDIS_ITEM_EXPIRE;
	
	@Autowired
	private TbItemDescMapper itemDescMapper;
	
	@Autowired
	private TbItemParamItemMapper itemParamItemMapper;
	
	/**
	 * 取商品基本信息
	 */
	@Override
	public TaotaoResult getItemBaseInfo(Long itemId) {
		
		try{
			//添加缓存逻辑
			//从缓存中取商品信息，商品id对应的信息
			String json = jedisClient.get(REDIS_ITEM_KEY+":" + itemId + ":base");
			//判断是否有值
			if(!StringUtils.isBlank(json)){
				//把json转换成java对象
				TbItem item = JsonUtils.jsonToPojo(json, TbItem.class);
				return TaotaoResult.ok(item);
			}
		}catch(Exception e){
			e.printStackTrace();
		}

		//根据商品id取商品基本信息
		TbItem item = itemMapper.selectByPrimaryKey(itemId);
		
		try{
			//把商品信息写入缓存
			jedisClient.set(REDIS_ITEM_KEY+":" + itemId + ":base", JsonUtils.objectToJson(item));
			//设置key的有效期
			jedisClient.expire(REDIS_ITEM_KEY+":" + itemId + ":base", REDIS_ITEM_EXPIRE);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		//将获取的数据封装成TaotaoResult
		return TaotaoResult.ok(item);
	}
	
	/**
	 * 取商品基本信息
	 */
	@Override
	public TaotaoResult getItemDesc(Long itemId) {
		
		try{
			//添加缓存逻辑
			//从缓存中取商品信息，商品id对应的信息
			String json = jedisClient.get(REDIS_ITEM_KEY+":" + itemId + ":desc");
			//判断是否有值
			if(!StringUtils.isBlank(json)){
				//把json转换成java对象
				TbItemDesc item = JsonUtils.jsonToPojo(json, TbItemDesc.class);
				return TaotaoResult.ok(item);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		//创建查询条件
		TbItemDesc desc = itemDescMapper.selectByPrimaryKey(itemId);
		
		try{
			//把商品信息写入缓存
			jedisClient.set(REDIS_ITEM_KEY+":" + itemId + ":desc", JsonUtils.objectToJson(desc));
			//设置key的有效期
			jedisClient.expire(REDIS_ITEM_KEY+":" + itemId + ":desc", REDIS_ITEM_EXPIRE);
		}catch(Exception e){
			e.printStackTrace();
		}
		return TaotaoResult.ok(desc);
	}

	/**
	 * 取商品规格参数
	 */
	@Override
	public TaotaoResult getItemParam(Long itemId) {

		try{
			//添加缓存逻辑
			//从缓存中取商品信息，商品id对应的信息
			String json = jedisClient.get(REDIS_ITEM_KEY+":" + itemId + ":param");
			//判断是否有值
			if(!StringUtils.isBlank(json)){
				//把json转换成java对象
				TbItemParamItem item = JsonUtils.jsonToPojo(json, TbItemParamItem.class);
				return TaotaoResult.ok(item);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		//设置查询条件
		TbItemParamItemExample example = new TbItemParamItemExample();
		Criteria criteria = example.createCriteria();
		criteria.andItemIdEqualTo(itemId);
		
		//执行查询
		List<TbItemParamItem> list = itemParamItemMapper.selectByExampleWithBLOBs(example);
		if(list !=null && list.size() > 0){
			TbItemParamItem paramItem = list.get(0);
			
			try{
				//把商品信息写入缓存
				jedisClient.set(REDIS_ITEM_KEY+":" + itemId + ":param", JsonUtils.objectToJson(paramItem));
				//设置key的有效期
				jedisClient.expire(REDIS_ITEM_KEY+":" + itemId + ":param", REDIS_ITEM_EXPIRE);
			}catch(Exception e){
				e.printStackTrace();
			}
			
			return TaotaoResult.ok(paramItem);
		}
		return TaotaoResult.build(400, "无此商品规格参数");
	}
	
	

}
