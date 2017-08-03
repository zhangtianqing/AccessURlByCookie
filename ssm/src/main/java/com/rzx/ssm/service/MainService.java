package com.rzx.ssm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import com.rzx.ssm.entity.User;
import com.rzx.ssm.mapper.ClasssMapper;
import com.rzx.ssm.mapper.UserMapper;
import com.rzx.ssm.util.StartTaskThread;

@Service(value = "mainService")
public class MainService {
	@Autowired
	UserMapper userMapper;
	@Autowired
	ClasssMapper classsMapper;
	
	//多线程使用
	@Autowired
	private ThreadPoolTaskExecutor threadPoolTaskExecutor;
	public void testThreadPoolExecutor(int produceTaskSleepTime,int produceTaskThreadMaxNumber,int taskNumber) {
		for (int i = 1; i <= produceTaskThreadMaxNumber; i++) {
			try {
				Thread.sleep(produceTaskSleepTime);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			new Thread(new StartTaskThread(threadPoolTaskExecutor, i,classsMapper,taskNumber)).start();
		}

	}
	
	public boolean checkUserExist(User user) {
		return userMapper.userExist(user) == null ? false : true;
	}

	
}
