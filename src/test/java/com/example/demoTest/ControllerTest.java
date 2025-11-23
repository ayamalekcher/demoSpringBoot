package com.example.demoTest;

import com.example.demoTest.model.Student;
import com.example.demoTest.repository.StudentRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ControllerTest {

    @Autowired
    private StudentRepository repo;

    @Test
    @Order(1)
    void shouldSaveStudent() {
        Student s = new Student("Charlie", "Algeria");
        repo.save(s);

        assertThat(repo.count()).isEqualTo(1);
    }

    @Test
    @Order(2)
    void shouldFindAllStudents() {
        List<Student> list = repo.findAll();

        assertThat(list).hasSize(1);
        assertThat(list.get(0).getName()).isEqualTo("Charlie");
    }
}
