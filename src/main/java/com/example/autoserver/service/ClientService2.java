package com.example.autoserver.service;

import com.example.autoserver.model.Auto;
import com.example.autoserver.model.Client;
import com.example.autoserver.repository.AutoRepository;
import com.example.autoserver.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ClientService2 implements ClientService{

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private AutoRepository autoRepository;

    public List<Auto> getClientsAutos(int id){
        Client client = clientRepository.findById(id);
        if(client!=null){
            List<Auto> autos =  autoRepository.getAutosByClient(client);
            return autos;
        }
        return null;
    }

    @Override
    public void create(Client client) {
        clientRepository.save(client);
    }

    @Override
    public List<Client> readAll() {
        List<Client> clients = clientRepository.findAll();
        if(!clients.isEmpty()){
            return clients;
        }
        return List.of();
    }

    @Override
    public Client read(int id) {
        return clientRepository.findById(id);
    }

    @Override
    public boolean update(Client client, int id) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
