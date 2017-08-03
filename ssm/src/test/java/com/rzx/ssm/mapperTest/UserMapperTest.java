package com.rzx.ssm.mapperTest;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.rzx.ssm.entity.ClasssKey;
import com.rzx.ssm.entity.User;
import com.rzx.ssm.mapper.ClasssMapper;
import com.rzx.ssm.mapper.UserMapper;

public class UserMapperTest extends BasicTest {

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private ClasssMapper classsMapper;
	
	@Test
	public void testInsertUser(){
		ClasssKey classsKey=classsMapper.selectClasssByClasssName("计应143");
		User user=new User();
		user.setUsername("adminstrator");
		user.setPassword("soft");
		user.setcUuid(classsKey.getcUuid());
		System.out.println(userMapper.insert(user));
	}
	
	
	@Test
	public void testUserExist(){
		User user=new User();
//		user.setUsername("adminstrator");
		user.setUsername("adminstrators");
		user.setPassword("soft");
		User user2=userMapper.userExist(user);
		if (user2!=null) {
			System.out.println("exiist");
		}else {
			System.out.println("not exist");
		}
	}
	
	
}
