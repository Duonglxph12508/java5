package com.asg.dto;

import java.sql.Date;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import com.asg.entity.Categories;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
	 
	private Integer id;
	
	@NotNull
	private String name;
	
	
	private String image;
	
	@NotNull
	private Integer price;
	
	
	private Date create_date;
	
	@NotNull
	private Integer available;
	
	@NotNull
	private Categories cate;

	@Override
	public String toString() {
		return "productDTO [id=" + id + ", name=" + name + ", image=" + image + ", price=" + price + ", create_date="
				+ create_date + ", avalabe=" + available + ", categoryId=" + cate + "]";
	}
	

}
