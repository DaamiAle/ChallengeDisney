package com.challengeDisney.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.challengeDisney.Models.RolesModel;

@Repository
public interface RolesRepository extends JpaRepository<RolesModel, Long>{
}
