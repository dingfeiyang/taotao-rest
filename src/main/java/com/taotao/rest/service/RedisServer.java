package com.taotao.rest.service;

import com.taotao.common.pojo.TaotaoResult;

public interface RedisServer {
	TaotaoResult syncContent(Long contentCid);
}
