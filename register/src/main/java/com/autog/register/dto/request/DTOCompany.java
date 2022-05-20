package com.autog.register.dto.request;

import com.autog.register.entity.Company;
import com.autog.register.entity.Manager;

import java.util.List;

public class DTOCompany {
    private Company company;
    private List<Manager> managers;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Manager> getManagers() {
        return managers;
    }

    public void setManagers(List<Manager> managers) {
        this.managers = managers;
    }
}
