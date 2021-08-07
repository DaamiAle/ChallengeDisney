package com.challengeDisney.RestControllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.challengeDisney.Models.RolesModel;
import com.challengeDisney.Services.AdministrationPageService;

@RestController
@RequestMapping("/webAdministration")
public class AdministrationPage {
	@Autowired
	AdministrationPageService adminPage;
	@GetMapping("/rolList")
	public ResponseEntity<ArrayList<RolesModel>> getRoles(){
		return new ResponseEntity<ArrayList<RolesModel>>(adminPage.getRoles(), HttpStatus.OK);
	}
	@PostMapping("/createRol")
	public ResponseEntity<?> createNewRol(@RequestParam (required=true, name="newRol")String newRol){
		return new ResponseEntity<>(adminPage.createdRol(newRol) ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST);
	}
}
