package com.example.shop.testDate.service;

import java.util.List;
import java.util.Map;

import com.example.shop.testDate.dto.Page_MapDTO;
import com.example.shop.testDate.dto.Page_TestDTO;
import com.example.shop.testDate.dto.ReviewDTO;

import com.example.shop.testDate.dto.main_imagesDTO;
import com.example.shop.testDate.dto.main_sub_bannerDTO;

public interface TestDataService {
	
	public List<main_imagesDTO> main_list(Page_TestDTO Page_TestDTO);
	
	public int count();
	
	public List<main_sub_bannerDTO> main_list_detail(int main_code);
	
	public List<ReviewDTO> ReviewSelect(Page_TestDTO page_TestDTO);
	
	public int reviewCount(int main_code);
	
	public void reviewInsert(ReviewDTO reviewDTO, main_imagesDTO main_imagesDTO);
	
	public List<main_imagesDTO> reviewOneSelect(int review_code);
	
	public void reviewUpdate(ReviewDTO reviewDTO);
	
	public void deleteReview(int review_code);
	
	public void deleteReviewImage(int review_code);
	
	public void insertReviewImage(main_imagesDTO main_imagesDTO);
	
	public List<main_imagesDTO> reviewImagesSelectOne (int review_code);
	
	public void reviewImagesUpdataDelete (main_imagesDTO main_imagesDTO);
	
	public void updateReviewImage(main_imagesDTO main_imagesDTO);
	
	public List<main_imagesDTO> MapSelectList(Page_MapDTO page_MapDTO);
	
	public List<Page_TestDTO> getFilteredData(Map<String, Object> filterParams);

	
}
