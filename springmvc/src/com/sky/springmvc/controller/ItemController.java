package com.sky.springmvc.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sky.springmvc.pojo.Items;

/**
 * 商品管理
*/

@Controller
public class ItemController {

	
	//入门程序  HandlerMapping
	@RequestMapping(value="/item/itemlist.action")
	public ModelAndView itemList() {
		
		//创建页面需要显示的商品数据
		List<Items> list = new ArrayList<Items>();
		list.add(new Items(1,"1华为荣耀8",2399f,new Date(),"质量好！1"));
		list.add(new Items(2,"2华为荣耀8",2399f,new Date(),"质量好！2"));
		list.add(new Items(3,"3华为荣耀8",2399f,new Date(),"质量好！3"));
		list.add(new Items(4,"4华为荣耀8",2399f,new Date(),"质量好！4"));
		list.add(new Items(5,"5华为荣耀8",2399f,new Date(),"质量好！5"));
		list.add(new Items(6,"6华为荣耀8",2399f,new Date(),"质量好！6"));
		
		ModelAndView mav = new ModelAndView();
		//添加数据
		mav.addObject("itemList", list);
		//ViewResolver
		mav.setViewName("/WEB-INF/jsp/itemList.jsp");
		return mav;
	}
}
