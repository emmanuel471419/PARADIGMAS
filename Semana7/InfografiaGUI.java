package Semana7;

import javax.swing.*;
import java.awt.*;

public class InfografiaGUI {
    public static void main(String[] args) {
        // Asegurar que la interfaz se ejecute en el hilo de eventos de Swing (EDT)
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Infografía Expandida: Paradigmas Orientados a Eventos en Java");
            frame.setSize(900, 700);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);

            // JEditorPane para renderizar la infografía detallada en formato HTML
            JEditorPane editorPane = new JEditorPane();
            editorPane.setContentType("text/html");
            editorPane.setEditable(false);

            // Contenido enriquecido con más información técnica
            String contenidoInfografia = "<html>" +
                "<head><style>" +
                "body { font-family: 'Segoe UI', Arial, sans-serif; padding: 20px; color: #212529; background-color: #f8f9fa; }" +
                "h1 { color: #03045e; text-align: center; font-size: 24px; margin-bottom: 5px; }" +
                ".subtitle { text-align: center; color: #0077b6; font-size: 13px; margin-bottom: 20px; font-weight: bold; }" +
                "h2 { color: #0077b6; font-size: 15px; border-bottom: 2px solid #0077b6; padding-bottom: 4px; margin-top: 20px; }" +
                "p, li { font-size: 12px; line-height: 1.5; }" +
                ".flow-box { background: #eef4f8; padding: 10px; border-radius: 6px; text-align: center; font-weight: bold; font-size: 11px; color: #023e8a; }" +
                "table { width: 100%; border-collapse: collapse; margin-top: 10px; font-size: 11px; }" +
                "th, td { border: 1px solid #ced4da; padding: 7px; text-align: left; }" +
                "th { background-color: #0077b6; color: white; }" +
                "code { background-color: #e9ecef; padding: 2px 4px; font-family: monospace; color: #d63384; font-size: 11px; }" +
                "ul { margin-top: 5px; padding-left: 20px; }" +
                ".grid { display: flex; justify-content: space-between; }" +
                ".col { width: 48%; background: #ffffff; padding: 10px; border: 1px solid #dee2e6; border-radius: 5px; }" +
                "</style></head>" +
                "<body>" +
                
                "<h1>Paradigmas Orientados a Eventos en Java</h1>" +
                "<div class='subtitle'>De las Interfaces Gráficas de Usuario (GUI) a los Sistemas Reactivos Modernos</div>" +

                "<h2>1. Introducción al Paradigma</h2>" +
                "<p>La programación orientada a eventos cambia el flujo de ejecución secuencial: el programa responde dinámicamente a <b>eventos</b> (acciones de usuario, mensajes de red o disparadores del sistema). En lugar de que el hilo principal consulte constantemente el estado (polling), los componentes se mantienen inactivos hasta que ocurre un estímulo, activando manejadores automáticos.</p>" +

                "<h2>2. El Modelo de Delegación de Eventos en Java</h2>" +
                "<div class='flow-box'>[ 1. Event Source (Ej. Button) ] &nbsp;➔&nbsp; [ 2. Event Object (Ej. ActionEvent) ] &nbsp;➔&nbsp; [ 3. Listener / Handler (Ej. Lambda) ]</div>" +
                "<p><b>¿Cómo funciona?</b> La fuente genera un objeto de evento cuando ocurre una acción y lo distribuye entre los <em>listeners</em> suscritos utilizando típicamente el <b>Patrón Observer</b>.</p>" +

                "<h2>3. Ventajas y Retos del Paradigma</h2>" +
                "<table>" +
                "<tr><th>Ventajas / Beneficios</th><th>Retos / Desventajas</th></tr>" +
                "<tr>" +
                "<td>• Desacoplamiento total entre emisor y receptor.<br>• Alta capacidad de respuesta en interfaces y backend.<br>• Excelente manejo de procesos asíncronos y no bloqueantes.</td>" +
                "<td>• Dificultad para seguir el flujo de ejecución (traza de depuración compleja).<br>• Posible gestión compleja de concurrencia e hilos.<br>• Riesgo de pérdidas de eventos si no se administra bien el buffer.</td>" +
                "</tr>" +
                "</table>" +

                "<h2>4. Comparativa de Frameworks: GUI vs. Enterprise Reactivo</h2>" +
                "<table>" +
                "<tr><th>Característica</th><th>Frameworks GUI (Swing / JavaFX)</th><th>Enterprise Reactivo (Spring WebFlux / Vert.x)</th></tr>" +
                "<tr><td><b>Ámbito Principal</b></td><td>Escritorio / Interfaces de Usuario</td><td>Microservicios / Backend de Alto Rendimiento</td></tr>" +
                "<tr><td><b>Tipos de Eventos</b></td><td>Clics, teclas, movimientos del cursor</td><td>Peticiones HTTP, flujos de datos masivos (Streams)</td></tr>" +
                "<tr><td><b>Modelo de Concurrencia</b></td><td>Event Dispatch Thread (EDT) / Hilo UI</td><td>Event Loops Asíncronos No Bloqueantes</td></tr>" +
                "<tr><td><b>Abstracción Clave</b></td><td><code>ActionListener</code>, <code>EventHandler</code></td><td><code>Flux</code>, <code>Mono</code>, <code>EventBus</code></td></tr>" +
                "</table>" +

                "<h2>5. Ejemplos Prácticos de Código</h2>" +
                "<p><b>A. GUI Tradicional (Java Swing con Expresión Lambda):</b><br>" +
                "<code>JButton btn = new JButton(\"Enviar\");</code><br>" +
                "<code>btn.addActionListener(e -&gt; System.out.println(\"Acción detectada en: \" + e.getActionCommand()));</code></p>" +
                
                "<p><b>B. Backend Reactivo (Spring WebFlux / Reactor):</b><br>" +
                "<code>Flux&lt;String&gt; stream = Flux.just(\"Evento1\", \"Evento2\");</code><br>" +
                "<code>stream.filter(ev -&gt; ev.contains(\"1\")).subscribe(System.out::println);</code></p>" +

                "<h2>6. Glosario Clave</h2>" +
                "<ul>" +
                "<li><b>Asíncrono:</b> Ejecución de tareas independiente del hilo principal que evita bloqueos de la aplicación.</li>" +
                "<li><b>Callback:</b> Función o método pasado como argumento que se ejecuta de forma automática al completarse un evento.</li>" +
                "<li><b>Streams Reactivos:</b> Modelo estándar para procesamiento de flujos de datos asíncronos con control de carga (backpressure).</li>" +
                "</ul>" +

                "</body></html>";

            editorPane.setText(contenidoInfografia);

            // Agregar el componente dentro de un JScrollPane para permitir desplazamiento vertical
            JScrollPane scrollPane = new JScrollPane(editorPane);
            frame.add(scrollPane);

            frame.setVisible(true);
            System.out.println("[GUI] Infografía ampliada abierta exitosamente.");
        });
    }
}