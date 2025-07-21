package br.com.valadares.screensound.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "artistas")
public class Artista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String nome;

    @Enumerated(EnumType.STRING)
    private TipoArtista tipo;

    @OneToMany(mappedBy = "artista")
    private List<Musica> musicas = new ArrayList<>();

    public Artista() {}

    public Artista(String nome, TipoArtista tipoArtista) {
        this.nome = nome;
        this.tipo = tipoArtista;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoArtista getTipo() {
        return tipo;
    }

    public void setTipo(TipoArtista tipo) {
        this.tipo = tipo;
    }

    public List<Musica> getMusicaList() {
        return musicas;
    }

    public void setMusicaList(List<Musica> musicaList) {
        this.musicas = musicaList;
    }

    @Override
    public String toString() {
        return  "Artista - " + nome + '\'' +
                ", Tipo - " + tipo +
                ", Musicas - " + musicas;
    }
}
