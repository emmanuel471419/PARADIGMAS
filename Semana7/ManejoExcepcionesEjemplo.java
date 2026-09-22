package Semana7;

public class ManejoExcepcionesEjemplo {
   public ManejoExcepcionesEjemplo() {
   }

   public static int dividir(int var0, int var1) {
      return var0 / var1;
   }

   public static void main(String[] var0) {
      byte var1 = 20;
      byte var2 = 0;
      System.out.println("Iniciando la aplicación...");

      try {
         System.out.println("Intentando realizar la división...");
         int var3 = dividir(var1, var2);
         System.out.println("El resultado es: " + var3);
      } catch (ArithmeticException var7) {
         System.out.println("[Error controlado]: No es posible dividir un número entre cero.");
      } finally {
         System.out.println("Bloque finally ejecutado: limpieza de recursos finalizada.\n");
      }

      System.out.println("El programa continúa su ejecución normal después del manejo de la excepción.");
   }
}

