package com.rzx.ssm.controller;

import java.lang.reflect.Method;

import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rzx.ssm.controller.msg.RequestMessage;
import com.rzx.ssm.controller.msg.ResponseMessage;

public class MsgProcessor {

	// 处理请求消息

		public static ResponseMessage process(RequestMessage msg,
				Object objService) throws Exception {
			ResponseMessage resMsg = new ResponseMessage();

			// 获取Service的方法
			Method serviceMethod = getMethod(objService, msg.getMethodName());

			if (serviceMethod == null) { // Service中不存在对应方法

				resMsg.status = 0;
				resMsg.desc = msg.getProcClassName() + "中未找到调用方法"
						+ msg.getMethodName();
				return resMsg;
			} // 返回错误信息


			Class[] paramTypes = serviceMethod.getParameterTypes();
			Class paramType = paramTypes[0]; // 获得第一个参数的类型


			// 执行指令 并将msg.data(json格式)转换为对象
			ObjectMapper mapper = new ObjectMapper();
			Object objData = mapper.readValue(msg.data, paramType);
			resMsg.id = msg.id;
			try {
				Object retObj=null;
				if(paramTypes.length==1)
					retObj = serviceMethod.invoke(objService, objData);
//				else if(paramTypes.length==2) //第二个参数为session（用于登录方法，或其他要进行二次用户权限验证的方法）
//					retObj = serviceMethod.invoke(objService, objData,httpSession);
				resMsg.data = mapper.writeValueAsString(retObj);
				resMsg.status = 1;
			} catch (Exception ex) {
				resMsg.status = 0;
				resMsg.desc = ex.getMessage();
			}
			
			// 返回结果
			return resMsg;
		}


		/**
		 * 获取指定的对象中的方法对象
		 * @param objService
		 * @param methodName
		 * @return
		 */
		public static Method getMethod(Object objService, String methodName) {
			Class cls = objService.getClass();
			Method serviceMethod = null;
			Method[] ms = cls.getMethods();
			for (Method m : ms)
				if (m.getName().equals(methodName)) {
					serviceMethod = m;
					break;
				}
			return serviceMethod;
		}
}
