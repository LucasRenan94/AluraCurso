package br.com.alura.screenmatch;

import model.DadosSerie;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import service.ConsumoApi;
import service.ConverteDados;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(ScreenmatchApplication.class, args);

	}

	// metodo run como se fosse o metodo main para exec
	@Override
	public void run(String... args) throws Exception {

		var consumoApi = new ConsumoApi();
		var json  =  consumoApi.obterDados("http://www.omdbapi.com/?t=troy&apikey=fc7977b5");
		System.out.println(json);

		ConverteDados conversor = new ConverteDados();
		DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
		System.out.println(dados);

	}

	
}
