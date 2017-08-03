package com.rzx.ssm.mapperTest;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.rzx.ssm.entity.ClasssKey;
import com.rzx.ssm.mapper.ClasssMapper;

public class ClasssMapperTest extends BasicTest {
	@Autowired
	private ClasssMapper classsMapper;
	
	@Test
	public void testInsertClasss(){
		ClasssKey classs=new ClasssKey();
		classs.setcName("计应143");
		System.out.println(classsMapper.insert(classs));
	}
}
