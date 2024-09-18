package com.aniket.findjob.company.impl;

import com.aniket.findjob.company.Company;
import com.aniket.findjob.company.CompanyRepo;
import com.aniket.findjob.company.CompanyService;
import com.aniket.findjob.job.Job;
import com.aniket.findjob.job.JobRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepo companyRepo;
    private Long nextId = 1L;

    public CompanyServiceImpl(CompanyRepo companyRepo) {
        this.companyRepo = companyRepo;
    }

    @Override
    public List<Company> findAll() {
        return companyRepo.findAll();
    }

    @Override
    public boolean updateCompanyById(Long id, Company updatedCompany) {
        Optional<Company> CompanyOptional = companyRepo.findById(id);
        if (CompanyOptional.isPresent()){
            Company companytoUpdate = CompanyOptional.get();
            companytoUpdate.setName(updatedCompany.getName());
            companytoUpdate.setDescription(updatedCompany.getDescription());
            companytoUpdate.setJobs(updatedCompany.getJobs());
            companyRepo.save(companytoUpdate);
            return true;
        }
        return false;
    }

    @Override
    public boolean addCompany(Company company){
        company.setId(nextId++);
        companyRepo.save(company);
        return true;
    }

    @Override
    public Company getCompanyById(Long id) {
        return companyRepo.findById(id).orElse(null);
    }

    @Override
    public boolean deleteCompanyById(Long id) {
        if(companyRepo.existsById(id)){
            companyRepo.deleteById(id);
            return true;
        }else{
            return false;
        }
    }
}
