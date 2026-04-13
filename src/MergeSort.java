import java.util.Arrays;

public class MergeSort<T extends Comparable<T>> implements IOrdenador<T> {

    private int comparacoes;
    private int movimentacoes;
    private double tempoOrdenacao;
    private double inicio;

    private final double nanoToMilli = 1.0 / 1_000_000;

    @Override
    public int getComparacoes() {
        return comparacoes;
    }

    @Override
    public int getMovimentacoes() {
        return movimentacoes;
    }

    @Override
    public double getTempoOrdenacao() {
        return tempoOrdenacao;
    }

    private void iniciar() {
        this.comparacoes = 0;
        this.movimentacoes = 0;
        this.inicio = System.nanoTime();
    }

    private void terminar() {
        this.tempoOrdenacao = (System.nanoTime() - this.inicio) * nanoToMilli;
    }


    private void mergesort(T[] vetor, int esq, int dir) {
        if (esq < dir) {
            int meio = (esq + dir) / 2;
            mergesort(vetor, esq, meio);
            mergesort(vetor, meio + 1, dir);
            intercalar(vetor, esq, meio, dir);
        }
    }


   
    private void intercalar(T[] vetor, int esq, int meio, int dir) {
        int n1 = meio - esq + 1;
        int n2 = dir - meio;

        T[] a1 = (T[]) new Comparable[n1];
        T[] a2 = (T[]) new Comparable[n2];


        for (int i = 0; i < n1; i++) {
            a1[i] = vetor[esq + i];
            movimentacoes++;
        }
        for (int j = 0; j < n2; j++) {
            a2[j] = vetor[meio + j + 1];
            movimentacoes++;
        }

        int i = 0, j = 0, k = esq;
        while (i < n1 && j < n2) {
            comparacoes++;
            if (a1[i].compareTo(a2[j]) <= 0) {
                vetor[k] = a1[i++];
            } else {
                vetor[k] = a2[j++];
            }
            movimentacoes++;
            k++;
        }


        while (i < n1) {
            vetor[k++] = a1[i++];
            movimentacoes++;
        }

        while (j < n2) {
            vetor[k++] = a2[j++];
            movimentacoes++;
        }
    }

    @Override
    public T[] ordenar(T[] dados) {
        T[] dadosOrdenados = Arrays.copyOf(dados, dados.length);
        iniciar();
        mergesort(dadosOrdenados, 0, dadosOrdenados.length - 1);
        terminar();
        return dadosOrdenados;
    }
}