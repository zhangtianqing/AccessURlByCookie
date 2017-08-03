package com.rzx.ssm.serviceTest;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.rzx.ssm.entity.User;
import com.rzx.ssm.mapperTest.BasicTest;
import com.rzx.ssm.service.MainService;

public class MainServiceTest extends BasicTest {

	@Autowired MainService mainService;
	
	@Test
	public void testServiceRun(){
		User user=new User();
//		user.setUsername("adminstrator");
		user.setUsername("adminstrator");
		user.setPassword("soft");
		System.out.println(mainService.checkUserExist(user));
	}
}
