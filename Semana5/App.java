package Semana5;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        File file = new File("src/Documento.txt");

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("El archivo no fue encontrado: " + e.getMessage());
        }
    }
}
class SaldoInsuficienteException extends Exception {
    private double saldoRequerido;
    private double saldoDisponible;

    public SaldoInsuficienteException(double requerido, double disponible) {
        super("Requiere: $" + requerido +
              " Disponible: $" + disponible);
        this.saldoRequerido = requerido;
        this.saldoDisponible = disponible;
    }

    public double getSaldoRequerido() { return saldoRequerido; }
    public double getSaldoDisponible() { return saldoDisponible; }
}