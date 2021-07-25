package com.challengeDisney.Roles;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolService {
	@Autowired
	RolRepository rolRepo;
	
	public RolModel createRol(RolModel rol) {
		return rolRepo.save(rol);
	}
	
	public ArrayList<RolModel> getRoles(){
		return (ArrayList<RolModel>) rolRepo.findAll();
	}
	
	public boolean deleteRol(Long id) {
		boolean okAction;
		try {
			rolRepo.deleteById(id);
			okAction = true;
		}
		catch(Exception err){
			okAction = false;
		}
		return okAction;
	}

}
