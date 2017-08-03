package com.rzx.ssm.util;


import java.io.Serializable;
import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Autowired;

import com.rzx.ssm.entity.ClasssKey;
import com.rzx.ssm.mapper.ClasssMapper;

public class ThreadPoolTask implements Callable<String>, Serializable {
	private static final long serialVersionUID = 0;
@Autowired
	ClasssMapper classsMapper;
	// 保存任务所需要的数据
	private Object threadPoolTaskData;

	private int taskNumber=0;
	public ThreadPoolTask(Object tasks,ClasssMapper classsMapper,int taskNumber) {
		this.threadPoolTaskData = tasks;
		this.classsMapper=classsMapper;
		this.taskNumber=taskNumber;
	}

	public synchronized String call() throws Exception {
		// 处理一个任务，这里的处理方式太简单了，仅仅是一个打印语句
		System.out.println("开始执行任务：" + threadPoolTaskData);
		String result = "";
		// //便于观察，等待一段时间
		try {
			// long r = 5/0;
			ClasssKey classsKey;
			for (int i = 0; i < taskNumber; i++) {
				classsKey=new ClasssKey("name"+i);
				classsMapper.insert(classsKey);
			}
			result = "OK";
		} catch (Exception e) {
			e.printStackTrace();
			result = "ERROR";
		}
		threadPoolTaskData = null;
		return result;
	}
}