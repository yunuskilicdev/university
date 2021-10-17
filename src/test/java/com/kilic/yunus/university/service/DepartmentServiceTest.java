package com.kilic.yunus.university.service;

import com.kilic.yunus.university.data.DepartmentDto;
import com.kilic.yunus.university.data.model.Department;
import com.kilic.yunus.university.data.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class DepartmentServiceTest {

    private final Integer preInitDepartmentSize = 6;

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    DepartmentService departmentService;

    @Transactional
    @Test
    void listAll() {
        List<Department> departments = departmentService.listAll();
        assertEquals(preInitDepartmentSize, departments.size());
    }

    @Transactional
    @Test
    void getById() {
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setName("Test");
        Department department = departmentService.create(departmentDto);

        Department response = departmentService.getById(department.getId());
        assertNotNull(response);
        assertNotNull(response.getId());
    }

    @Transactional
    @Test
    void whenIdNotExists_ThenGetByIdThrowsException() {
        ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> {
            departmentService.getById(-1);
        });
        assertEquals("Department not found", exception.getReason());
    }

    @Transactional
    @Test
    void deleteById() {
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setName("Test");
        Department department = departmentService.create(departmentDto);

        assertAll(() -> departmentService.deleteById(department.getId()));
    }

    @Transactional
    @Test
    void whenIdNotExists_ThenDeleteByIdThrowsException() {
        ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> {
            departmentService.deleteById(-1);
        });
        assertEquals("Department not found", exception.getReason());
    }

    @Transactional
    @Test
    void create() {
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setName("Test");
        Department department = departmentService.create(departmentDto);
        assertNotNull(department.getId());
    }

    @Transactional
    @Test
    void whenNameIsEmpty_ThenExceptionThrown() {
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setName("");
        ResponseStatusException responseStatusException = assertThrows(ResponseStatusException.class, () -> {
            departmentService.create(departmentDto);
        });
        assertEquals("Empty name", responseStatusException.getReason());
    }

    @Transactional
    @Test
    void whenNameIsExisting_ThenCreateThrowsException() {
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setName("Test");
        departmentService.create(departmentDto);
        ResponseStatusException responseStatusException = assertThrows(ResponseStatusException.class, () -> {
            departmentService.create(departmentDto);
        });
        assertEquals("Department name exists", responseStatusException.getReason());
    }
}