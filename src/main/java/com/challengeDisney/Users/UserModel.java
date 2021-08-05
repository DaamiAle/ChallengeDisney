package com.challengeDisney.Users;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

//import com.challengeDisney.Roles.RolModel;
import com.sun.istack.NotNull;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@Table(name = "users")
public class UserModel{
	@Id
	@SequenceGenerator(name = "seqUser",sequenceName = "seqUser",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqUser")
	private Long id;
	@Column(unique = true) @NotNull
	private String userName;
	@NotNull
	private String password;
	@Column(unique = true) @NotNull //@Email
	private String userEmail;
//	private Integer accessLevel;
//	@NotNull
//	@ManyToOne
//	@JoinColumn(name= "rol_id")
//	private RolModel userRol;
}
