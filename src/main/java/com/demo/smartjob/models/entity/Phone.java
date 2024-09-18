package com.demo.smartjob.models.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "PHONES")
public class Phone {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PHONE")
	private Long id;

	@Column(name = "NUMBER", length = 20)
	private String number;

	@Column(name = "CITY_CODE", length = 5)
	private String cityCode;

	@Column(name = "COUNTRY_CODE", length = 5)
	private String countryCode;

	@ManyToOne
	@JoinColumn(name = "ID_USER", foreignKey = @ForeignKey(name = "PHONE_TO_USER"))
	private User user;

}
