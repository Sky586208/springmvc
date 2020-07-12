package com.sky.springmvc.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.sky.springmvc.exception.MessageException;
import com.sky.springmvc.pojo.Items;
import com.sky.springmvc.pojo.QueryVo;
import com.sky.springmvc.service.ItemService;

/**
 * 商品管理
*/

@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	//入门程序  HandlerMapping
	@RequestMapping(value="/item/itemlist.action")
	public ModelAndView itemList() throws MessageException {
		
		//从MySql中查询
		List<Items> list = itemService.selectItemsList();
		
//		if(null == null) {
//			throw new MessageException("商品信息不能为空");
//		}
		
		ModelAndView mav = new ModelAndView();
		//添加数据
		mav.addObject("itemList", list);
		//ViewResolver  jsp页面
		mav.setViewName("itemList");
		return mav;
	}
	
	//去修改页面入参 id   itemEdit.action
	@RequestMapping(value = "/itemEdit.action")
	//public ModelAndView toEdit(@RequestParam(value="id",required = false,defaultValue = "1") 
	public ModelAndView toEdit(Integer id,
			HttpServletRequest request,HttpServletResponse response,HttpSession session,Model model) {
		
		//Servlet 时代开发
		//String id = request.getParameter("id");
		
		//查询一个商品
		//Items items = itemService.selectItemsById(Integer.parseInt(id));
		Items items = itemService.selectItemsById(id);
	
		ModelAndView mav = new ModelAndView();
		//添加数据
		mav.addObject("item", items);
		//ViewResolver
		mav.setViewName("editItem");
		return mav;
	}
	//提交修改页面入参 为Items对象 
	@RequestMapping(value="/updateitem.action")
	//public ModelAndView updateitem(Items items) {
	public ModelAndView updateitem(QueryVo vo,MultipartFile pictureFile) throws Exception {
		
		//保存图片
		String name = UUID.randomUUID().toString().replaceAll("-", "");
		//jpg
		String ext = FilenameUtils.getExtension(pictureFile.getOriginalFilename());
				
		pictureFile.transferTo(new File("H:\\upload\\" + name + "." + ext));
				
		vo.getItems().setPic(name + "." + ext);
		
		//修改
		itemService.updateItemsById(vo.getItems());
		
		ModelAndView mav = new ModelAndView();
		
		//ViewResolver
		mav.setViewName("success");
		return mav;
	}
	
	//删除多个
	@RequestMapping(value="/deletes.action")
	public ModelAndView deletes(QueryVo vo) {
		
        ModelAndView mav = new ModelAndView();
		
		//ViewResolver
		mav.setViewName("success");
		return mav;
	}
	
	//批量修改
	@RequestMapping(value="/updates.action",method = {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView updates(QueryVo vo) {
			
	    ModelAndView mav = new ModelAndView();
			
		//ViewResolver
		mav.setViewName("success");
		return mav;
	}
		
	//JSON数据交互
	@RequestMapping(value="/json.action")
	public @ResponseBody
	Items json(@RequestBody Items items) {
		
		//System.out.println(items);
		return items;
	}
	//去登陆的页面
	@RequestMapping(value = "/login.action",method = RequestMethod.GET)
	public String login(){
		return "login";
	}
	@RequestMapping(value = "/login.action",method = RequestMethod.POST)
	public String login(String username
				,HttpSession httpSession){
	    httpSession.setAttribute("USER_SESSION", username);
	    return "redirect:/item/itemlist.action";
	}
	
}
