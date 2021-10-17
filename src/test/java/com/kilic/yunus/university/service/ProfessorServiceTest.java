package com.kilic.yunus.university.service;

import com.kilic.yunus.university.data.DepartmentDto;
import com.kilic.yunus.university.data.ProfessorDto;
import com.kilic.yunus.university.data.SearchDto;
import com.kilic.yunus.university.data.model.Department;
import com.kilic.yunus.university.data.model.Professor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
class ProfessorServiceTest {

    private final Integer preInitProfessorSize = 10;
    private final Integer searchResultProfessorSize = 4;

    @Autowired
    ProfessorService professorService;

    @Autowired
    DepartmentService departmentService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void listAllProfessorsHaveSchedule() {
        SearchDto[] searchDtos = professorService.listAllProfessorsHaveSchedule();
        assertEquals(searchResultProfessorSize, searchDtos.length);
    }

    @Test
    void listAll() {
        List<Professor> professors = professorService.listAll();
        assertEquals(preInitProfessorSize, professors.size());
    }

    @Test
    void getById() {
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setName("Test");
        Department department = departmentService.create(departmentDto);

        ProfessorDto professorDto = new ProfessorDto();
        professorDto.setName("Test");
        professorDto.setDepartmentId(department.getId());
        Professor professor = professorService.create(professorDto);

        Professor response = professorService.getById(professor.getId());
        assertNotNull(response);
        assertNotNull(response.getId());
    }

    @Test
    void whenIdNotExists_ThenGetByIdThrowsException() {
        ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> {
            professorService.getById(-1);
        });
        assertEquals("Professor not found", exception.getReason());
    }

    @Test
    void deleteById() {
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setName("Test");
        Department department = departmentService.create(departmentDto);

        ProfessorDto professorDto = new ProfessorDto();
        professorDto.setName("Test");
        professorDto.setDepartmentId(department.getId());
        Professor professor = professorService.create(professorDto);

        assertAll(() -> professorService.deleteById(professor.getId()));
    }

    @Test
    void whenIdNotExists_ThenDeleteByIdThrowsException() {
        ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> {
            professorService.deleteById(-1);
        });
        assertEquals("Professor not found", exception.getReason());
    }

    @Test
    void create() {
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setName("Test");
        Department department = departmentService.create(departmentDto);
        ProfessorDto professorDto = new ProfessorDto();
        professorDto.setName("Test");
        professorDto.setDepartmentId(department.getId());
        Professor professor = professorService.create(professorDto);
        assertNotNull(professor.getId());
    }

    @Test
    void whenDepartmentNotExist_ThenCreateThrowsException() {
        ProfessorDto professorDto = new ProfessorDto();
        professorDto.setName("Test");
        professorDto.setDepartmentId(-1);
        ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> {
            professorService.create(professorDto);
        });
        assertEquals("Department not found", exception.getReason());
    }
}