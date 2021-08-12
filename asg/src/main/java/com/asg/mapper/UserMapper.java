package com.asg.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.asg.dto.UserDTO;
import com.asg.entity.User;


@Component //định nghĩa lớp này là 1 spring bean
public class UserMapper {
	@Autowired
	private ModelMapper mapper;
	
	public User convertToEntity(UserDTO userDTO ) {
		User entity = new User();
		mapper.map(userDTO,entity);
		return entity ;
	}
	
	public UserDTO convertToDTO(User entity) {
		UserDTO userDTO = new UserDTO();
		mapper.map(entity, userDTO);
		return userDTO;
	}
}
