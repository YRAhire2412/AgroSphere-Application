package com.app.service;

import java.util.List;

import com.app.dto.FarmerListDto;
import com.app.dto.Signup;
import com.app.entities.UserEntity;

public interface UserService {
//sign up
	Signup userRegistration(Signup reqDTO);

	List<FarmerListDto> getUsers();

//	String updateUser(UserEntity obj, Long id);

	String deleteUser(Long id);

	String updateUser(Long id, UserEntity obj);

	UserEntity getUsers(Long id);

	boolean requestPasswordReset(String email);

	boolean resetPassword(String resetToken, String newPassword);
}
