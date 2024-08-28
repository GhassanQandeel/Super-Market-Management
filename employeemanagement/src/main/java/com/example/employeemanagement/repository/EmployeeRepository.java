package com.example.employeemanagement.repository;

import com.example.employeemanagement.model.*;
import com.example.employeemanagement.projections.EmployeeProjections;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>, JpaSpecificationExecutor<Employee> {



    @Query(nativeQuery = true,value = ("""
            SELECT e.id ,e.name,e.email,e.employee_role
            FROM employee e
            """))
    List<EmployeeProjections> findAllEmployeesBySomeAttributes();













































/*

    //JPQL Query find by email
    @Query("""
            SELECT e
            FROM Employee e
            WHERE e.email=?1
            """)
    List<Employee> findByEmail(String email);



    //practice on return some type
    @Query(nativeQuery = true,value =
            ("""
            SELECT e.id ,e.employee_role
            FROM Employee e
            """))
    List<Map<Long,Role>> findRoleForEveryEmployeeId();














    // number of role employees
    @Query(nativeQuery = true,value =
              ("""
               select COUNT(e.employee_role) 
               from Employee e
               GROUP BY e.employee_role
               HAVING e.employee_role=:role
               """))
    Integer findNumberOfEmployeeForEachRole(String role);
*/


}
