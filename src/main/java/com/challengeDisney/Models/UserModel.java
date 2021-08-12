package com.challengeDisney.Models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

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
	private String name;
	@Column(unique = true) @NotNull
	private String userEmail;
	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinTable(
	        name = "user_role",
	        joinColumns = @JoinColumn(name = "user_id", nullable = false),
	        inverseJoinColumns = @JoinColumn(name="rol_id", nullable = false)
	        )
	private List<Role> roles;
}
