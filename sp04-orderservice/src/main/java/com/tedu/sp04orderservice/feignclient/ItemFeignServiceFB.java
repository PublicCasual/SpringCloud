package com.tedu.sp04orderservice.feignclient;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.tedu.sp01.webUtil.JsonResult;
import org.springframework.stereotype.Component;

import com.tedu.sp01.pojo.Item;

@Component
public class ItemFeignServiceFB implements ItemFeignService{
	@Override
	public JsonResult<List<Item>> getItems(String orderId) {
		if (Math.random()<0.5) {
			//缓存
			ArrayList<Item> list = new ArrayList<Item>();
			Collections.addAll(
					list, 
					new Item(1, "缓存商品1", 1),
					new Item(2, "缓存商品2", 2),
					new Item(3, "缓存商品3", 3),
					new Item(4, "缓存商品4", 4),
					new Item(5, "缓存商品5", 5));
			
			return JsonResult.ok(list);
		}
		
		return JsonResult.err("获取订单的商品列表失败");
	}
	@Override
	public JsonResult decreaseNumber(List<Item> items) {
		return JsonResult.err("减少商品库存失败");
	}
}
