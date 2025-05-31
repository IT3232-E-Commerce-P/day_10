package com.example.demo.repo;


import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.example.demo.model.Department;
import com.example.demo.model.Employee;


@Repository
public interface DepartmentRepo extends JpaRepository<Department, Integer> {
	@Query("SELECT d.name FROM Department d")
	List<String> getDepNames();


	@Query("SELECT d FROM Department d WHERE d.name LIKE %?1%")
	List<Department> searchName(String name);
}
