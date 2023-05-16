package com.example.shop.curator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shop.curator.dao.HostDAO;
import com.example.shop.curator.dto.ConDTO;
import com.example.shop.curator.dto.HostDTO;
import com.example.shop.curator.dto.LocDTO;

@Service
public class HostServiceImp implements HostService {

	@Autowired
	private HostDAO hostDao;
	
	@Override
	public HostDTO recMainHostProcess(int main_code) {
		return hostDao.recMainHost(main_code);
	}
	
	@Override
	public ConDTO recMainConProcess(int main_code) {
		return hostDao.recMainCon(main_code);
	}
	
	@Override
	public LocDTO recMainLocProcess(int main_code) {
		return hostDao.recMainLoc(main_code);
	}

}
