package com.asg.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order_details ")
public class OrderDetail implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "order_id",
			nullable = false,
			referencedColumnName = "id")
	Order order;
	
	@ManyToOne 
	@JoinColumn(name = "product_id",
			nullable = false,
			referencedColumnName = "id")
	Product product;
	@Column(name = "quantity")
	private Integer quantity ;
	
	@Column(name = "price")
	private Integer price;

	@Override
	public String toString() {
		return "OderDetail [id=" + id + ", order=" + order + ", product=" + product + ", quantity=" + quantity
				+ ", price=" + price + "]";
	}

	
}
