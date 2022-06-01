package com.autog.register.dto.request;

import com.autog.register.entity.Company;
import com.autog.register.entity.Gestor;

import java.util.List;

public class DTOCompany {
    private Company company;
    private List<Gestor> gestors;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Gestor> getManagers() {
        return gestors;
    }

    public void setManagers(List<Gestor> gestors) {
        this.gestors = gestors;
    }
}
