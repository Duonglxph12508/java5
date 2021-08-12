package com.asg.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoriesDTO {
	@NotNull
	private Integer id;
	
	@NotNull(message="Tên danh mục không được để trống")
	@NotBlank
	private String name;

	@Override
	public String toString() {
		return "CategoriesDTO [id=" + id + ", name=" + name + "]";
	}
	
}
