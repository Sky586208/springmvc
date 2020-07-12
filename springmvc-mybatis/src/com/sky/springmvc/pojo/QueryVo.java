package com.sky.springmvc.pojo;

import java.util.List;

public class QueryVo {

	//…Ã∆∑
	private Items items;

	Integer[] ids;
	
	private List<Items> itemList;
	
	public List<Items> getItemList() {
		return itemList;
	}

	public void setItemList(List<Items> itemList) {
		this.itemList = itemList;
	}

	public Integer[] getIds() {
		return ids;
	}

	public void setIds(Integer[] ids) {
		this.ids = ids;
	}

	public Items getItems() {
		return items;
	}

	public void setItems(Items items) {
		this.items = items;
	}
	
	
}
