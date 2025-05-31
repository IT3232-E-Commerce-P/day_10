package com.example.demo.service;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;


import jakarta.persistence.EntityNotFoundException;
import com.example.demo.model.Department;
import com.example.demo.repo.DepartmentRepo;


@Service
public class DepartmentService {
	@Autowired
	private DepartmentRepo repo;


	public List<Department> getDepts() {
		return repo.findAll();
	}


	public Department getDept(int id) {
		return repo.findById(id).orElseThrow(() -> new EntityNotFoundException("Department Not Found"));
	}


	public String addDept(Department department) {
		if (repo.findById(department.getId()).isPresent()) {
			throw new DuplicateKeyException("The department ID is already available");
		}
		repo.save(department);
		return "New department added";
	}


	public List<String> getDepartmentNames() {
		List<String> names = repo.getDepNames();
		if (names.isEmpty()) {
			throw new EntityNotFoundException("Department Not Found");
		}
		return names;
	}


	public List<Department> searchDepartmentbyName(String name) {
		List<Department> departments = repo.searchName(name);
		if (departments.isEmpty()) {
			throw new EntityNotFoundException("Department Not Found");
		}
		return departments;
	}
}
