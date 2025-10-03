package main.java.zothers.exercises;

import java.time.LocalDate;

import static main.java.zothers.Utils.Functions.*;

/**
 * Constantes em java são geralmente declaradas como static final.
 * Por convenção, os nomes das constantes são escritos em letras maiúsculas com palavras separadas por sublinhados.
 * Exemplo:
 * public static final int MAX_VALUE = 100;
 */
public class Constants {
    public static final int IDADE_BEBE = 2;
    public static final int IDADE_CRIANCA = 12;
    public static final int IDADE_ADOLESCENTE = 19;
    public static final int IDADE_ADULTO = 65;
    public static final int IDADE_VOTO = 16;

    public static void main(String[] args) {

        String nome = "Joãozinho";
        int idade = 20;

        // imprime nome e idade
        println(nome + " tem " + idade + " anos.");

        // faixa etária
        if (idade <= IDADE_BEBE) {
            println("Bebê");
        } else if (idade <= IDADE_CRIANCA) {
            println("Criança");
        } else if (idade <= IDADE_ADOLESCENTE) {
            println("Adolescente");
        } else if (idade <= IDADE_ADULTO) {
            println("Adulto");
        } else {
            println("Idoso");
        }

        // pode votar (ternário)
        println( (idade >= IDADE_VOTO) ? "Pode votar" : "Não pode votar" );


        /**
         * 🔄 Switch Tradicional (até Java 13)
         * Break obrigatório
         */

        // pegar data de hoje
        LocalDate dataHoje = LocalDate.now();
        int diaDaSemana = dataHoje.getDayOfWeek().getValue() % 7 + 1; // 1=Domingo, 2=Segunda, ..., 7=Sábado
        switch( diaDaSemana ) {
            case 1:
                println("Domingo");
                break;
            case 2:
                println("Segunda-feira");
                break;
            case 3:
                println("Terça-feira");
                break;
            case 4:
                println("Quarta-feira");
                break;
            case 5:
                println("Quinta-feira");
                break;
            case 6:
                println("Sexta-feira");
                break;
            case 7:
                println("Sábado");
                break;
            default:
                println("Dia inválido");
        }


        /**
         * 🚀 Switch Expression (Java 14+) - Sua Sintaxe
         */
        switch(diaDaSemana) {
            case 2, 3, 4, 5, 6 -> {
                println("Dia útil");
                println("⏰Horário comercial: 8h às 18h");
                println("Lembrete: Reunião às 14h");
            }
            case 1 -> {
                println("Domingo - Dia de Criador");
                println("Vamos adorarrrrr a Deus! 🙏");
            }
            case 7 -> {
                println("Sábado - Deus nos deu esse dia para descansar! 😴");
                println("Aproveite a família! 👨‍👩‍👧‍👦");
            }
        }

        String tipoDia = getTipoDia(dataHoje);
        String mensagemDiaUtil = isDiaUtil(dataHoje) ? "Hoje é dia útil, bora trabalhar!" : "Hoje não é dia útil, aproveite!";
        println("Hoje é " + tipoDia + ". " + mensagemDiaUtil);
    }

}
