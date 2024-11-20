package org.example;

import java.util.Scanner;

public class Main {

    private static final int S1 = 0;
    private static final int S2 = 1;
    private static final int S3 = 2;
    private static final int S4 = 3;
    private static final int S5 = 4;
    private static final int S6 = 5;
    private static final int S7 = 6;
    private static final int S8 = 7;
    private static final int S9 = 8;
    private static final int S10 = 9;
    private static final int S11 = 10;
    private static final int S12 = 11;
    private static final int S13 = 12;
    private static final int S14 = 13;
    private static final int S15 = 14;
    private static final int S16 = 15;
    private static final int S17 = 16;
    private static final int S18 = 17;
    private static final int S19 = 18;
    private static final int S20 = 19;

    public static int lerEstacao(String tipo, Scanner in) {
        System.out.print("por favor, insira o número da estação " + tipo + ": ");
        while (true) {
            try {
                return Integer.parseInt(in.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("entrada inválida, favor inserir um numero valido");
            }
        }
    }

    public static void main(String[] args) {
        AlgoritmoDijkstra dijkstra = new AlgoritmoDijkstra(20);

        // linha vermelha do metro
        dijkstra.criarAresta(S1, S2, 16);
        dijkstra.criarAresta(S2, S3, 14);
        dijkstra.criarAresta(S3, S4, 12);
        dijkstra.criarAresta(S4, S5, 12);
        dijkstra.criarAresta(S5, S6, 14);

        // linha verde do metro
        dijkstra.criarAresta(S7, S8, 15);
        dijkstra.criarAresta(S8, S9, 11);
        dijkstra.criarAresta(S9, S10, 13);
        dijkstra.criarAresta(S10, S11, 16);
        dijkstra.criarAresta(S11, S6, 15);

        // linha amarela do metro
        dijkstra.criarAresta(S12, S8, 11);
        dijkstra.criarAresta(S8, S2, 8);
        dijkstra.criarAresta(S2, S15, 7);
        dijkstra.criarAresta(S15, S16, 7);
        dijkstra.criarAresta(S16, S17, 12);
        dijkstra.criarAresta(S17, S18, 9);

        // linha azul do metro
        dijkstra.criarAresta(S12, S9, 17);
        dijkstra.criarAresta(S9, S13, 7);
        dijkstra.criarAresta(S13, S14, 9);
        dijkstra.criarAresta(S14, S5, 9);
        dijkstra.criarAresta(S5, S17, 10);

        // linha roxa do metro
        dijkstra.criarAresta(S10, S13, 11);
        dijkstra.criarAresta(S13, S3, 13);
        dijkstra.criarAresta(S3, S16, 11);
        dijkstra.criarAresta(S16, S19, 13);
        dijkstra.criarAresta(S19, S20, 12);

        Scanner in = new Scanner(System.in);

        System.out.println("bem vindo ao sistema de metro");
        System.out.println("----------------------------------------------------------------------------------------");

        while (true) {
            System.out.println("por favor, digite a sua rota ou pressione enter para sair do programa");
            int origem = lerEstacao("Origem", in);
            int destino = lerEstacao("Destino", in);

            for (Integer estacao : dijkstra.caminhoMinimo(origem-1, destino-1)) {
                System.out.print((estacao + 1));
                if (estacao != destino-1) {
                    System.out.print(" -> ");
                }
            }
            System.out.println();
            System.out.println("fim da rota");
        }
    }
}