package com.app.service;

import java.util.List;

import com.app.dto.FarmerListDto;
import com.app.entities.UserEntity;

public interface FarmerService 
{


	List<FarmerListDto> getFarmers();

	String updateFarmer(UserEntity obj, Long id);

   
	 
	
}
