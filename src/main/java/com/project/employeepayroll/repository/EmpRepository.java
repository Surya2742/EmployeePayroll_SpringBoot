package com.project.employeepayroll.repository;

import com.project.employeepayroll.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
@Repository
public interface EmpRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findByDepartmentAndName(String department, String name);
    Optional<Employee> findByName(String name);
}
