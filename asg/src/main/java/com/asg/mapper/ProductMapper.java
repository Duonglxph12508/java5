package com.asg.mapper;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.asg.dto.ProductDTO;
import com.asg.entity.Product;

@Component
public class ProductMapper {
	@Autowired
	private ModelMapper mapper;
	
	public Product ConvertToEntity(ProductDTO prdDTO) {
		Product prd = new Product();
		mapper.map(prdDTO, prd);
		return prd;
	}
	
	public ProductDTO ConvertToDTO(Product prd) {
		ProductDTO prdDTO = new ProductDTO();
		mapper.map(prd, prdDTO);
		return prdDTO;
	}
}
