package br.com.valadares.screensound.repository;

import br.com.valadares.screensound.model.Artista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistaRepository extends JpaRepository<Artista, Long> {
}
