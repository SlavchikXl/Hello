package com.kogut.recharge.system.tables;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Formatter;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Slava on 24.03.2015.
 */

//@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
@Table(name = "_kjp", catalog = "EKB_P1_ARC")
public class User implements java.io.Serializable {

    private String id;
    private String eMail;
    private String password;
    private String status;

    public User() {
    }

    public User(String eMail, String password) {
        this.eMail = eMail;
        this.password = password;
    }

    public User(String id, String eMail, String password) {
        this.id = id;
        this.eMail = eMail;
        this.password = password;
    }

    public User(String id, String eMail, String password, String status) {
        this.id = id;
        this.eMail = eMail;
        this.password = password;
        this.status = status;
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
    public String getEMail() {
        return this.eMail;
    }

    public void setEMail(String eMail) {
        this.eMail = eMail;
    }

    @Column(name = "password", nullable = false, length = 20)
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "status", nullable = false, length = 1)
    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
