package com.service.Authentication.Entities;

import com.service.Authentication.Enums.CitiesEnum;
import com.service.Authentication.Enums.GenderEnum;
import jakarta.persistence.*;

import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    private int id;
    @Enumerated(EnumType.STRING)
    private GenderEnum gender;
    @NotNull
    private String email;
    @NotNull

    private String password;
    @NotNull

    private String name;
    @NotNull

    private String lastname;
    @NotNull

    @Enumerated(EnumType.STRING)
    private CitiesEnum city;
    @NotNull
    private String phone;
    @NotNull
    private String address;

    private String token;
    private boolean isAdmin;

    public User() {
    }

    public User(int id, GenderEnum gender, String email, String password, String name, String lastname, CitiesEnum city, String phone, String address) {
        this.id = id;
        this.gender = gender;
        this.email = email;
        this.password = password;
        this.name = name;
        this.lastname = lastname;
        this.city = city;
        this.phone = phone;
        this.address = address;
    }
    public User(GenderEnum gender, String email, String password, String name, String lastname, CitiesEnum city, String phone, String address) {

        this.gender = gender;
        this.email = email;
        this.password = password;
        this.name = name;
        this.lastname = lastname;
        this.city = city;
        this.phone = phone;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setId(int id) {
        this.id = id;
    }

    public GenderEnum getGender() {
        return gender;
    }

    public void setGender(GenderEnum gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public CitiesEnum getCity() {
        return city;
    }

    public void setCity(CitiesEnum city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
