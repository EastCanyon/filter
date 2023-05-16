package com.example.shop.curator.service;

import com.example.shop.curator.dto.ConDTO;
import com.example.shop.curator.dto.HostDTO;
import com.example.shop.curator.dto.LocDTO;

public interface HostService {
	public HostDTO recMainHostProcess(int main_code);
	public ConDTO recMainConProcess(int main_code);
	public LocDTO recMainLocProcess(int main_code);

}
