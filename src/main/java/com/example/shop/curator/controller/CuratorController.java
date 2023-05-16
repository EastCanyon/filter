package com.example.shop.curator.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.shop.curator.dto.ConDTO;
import com.example.shop.curator.dto.HostDTO;
import com.example.shop.curator.dto.LocDTO;
import com.example.shop.curator.service.HostService;
import java.io.IOException;
import org.springframework.http.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin({ "*" })
@RestController
public class CuratorController {

	@Autowired
	private HostService hostService;

	@GetMapping("/recommend/{T_ID}")
	public Map<String, Object> reFa(@PathVariable("T_ID") int T_ID) {
		System.out.println("1번큐레이팅 시작");
		System.out.println(T_ID);
		Map <String,Object> resultMap= new HashMap<>();

		String url = "http://localhost:5000/recommend/" + String.valueOf(T_ID);

		// RestTemplate 생성
		RestTemplate restTemplate = new RestTemplate();

		// HttpHeader 객체 생성
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		// HttpEntity 객체 생성
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		// 요청 보내고 응답 받기
		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

		// 응답 본문 출력
		System.out.println(response.getBody());
		List<Integer> placeslist = null;
		List<String> secondlist = null;
		List<Integer> thirdlist = null;
		String json = response.getBody();

		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode rootNode;
		try {
			rootNode = objectMapper.readTree(json);
			JsonNode placesa = rootNode.get("first");
			JsonNode seconda = rootNode.get("second");
			JsonNode thirda = rootNode.get("third");
			placeslist = objectMapper.convertValue(placesa, new TypeReference<List<Integer>>() {
			});
			secondlist = objectMapper.convertValue(seconda, new TypeReference<List<String>>() {
			});
			thirdlist = objectMapper.convertValue(thirda, new TypeReference<List<Integer>>() {
			});

		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		HostDTO hd=new HostDTO();
		ConDTO cd= new ConDTO();
		LocDTO ld= new LocDTO();
		
		List<HostDTO> hdlist=new ArrayList<HostDTO>();
		List<ConDTO> cdlist= new ArrayList<ConDTO>();
		List<LocDTO> ldlist= new ArrayList<LocDTO>();
		
		for(int i =0; i<4; i++) {
			System.out.println(placeslist.get(i));
			System.out.println(Integer.parseInt(secondlist.get(i)));
			hd=hostService.recMainHostProcess(placeslist.get(i));
			cd=hostService.recMainConProcess(Integer.parseInt(secondlist.get(i)));
			ld=hostService.recMainLocProcess(thirdlist.get(i));
			System.out.println("편의편의"+cd.getMain_code());
			System.out.println("거리거리"+ld.getMain_code());
			hdlist.add(hd);
			cdlist.add(cd);
			ldlist.add(ld);
		}
		
		resultMap.put("cdlist",cdlist);
		resultMap.put("hdlist",hdlist);
		resultMap.put("ldlist",ldlist);
	
		
		return resultMap;

	}
}
