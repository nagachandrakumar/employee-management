package com.leadsquared.employee.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "project")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Project {

    @Id
    @Column(name = "proj_code")
    private String projCode;

    @Column(name = "proj_name")
    private String projName;

    public Project(){}

    public Project(String projCode, String projName) {
        this.projCode = projCode;
        this.projName = projName;
    }

    public String getProjName() {
        return projName;
    }

    public void setProjName(String projName) {
        this.projName = projName;
    }

    public String getProjCode() {
        return projCode;
    }

    public void setProjCode(String projCode) {
        this.projCode = projCode;
    }

}
