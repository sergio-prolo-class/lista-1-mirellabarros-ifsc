/*
 * This source file was generated by the Gradle 'init' task
 */
package org.example;
import java.lang.Math;

public class App {
    public static void main(String[] args) {
        int[] resistor = {-1, -1, -1, -1, -1};
        double[] multiplicador = {1,
                10,
                Math.pow(10,2),
                Math.pow(10,3),
                Math.pow(10,4),
                Math.pow(10,5),
                Math.pow(10,6),
                Math.pow(10,7),
                Math.pow(10,8),
                Math.pow(10,9),
                Math.pow(10,-1),
                Math.pow(10,-2)};

        double[] tolerancia = {0, 1, 2, -1, -1, 0.5, 0.25, 0.1, 0.05, 0.05, 0.1};
        String[] abreviacoes = {"", "K", "M", "G", "T"};
        for (int i = 0; i < args.length; i++) {
            resistor[i] = switch (args[i]) {
                case "preto" -> 0;
                case "marrom" -> 1;
                case "vermelho" -> 2;
                case "laranja" -> 3;
                case "amarelo" -> 4;
                case "verde" -> 5;
                case "azul" -> 6;
                case "violeta" -> 7;
                case "cinza" -> 8;
                case "branco" -> 9;
                case "ouro" -> 10;
                case "prata" -> 11;
                default -> -1;
            };
        }

        String valorInicial = Integer.toString(resistor[0]) + Integer.toString(resistor[1]);
        double resistencia = Integer.parseInt(valorInicial) * multiplicador[resistor[2]];

        double fatorDivisao = 1000;
        int contador = 0;

        while (resistencia >= fatorDivisao) {
            resistencia = resistencia / fatorDivisao;
            contador++;
        }

        System.out.println(resistencia + " " + abreviacoes[contador] + " Ohms (+- " + tolerancia[resistor[3]] + "%)");

    }
}
