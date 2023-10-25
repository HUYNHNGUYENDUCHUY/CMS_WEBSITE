package com.fa.training.repository;

import com.fa.training.entity.Role;
import com.fa.training.entity.enums.ERole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRoleRepository extends JpaRepository <Role,Long >{
    List<Role> findByName(ERole name);
}
