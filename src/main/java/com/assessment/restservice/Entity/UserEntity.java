package com.assessment.restservice.Entity;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class UserEntity {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_generator")
	@SequenceGenerator(name = "user_id_generator", sequenceName = "user_id_seq", allocationSize = 1)
	private Long id;

	@Column(name = "email_address")
	private String emailAddress;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
}
