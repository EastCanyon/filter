package com.example.shop.curator.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CuratorDTO {

	private int T_id;
	private int main_code;
	private String main_category;
	private String comfort;
	private String aircon;
	private String etc;
	private String main_address;
	private String main_name;
}
