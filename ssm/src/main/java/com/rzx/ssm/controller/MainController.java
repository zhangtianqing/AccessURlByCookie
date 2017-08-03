package com.rzx.ssm.controller;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.TypeVariable;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rzx.ssm.controller.msg.RequestMessage;
import com.rzx.ssm.controller.msg.ResponseMessage;
import com.rzx.ssm.service.MainService;

@Controller
@RequestMapping(value="/v1")
public class MainController {

	@Autowired
	public MainService mainService;
	
	@RequestMapping(value="/test/{sleep}/{thread}")
	public String testConnection(@PathVariable int sleep,@PathVariable int thread){
		mainService.testThreadPoolExecutor(sleep, thread);
		
		return "index";
	}
	
	@RequestMapping(value="/input")
	public ResponseMessage Connections(@RequestBody RequestMessage msg) throws Exception{
		System.out.println("@@@@@收到消息：id="+msg.id+"，处理的服务程序："+msg.proc+"，内容："+msg.data);

		//获取spring注入的service对象(负责处理业务的对象)
		//System.out.println(this.getClass().getName());
		Field field = this.getClass().getDeclaredField(msg.getProcClassName());
		Object objService = field.get(this); //!!测试时还没有注入，为null
		
		// check jurisdiction 
		
		return MsgProcessor.process(msg, objService);
	}
}
