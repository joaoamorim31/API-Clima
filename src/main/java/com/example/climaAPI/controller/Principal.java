package com.example.climaAPI.controller;

import com.example.climaAPI.model.Clima;
import com.example.climaAPI.service.ConverteDados;
import com.example.climaAPI.service.consumoApi;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

@RestController
public class Principal {
    Scanner scanner = new Scanner(System.in);
    private consumoApi consumo = new consumoApi();
    private ConverteDados conversor = new ConverteDados();
    private final String URL_BASE = "https://api.openweathermap.org/data/2.5/weather?q=";
    private final String API_KEY = "&appid=667c9d5e1fd9eccdb4c7fee0a855863e&units=metric&lang=pt_br";


    public void Iniciar() {
        while (true) {
            System.out.println("Digite o nome da cidade (ou 'sair' para encerrar): ");
            var cidade = scanner.nextLine();

            if (cidade.equalsIgnoreCase("sair")) {
                System.out.println("Encerrando programa...");
                break;
            }
            try {
                String cidadCodificada = URLEncoder.encode(cidade, StandardCharsets.UTF_8.toString());
                buscarCidade(cidadCodificada);
            }catch (Exception e){
                System.out.println("Erro ao codificar o nome da cidade");
            }
        }
        scanner.close();
        System.exit(0);
    }


    public void buscarCidade(String cidade) {

        try {
            String endereco = URL_BASE + cidade + API_KEY;
            var json = consumo.obterDados(endereco);
            Clima dados = conversor.obterDados(json, Clima.class);
            System.out.println(dados);
        } catch (Exception e) {
            System.out.println("Erro ao buscar cidade " + cidade);
        }
    }

}