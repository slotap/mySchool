package com.slotap.myschool.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "USERS")
public class User {

    private long id;
    private String firstName;
    private String lastName;
    private String pesel;
    private UserRole role;

    public User() {
    }

    User(final long id, final String firstName, final String lastName, final String pesel, final UserRole role) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;
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
}
