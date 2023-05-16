package com.example.shop.chating.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.shop.chating.dto.ChatDto;

@Mapper
@Repository
public interface ChatMapper {
	List<ChatDto> selectMessages(int roomId) throws Exception;
	void insertMessage(ChatDto chatDto) throws Exception;
	public List<ChatDto> selectChatRoom();
	
	public  void insertChatRoom(ChatDto chatDto);
}
