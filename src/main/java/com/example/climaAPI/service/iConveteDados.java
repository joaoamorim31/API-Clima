package com.example.climaAPI.service;



public interface iConveteDados {
    <T> T obterDados(String json, Class<T> classe);

}
