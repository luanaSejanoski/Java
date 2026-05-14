import java.time.*;
import java.time.format.*;
import java.util.*;

public class horasTrabalhadas{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome: ");
        String nome = scanner.nextLine();

        //formata entrada
        System.out.println("Digite a hora de entrada: ");
        String entrada = scanner.nextLine();

        DateTimeFormatter horaEntradaFormatada =  DateTimeFormatter.ofPattern("HH:mm");
        LocalTime horaEntrada = LocalTime.parse(entrada, horaEntradaFormatada);

        //formata saida
        System.out.println("Digite a hora de saída: ");
        String saida = scanner.nextLine();

        DateTimeFormatter horaSaidaFormatada = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime horaSaida = LocalTime.parse(saida, horaSaidaFormatada);

        //calcula diferença
        Duration diferenca = Duration.between(horaEntrada, horaSaida);

        long horas = diferenca.toHours();

        long minutos = diferenca.toMinutes() % 60;

        Duration jornadaPadrao = Duration.ofHours(8);

        boolean horasExtras = diferenca.compareTo(jornadaPadrao) > 0;

        //exibe 
        System.out.printf("\n-------------------------\nNome: %s \nEntrada: %s \nSaída: %s \nHoras trabalhadas: %d horas e %d minutos \nHoras extras: %s", 
        nome, 
        horaEntrada, 
        horaSaida, 
        horas, 
        minutos,
        horasExtras ? "Sim" : "Não");


    scanner.close();
    }
}
