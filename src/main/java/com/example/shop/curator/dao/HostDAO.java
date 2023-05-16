package com.example.shop.curator.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.shop.curator.dto.ConDTO;
import com.example.shop.curator.dto.HostDTO;
import com.example.shop.curator.dto.LocDTO;


@Mapper
@Repository
public interface HostDAO {

	public HostDTO recMainHost(int main_code);
	public ConDTO recMainCon(int main_code);
	public LocDTO recMainLoc(int main_code);
}
