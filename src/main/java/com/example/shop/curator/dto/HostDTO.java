package com.example.shop.curator.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HostDTO {
	private int main_code;
	private String main_name;
	private String main_address;
	private String main_comment;
	private String Latitude;
	private String longitude;
	private String main_logo;
	private String main_category;
}
