package com.asg.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.asg.dto.CategoriesDTO;
import com.asg.dto.UserDTO;
import com.asg.entity.Categories;
import com.asg.entity.User;

@Component
public class CateMapper {
	@Autowired
	private ModelMapper mapper;

	public Categories convertToEntity(CategoriesDTO cateDTO) {
		Categories cate = new Categories();
		mapper.map(cateDTO, cate);
		return cate;
	}

	public CategoriesDTO convertToDTO(Categories cate) {
		CategoriesDTO cateDTO = new CategoriesDTO();
		mapper.map(cate,cateDTO);
		return cateDTO;
	}
}
