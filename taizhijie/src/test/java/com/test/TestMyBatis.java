package com.test;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.model.User;
import com.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-mybatis.xml" })
public class TestMyBatis {
	private static Logger logger = Logger.getLogger(TestMyBatis.class);
	// private ApplicationContext ac = null;

	@Autowired
	private UserService userService;
	// @Before
	// public void before() {
	// ac = new ClassPathXmlApplicationContext("applicationContext.xml");
	// userService = (IUserService) ac.getBean("userService");
	// }

	@Test
	public void test1() {
		System.out.println(userService);
		User user = userService.getUserById(1);
		System.out.println(user.getUserName());
		logger.info("值：" + user.getUserName());
	}
}