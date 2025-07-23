package br.com.valadares.screensound.principal;

import br.com.valadares.screensound.model.Artista;
import br.com.valadares.screensound.model.Musica;
import br.com.valadares.screensound.model.TipoArtista;
import br.com.valadares.screensound.repository.ArtistaRepository;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Principal {

    private final ArtistaRepository repositorio;
    public Scanner leitura = new Scanner(System.in);

    public Principal(ArtistaRepository repositorio) {
        this.repositorio = repositorio;
    }

    public void exibiMenu() {
        var opcao = -1;

        while (opcao != 0) {
            var texto = """
                     -_- Menu de opções -_-
                    
                    1 - Cadastrar artista
                    2 - Cadastrar musica
                    3 - Listar Musicas
                    4 - Buscar musicas por artista
                    
                    
                    0 - Sair""";
            System.out.println(texto);
            opcao = leitura.nextInt();
            leitura.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarArtista();
                    break;
                case 2:
                    cadastrarMusica();
                    break;
                case 3:
                    listarMusicas();
                    break;
                case 4:
                    buscarMusicasPorArtista();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.printf("Encerrando, opção invalida!");
                    break;
            }
        }
    }

    private void cadastrarArtista() {
        var cadastrarNovo = "S";

        while (cadastrarNovo.equalsIgnoreCase("S")) {
            System.out.println("Digite o nome do artista que deseja cadastrar:");
            var nome = leitura.nextLine();

            System.out.println("Escolha qual o tipo do artista: (solo, dupla, banda");
            var tipo = leitura.nextLine();

            TipoArtista tipoArtista = TipoArtista.valueOf(tipo.toUpperCase());
            Artista artista = new Artista(nome, tipoArtista);
            repositorio.save(artista);

            System.out.println("Deseja cadastrar outro artistas? S/N");
            cadastrarNovo = leitura.nextLine();
        }
    }

    private void cadastrarMusica() {
        System.out.println("Cadastrar musica de qual artista? ");
        var nome = leitura.nextLine();
        Optional<Artista> artista = repositorio.findByNomeContainingIgnoreCase(nome);
        if(artista.isPresent()){
            System.out.printf("Digite o nome da musica: ");
            var nomeMusica = leitura.nextLine();
            Musica musica = new Musica(nomeMusica);
            musica.setArtista(artista.get());
            artista.get().getMusicaList().add(musica);
            repositorio.save(artista.get());
        }else{
            System.out.println("Artista não encontrado!");
        }
    }

    private void listarMusicas() {
        List<Artista> artistas = repositorio.findAll();
        artistas.forEach(a -> a.getMusicaList().forEach(System.out::println));
    }

    private void buscarMusicasPorArtista() {
    }
}
