package com.aniket.findjob.company;

import com.aniket.findjob.job.Job;

import java.util.List;

public interface CompanyService {

    boolean updateCompanyById(Long id, Company updatedCompany);

    boolean addCompany(Company company);

    Company getCompanyById(Long id);

    boolean deleteCompanyById(Long id);

    List<Company> findAll();
}
