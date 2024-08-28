package com.example.employeemanagement.specification;

import com.example.employeemanagement.model.Employee;
import com.example.employeemanagement.specification.dto.EmployeeSearch;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.NonNull;

import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;



public class EmployeeSpecification implements Specification<Employee> {

    private  EmployeeSearch employeeSearch;

    public EmployeeSpecification(EmployeeSearch employeeSearch) {
        this.employeeSearch = employeeSearch;
    }

    @Override
    public Predicate toPredicate(@NonNull Root<Employee> root, CriteriaQuery<?> query, @NonNull CriteriaBuilder cb) {
        List<Predicate> predicates = new ArrayList<>();

        if(employeeSearch.getId()!=null)
            predicates.add(cb.equal(root.get("id"), employeeSearch.getId()));

        if((!(employeeSearch.getName()==null))&&(!employeeSearch.getName().isEmpty()))
            predicates.add(cb.like(root.get("name"), employeeSearch.getName()));

        if((!(employeeSearch.getEmail()==null))&&(!employeeSearch.getEmail().isEmpty()))
            predicates.add(cb.like(root.get("email"), employeeSearch.getEmail()));

        if(!(employeeSearch.getDateOfBirth() ==null))
            predicates.add(cb.between(root.get("dateOfBirth"), employeeSearch.getDateOfBirth(), null));

        if(!(employeeSearch.getCreatedDate()==null))
            predicates.add(cb.between(root.get("createdDate"), employeeSearch.getCreatedDate(), null));

        if(!(employeeSearch.getDeployeDate()==null))
            predicates.add(cb.between(root.get("deployeDate"), employeeSearch.getDeployeDate(), null));

        if(!(employeeSearch.getStartDate()==null))
            predicates.add(cb.between(root.get("startDate"), employeeSearch.getStartDate(), null));

        if(!(employeeSearch.getEmployeeRole()==null))
            predicates.add(cb.equal(root.get("employeeRole"), employeeSearch.getEmployeeRole()));

        return cb.and(predicates.toArray(new Predicate[0]));
    }
}
