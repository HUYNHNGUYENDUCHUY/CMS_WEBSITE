package com.fa.training.repository;

import com.fa.training.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMemberRepository extends JpaRepository<Member, Long> {
    Member findByUsernameAndPassword(String userName ,String password);
    Member findByUsername(String username);

    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);



}
