package com.kodilla.hibernate.manytomany;


import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;


import java.util.ArrayList;
import java.util.List;


@NamedNativeQuery(
        name = "Company.findByFirstThreeLetters",
        query = "SELECT * FROM COMPANIES WHERE LEFT(COMPANY_NAME, 3) = :PREFIX",
        resultClass = Company.class
)
@NamedQuery(
        name = "Company.findByNameFragment",
        query = "FROM Company WHERE name LIKE :NAME_FRAGMENT"
)
@Entity
@Table(name = "COMPANIES")
public class Company {

    private int id;
    private String name;
    private List<Employee> employees = new ArrayList<>();

    public Company() {
    }

    public Company(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "COMPANY_ID", unique = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NotNull
    @Column(name = "COMPANY_NAME", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "companies")
    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
