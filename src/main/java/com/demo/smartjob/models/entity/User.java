package com.demo.smartjob.models.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "USERS")
@Setter
@Getter
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_USER")
	private Long id;

	@Column(name = "NAME", length = 50, nullable = false)
	private String name;

	@Column(name = "EMAIL", length = 60, nullable = false)
	private String email;

	@Column(name = "PASSWORD", length = 30, nullable = false)
	private String password;

	@OneToMany(mappedBy = "user")
	private List<Phone> phones;

	@Column(name = "CREATED", columnDefinition = "timestamp", nullable = false)
	@CreationTimestamp
	private Instant created;

	@Column(name = "MODIFIED", nullable = false, columnDefinition = "timestamp default current_timestamp")
	@UpdateTimestamp
	private Instant modified;

	@Column(name = "LAST_LOGIN", nullable = false, columnDefinition = "timestamp default current_timestamp")
	@UpdateTimestamp
	private Instant lastLogin;

	@Column(name = "TOKEN")
	private String token;

	@Column(name = "IS_ACTIVE")
	private Boolean isActive;

}
