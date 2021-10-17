package com.kilic.yunus.university.service;

import com.kilic.yunus.university.data.DepartmentDto;
import com.kilic.yunus.university.data.model.Department;
import com.kilic.yunus.university.data.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public List<Department> listAll() {
        return departmentRepository.findAll();
    }

    public Department getById(Integer id) {
        Optional<Department> byId = departmentRepository.findById(id);
        if (byId.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Department not found");
        }
        return byId.get();
    }

    public void deleteById(Integer id) {
        Optional<Department> byId = departmentRepository.findById(id);
        if (byId.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Department not found");
        }
        departmentRepository.deleteById(id);
        int a = 3;
    }

    public Department create(DepartmentDto dto) {
        if (!StringUtils.hasText(dto.getName())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Empty name");
        }
        Optional<Department> byName = departmentRepository.findByName(dto.getName());
        if (byName.isPresent()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Department name exists");
        }

        Department department = new Department();
        department.setName(dto.getName());
        return departmentRepository.save(department);
    }
}
