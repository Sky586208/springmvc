package com.sky.springmvc.service;

import java.util.List;

import com.sky.springmvc.pojo.Items;

public interface ItemService {

	//��ѯ��Ʒ�б�
	public List<Items> selectItemsList();
	
	public Items selectItemsById(Integer id);
	
	//�޸�
	public void updateItemsById(Items items);
}
