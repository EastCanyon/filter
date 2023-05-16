package com.example.shop.chating.service;

import java.util.List;

import com.example.shop.chating.dto.ChatDto;

public interface ChatService {
	List<ChatDto> selectMessages(int roomId) throws Exception;
	void insertMessage(ChatDto chatDto) throws Exception;
	public List<ChatDto> selectChatRoom();
	
	public void insertChatRoom(ChatDto chatDto);
	
	
}
