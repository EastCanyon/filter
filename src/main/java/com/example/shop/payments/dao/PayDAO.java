package com.example.shop.payments.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.shop.payments.dto.AddressDTO;
import com.example.shop.payments.dto.BookingDTO;
import com.example.shop.payments.dto.KakaoPay_KeyDTO;
import com.example.shop.payments.dto.Page_BookingDTO;
import com.example.shop.payments.dto.Payments_KeyDTO;




@Mapper
@Repository
public interface PayDAO {

	
	public void Insert_tossPayments(BookingDTO bookingDTO);
	
	public void Insert_Key_tossPayments(Payments_KeyDTO payments_KeyDTO);
	
	public void kakao_Key(KakaoPay_KeyDTO kakaoPayCancelDTO);
	
	//////////////////////////////////////////////////////////////////////

	
	public List<BookingDTO> admin_bookingList(Page_BookingDTO page_BookigListDTO);
	public int count_admin_bookingList();
	
	public List<BookingDTO> user_bookingList(Page_BookingDTO page_BookigListDTO);
	public int count_user_bookingList(int t_id);
	
	
	public KakaoPay_KeyDTO kakaoPay_Cencle(int booking_code);
	
	public void bookingCancel(int booking_code);
	
	public String toss_payments_Cencle(int booking_code);
	
	public List<AddressDTO> user_Page_Address();
	
}
