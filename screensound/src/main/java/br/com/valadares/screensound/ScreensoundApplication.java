package br.com.valadares.screensound;

import br.com.valadares.screensound.principal.Principal;
import br.com.valadares.screensound.repository.ArtistaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreensoundApplication implements CommandLineRunner {
	private ArtistaRepository repositorio;

	public static void main(String[] args) {
		SpringApplication.run(ScreensoundApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(repositorio);
		principal.exibiMenu();
	}
}
