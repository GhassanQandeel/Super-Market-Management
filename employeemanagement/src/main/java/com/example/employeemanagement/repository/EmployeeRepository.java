package com.example.employeemanagement.repository;

import com.example.employeemanagement.model.*;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    //JPQL Query find by email
    @Query("SELECT e FROM Employee e WHERE e.email=?1")
    List<Employee> findByEmail(String email);

    //JPQL Query find by email and order desc
    @Query("SELECT e FROM Employee e WHERE e.name=?1 order by e.id desc ")
    List<Employee> findEmployeeByNameAndOrderBy(String name, Sort sort);


    //Native Query for select all records
    @Query(value = "SELECT * FROM Employee Order By id ASC ",nativeQuery = true)
    //here should return EmployeeDTO
    List<Employee> find();

    //practice on return some type
    @Query(value = "SELECT e.id ,e.employee_role FROM Employee e where e.id>20",nativeQuery = true)
    List<Map<Long,Role>> findRoleForEveryEmployeeId();

    //return count of specific role.
    @Query(value = "select COUNT(e.employee_role) from Employee e GROUP BY e.employee_role HAVING e.employee_role=:role",nativeQuery = true )
    Integer findNumberOfEmployeeForEachRole(String role);






}
