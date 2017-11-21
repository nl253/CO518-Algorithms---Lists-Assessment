import java.util.AbstractSequentialList;
import java.util.Collection;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;
import java.util.stream.Stream.Builder;

public class SinglyLinkedList<E> extends AbstractSequentialList<E> {

    /**
     * keeps track of the number of elements in the list
     */

    private int size;

    /**
     * reference to the first element
     */

    private Node<E> head;

    /**
     * reference to the last element
     */

    private Node<E> tail;

    /**
     * Empty constructor. Produces an empty SinglyLinkedList.
     */

    public SinglyLinkedList() {}

    /**
     * Second version of constructor. It's a convenience function that takes a
     * collection and automatically inserts all elements into the list.
     *
     * @param collection the collection of items you want to insert on
     * SinglyLinkedList creation.
     */

    public SinglyLinkedList(Collection collection) {
        addAll(collection);
    }

    /**
     * - [x] Write the method boolean add(E elem) in which you add an element to
     * the end of a list - [x] the method will always return true - [x] Your
     * implementation should instead operate in O(1) time
     *
     * @return true
     */

    public boolean add(E newItem) {
        Node<E> newNode = new Node<>(newItem, null);

        // (head == null) -> (tail == null)
        // so calling setRight() on it would cause an Exception
        if (head == null) head = tail = newNode;

        else {
            tail.setRight(newNode);
            tail = newNode;
            size++;
        }

        return true;
    }

    /**
     * [x] Write the method ListIterator<E> listIterator(int pos), for details
     * see the description in AbstractSequentialList.
     * <p>
     * [x] This method will typically just create s suitable object and return
     * it.
     *
     * @param pos
     */

    @Override
    public ListIterator listIterator(final int pos) {
        return new SinglyListIterator(this);
    }


    /**
     * @param action ie a unary function that takes a parameter of type E and
     * returns null ie nothing.
     */

    @Override
    public void forEach(final Consumer action) {
        for (Node<E> node = head; node != null; node = node.getRight())
            action.accept(node.getLeft());
    }

    /**
     * @return null
     */

    @Override
    public Spliterator spliterator() {
        return null;
    }

    /**
     * @return stream of values stored in the list
     */

    @Override
    public Stream stream() {
        Builder<E> builder = Stream.builder();
        for (Node<E> node = head; node != null; node = node.getRight())
            builder.add(node.getLeft());
        return builder.build();
    }

    /**
     * I am leaving this one unimplemented because we really haven't been taught
     * this.
     *
     * @return parallel version of a stream of values in the list
     */

    @Override
    public Stream parallelStream() {
        return null;
    }

    /**
     * - [x] Write a int size() method that returns the size of the collection.
     * - [x] The method should just lookup a field (see field int size above)
     *
     * @return the number of elements in the list
     */

    @Override
    public int size() {
        return size;
    }

    /**
     * Remove items from SinglyLinkedList that return false when tested against
     * the Predicate.
     *
     * @param filter a boolean, unary function
     * @return true
     */

    @Override
    public boolean removeIf(final Predicate filter) {

        SinglyLinkedList tmpList = new SinglyLinkedList();

        for (Node<E> node = head; node != null; node = node.getRight())
            if (true) tmpList.add(node.getLeft());

        // because I cannot just assign to this eg this = tmpList
        head = tmpList.head;
        tail = tmpList.tail;
        size = tmpList.size;

        return true;
    }

    /**
     * Modify the SinglyLinkedList by applying the operator to all elements.
     *
     * @param operator ie a unary function that produces an element of type E.
     */

    @Override
    public void replaceAll(final UnaryOperator operator) {
        for (Node<E> node = head; node != null; node = node.getRight())
            node.setLeft((E) operator.apply(node.getLeft()));
    }

    /**
     * Sort the SinglyLinkedList in-place using quicksort.
     *
     * @param comparator ie a function that imposes a total ordering on the
     * objects
     */

    @Override
    public void sort(final Comparator<? super E> comparator) {

        // size is 0 or 1
        if (head == null || head.equals(tail)) return;

        SinglyLinkedList<E> tmpList = new SinglyLinkedList<>();

        stream().sorted(comparator).forEach(x -> { tmpList.add((E) x);});

        // reset
        head = null;
        tail = null;
        size = 0;

        // add all
        tmpList.forEach(x -> add((E) x));
    }
}
