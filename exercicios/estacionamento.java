import java.time.*;
import java.time.format.*;
import java.util.*;

public class estacionamento {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);


    System.out.println("Digite a placa:");
    String placa = scanner.nextLine();

    //hora entrada
    System.out.println("Digite a hora de entrada (hh:mm): ");
    String entrada = scanner.nextLine();

    //formata hora entrada
    DateTimeFormatter horaEntradaFormato = DateTimeFormatter.ofPattern("HH:mm");
    LocalTime horaEntrada = LocalTime.parse(entrada, horaEntradaFormato);


    //hora saida
    System.out.println("Digite a hora de saída (hh:mm):");
    String saida = scanner.nextLine();

    //formata hora saida
    DateTimeFormatter  horaSaidaFormato = DateTimeFormatter.ofPattern("HH:mm");
    LocalTime horaSaida = LocalTime.parse(saida, horaSaidaFormato);


    //converte em minutos
    Duration diferenca = Duration.between(horaEntrada, horaSaida);
    long minutos = diferenca.toMinutes();
    long minutosTotais = minutos;
    
        if(minutos < 0){
        minutos += 1440; // 24(horas) * 60(minutos)
    }

    //calcula valor conforme a quantidade de tempo usado
    double ValorTotal = 5;
    while(minutosTotais > 60){
        minutosTotais -= 15;
        ValorTotal += 2;
    }

    //exibe
   System.out.printf(
    "--------------------\nRECIBO\n--------------------\nPlaca: %s\nEntrada: %s\nSaida: %s\nTempo total(em minutos): %d\nTotal a pagar: R$ %.2f \n--------------------",
    placa,
    horaEntrada,
    horaSaida,
    minutos,
    ValorTotal
);

    scanner.close();
}
}