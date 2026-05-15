import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class pagamento {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Data prevista para o pagamento:");
        String dataP = scanner.next();

        System.out.print("Data efetiva para o pagamento:");
        String dataE = scanner.next();

        System.out.print("Valor da dívida:");
        double valor = scanner.nextDouble();

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate dataPrevista = LocalDate.parse(dataP, formato);
        LocalDate dataEfetiva = LocalDate.parse(dataE, formato);

        long diferenca = ChronoUnit.DAYS.between(dataPrevista, dataEfetiva);

        System.out.println("\nData prevista: " + dataPrevista.format(formato));
        System.out.println("Data Pagamento: " + dataEfetiva.format(formato));

        if(diferenca > 0){
            double juros = valor * 0.2;
            valor += juros;
            System.out.printf("Pagamento em atraso\n");
            System.out.printf("Dias de atraso: \n", diferenca);
            System.out.printf("Juros: R$ %.2f\n", juros);
            System.out.printf("Valor final: R$%.2f", valor);
        }
        else{
            System.out.printf("Pagamento realizado no prazo.\n");
            System.out.printf("Valor: R$ %.2f", valor);
        }
        scanner.close();
    }
}
