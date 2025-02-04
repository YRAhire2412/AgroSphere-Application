package com.app.dto.modelMapper;

import org.springframework.stereotype.Component;

import com.app.dao.UserEntityDao;
import com.app.dto.FarmerListDto;
import com.app.entities.UserEntity;


@Component
public class ModelMapper {
	
	public FarmerListDto UserEntityToFarmerDto(UserEntity userEntity) {
		return FarmerListDto.builder()
				.firstName(userEntity.getFirstName())
				.lastName(userEntity.getLastName())
				.email(userEntity.getEmail())
				.role(userEntity.getRole())
				.address(userEntity.getAddress())
				.contactNo(userEntity.getContactNo())
				.build();
		
	}

}
