import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class SinglyLinkedList<E> extends AbstractSequentialList<E> {

    private int size = 0;

    public SinglyLinkedList() {
    }

    public SinglyLinkedList(Collection collection) {
        this.addAll(collection);
    }

    /**
     * Write the method boolean add(E elem) in which you add an element to the
     * end of a list; the method will always return true. Note that we would
     * inherit a fully functioning add method from the superclass (as long as we
     * implement listIterator), but this method is inefficient. Your
     * implementation should instead operate in O(1) time.
     */

    public boolean add (E newItem) {

    }

    /**
     * Write the method ListIterator<E> listIterator(int pos), for details see
     * the description in AbstractSequentialList. This method will typically
     * just create s suitable object and return it.
     *
     * @param pos
     */

    @Override
    public ListIterator listIterator(final int pos) {
        return null;
    }


    @Override
    public void forEach(final Consumer action) {

    }

    @Override
    public Spliterator spliterator() {
        return null;
    }

    @Override
    public Stream stream() {
        return null;
    }

    @Override
    public Stream parallelStream() {
        return null;
    }

    /**
     * Write a int size() method that returns the size of the collection. The
     * method should just lookup a field - marks for this question will indicate
     * the extend to which you have maintained that field correctly in other
     * parts of the implementation.
     *
     * @return
     */

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean removeIf(final Predicate filter) {
        return false;
    }

    @Override
    public void replaceAll(final UnaryOperator operator) {

    }

    @Override
    public void sort(final Comparator c) {

    }
}
