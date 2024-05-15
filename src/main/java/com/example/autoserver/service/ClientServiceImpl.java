package com.example.autoserver.service;

import com.example.autoserver.model.Client;
import com.example.autoserver.repository.Repo;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
@Component
public class ClientServiceImpl implements ClientService{

    // Переменная для генерации ID клиента
    private static final AtomicInteger CLIENT_ID_HOLDER = new AtomicInteger();

    /**
     * Создаем образец объекта ClientServiceImpl для его подстановки в нуные нам места
     * @return
     */
    @Bean
    ClientServiceImpl clientService(){
        ClientServiceImpl clientService = new ClientServiceImpl();
        return clientService;
    }

    @Override
    public void create(Client client) {
        final int clientId = CLIENT_ID_HOLDER.incrementAndGet();         // Получаем id для Client
        client.setId(clientId);
        Repo.getInstance().getCLIENT_REPOSITORY_MAP().put(clientId, client);
    }

    @Override
    public List<Client> readAll() {
        return new ArrayList<>(Repo.getInstance().getCLIENT_REPOSITORY_MAP().values());
    }

    @Override
    public Client read(int id) {
        return Repo.getInstance().getCLIENT_REPOSITORY_MAP().get(id);
    }

    @Override
    public boolean update(Client client, int id) {
        if (Repo.getInstance().getCLIENT_REPOSITORY_MAP().containsKey(id)) {
            client.setId(id);
            Repo.getInstance().getCLIENT_REPOSITORY_MAP().put(id, client);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        return Repo.CLIENT_REPOSITORY_MAP.remove(id) != null;
    }
}
