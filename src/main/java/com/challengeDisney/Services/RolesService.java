package com.challengeDisney.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import com.challengeDisney.Models.RolesModel;
import com.challengeDisney.Repositories.RolesRepository;

@Service
public class RolesService {
	@Autowired
	RolesRepository rolRepo;

	public List<RolesModel> getAll() {
		return rolRepo.findAll();
	}

	public RolesModel create(String newRol) {
		RolesModel rolEntity = new RolesModel();
		rolEntity.setAuthoritie(new SimpleGrantedAuthority(newRol));
		return rolRepo.saveAndFlush(rolEntity);
	}
	
	
}
