package com.demo.smartjob.models.service;

import com.demo.smartjob.models.dto.UserDTO;
import com.demo.smartjob.models.dto.UserResponseDTO;

public interface IUserService {

	UserResponseDTO create(UserDTO user);

	void update(UserDTO user);

	UserResponseDTO getItemById(Long id);

	void delete (Long id);


}
