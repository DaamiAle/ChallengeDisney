package com.challengeDisney.Users;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.challengeDisney.Roles.RolModel;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@Table(name = "users")
public class UserModel{
	@Id
	@SequenceGenerator(name = "sequenceUser",sequenceName = "sequenceUser",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceUser")
	private Long id;
	private String userName;
	private String password;
	@ManyToOne
	@JoinColumn(name= "id_rol")
	private RolModel userRol;
}
