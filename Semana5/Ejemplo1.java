package Semana5;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Ejemplo1 {
    public static void main(String[] args) {
        double saldo = 1000.0;
        int meses = 2;
        CuentaBancaria cuenta = new CuentaBancaria();
        double interes = cuenta.calcularInteres(saldo, meses);
        System.out.println("Interés: " + interes);

    }
}
class CuentaBancaria {
    public double calcularInteres(double saldo, int meses) {
        try {
            if (meses == 0)
                throw new ArithmeticException("Meses != 0");
            double interes = saldo * 0.05 / 12 * meses;
            return interes;
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
            return 0.0;
        }
    }
}