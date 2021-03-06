package com.asg.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "image")
	private String image;
	
	@Column(name = "price")
	private Integer price;
	
	@Column(name = "create_date")
	private Date create_date;
	
	@Column(name = "available")
	private Integer available;
	
//	@Column(name = "category_id")
//	private Integer category_id;
//	
	@ManyToOne()
	@JoinColumn(
			name = "category_id",
			nullable = false,
			referencedColumnName = "id"
	)
	private Categories cate;
	
	@OneToMany(mappedBy = "product")
	List<OrderDetail> orderDetails;
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", image=" + image + ", price=" + price + ", create_date="
				+ create_date + ", available=" + available + ", cate=" + cate + "]";
	}
	
}
