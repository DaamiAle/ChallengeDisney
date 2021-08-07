package com.challengeDisney.Services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challengeDisney.Models.RolesModel;

@Service
public class AdministrationPageService {
	@Autowired
	RolesService rolService;
	
	public ArrayList<RolesModel> getRoles() {
		return (ArrayList<RolesModel>) rolService.getAll();
	}

	public boolean createdRol(String newRol) {
		return rolService.create(newRol) != null;
	}
	
}
