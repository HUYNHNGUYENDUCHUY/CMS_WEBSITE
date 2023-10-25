package com.fa.training.service;

import com.fa.training.entity.Role;
import com.fa.training.repository.IRoleRepository;
import com.fa.training.service.templates.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private IRoleRepository roleRepository;

    @Override
    public void save(Role role) {
        roleRepository.save(role);
    }
}
