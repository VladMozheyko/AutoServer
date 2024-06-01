package com.example.autoserver.repository;

import com.example.autoserver.model.Auto;
import com.example.autoserver.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;


public interface ClientRepository extends JpaRepository<Client, Integer> {
    Client findById(int id);
}
