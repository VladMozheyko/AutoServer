package com.example.autoserver.repository;

import com.example.autoserver.model.Auto;
import com.example.autoserver.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AutoRepository extends JpaRepository<Auto, Integer> {
    List<Auto> getAutosByClient(Client client);
}
