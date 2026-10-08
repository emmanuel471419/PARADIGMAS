package Semana9;
import java.util.ArrayList;
import java.util.List;

// --- MODEL ---
class StudentModel {
    private String name;
    private String email;
    private static List<String> studentDatabase = new ArrayList<>();

    public StudentModel(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() { return name; }
    public String getEmail() { return email; }

    // Lógica de negocio: guarda el alumno solo si el correo es válido
    public boolean saveStudent() {
        if (email != null && email.contains("@")) {
            studentDatabase.add(name + " (" + email + ")");
            return true;
        }
        return false;
    }

    public static List<String> getAllStudents() {
        return studentDatabase;
    }
}

// --- VIEW ---
class StudentView {
    public void displayStudentDetails(String name, String email, boolean success) {
        if (success) {
            System.out.println("[VIEW] ¡Éxito! El alumno " + name + " se registró correctamente.");
        } else {
            System.out.println("[VIEW] Error: El correo no es válido. No se pudo registrar.");
        }
    }

    public void displayAllStudents(List<String> students) {
        System.out.println("\n--- Alumnos Registrados Actualmente ---");
        for (String student : students) {
            System.out.println("- " + student);
        }
        System.out.println("---------------------------------------\n");
    }
}

// --- CONTROLLER ---
class StudentController {
    private StudentView view;

    public StudentController(StudentView view) {
        this.view = view;
    }

    public void registerNewStudent(String name, String email) {
        // El controlador coordina al modelo y a la vista
        StudentModel model = new StudentModel(name, email);
        boolean isSaved = model.saveStudent();
        
        // Actualiza la vista dependiendo del resultado del modelo
        view.displayStudentDetails(name, email, isSaved);
        view.displayAllStudents(StudentModel.getAllStudents());
    }
}


public class Main {
    public static void main(String[] args) {
        StudentView view = new StudentView();
        StudentController controller = new StudentController(view);

        // Simulamos acciones del usuario pasando por el controlador
        controller.registerNewStudent("Carlos Gomez", "carlos@example.com");
        controller.registerNewStudent("Ana Lopez", "invalid-email");
    }
}