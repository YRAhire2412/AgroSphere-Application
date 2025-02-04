package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.FarmerListDto;
import com.app.entities.UserEntity;
import com.app.service.FarmerService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/farmer")

public class FarmerController 
{

		@Autowired
		FarmerService farmerService;
		
		@GetMapping("/list")
		
		public ResponseEntity<?> getAllFarmers()
		{
			List<FarmerListDto> users = farmerService.getFarmers();
			
			if(users.isEmpty())
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			
			return ResponseEntity.ok(users);
			
		}
		
		@PutMapping("/edit/{id}")
		public ResponseEntity<?> updateFarmers(@RequestBody UserEntity obj, @PathVariable Long id)	
		{
			return ResponseEntity.ok(farmerService.updateFarmer(obj, id));
			
		}
}
