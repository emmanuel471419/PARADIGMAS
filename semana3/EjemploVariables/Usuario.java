public class Usuario {
    private String nombre;        // Variable de instancia
    private static int total = 0; // Variable de clase

    public Usuario(String nombre) {
        this.nombre = nombre;
        total++; // Se incrementa para todos
    }

    public static int obtenerTotal() {
        return total; // Acceso a variable static
    }

    public static void main(String[] args) {
        // Uso:
        new Usuario("Juan");  // total = 1
        new Usuario("María"); // total = 2
        
        System.out.println(Usuario.obtenerTotal()); // Muestra 2
    }
}