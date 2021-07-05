package mfsi.learnmvc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mfsi.learnmvc.auth.ERole;
import mfsi.learnmvc.domain.Role;
import mfsi.learnmvc.domain.Singer;
import mfsi.learnmvc.dto.IdName;
import mfsi.learnmvc.dto.SingerDto;
import mfsi.learnmvc.repository.RoleRepository;
import mfsi.learnmvc.util.AppConstant;

@Service
public class RoleService {

	@Autowired
	private RoleRepository repository;

	public void save(Role role) {
		repository.save(role);
	}

	public Role findByName(String name) {
		return repository.findByName(name).orElse(null);
	}

	public void populateRoles() {
		for (ERole roleEnum : ERole.values()) {
			if (!repository.existsByName(roleEnum.role())) {
				Role role = new Role(roleEnum.role());
				role.setCreatedBy(AppConstant.SYSTEM);
				role.setUpdatedBy(AppConstant.SYSTEM);
				save(role);
			}
		}
	}
	public List<IdName> getAll() {
		return repository.getAll();
	}

	public List<IdName> selector() {
		return repository.getAll();
	}
}
