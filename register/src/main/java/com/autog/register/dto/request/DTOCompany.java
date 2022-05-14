package com.autog.register.dto.request;

import com.autog.register.entity.Company;

import java.util.List;

public class DTOCompany {
    private Company company;
    private List<Company.Manager> managers;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Company.Manager> getManagers() {
        return managers;
    }

    public void setManagers(List<Company.Manager> managers) {
        this.managers = managers;
    }
}
