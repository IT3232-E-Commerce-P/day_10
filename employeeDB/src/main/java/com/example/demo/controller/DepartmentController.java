package com.example.demo.controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.model.Department;
import com.example.demo.service.DepartmentService;


@RestController
@RequestMapping("/dept")
public class DepartmentController {
	@Autowired
	public DepartmentService service;


	@GetMapping
	public ResponseEntity<List<Department>> getDepts() {
		return new ResponseEntity<List<Department>>(service.getDepts(), HttpStatus.OK);
	}


	@GetMapping("/{id}")
	public ResponseEntity<Department> getDept(@PathVariable("id") int id) {
		if (service.getDept(id) == null) {
			return new ResponseEntity<Department>(service.getDept(id), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Department>(service.getDept(id), HttpStatus.OK);
	}


	@GetMapping("/names")
	public ResponseEntity<List<String>> getNames() {
		return new ResponseEntity<List<String>>(service.getDepartmentNames(), HttpStatus.OK);
	}


	@GetMapping("/search/{name}")
	public ResponseEntity<List<Department>> searchDepts(@PathVariable("name") String name) {
		return new ResponseEntity<List<Department>>(service.searchDepartmentbyName(name), HttpStatus.OK);
	}
}
