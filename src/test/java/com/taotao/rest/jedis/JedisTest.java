package com.taotao.rest.jedis;

//import static org.junit.Assert.*;
//
//import java.util.HashSet;
//import java.util.Set;
//
//import org.junit.Test;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import redis.clients.jedis.HostAndPort;
//import redis.clients.jedis.Jedis;
//import redis.clients.jedis.JedisCluster;
//import redis.clients.jedis.JedisPool;

public class JedisTest {
//
//	@Test
//	public void testJedisSinge() throws Exception {
//		//创建一个jedis对象
//		Jedis jedis = new Jedis("192.168.198.128",6379);
//		//调用jedis对象的方法，方法名称跟jedis的命令一致
//		jedis.set("key1", "jedis test");
//		String string = jedis.get("key1");
//		System.out.println(string);
//		//关闭jedis
//		jedis.close();
//	}
//	
//	//使用连接池
//	@Test
//	public void testJedisPool() throws Exception {
//		//创建jedis连接池
//		JedisPool jedisPool = new JedisPool("192.168.198.128",6379);
//		//从连接池中获取jedis对象
//		Jedis jedis = jedisPool.getResource();
//		String string = jedis.get("key1");
//		System.out.println(string);
//		jedis.close();
//		
//	}
//	
//	/*
//	 * 集群版测试
//	 */
//	
//	@Test
//	public void testJedisCluster() throws Exception {
//		Set<HostAndPort> nodes = new HashSet<HostAndPort>();
//		nodes.add(new HostAndPort("192.168.198.128", 7001));
//		nodes.add(new HostAndPort("192.168.198.128", 7002));
//		nodes.add(new HostAndPort("192.168.198.128", 7003));
//		nodes.add(new HostAndPort("192.168.198.128", 7004));
//		nodes.add(new HostAndPort("192.168.198.128", 7005));
//		nodes.add(new HostAndPort("192.168.198.128", 7006));
//		
//		JedisCluster jedisCluster = new JedisCluster(nodes);
////		jedisCluster.set("key1", "1000");
//		String string = jedisCluster.get("key1");
//		System.out.println(string);
//		
//		jedisCluster.close();
//	}
//	
//	/**
//	 * 单机版测试
//	 */
//	@Test
//	public void testSpringJedisSingle() {
//		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
//		JedisPool pool =  applicationContext.getBean("redisClient",JedisPool.class);
//		Jedis jedis = pool.getResource();
//		String string = jedis.get("key1");
//		System.out.println(string);
//		jedis.close();
//		pool.close();
//	}
//
//	@Test
//	public void testSpringJedisCluster() {
//		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-jedis.xml");
//		JedisCluster jedisCluster =  (JedisCluster) applicationContext.getBean("redisClient");
//		String string = jedisCluster.get("key1");
//		System.out.println(string);
//		jedisCluster.close();
//	}


}
