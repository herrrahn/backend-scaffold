package com.rafaelrahn.demospringrrr.customer;

public class CustomerDTO {
    private Integer cust_id;
    private String full_name;
    private String email;

    public CustomerDTO() {}

    public CustomerDTO(Integer cust_id, String full_name, String email) {
        this.cust_id = cust_id;
        this.full_name = full_name;
        this.email = email;
    }

    public Integer getCust_id() {
        return cust_id;
    }

    public void setCust_id(Integer cust_id) {
        this.cust_id = cust_id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
