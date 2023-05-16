package com.example.shop.test;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MyDTO {
	private Map<String, List<RouteDTO>> msgBody;
	private Map<String, RouteDTO> msgBody2;
	
//	
//	 @JsonProperty("msgBody")
//	    private void unpackNested(Map<String, Object> test) {
//	        if (test.containsKey("list")) {
//	        	msgBody = ObjectMapper.convertValue(test.get("list"), new TypeReference<List<RouteDTO>>() {});
//	        }
//	        if (test.containsKey("map")) {
//	        	msgBody2 = ObjectMapper.convertValue(test.get("map"), new TypeReference<Map<String, RouteDTO>>() {});
//	        }
//	    }
}
