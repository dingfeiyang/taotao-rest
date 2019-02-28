package com.taotao.rest.jedis;

//import static org.junit.Assert.*;
//
//import org.apache.solr.client.solrj.SolrQuery;
//import org.apache.solr.client.solrj.SolrServer;
//import org.apache.solr.client.solrj.impl.HttpSolrServer;
//import org.apache.solr.client.solrj.response.QueryResponse;
//import org.apache.solr.common.SolrDocument;
//import org.apache.solr.common.SolrDocumentList;
//import org.apache.solr.common.SolrInputDocument;
//import org.junit.Test;

public class SolrJTest {
	
//	//添加文档
//	@Test
//	public void addDocument() throws Exception {
//		//创建一连接
//		SolrServer solrServer = new HttpSolrServer("http://192.168.198.129:8080/solr");
//		//创建一个文档对象
//		SolrInputDocument document = new SolrInputDocument();
//		document.addField("id", "test001");
//		document.addField("item_title", "测试商品");
//		document.addField("item_price", 12345);
//		//将文档写入索引库
//		solrServer.add(document);
//		//提交
//		solrServer.commit();
//	}
//	
//	//删除文档
//	@Test
//	public void delDocument() throws Exception {
//		SolrServer solrServer = new HttpSolrServer("http://192.168.198.129:8080/solr");
//		solrServer.deleteByQuery("*:*");
//		solrServer.commit();
//	}
//	
//	//查询文档
//	@Test
//	public void queryDoument() throws Exception {
//		SolrServer solrServer = new HttpSolrServer("http://192.168.198.128:8080/solr");
//		//创建一个查询对象
//		SolrQuery query = new SolrQuery();
//		//设置查询条件
//		query.setQuery("*:*");
//		query.setStart(20);
//		query.setRows(50);
//		//执行查询
//		QueryResponse response = solrServer.query(query);
//		//取查询结果
//		SolrDocumentList solrDocumentList = response.getResults();
//		System.out.println("共查询："+solrDocumentList.getNumFound());
//		for(SolrDocument solrDocument : solrDocumentList){
//			System.out.println("id："+solrDocument.get("id"));
//			System.out.println("标题："+solrDocument.get("item_title"));
//			System.out.println("价格："+solrDocument.get("item_price"));
//		}
//	}
}
