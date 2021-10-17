package com.kilic.yunus.university.service;

import com.kilic.yunus.university.data.model.Course;
import com.kilic.yunus.university.data.model.Department;
import com.kilic.yunus.university.data.model.Professor;
import com.kilic.yunus.university.data.model.Schedule;
import com.kilic.yunus.university.data.repository.CourseRepository;
import com.kilic.yunus.university.data.repository.DepartmentRepository;
import com.kilic.yunus.university.data.repository.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@RequiredArgsConstructor
@Service
public class InitDataService {

    private final DepartmentRepository departmentRepository;

    private final ProfessorRepository professorRepository;

    private final CourseRepository courseRepository;

    @PostConstruct
    public void initData() {
        if (departmentRepository.count() > 0) {
            return;
        }

        Department department = new Department();
        department.setName("Physical Sciences");
        Department physical = departmentRepository.save(department);

        department = new Department();
        department.setName("Clinical Medicine");
        Department clinic = departmentRepository.save(department);

        department = new Department();
        department.setName("Biological Sciences");
        Department bio = departmentRepository.save(department);

        department = new Department();
        department.setName("Arts and Humanities");
        Department art = departmentRepository.save(department);

        department = new Department();
        department.setName("Technology");
        Department tech = departmentRepository.save(department);

        department = new Department();
        department.setName("Humanities & Social Sciences");
        Department human = departmentRepository.save(department);

        Professor professor = new Professor();
        professor.setName("John Doe");
        professor.setDepartment(tech);
        Professor john = professorRepository.save(professor);

        professor = new Professor();
        professor.setName("Frida Mcintosh");
        professor.setDepartment(clinic);
        Professor frida = professorRepository.save(professor);

        professor = new Professor();
        professor.setName("Grace Avery");
        professor.setDepartment(physical);
        Professor grace = professorRepository.save(professor);

        professor = new Professor();
        professor.setName("Ada Osborne");
        professor.setDepartment(bio);
        Professor ada = professorRepository.save(professor);

        professor = new Professor();
        professor.setName("Rowan Graves");
        professor.setDepartment(physical);
        Professor rowan = professorRepository.save(professor);

        professor = new Professor();
        professor.setName("Selena Owen");
        professor.setDepartment(tech);
        Professor selena = professorRepository.save(professor);

        professor = new Professor();
        professor.setName("Sarahi Barry");
        professor.setDepartment(clinic);
        Professor sarahi = professorRepository.save(professor);

        professor = new Professor();
        professor.setName("Camden Lin");
        professor.setDepartment(physical);
        Professor camden = professorRepository.save(professor);

        professor = new Professor();
        professor.setName("Daniel Hicks");
        professor.setDepartment(tech);
        Professor daniel = professorRepository.save(professor);

        professor = new Professor();
        professor.setName("Timothy Hickman");
        professor.setDepartment(art);
        Professor timothy = professorRepository.save(professor);

        Course course = new Course();
        course.setName("Pure Mathematics and Mathematical Statistics");
        course.setCredits(3);
        course.setDepartment(physical);
        Course pureMath = courseRepository.save(course);

        course = new Course();
        course.setName("Applied Mathematics and Theoretical Physics");
        course.setCredits(5);
        course.setDepartment(physical);
        Course appliedMath = courseRepository.save(course);


        course = new Course();
        course.setName("Earth Science");
        course.setCredits(7);
        course.setDepartment(physical);
        Course earthScience = courseRepository.save(course);

        course = new Course();
        course.setName("Astronomy");
        course.setCredits(6);
        course.setDepartment(physical);
        Course astronomy = courseRepository.save(course);

        course = new Course();
        course.setName("Physics");
        course.setCredits(8);
        course.setDepartment(physical);
        Course physics = courseRepository.save(course);

        course = new Course();
        course.setName("Geography");
        course.setCredits(7);
        course.setDepartment(physical);
        Course geography = courseRepository.save(course);

        course = new Course();
        course.setName("Materials Science and Metallurgy");
        course.setCredits(5);
        course.setDepartment(physical);
        Course materials = courseRepository.save(course);

        course = new Course();
        course.setName("Chemistry");
        course.setCredits(1);
        course.setDepartment(physical);
        Course chemistry = courseRepository.save(course);

        course = new Course();
        course.setName("Clinical Biochemistry");
        course.setCredits(3);
        course.setDepartment(clinic);
        Course clinicBio = courseRepository.save(course);

        course = new Course();
        course.setName("Clinical Neuroscience");
        course.setCredits(5);
        course.setDepartment(clinic);
        Course clinicNeuro = courseRepository.save(course);

        Schedule schedule = new Schedule();
        schedule.setCourse(pureMath);
        schedule.setSemester(1);
        schedule.setYear(2011);
        rowan.AddSchedule(schedule);
        professorRepository.save(rowan);

        schedule = new Schedule();
        schedule.setCourse(earthScience);
        schedule.setSemester(6);
        schedule.setYear(2012);
        rowan.AddSchedule(schedule);
        professorRepository.save(rowan);

        schedule = new Schedule();
        schedule.setCourse(pureMath);
        schedule.setSemester(1);
        schedule.setYear(2013);
        sarahi.AddSchedule(schedule);
        professorRepository.save(sarahi);

        schedule = new Schedule();
        schedule.setCourse(geography);
        schedule.setSemester(4);
        schedule.setYear(2007);
        rowan.AddSchedule(schedule);
        professorRepository.save(rowan);

        schedule = new Schedule();
        schedule.setCourse(materials);
        schedule.setSemester(6);
        schedule.setYear(2010);
        rowan.AddSchedule(schedule);
        professorRepository.save(rowan);

        schedule = new Schedule();
        schedule.setCourse(clinicBio);
        schedule.setSemester(4);
        schedule.setYear(2005);
        frida.AddSchedule(schedule);
        professorRepository.save(frida);

        schedule = new Schedule();
        schedule.setCourse(clinicBio);
        schedule.setSemester(1);
        schedule.setYear(2014);
        sarahi.AddSchedule(schedule);
        professorRepository.save(sarahi);

        schedule = new Schedule();
        schedule.setCourse(clinicBio);
        schedule.setSemester(5);
        schedule.setYear(2011);
        daniel.AddSchedule(schedule);
        professorRepository.save(daniel);

        schedule = new Schedule();
        schedule.setCourse(clinicNeuro);
        schedule.setSemester(2);
        schedule.setYear(2004);
        frida.AddSchedule(schedule);
        professorRepository.save(frida);

        schedule = new Schedule();
        schedule.setCourse(clinicNeuro);
        schedule.setSemester(6);
        schedule.setYear(2009);
        sarahi.AddSchedule(schedule);
        professorRepository.save(sarahi);

    }
}
