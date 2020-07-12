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
	
	//��ѯ��Ʒ�б�
	public List<Items> selectItemsList(){
		
		return itemsMapper.selectByExampleWithBLOBs(null);
	}
	//������Ʒid��ѯ
	public Items selectItemsById(Integer id) {
		return itemsMapper.selectByPrimaryKey(id);
	}
	//�޸�
	public void updateItemsById(Items items) {
		items.setCreatetime(new Date());
		itemsMapper.updateByPrimaryKeyWithBLOBs(items);
	}
}
