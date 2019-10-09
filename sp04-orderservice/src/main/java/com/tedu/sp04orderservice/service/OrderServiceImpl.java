package com.tedu.sp04orderservice.service;

import java.util.List;

import com.tedu.sp01.webUtil.JsonResult;
import com.tedu.sp04orderservice.feignclient.ItemFeignService;
import com.tedu.sp04orderservice.feignclient.UserFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tedu.sp01.pojo.Item;
import com.tedu.sp01.pojo.Order;
import com.tedu.sp01.pojo.User;
import com.tedu.sp01.service.OrderService;


import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private ItemFeignService itemService;
	@Autowired
	private UserFeignService userService;
	
	@Override
	public Order getOrder(String orderId) {
		//调用user-service获取用户信息
		JsonResult<User> u = userService.getUser(7);
		
		//调用item-service获取商品信息
		JsonResult<List<Item>> items = itemService.getItems(orderId);
		
		Order order = new Order();
		order.setId(orderId);
		order.setUser(u.getData());
		order.setItems(items.getData());
		return order;
	}

	@Override
	public void addOrder(Order order) {
		//调用item-service减少商品库存
		itemService.decreaseNumber(order.getItems());
		
		//调用user-service增加用户积分
		userService.addScore(order.getUser().getId(), 100);
		
		log.info("保存订单："+order);
	}

}
