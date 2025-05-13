package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Transactional
@Repository
public interface CompanyDao extends CrudRepository<Company, Integer> {

    @Query(
            nativeQuery = true,
            value = "SELECT * FROM COMPANIES WHERE LEFT(COMPANY_NAME, 3) = :PREFIX"
    )
    List<Company> findByFirstThreeLetters(@Param("PREFIX") String prefix);

    @Query(name = "Company.findByNameFragment")
    List<Company> findByNameFragment(@Param("NAME_FRAGMENT") String nameFragment);

}
