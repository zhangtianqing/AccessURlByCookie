package com.rzx.ssm.controllerTest;

import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rzx.ssm.controller.MainController;
import com.rzx.ssm.controller.msg.RequestMessage;
import com.rzx.ssm.entity.User;
import com.rzx.ssm.mapperTest.BasicTest;
import com.rzx.ssm.service.MainService;

public class MainControllerTest extends BasicTest {

	@Autowired
	MainService mainService;
	
	
	@Test
	public void testController() throws Exception{
		User user=new User();
//		user.setUsername("adminstrator");
		user.setUsername("adminstrators");
		user.setPassword("soft");
		ObjectMapper mapper=new ObjectMapper();
		String data=mapper.writeValueAsString(user);
		RequestMessage message=new RequestMessage("123", "check user", "mainService_checkUserExist",data);
		MainController mains=new MainController();
		mains.mainService=mainService;
		System.out.println(mains.Connections(message).toString());
	}
}
