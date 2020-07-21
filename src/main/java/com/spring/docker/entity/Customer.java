package com.spring.docker.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "customer")
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("Customer Entity")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;

	@Size(min = 3)
	@ApiModelProperty("Must have greater value then 3")
	@Column(name = "first_name")
	String firstName;

	@Size(min = 3)
	@ApiModelProperty("Must have greater value then 3")
	@Column(name = "last_name")
	String lastName;

	@Size(min = 3)
	@ApiModelProperty("Must have greater value then 3")
	@Column(name = "email")
	String email;

	public Customer(String firstName,String lastName,String email) {
		this.firstName=firstName;
		this.lastName=lastName;
		this.email=email;
	}

	public Customer toUpperCaseLastName(){
		if(this.lastName!=null)
			this.lastName=this.lastName.toUpperCase();
		return this;
	}
}
