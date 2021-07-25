package com.challengeDisney.Roles;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.challengeDisney.Users.UserModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@Table(name = "roles")
public class RolModel {
	@Id
	@SequenceGenerator(name = "sequenceRol",sequenceName = "sequenceRol",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceRol")
	private Long id;
	private String rolName;
	@OneToMany(mappedBy = "userRol", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<UserModel> userModel;
}
