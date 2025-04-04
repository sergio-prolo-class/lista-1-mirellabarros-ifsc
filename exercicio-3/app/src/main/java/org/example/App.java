/*
 * This source file was generated by the Gradle 'init' task
 */
package org.example;
import java.util.Random;
import java.util.ArrayList;

public class App {

    public static void main(String[] args) {

        // Definição de variáveis
        Random r = new Random();
        int navio;
        boolean navioExisteNoTabuleiro;

        // Define uma matriz 10x10 (tabuleiro)
        String[][] tabuleiro = new String[10][10];

        // Inicializa o tabuleiro com pontos
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++) {
                tabuleiro[i][j] = ".";
            }
        }

        // Estabelece os navios possiveis e seus respectivos tamanhos
        String[] simboloNavio = {"P", "E", "C", "S", "N"};
        int[] tamanhoNavio = {5, 4, 3, 3, 2};

        // Lista com os navios inseridos no tabuleiro e a quantidade de navios já inseridos
        String[] itensTabuleiro = {"-", "-", "-", "-", "-"};
        int itensContagem = 0;

        // Laço para inserir todos os navios possíveis no tabuleiro
        for (int j = 0; j < simboloNavio.length; j++) {
            do {
                // Seleciona o navio a ser inserido da lista simboloNavio
                navio = r.nextInt(5);
                // Flag para identificar se o navio selecionado está presente no tabuleiro
                navioExisteNoTabuleiro = false;
                // Percorre a lista itensTabuleiro e verifica se o navio já foi inserido no tabuleiro
                for (int i = 0; i < itensTabuleiro.length; i++) {
                    if (itensTabuleiro[i].equals(simboloNavio[navio])) {
                        navioExisteNoTabuleiro = true;
                        break;
                    }
                }
            } while (navioExisteNoTabuleiro);

            boolean posicaoValida = true;

            do {
                // Seleciona a orientação do navio: 0 para horizontal e 1 para vertical
                int orientacao = r.nextInt(2);
                // Percorre as linhas do tabuleiro em busca de uma posição válida
                if (orientacao == 0) {
                    int linhaInicial = r.nextInt(10);
                    int colunaInicial = r.nextInt(10 - tamanhoNavio[navio]);
                    posicaoValida = true;
                    for (int i = colunaInicial; i < colunaInicial+tamanhoNavio[navio]; i++) {
                        if (!tabuleiro[linhaInicial][i].equals(".")) {
                            posicaoValida = false;
                            break;
                        }
                    }
                    // Insere o navio no tabuleiro caso a posição seja válida
                    // Adiciona o navio à lista itensTabuleiro
                    // incrementa o contador de navios inseridos
                    if (posicaoValida) {
                        for (int i = colunaInicial; i < colunaInicial+tamanhoNavio[navio]; i++) {
                            tabuleiro[linhaInicial][i] = simboloNavio[navio];
                        }
                        itensTabuleiro[itensContagem] = simboloNavio[navio];
                        itensContagem++;
                        break;
                    }
                }
                // Percorre as colunas do tabuleiro em busca de uma posição válida
                if (orientacao == 1) {
                    int linhaInicial = r.nextInt(10 - tamanhoNavio[navio]);
                    int colunaInicial = r.nextInt(10);
                    posicaoValida = true;
                    for (int i = linhaInicial; i < linhaInicial+tamanhoNavio[navio]; i++) {
                        if (!tabuleiro[i][colunaInicial].equals(".")) {
                            posicaoValida = false;
                            break;
                        }
                    }
                    // Insere o navio no tabuleiro caso a posição seja válida
                    // Adiciona o navio à lista itensTabuleiro
                    // incrementa o contador de navios inseridos
                    if (posicaoValida) {
                        for (int i = linhaInicial; i < linhaInicial+tamanhoNavio[navio]; i++) {
                            tabuleiro[i][colunaInicial] = simboloNavio[navio];
                        }
                        itensTabuleiro[itensContagem] = simboloNavio[navio];
                        itensContagem++;
                        break;
                    }
                }
            } while (posicaoValida == false);
        }

        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++) {
                System.out.print(tabuleiro[i][j] + " ");
            }
            System.out.println();
        }

    }
}
