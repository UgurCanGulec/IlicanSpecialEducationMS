package com.ilicanspecialeducation.infrastructure.adapter.employee.repository;

import com.ilicanspecialeducation.infrastructure.adapter.employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
