package com.aniket.findjob.job;
import com.aniket.findjob.company.Company;
import jakarta.persistence.*;

@Entity
//@Table(name = "job_table") //to change name of the table in DB
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // to remove allocation of values of primary ID(id) on our own
    private Long id;
    private String title;
    private String description;
    private String minSalary;
    private String maxSalary;
    private String Location;

    @ManyToOne
    private Company company;

    //default no argument constructor for JPA method
    public Job() {
    }

    public Job(Long id, String title, String description, String minSalary, String maxSalary, String location, Company company) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
        Location = location;
        this.company = company;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(String minSalary) {
        this.minSalary = minSalary;
    }

    public String getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(String maxSalary) {
        this.maxSalary = maxSalary;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }
}
