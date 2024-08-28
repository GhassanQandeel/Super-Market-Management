package com.example.employeemanagement.repository;

import com.example.employeemanagement.model.Employee;
import com.example.employeemanagement.specification.dto.EmployeeSearch;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomEmployeeRepository {
    @PersistenceContext
    private EntityManager em ;

    public List<Employee> getEmployeeById(Long id){
        CriteriaBuilder criteriaBuilder=em.getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery= criteriaBuilder.createQuery(Employee.class);
        Root<Employee> employeeRoot=criteriaQuery.from(Employee.class);

        Predicate employeePredicate=criteriaBuilder.equal(employeeRoot.get("id"), id);

        criteriaQuery.select(employeeRoot);
        criteriaQuery.where(employeePredicate);


        return em.createQuery(criteriaQuery).getResultList();
    }
}
