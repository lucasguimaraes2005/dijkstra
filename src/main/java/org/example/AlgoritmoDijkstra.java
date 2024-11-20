package org.example;

import java.util.*;

public class AlgoritmoDijkstra {
    private int vertices[][];

    public AlgoritmoDijkstra(final int numVertices) {
        vertices = new int[numVertices][numVertices];
    }

    public void criarAresta(final int noOrigem, final int noDestino, final int peso) {
        if (peso >= 1) {
            vertices[noOrigem][noDestino] = peso;
            vertices[noDestino][noOrigem] = peso;
        } else {
            throw new IllegalArgumentException("O peso do nó origem para o nó destino não pode ser negativo");
        }
    }

    public int getMaisProximo(final int listaCustos[], final Set<Integer> naoVisitados) {
        int minDistancia = Integer.MAX_VALUE;
        int noProximo = 0;
        for (Integer i : naoVisitados) {
            if (listaCustos[i] < minDistancia) {
                minDistancia = listaCustos[i];
                noProximo = i;
            }
        }

        return noProximo;
    }


    public List<Integer> getVizinhos(final int no){
        List<Integer> vizinhos = new ArrayList<Integer>();
        for (int i = 0; i < vertices.length; i++) {
            if (vertices[no][i] > 0) {
                vizinhos.add(i);
            }
        }
        return vizinhos;
    }

    public int getCusto(final int noOrigem, final int noDestino) {
        return vertices[noOrigem][noDestino];
    }

    public List<Integer> caminhoMinimo(final int noOrigem, final int noDestino) {
        int custo[] = new int[vertices.length];
        int antecessor[] = new int[vertices.length];
        Set<Integer> naoVisitados = new HashSet<Integer>();

        custo[noOrigem] = 0;

        for (int i = 0; i < vertices.length; i++) {
            if (i != noOrigem) {
                custo[i] = Integer.MAX_VALUE;
            }
            antecessor[i] = -1;
            naoVisitados.add(i);
        }

        while (!naoVisitados.isEmpty()) {
            int noMaisProximo = getMaisProximo(custo, naoVisitados);
            naoVisitados.remove(noMaisProximo);

            for (Integer vizinhos : getVizinhos(noMaisProximo)) {
                int custoTotal = custo[noMaisProximo] + getCusto(noMaisProximo, vizinhos);
                if (custoTotal < custo[vizinhos]) {
                    custo[vizinhos] = custoTotal;
                    antecessor[vizinhos] = noMaisProximo;
                }
            }
            if (noMaisProximo == noDestino) {
                return caminhoMaisProximo(antecessor, noMaisProximo);
            }
        }
        return null;
    }

    public List<Integer> caminhoMaisProximo(final int antecessor[], int noMaisProximo) {
        List<Integer> caminho = new ArrayList<Integer>();
        caminho.add(noMaisProximo);

        while (antecessor[noMaisProximo] != -1) {
            caminho.add(antecessor[noMaisProximo]);
            noMaisProximo = antecessor[noMaisProximo];
        }

        Collections.reverse(caminho);
        return caminho;
    }
}
