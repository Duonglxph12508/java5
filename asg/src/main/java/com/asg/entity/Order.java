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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.lang.Nullable;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "create_date")
	private Date createDate = new Date();
	
	
	@Column(name = "address")
	private String address;
	
	
//	@Override
//	public String toString() {
//		return "Order [id=" + id + ", createDate=" + createDate + ", address=" + address + ", user=" + user + "]";
//	}


	@ManyToOne()
	@JoinColumn(
			name = "user_id",
			nullable = false,
			referencedColumnName = "id"
	)
	private User user;
	
	@OneToMany(mappedBy = "order")
	List<OrderDetail> orderDetails;
}
