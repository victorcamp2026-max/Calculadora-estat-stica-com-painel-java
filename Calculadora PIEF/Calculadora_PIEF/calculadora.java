import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class calculadora {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        // Scanner: para o usuário digitar os números q quiser

        ArrayList<Double> numeros = new ArrayList<>();

        //ArrayList: para guardar todos os números digitados
        //Double: números com vírgula

        int opcao;

        do {
            System.out.println("\n=================== Calculadora ===================");
            System.out.println("1 - Adicionar números");
            System.out.println("2 - Remover números");
            System.out.println("3 - Mostrar números");
            System.out.println("4 - Cálculos");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");

            //menu principal com as opcoes, para ajudar na visualização do usuário

            opcao = teclado.nextInt();

            switch (opcao) {
                case 1:
                    adicionarNumeros(teclado, numeros);
                    break;
                case 2:
                    removerNumeros(teclado, numeros);
                    break;
                case 3:
                    mostrarNumeros(numeros);
                    break;
                case 4:
                    realizarCalculos(teclado, numeros);
                    break;
                case 5:
                    System.out.println("Você saiu da calculadora");
                    break;
                default:
                    System.out.println("Opção inválida, digite um número de 1 a 5");
            }

            // switch: é como se fosse um if, mas com os cases fica mais organizado, cada opção tem uma função diferente


        } while (opcao != 5);

        teclado.close();
        // fecha o scanner
    }

    // Função para adicionar números
    public static void adicionarNumeros(
            Scanner teclado, ArrayList<Double> numeros) {

        String resposta;

        do {
            System.out.print("Digite um número: ");
            numeros.add(teclado.nextDouble());

            do {
                System.out.print("Deseja adicionar outro número? (s/n): ");
                resposta = teclado.next();

                if (!resposta.equalsIgnoreCase("s")
                        && !resposta.equalsIgnoreCase("n")) {
                    System.out.println("Opção inválida! Digite s ou n.");
                }

            } while (!resposta.equalsIgnoreCase("s")
                    && !resposta.equalsIgnoreCase("n"));

        } while (resposta.equalsIgnoreCase("s"));

        System.out.println("Números adicionados");
    }
    // .add: adiciona o número digitado no array (numeros)
    // .equalsIgnoreCase: ignora se a letra é maiúscula ou minúscula
    // do while: é um laço de repetição que executa o bloco de código pelo menos uma vez, e depois verifica a condição para continuar ou não
    // while: ele verifica a condição antes de entra no laço de repetição, quando é verdadeiro ele continua, se não, ele quebra
    // !: negação, por exemplo, se tiver !resposta(s), quer dizer que não é s
    // &&: E, que nem em matemática discreta (^), se for verdadeiro e verdadeiro (1 e 1) funciona, se for v e f (1 e 0) ou contrário ou dois falsos, ele não funciona

    // Função para remover números

    public static void removerNumeros(
            Scanner teclado, ArrayList<Double> numeros) {

        if (numeros.isEmpty()) {
            System.out.println("Não há números para remover.");
            return;
        }

        mostrarNumeros(numeros);

        System.out.print("Digite a posição que deseja remover: ");
        int posicao = teclado.nextInt();

        if (posicao >= 1 && posicao <= numeros.size()) {
            double removido = numeros.remove(posicao - 1);
            System.out.println("Número removido: " + removido);
        } else {
            System.out.println("Posição inválida!");
        }
    }

    // .isEmpty: ele ve se o array tá vazio ou não
    // .size: ele ve o tamanho do array, nesse caso, se a posição que o usuário digitar for maior que o array, vai dar erro
    // .remove: remove o número da posição que o usuário digitou
    // lembra que array sempre começa em 0

    // Função para mostrar números
    public static void mostrarNumeros(ArrayList<Double> numeros) {

        if (numeros.isEmpty()) {
            System.out.println("Não tem números");
            return;
        }

        System.out.println("\n------------------ Números ------------------");

        for (int i = 0; i < numeros.size(); i++) {
            System.out.println((i + 1) + " - " + numeros.get(i));
        }
    }

    // .get: pega o número da posição que o usuário digitou
    // for: ele vai repetir até passar por todos os números do array

    // Funçôes para realizar os cálculos

    public static void realizarCalculos(
            Scanner teclado, ArrayList<Double> numeros) {

        if (numeros.isEmpty()) {
            System.out.println("Adicione números antes de calcular.");
            return;
        }

        int opcao;

        do {
            System.out.println("\n----------- Menu de cálculos -----------");
            System.out.println("1 - Soma");
            System.out.println("2 - Média");
            System.out.println("3 - Mediana");
            System.out.println("4 - Moda");
            System.out.println("5 - Amplitude");
            System.out.println("6 - Variância");
            System.out.println("7 - Desvio padrão");
            System.out.println("8 - Frequência");
            System.out.println("9 - Voltar para o Menu principal");
            System.out.print("Escolha uma opção: ");

            // Criei mais um menu para facilitar a visualização do usuário, pq tem mtts cálculos

            opcao = teclado.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Soma: " + calcularSoma(numeros));
                    break;
                case 2:
                    System.out.println("Média: " + calcularMedia(numeros));
                    break;
                case 3:
                    System.out.println("Mediana: " + calcularMediana(numeros));
                    break;
                case 4:
                    mostrarModa(numeros);
                    break;
                case 5:
                    System.out.println("Amplitude: " + calcularAmplitude(numeros));
                    break;
                case 6:
                    System.out.println("Variância: "
                            + calcularVariancia(numeros));
                    break;
                case 7:
                    System.out.println("Desvio padrão: "
                            + calcularDesvioPadrao(numeros));
                    break;
                case 8:
                    mostrarFrequencia(numeros);
                    break;
                case 9:
                    System.out.println("Você voltou para o Menu principal\n");
                    break;
                default:
                    System.out.println("Opção inválida, digite um número de 1 a 9");
            }

        } while (opcao != 9);
    }


    // Função para somar todos os números
    public static double calcularSoma(ArrayList<Double> numeros) {
        double soma = 0;

        for (double numero : numeros) {
            soma += numero;
        }

        return soma;
    }

    // calcularSoma: ele vai somar todos os números do array, e depois retornar a soma total
    // for-each: ele vai repetir até passar por todos os números do array, usando somente double numero : numeros, sem precisar do índice, que é o "i"

    // Função para calcular a média
    public static double calcularMedia(ArrayList<Double> numeros) {
        return calcularSoma(numeros) / numeros.size();
    }

    // ele puxa a função soma e depois divide pelo tamanho do array, dando a média dos números

    // Função para calcular a mediana

    public static double calcularMediana(ArrayList<Double> numeros) {
        ArrayList<Double> copia = new ArrayList<>(numeros);
        Collections.sort(copia);

        int tamanho = copia.size();
        int meio = tamanho / 2;

        if (tamanho % 2 != 0) {
            return copia.get(meio);
        }

        return (copia.get(meio - 1) + copia.get(meio)) / 2;
    }

    // primeiro cria uma cópia do array números, para não mudar a ordem dos números digitados: ArrayList<Double> copia = new ArrayList<>(numeros);
    // depois com o Collections.sort(copia); ele arruma os números em ordem crescente
    // int tamanho é o tamanho do array
    // int meio é a posição do meio do array
    // o if serve para que, se o número for ímpar, ele retorna o número do meio, mas se for par, ele faz uma média entre os dois números do meio
    // % 2: é o resto da divisão, se for != (diferente) de 0, quer dizer que é ímpar
    // lembrando que sempre que der um número decimal, ele sempre arredonda para cima se for int. ex: 2.1 vai ser igual a int 3

    // Função para mostrar a moda
    public static void mostrarModa(ArrayList<Double> numeros) {
        int maiorFrequencia = 0;

        for (int i = 0; i < numeros.size(); i++) {
            int frequencia = contarFrequencia(numeros, numeros.get(i));

            if (frequencia > maiorFrequencia) {
                maiorFrequencia = frequencia;
            }
        }

        if (maiorFrequencia == 1) {
            System.out.println("Não tem moda, pois todos aparecem uma vez");
            return;
        }

        // usa a função contar frequência para contar quantas vezes cada número aparece no array
        // se a frequência for maior que a maior frequência, ele atualiza a maior frequência
        // se a maior frequência for 1, quer dizer que todos os números aparecem uma vez só, ent não tem moda

        System.out.print("Moda: ");

        for (int i = 0; i < numeros.size(); i++) {
            double numero = numeros.get(i);
            int frequencia = contarFrequencia(numeros, numero);
            boolean numero_jamostrado = false;

            for (int j = 0; j < i; j++) {
                if (numeros.get(j).equals(numero)) {
                    numero_jamostrado = true;
                    break;
                }
            }

            if (!numero_jamostrado && frequencia == maiorFrequencia) {
                System.out.print(numero + " ");
            }
        }

        System.out.println("\nFrequência da moda: " + maiorFrequencia);
    }

    // boolean numero_jamostrado: ele vai verificar se o número já foi mostrado, pois pode ter mais de uma moda
    // se o número não foi mostrado e a frequência dele for igual a maior frequência, ele mostra o número como moda
    // é um for dentro de outro for, o primeiro for vai percorrer todos os números do array, e o segundo for vai percorrer todos os números antes do número que está sendo verificado, para ver se ele já foi mostrado ou não
    // equals: ele ve se o número é igual ao outro
    // se for igual, o boolean fica true e quebra o for
    // o outro if ve se o !numero_jamostrado é true e se a frequência é igual a maior frequência
    // no fim tem um print para mostrar a frequência da moda

    // Função para calcular a amplitude
    public static double calcularAmplitude(ArrayList<Double> numeros) {
        double menor = numeros.get(0);
        double maior = numeros.get(0);

        for (double numero : numeros) {
            if (numero < menor) {
                menor = numero;
            }
            if (numero > maior) {
                maior = numero;
            }
        }

        return maior - menor;
    }

    // a amplitude é o maior menos o menor número da lista
    // criei duas variaveis maior e menor, que vão receber o menor e o maior número do array, por conta do for-each
    // que vai percorrer todo o array e com os if, vai comparar o valor que já tem com o próximo
    // na variável maior vai ser guardado sempre o maior número até acabar e o menor o contrário
    // e no fim com o return, ele retorna a amplitude

    // Função para calcular a variância
    public static double calcularVariancia(ArrayList<Double> numeros) {
        double media = calcularMedia(numeros);
        double somaDosQuadrados = 0;

        for (double numero : numeros) {
            somaDosQuadrados += Math.pow(numero - media, 2);
        }

        return somaDosQuadrados / numeros.size();
    }

    // a variância é a média dos quadrados das diferenças entre cada número e a média
    // criei uma variável media que vai receber a média dos números com a função calcularMedia
    // e uma variável somaDosQuadrados que vai receber a soma dos quadrados das diferenças entre cada número e a média
    // com o for-each, ele vai percorrer todo o array e com o Math.pow, ele vai calcular o quadrado da diferença entre cada número e a média
    // o math.pow é uma função que faz a potência
    // ele retorna a soma dos quadrados dividida pelo tamanho do array, que é a variância

    // Função para calcular o desvio padrão
    public static double calcularDesvioPadrao(ArrayList<Double> numeros) {
        return Math.sqrt(calcularVariancia(numeros));
    }

    // o desvio padrão é a raiz quadrada da variância
    // usa o math.sqrt para calcular a raiz quadrada da variância

    // Função para contar a frequência de um número específico
    public static int contarFrequencia(
            ArrayList<Double> numeros, double valor) {

        int frequencia = 0;

        for (double numero : numeros) {
            if (Double.compare(numero, valor) == 0) {
                frequencia++;
            }
        }

        return frequencia;
    }

    // o usuário pode escolher um número para ver a quant. de vezes que ele aparece no array
    // criei uma variável frequencia que vai receber a quant. de vezes que o número aparece no array
    // com o for-each, ele vai percorrer todo o array e com o if, ele vai comparar o número com o valor que o usuário digitou
    // o Double.compare é uma função que compara dois números, se for igual, ele retorna 0, se for menor, ele retorna -1 e se for maior, ele retorna 1
    // então se for igual a 0 ele soma a frequência mais 1

    // Função para mostrar a frequência de todos os números
    public static void mostrarFrequencia(ArrayList<Double> numeros) {
        System.out.println("\n------- Frequência dos números -------");

        for (int i = 0; i < numeros.size(); i++) {
            double numero = numeros.get(i);
            boolean numero_jamostrado = false;

            for (int j = 0; j < i; j++) {
                if (Double.compare(numeros.get(j), numero) == 0) {
                    numero_jamostrado = true;
                    break;
                }
            }

            if (!numero_jamostrado) {
                int frequencia = contarFrequencia(numeros, numero);

                System.out.println(
                    "Número " + numero + " aparece "
                    + frequencia
                );
            }
        }

    // esse for vai percorrer todo o array e com o boolean numero_jamostrado, ele vai verificar se o número já foi mostrado, para não mostrar a frequência do mesmo número mais de uma vez
    // depois ele vai chamar a função contarFrequencia para contar a frequência do número e mostrar na tela
    // o Double.compare é usado para comparar os números, pois com o == ele não funciona com números com vírgula
    }
}