import java.time.*;
import java.time.format.*;
import java.util.*;

public class estacionamento {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);


    System.out.println("Digite a placa:");
    String placa = scanner.nextLine();
    
    System.out.println("Digite a hora de entrada (hh:mm): ");
    String entrada = scanner.nextLine();

    DateTimeFormatter horaEntradaFormato = DateTimeFormatter.ofPattern("HH:mm");
    LocalTime horaEntrada = LocalTime.parse(entrada, horaEntradaFormato);


    //HORA SAIDA
    System.out.println("Digite a hora de saída (hh:mm):");
    String saida = scanner.nextLine();

    DateTimeFormatter  horaSaidaFormato = DateTimeFormatter.ofPattern("HH:mm");
    LocalTime horaSaida = LocalTime.parse(saida, horaSaidaFormato);


    //CONVERTE EM MINUTOS
    Duration diferenca = Duration.between(horaEntrada, horaSaida);
    long minutos = diferenca.toMinutes();
    long minutosTotais = minutos;
    
        if(minutos < 0){
        minutos += 1440;
    }


    double ValorTotal = 5;
    while(minutosTotais > 60){
        minutosTotais -= 15;
        ValorTotal += 2;
    }


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