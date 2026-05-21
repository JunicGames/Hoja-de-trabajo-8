package app;
import heap.VectorHeap;
import model.Paciente;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class main {

    public static void main(String[] args) {

        VectorHeap<Paciente> cola = new VectorHeap<>();

        try {

            BufferedReader br = new BufferedReader(
                    new FileReader("untitled/src/pacientes.txt")
            );

            String linea;

            while ((linea = br.readLine()) != null) {

                String[] partes = linea.split(",");

                String nombre = partes[0].trim();
                String sintoma = partes[1].trim();
                char prioridad = partes[2].trim().charAt(0);

                Paciente paciente = new Paciente(nombre, sintoma, prioridad);

                cola.add(paciente);
            }

            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Siguiente paciente a atender:");
        System.out.println(cola.peek());

        System.out.println("\nOrden de atención:");

        while (!cola.isEmpty()) {
            System.out.println(cola.remove());
        }
    }
}