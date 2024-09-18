package com.demo.smartjob.models.service;

import com.demo.smartjob.enums.ErrorCodeEnum;
import com.demo.smartjob.exception.EmailException;
import com.demo.smartjob.exception.EntityException;
import com.demo.smartjob.mapper.UserMapper;
import com.demo.smartjob.models.dto.UserDTO;
import com.demo.smartjob.models.dto.UserResponseDTO;
import com.demo.smartjob.models.entity.User;
import com.demo.smartjob.models.repository.IUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Optional;


@Service
@Slf4j
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserRepository repository;

	private final UserMapper mapper = Mappers.getMapper(UserMapper.class);


	@Override
	@Transactional
	public UserResponseDTO create(UserDTO user) {
		log.info("Service call repository saving user");
		validateEmail(repository.findByEmail(user.getEmail()));
		User result = mapper.userDTOtoUser(user);
		User userBD = repository.save(result);
		log.info("Service success saving user");
		return mapper.INSTANCE.userToUserResponseDTO(userBD);
	}

	@Override
	@Transactional
	public void update(UserDTO userDTO) {
		log.info("Service call repository update user");
		Optional<User> user = repository.findById(userDTO.getId());
		user.ifPresent(
				user1-> {
					user1.setPassword(userDTO.getPassword());
					user1.setName(userDTO.getName());
					user1.setEmail(userDTO.getEmail());
					user1.setModified(Instant.now());
					user1.setLastLogin(Instant.now());
					user1.setPhones(mapper.phoneToPhoneDTOList(userDTO.getPhones()));
					repository.save(user1);
					log.info("Service success saving update user");
				}
		);

	}

	@Override
	@Transactional(readOnly = true)
	public UserResponseDTO getItemById(Long id) {
		log.info("Service call repository find user with id {}", id);
		User user = repository.findById(id).orElseThrow(() -> new EntityException(User.class.toString(), "id", id));
		log.info("Service success repository find user with id {}", id);
		return mapper.INSTANCE.userToUserResponseDTO(user);
	}

	@Override
	public void delete (Long id) {
		log.info("Service call repository find user with id {}", id);
		User user = repository.findById(id).orElseThrow(() -> new EntityException(User.class.toString(), "id", id));
		log.info("Service success repository delete transaction with id {}", id);
		repository.delete(user);
	}


	private void validateEmail(User result) {
		if(result != null){
			throw new EmailException(ErrorCodeEnum.BAD_REQUEST, "El correo ya se encuentra registrado");
		}
	}
}
