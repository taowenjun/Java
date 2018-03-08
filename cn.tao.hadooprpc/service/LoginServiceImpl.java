package cn.tao.hadooprpc.service;

import cn.tao.hadooprpc.protocol.IUserLoginService;

public class LoginServiceImpl implements IUserLoginService{

	@Override
	public String login(String name, String password) {
		return name+" login successfully!";
	}
}
