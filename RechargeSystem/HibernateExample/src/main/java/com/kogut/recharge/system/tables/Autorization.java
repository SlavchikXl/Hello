package com.kogut.recharge.system.tables;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Slava on 24.03.2015.
 */
@Entity
@Table(name = "Autorization", catalog = "RechargeSystem")
public class Autorization implements java.io.Serializable {

    private String id;
    private String email;
    private String password;

    public Autorization() {
    }

    public Autorization(String id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    @Id
    @Column(name = "id", unique = true, nullable = false, precision = 14, scale = 0)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "email", nullable = false, length = 100)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "password", nullable = false, length = 100)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
