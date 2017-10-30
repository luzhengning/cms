package com.geek.cms.modules.faramwer.dpatterns.factoryMethod;

public abstract class ServiceFactory<T> {
	public T create(){
		try {
			throw new Exception("工厂未创建产品！");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
