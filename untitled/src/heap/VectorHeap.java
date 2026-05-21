package heap;

import java.util.Vector;

public class VectorHeap<E extends Comparable<E>> implements PriorityQueue<E> {

    private Vector<E> data;

    public VectorHeap() {
        data = new Vector<>();
    }

    @Override
    public void add(E value) {
        data.add(value);
        percolateUp(data.size() - 1);
    }

    @Override
    public E remove() {

        if (isEmpty()) {
            return null;
        }

        E minVal = data.get(0);

        E lastVal = data.remove(data.size() - 1);

        if (!isEmpty()) {
            data.set(0, lastVal);
            pushDownRoot(0);
        }

        return minVal;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }

        return data.get(0);
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    private void percolateUp(int index) {

        int parent;

        while (index > 0) {

            parent = (index - 1) / 2;

            if (data.get(index).compareTo(data.get(parent)) >= 0) {
                break;
            }

            swap(index, parent);
            index = parent;
        }
    }

    private void pushDownRoot(int index) {

        int heapSize = data.size();

        while (true) {

            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int smallest = index;

            if (left < heapSize &&
                    data.get(left).compareTo(data.get(smallest)) < 0) {

                smallest = left;
            }

            if (right < heapSize &&
                    data.get(right).compareTo(data.get(smallest)) < 0) {

                smallest = right;
            }

            if (smallest == index) {
                break;
            }

            swap(index, smallest);
            index = smallest;
        }
    }

    private void swap(int i, int j) {

        E temp = data.get(i);
        data.set(i, data.get(j));
        data.set(j, temp);
    }
}
