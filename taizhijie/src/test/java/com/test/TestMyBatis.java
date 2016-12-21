package com.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

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
		logger.error("start");
		User user = userService.getUserById(1);
		ExecutorService pool = Executors.newFixedThreadPool(1);
		ThreadPoolExecutor tx = (ThreadPoolExecutor) pool;
		for (int i = 2; i <= 1000000; i++) {
			User u = new User();
			u.setAge((int)Math.random());
			u.setUserName("Ln " + (int)Math.random());
			u.setPwd("wpddsa13c");
//			u.setId(i);
			ThreadInert t = new ThreadInert(userService, u);
			Thread th = new Thread(t);
			tx.execute(th);
			// userService.saveUser(user);
            while (true) {
                long todoTotal = tx.getTaskCount() - tx.getCompletedTaskCount();
                if (todoTotal >= 2000) {
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                    }
                } else {
                    break;
                }
            }
		}
		logger.error("end");
	}
}

class ThreadInert implements Runnable {
	private UserService userService;
	private User user;

	public ThreadInert(UserService userService, User user) {
		this.userService = userService;
		this.user = user;
	}

	public void run() {
		try {
			userService.saveUser(user);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}