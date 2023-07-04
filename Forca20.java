package forca2.pkg0;

import java.util.Scanner;
import java.util.Random;
import java.util.Set;
import java.util.HashSet;

public class Forca20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] palavrasSecretas = {"ELEFANTE", "GIRASSOL", "BANANA", "ABACAXI", "PAPAGAIO", "COALA", "PANTUFA", "SECRETAS", "SINTETIZACAO", "COZINHAR", "ARREDAR", "PEDREIRO", "JARDIM", "ASA", "ALTERNADO", "TER", "GRAU", "TEMEROSO", "MOBILIAR", "MOVEIS", "DROMEDARIO", "PIZZA", "SALADA", "DEDAL", "DICIONARIO"};  // Array de palavras secretas

        Random random = new Random();
        int indicePalavraSecreta = random.nextInt(palavrasSecretas.length);  // Selecionar um índice aleatório do array

        String palavraSecreta = palavrasSecretas[indicePalavraSecreta];  // Palavra secreta selecionada

        int maxTentativas = 10;  // Número máximo de tentativas

        char[] letrasCorretas = new char[palavraSecreta.length()];  // Array para armazenar as letras corretas adivinhadas
        for (int i = 0; i < letrasCorretas.length; i++) {
            letrasCorretas[i] = '_';
        }

        int tentativas = 0;  // Contador de tentativas

        Set<Character> letrasDigitadas = new HashSet<>();  // Conjunto para armazenar as letras já digitadas

        boolean jogoTerminado = false;

        while (!jogoTerminado) {
            
            System.out.println("Palavra: " + String.valueOf(letrasCorretas));
            System.out.println("Dica: A palavra secreta possui " + palavraSecreta.length() + " letras.");
            System.out.println("Tentativas restantes: " + (maxTentativas - tentativas));
            System.out.println("Letras digitadas: " + letrasDigitadas);

            System.out.print("Digite uma letra ou a palavra completa: ");
            String input = scanner.nextLine().toUpperCase();

            if (input.trim().isEmpty()) {
                System.out.println("Nenhuma letra foi digitada. Por favor, tente novamente.");
                continue;
            }
            

            if (input.equals(palavraSecreta)) {
                System.out.println("Parabéns, você ganhou! A palavra secreta era: " + palavraSecreta);
                jogoTerminado = true;
                break;
            }

            char letra = input.charAt(0);

            if (letrasDigitadas.contains(letra)) {
                System.out.println("Essa letra já foi digitada. Por favor, tente novamente.");
                continue;
            }

            letrasDigitadas.add(letra);

            boolean letraEncontrada = false;

            for (int i = 0; i < palavraSecreta.length(); i++) {
                if (palavraSecreta.charAt(i) == letra) {
                    letrasCorretas[i] = letra;
                    letraEncontrada = true;
                }
            }

            if (!letraEncontrada) {
                tentativas++;
            }

            if (tentativas == maxTentativas) {
                System.out.println("Você perdeu! A palavra secreta era: " + palavraSecreta);
                jogoTerminado = true;
            }

            if (String.valueOf(letrasCorretas).equals(palavraSecreta)) {
                System.out.println("Parabéns, você ganhou! A palavra secreta era: " + palavraSecreta);
                jogoTerminado = true;
            }

            System.out.println("-----------------------");
        }

        scanner.close();
 
   }
}

