package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class SearchFacadeTest {

    @Autowired
    private SearchFacade searchFacade;

    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private EmployeeDao employeeDao;

    @Test
    void findCompaniesByFragment() {
        //Given
        Company company = new Company("Kodilla Industries");
        companyDao.save(company);

        //When
        List<Company> result = searchFacade.findCompaniesByFragment("dill");

        //Then
        assertEquals(1, result.size());
        assertEquals("Kodilla Industries", result.get(0).getName());

        //Clean up
        companyDao.delete(company);
    }

    @Test
    void findEmployeesByFragment() {
        //Given
        Employee employee = new Employee("Jakub","Jakubowski");
        employeeDao.save(employee);

        //When
        List<Employee> result = searchFacade.findEmployeesByFragment("bows");

        //Then
        assertEquals(1, result.size());
        assertEquals("Jakubowski", result.get(0).getLastname());

        //Clean up
        employeeDao.delete(employee);
    }

}
