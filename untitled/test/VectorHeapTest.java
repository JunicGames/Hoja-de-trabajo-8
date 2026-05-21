import static org.junit.Assert.*;
import org.junit.Test;

public class VectorHeapTest {

    @Test
    public void testAdd() {

        VectorHeap<Paciente> heap = new VectorHeap<>();

        heap.add(new Paciente("Juan", "fractura", 'C'));
        heap.add(new Paciente("Maria", "apendicitis", 'A'));

        assertEquals('A', heap.peek().getPrioridad());
    }

    @Test
    public void testRemove() {

        VectorHeap<Paciente> heap = new VectorHeap<>();

        heap.add(new Paciente("Juan", "fractura", 'C'));
        heap.add(new Paciente("Maria", "apendicitis", 'A'));
        heap.add(new Paciente("Luis", "fiebre", 'B'));

        Paciente primero = heap.remove();

        assertEquals('A', primero.getPrioridad());
    }
}