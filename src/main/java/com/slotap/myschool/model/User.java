package com.slotap.myschool.model;

import org.hibernate.validator.constraints.pl.PESEL;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "USERS")
public class User {

    private long id;
    private String firstName;
    private String lastName;
    private String pesel;
    private String address;
    private String email;
    private UserRole role;

    public User(){}

    public User(final String firstName, final String lastName, final String pesel, final String email,final String address, final UserRole role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;
        this.email = email;
        this.address = address;
        this.role = role;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID", unique = true)
    public long getId() {
        return id;
    }

    private void setId(final long id) {
        this.id = id;
    }

    @NotNull
    @Column(name = "FIRSTNAME")
    public String getFirstName() {
        return firstName;
    }

    private void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    @NotNull
    @Column(name = "LASTNAME")
    public String getLastName() {
        return lastName;
    }

    private void setLastName(final String lastName) {
        this.lastName = lastName;
    }

   // @PESEL
    @NotNull
    @Column(name = "PESEL")
    public String getPesel() {
        return pesel;
    }

    private void setPesel(final String pesel) {
        this.pesel = pesel;
    }

    @NotNull
    @Column(name = "ROLE")
    public UserRole getRole() {
        return role;
    }

    private void setRole(final UserRole role) {
        this.role = role;
    }

    @Column(name = "ADDRESS")
    public String getAddress() {
        return address;
    }

    private void setAddress(final String address) {
        this.address = address;
    }

    @Email
    @Column(name = "EMAIL")
    public String getEmail() {
        return email;
    }

    private void setEmail(final String email) {
        this.email = email;
    }
}
