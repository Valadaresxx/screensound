package br.com.valadares.screensound.principal;

import java.util.Scanner;

public class Principal {
    public Scanner leitura = new Scanner(System.in);
    public void exibiMenu() {
        var opcao = -1;

        while(opcao != 0){
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

            switch (opcao){
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
    }

    private void cadastrarMusica() {
    }

    private void listarMusicas() {
    }

    private void buscarMusicasPorArtista() {
    }
}
