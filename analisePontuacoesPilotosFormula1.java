import java.util.Scanner;

public class analisePontuacoesPilotosFormula1 {

    static Scanner entrada = new Scanner(System.in);
    static String nomesPilotos[] = new String[]{"Daniel Ricciardo","Kimi Raikkonen",
            "Lewis Hamilton","Nico Rosberg","Sebastian Vettel"};

    public static void main(String[] args) {

        String paises[] = new String[]{"Bélgica","Itália","Cingapura","Malásia","Japão"};

        relatorioGerencial(paises);

    }// Main

    public static void relatorioGerencial(String paises[]){

        int matrizPontuacoesPilotos[][] = entradaPontuacoesPilotos(paises);

        int somaPontosPorPiloto[] = verificaPontuacaoPorPiloto(matrizPontuacoesPilotos);

        String vetorPilotoVencedorPorGp[] = verificaPilotoVencedorPorGp(matrizPontuacoesPilotos);

        for(int i = 0; i < 5; i++){

            System.out.println("Vencedor GP " + (i+1) + ": " + vetorPilotoVencedorPorGp[i]);

        }// For exibe piloto vencedor por Gp

        exibePilotoMaiorPontuacao(somaPontosPorPiloto);

    }// Procedimento Relátorio gerencial

    public static int[][] entradaPontuacoesPilotos(String paises[]){

        int matrizPontuaçõesPilotos[][] = new int[5][5];

        for(int i = 0; i < 5; i++){

            System.out.println("Piloto: " + nomesPilotos[i]);

            for(int j = 0; j < 5; j++){

                System.out.print("Informe a pontuação GP " + paises[j] + ": ");
                matrizPontuaçõesPilotos[i][j] = entrada.nextInt();

            }// Colunas

            System.out.println();

        }// Linhas

        return matrizPontuaçõesPilotos;

    }// Método entrada pontuações pilotos;

    public static int[] verificaPontuacaoPorPiloto(int matrizPontuacoesPilotos[][]){

        int somaPontosPorPiloto[] = new int[5];

        for(int i = 0; i < 5 ; i++){

            for(int j = 0; j < 5; j++){

                somaPontosPorPiloto[i] += matrizPontuacoesPilotos[i][j];

            }// Colunas

        }// Linhas

        return somaPontosPorPiloto;

    }// Método verifica pontuação por piloto

    public static String[] verificaPilotoVencedorPorGp(int matrizPontuacoesPilotos[][]){

        String vetorPilotoVencedorPorGp[] = new String[5];
        int pontuacaoMaior = 0;
        int indiceMaior = 0;

        for(int i = 0; i < 5; i ++){

            pontuacaoMaior = 0;
            indiceMaior = 0;

            for(int j = 0; j < 5 ; j++){

                if(matrizPontuacoesPilotos[j][i] > pontuacaoMaior){

                    pontuacaoMaior = matrizPontuacoesPilotos[j][i];
                    indiceMaior = j;

                }// If pegar maior por GP

            }

            vetorPilotoVencedorPorGp[i] = nomesPilotos[indiceMaior];

        }

        return vetorPilotoVencedorPorGp;

    }// Método verifica piloto vencedor por gp

    public static void exibePilotoMaiorPontuacao(int somaPontosPorPiloto[]){

        int maiorPontuacao = 0;
        int indiceMaiorPiloto = 0;

        for(int i = 0; i < somaPontosPorPiloto.length ; i++){

            if(somaPontosPorPiloto[i] > maiorPontuacao){
                maiorPontuacao = somaPontosPorPiloto[i];

                indiceMaiorPiloto = i;

            }// If pega a maior pontuação

        }

        System.out.println();
        System.out.println("Piloto que teve a maior pontuação: " + nomesPilotos[indiceMaiorPiloto]);

    }// Procedimento exibe piloto maior pontuação

}// Class
