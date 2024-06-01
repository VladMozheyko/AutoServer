package com.example.autoserver.controller;

import com.example.autoserver.model.Auto;
import com.example.autoserver.model.Client;
import com.example.autoserver.service.ClientService;
import com.example.autoserver.service.ClientService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс выполняющий обработку клиентов(CRUD)
 * @version 1
 * @author Vlad
 */
@RestController
public class ClientController {


    // Инверсия контроля clientService получается из Бина, созданного в классе ClientServiceImpl(на строке 24)
    @Autowired
    ClientService2 clientService2;


    /**
     * Метод обрабатывающий post-запрос по мапингу clients
     * @param client объект Client - фремворк сам обработает JSON в этот объект
     * @return статус ответа - 201(Создан)
     */
    @PostMapping(value = "/clients")
    public ResponseEntity<?> create(@RequestBody Client client) {
        clientService2.create(client);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // Делаем новый коммит

    @GetMapping(value = "/clients")
    public ResponseEntity<List<Client>> read() {
        final List<Client> clients = clientService2.readAll();

        return clients != null &&  !clients.isEmpty()
                ? new ResponseEntity<>(clients, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/getClient{id}")
    public Client read(int id) {
        final Client client = clientService2.read(id);

        return client;
    }


    @GetMapping(value = "/getAutos{id}")
    public List<Auto> getAutos(int id){
       return clientService2.getClientsAutos(id);
    }

    @PutMapping(value = "/clients/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody Client client) {
        final boolean updated = clientService2.update(client, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/clients/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = clientService2.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
