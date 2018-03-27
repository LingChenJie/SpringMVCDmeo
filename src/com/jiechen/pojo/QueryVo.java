package com.jiechen.pojo;

import java.util.List;

public class QueryVo {

	//商品
	private Items item;
	
	Integer[] ids;
	
	private List<Items> list;
	
	public Integer[] getIds() {
		return ids;
	}

	public void setIds(Integer[] ids) {
		this.ids = ids;
	}

	public Items getItem() {
		return item;
	}

	public void setItem(Items item) {
		this.item = item;
	}

	public List<Items> getList() {
		return list;
	}

	public void setList(List<Items> list) {
		this.list = list;
	}
}
