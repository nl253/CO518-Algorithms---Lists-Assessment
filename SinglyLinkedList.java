import java.util.AbstractSequentialList;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class SinglyLinkedList extends AbstractSequentialList {

    @Override
    public ListIterator listIterator(final int i) {
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

    @Override
    public int size() {
        return 0;
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
