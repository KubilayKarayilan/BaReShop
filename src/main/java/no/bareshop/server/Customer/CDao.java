package no.bareshop.server.Customer;

import org.springframework.context.annotation.Bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by kubilay on 30.04.2015.
 */  @Entity
     @Table(name="person")
     public class CDao implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "fullname")
    private String fullname;
    @Column(name = "email")
    private String email;
    @Column(name = "tlf")
    private int tlf;
    @Column(name="tlfUID")
    private String tlfUID;

    public Long getId() {
        return id;
    }

    public CDao setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public CDao setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public CDao setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getFullname() {
        return fullname;
    }

    public CDao setFullname(String fullname) {
        this.fullname = fullname;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public CDao setEmail(String email) {
        this.email = email;
        return this;
    }

    public int getTlf() {
        return tlf;
    }

    public CDao setTlf(int tlf) {
        this.tlf = tlf;
        return this;
    }

    public String getTlfUID() {
        return tlfUID;
    }

    public CDao setTlfUID(String tlfUID) {
        this.tlfUID = tlfUID;
        return this;
    }
}
