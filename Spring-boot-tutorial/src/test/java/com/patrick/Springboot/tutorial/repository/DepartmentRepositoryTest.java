package com.patrick.Springboot.tutorial.repository;


import com.patrick.Springboot.tutorial.entity.Department;
import lombok.Data;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;


import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .departmentName("IT")
                .departmentCode("IT1")
                .departmentAddress("서울시 서초구 서초동")
                .build();

        entityManager.persist(department);

    }

    @Test
    public void whenFindByID_thenReturnDepartment() {
        Department department = departmentRepository.findById(1L).get();
        assertEquals("IT", department.getDepartmentName());
    }
}