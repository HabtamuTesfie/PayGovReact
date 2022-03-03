package com.mycompany.myapp.domain;

public class EmployeeAddress {
    String name;
    String email;


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String geEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }


    public EmployeeAddress(String name, String email) {
        super();
        this.name = name;
        this.email = email;

    }

    public EmployeeAddress() {}


}
