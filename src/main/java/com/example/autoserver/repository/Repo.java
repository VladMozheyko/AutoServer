package com.example.autoserver.repository;

import com.example.autoserver.model.Client;

import java.util.HashMap;
import java.util.Map;

/**
 * Класс для хранения и обработки пользователей в оперативной памяти - передлаем репозиторий для взаимодействия
 * с БД - создам интерфейс ClientRepository
 */
public class Repo {

    private final Map<Integer, Client> CLIENT_REPOSITORY_MAP = new HashMap<>();
    public static Repo repo;                 // Ссылка на оъект класса - хранится в Metaspace


    /**
     * Создаем приватный конструктор, чтобы запретить создание объекта вне класса, т.е. единственное место, где может
     * быть создан объект - сам класс этого объекта
     */
    private Repo(){

    }

    /**
     * Метод для получение объекта класса, если объект класса не существует, то он создается
     * @return объект классса
     */
    public static Repo getInstance(){
        if(repo == null){                 // Если нет объекта класса, создаем его
            repo = new Repo();
        }
        return repo;                     // Возвращаем объект класса
    }

    public Map<Integer, Client> getCLIENT_REPOSITORY_MAP() {
        return CLIENT_REPOSITORY_MAP;
    }
}
