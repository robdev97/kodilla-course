package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Employee;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Transactional
@Repository
public interface EmployeeDao extends CrudRepository<Employee, Integer> {
    @Query(
            name = "Employee.findByLastName"
    )
    List<Employee> findByLastName(@Param("LASTNAME") String lastname);

    @Query(name = "Employee.findByLastNameFragment")
    List<Employee> findByLastNameFragment(@Param("LASTNAME_FRAGMENT") String lastnameFragment);
}
