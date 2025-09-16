package Utils;

import java.time.LocalDate;

public class Functions {

    public static void println(String text) {
        System.out.println(text);
    }

    public static boolean isDiaUtil(LocalDate date) {
        int dia = date.getDayOfWeek().getValue();
        return switch(dia) {
            case 2, 3, 4, 5, 6 -> true; // Segunda a Sexta
            default -> false;
        };
    }

    public static String getTipoDia(LocalDate date) {
        int dia = date.getDayOfWeek().getValue() % 7 + 1; // Ajuste para 1=Domingo, ..., 7=Sábado
        return switch(dia) {
            case 1 -> "Domingo";
            case 2 -> "Segunda-feira";
            case 3 -> "Terça-feira";
            case 4 -> "Quarta-feira";
            case 5 -> "Quinta-feira";
            case 6 -> "Sexta-feira";
            case 7 -> "Sábado";
            default -> "Dia inválido";
        };
    }
}