package com.asg.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItem {

	Integer productId;
	String productName;
	Integer price;
	int quantity = 1;
}
