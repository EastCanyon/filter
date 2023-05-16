package com.example.shop.testDate.service;

import java.util.List;
import java.util.Map;

import org.apache.tomcat.jni.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.shop.testDate.dao.TestDataDAO;
import com.example.shop.testDate.dto.Page_MapDTO;
import com.example.shop.testDate.dto.Page_TestDTO;
import com.example.shop.testDate.dto.ReviewDTO;

import com.example.shop.testDate.dto.main_imagesDTO;
import com.example.shop.testDate.dto.main_sub_bannerDTO;

@Service
public class ServiceImpl implements TestDataService{

	@Autowired
	private TestDataDAO dao;
	
	
	@Override
	public List<main_imagesDTO> main_list(Page_TestDTO Page_TestDTO) {
		
		return dao.main_list(Page_TestDTO);
	}


	@Override
	public int count() {
		
		return dao.count();
	}


	@Override
	public List<main_sub_bannerDTO> main_list_detail(int main_code) {
		
		return dao.main_list_detail(main_code);
	}


	@Override
	public List<ReviewDTO> ReviewSelect(Page_TestDTO page_TestDTO) {
		return dao.ReviewSelect(page_TestDTO);
	}


	@Override
	public int reviewCount(int main_code) {
		return dao.reviewCount(main_code);
	}


	@Override
	public void reviewInsert(ReviewDTO reviewDTO, main_imagesDTO main_imagesDTO) {
			
			
			//답변글이면
			if(reviewDTO.getRef() != 0) {
				//dao.reStepCount(reviewDTO);
				reviewDTO.setRe_step(reviewDTO.getRe_step() + 1);
				reviewDTO.setRe_level(reviewDTO.getRe_level() + 1);
			}
			//제목글이면
			dao.reviewInsert(reviewDTO);
			
			main_imagesDTO.setReview_code(reviewDTO.getReview_code());
			
			
//			int result = hotelDAO.insertReview(review);
//			 
//			if (reviewImages != null && !reviewImages.isEmpty()) {
//			       for (ImageDTO reviewImage : reviewImages) {
//			          reviewImage.setReview_code(review.getReview_code());
//			          hotelDAO.insertReviewImage(reviewImage);
//			       }
//			    }
//		    
//			return result;
		
	}


	


	@Override
	public void reviewUpdate(ReviewDTO reviewDTO) {
		dao.reviewUpdate(reviewDTO);
	}


	@Override
	public List<main_imagesDTO> reviewOneSelect(int review_code) {
		
		return 	dao.reviewOneSelect(review_code);
	}


	@Override
	public void deleteReview(int review_code) {
		dao.deleteReview(review_code);
		
	}


	@Override
	public void deleteReviewImage(int review_code) {
		dao.deleteReviewImage(review_code);
	}


	@Override
	public void insertReviewImage(main_imagesDTO main_imagesDTO) {
		
		System.out.println("service : " + main_imagesDTO);
		
		dao.insertReviewImage(main_imagesDTO);
		
	}


	@Override
	public List<main_imagesDTO> reviewImagesSelectOne(int review_code) {
		
		return dao.reviewImagesSelectOne(review_code);
	}


	@Override
	public void reviewImagesUpdataDelete(main_imagesDTO main_imagesDTO) {
		dao.reviewImagesUpdataDelete(main_imagesDTO);
		
		
		
		//main_imagesDTO.getFilepath()
		
		
	}


	@Override
	public void updateReviewImage(main_imagesDTO main_imagesDTO) {
		
		dao.updateReviewImage(main_imagesDTO);
	}


	@Override
	public List<main_imagesDTO> MapSelectList(Page_MapDTO page_MapDTO) {
		return dao.MapSelectList(page_MapDTO);		
	}
	
	@Override
	public List<Page_TestDTO> getFilteredData(Map<String, Object> filterParams) {
	    // filterParams를 이용하여 필터링된 데이터 조회 로직 구현
	    // 필터링 조건에 따라 데이터베이스 쿼리를 생성하거나 다른 서비스/DAO를 호출하여 데이터를 조회
	    
	    // 예시: filterParams에서 필터링 조건 추출
	    List<String> regions = (List<String>) filterParams.get("regions");
	    List<String> categories = (List<String>) filterParams.get("categories");
	    List<String> etcs = (List<String>) filterParams.get("etcs");
	    
	    // 예시: DAO를 통해 필터링된 데이터 조회
	    List<Page_TestDTO> filteredData = dao.getFilteredData(regions, categories, etcs);
	    
	    return filteredData;
	}
}
