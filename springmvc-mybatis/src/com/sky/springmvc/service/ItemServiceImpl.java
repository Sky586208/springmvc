package com.sky.springmvc.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.springmvc.dao.ItemsMapper;
import com.sky.springmvc.pojo.Items;

@Service
public class ItemServiceImpl implements ItemService {

	
	@Autowired
	private ItemsMapper itemsMapper;
	
	//查询商品列表
	public List<Items> selectItemsList(){
		
		return itemsMapper.selectByExampleWithBLOBs(null);
	}
	//根据商品id查询
	public Items selectItemsById(Integer id) {
		return itemsMapper.selectByPrimaryKey(id);
	}
	//修改
	public void updateItemsById(Items items) {
		items.setCreatetime(new Date());
		itemsMapper.updateByPrimaryKeyWithBLOBs(items);
	}
}
