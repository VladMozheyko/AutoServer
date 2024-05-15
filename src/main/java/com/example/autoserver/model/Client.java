package com.example.autoserver.model;

import jakarta.persistence.*;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.atomic.AtomicInteger;

@Entity
@Table(name = "Client")
public class Client {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;                                             // Поля класса
    private String name;
    private String email;
    private String phone;

    public Client() {

    }

    public int getId() {                             // Набор геттеров и сетеров
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
