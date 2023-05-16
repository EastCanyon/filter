package com.example.shop.payments.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.shop.payments.dto.Page_BookingDTO;
import com.example.shop.payments.service.PayService;


import lombok.RequiredArgsConstructor;

@CrossOrigin("*")
@RestController

public class UserPageController {
	
	@Autowired
	private PayService service;
	
	@GetMapping("/admin/payPage/{currentPage}")
	public Map<String, Object> userBookingList(@PathVariable("currentPage") int currentPage) {
		
		System.out.println(currentPage);
		
		Map<String, Object> map = new HashMap();
		
		
		
		
		
		int totalRecord = service.count_admin_bookingList();
		
		if(totalRecord >=1) {
		
			
			Page_BookingDTO pdto = new Page_BookingDTO(currentPage, totalRecord);
			
			System.out.println("컨르롤러 Pto : " + pdto);
			
			map.put("adminPayList", service.admin_bookingList(pdto));
			
			//System.out.println(service.main_list(pdto));
			
			
			map.put("pv", pdto);
			
		}
		
		return map;
		
		
	}
	
	@GetMapping("/user/payPage/{currentPage}")
	public Map<String, Object> userBookingList(
			@PathVariable("currentPage") int currentPage,
			@RequestParam("t_id") String t_id) {
		
		System.out.println(t_id);
		
		Map<String, Object> map = new HashMap();
		
		int totalRecord = service.count_user_bookingList(Integer.parseInt(t_id));
		
		System.out.println(totalRecord);
		
		if(totalRecord >=1) {
			
			
			
			Page_BookingDTO pdto = new Page_BookingDTO(currentPage, totalRecord);
			
			pdto.setT_id(Integer.parseInt(t_id));
			
			System.out.println("컨르롤러 Pto : " + pdto);
			
			System.out.println(service.user_bookingList(pdto));
			map.put("userPayList", service.user_bookingList(pdto));
			
			//System.out.println(service.main_list(pdto));
			
			
			map.put("pv", pdto);
			
		}
		
		return map;
		
		
	}
	
	
}
