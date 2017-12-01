import java.util.AbstractSequentialList;
import java.util.Collection;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;
import java.util.stream.Stream.Builder;

/**
 * @param <E>
 * @author nl253
 */

@SuppressWarnings({"ClassHasNoToStringMethod", "ClassWithoutLogger", "DesignForExtension", "AccessingNonPublicFieldOfAnotherObject"})
public class SinglyLinkedList<E> extends AbstractSequentialList<E> {

    /**
     * keeps track of the number of elements in the list
     */

    @SuppressWarnings({"InstanceVariableMayNotBeInitialized", "InstanceVariableNamingConvention"})
    private int size;

    /**
     * reference to the first element
     */

    @SuppressWarnings({"InstanceVariableOfConcreteClass", "InstanceVariableMayNotBeInitialized", "InstanceVariableNamingConvention"})
    private Node<E> head;

    /**
     * reference to the last element
     */

    @SuppressWarnings({"InstanceVariableMayNotBeInitialized", "InstanceVariableOfConcreteClass", "InstanceVariableNamingConvention"})
    private Node<E> tail;

    /**
     * Empty constructor. Produces an empty SinglyLinkedList.
     */

    @SuppressWarnings({"ImplicitCallToSuper", "PublicConstructor"})
    public SinglyLinkedList() {}

    /**
     * Second version of constructor. It's a convenience function that takes a
     * collection and automatically inserts all elements into the list.
     *
     * @param collection the collection of items you want to insert on
     * SinglyLinkedList creation.
     */

    @SuppressWarnings({"ImplicitCallToSuper", "PublicConstructor"})
    public SinglyLinkedList(final Collection<E> collection) {
        addAll(collection);
    }

    /**
     * - [x] Write the method boolean add(E elem) in which you add an element to
     * the end of a list - [x] the method will always return true - [x] Your
     * implementation should instead operate in O(1) time
     *
     * @return true
     */

    @SuppressWarnings({"LocalVariableOfConcreteClass", "NestedAssignment", "ConstantConditions"})
    @Override
    public boolean add(final E e) {
        final Node<E> newNode = new Node<>(e, null);

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
     * [x] Write the method ListIterator listIterator(int pos), for details see
     * the description in AbstractSequentialList.
     * <p>
     * [x] This method will typically just create s suitable object and return
     * it.
     *
     * @param i
     */

    @Override
    public ListIterator<E> listIterator(final int i) {
        return new SinglyListIterator<>(this, i);
    }

    public ListIterator<E> listIterator() {
        return new SinglyListIterator<>(this);
    }


    /**
     * Execute a void (non-returning) function (a consumer) on each element in
     * this SinglyLinkedList.
     *
     * @param consumer ie a unary function that takes a parameter of type E and
     * returns null ie nothing.
     */

    @SuppressWarnings({"LawOfDemeter", "unchecked", "LocalVariableOfConcreteClass", "rawtypes"})
    @Override
    public void forEach(final Consumer consumer) {
        for (Node<E> node = head; node != null; node = node.getRight())
            consumer.accept(node.getLeft());
    }

    /**
     * Creates a stream builder and populates the stream with elements of this
     * SinglyLinkedList (NOT nodes but elements).
     *
     * @return stream of values stored in the list
     */

    @SuppressWarnings({"LawOfDemeter", "LocalVariableOfConcreteClass"})
    @Override
    public Stream<E> stream() {
        final Builder<E> builder = Stream.builder();
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

    @SuppressWarnings("ReturnOfNull")
    @Override
    public Stream<E> parallelStream() {
        return null;
    }

    /**
     * The number of elements in the list. Looks up the size field which gives
     * O(1) time complexity .
     * <p>
     * - [x] Write a int size() method that returns the size of the collection -
     * [x] The method should just lookup a field (see field int size above)
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
     * @param predicate a boolean, unary function
     * @return true
     */

    @SuppressWarnings({"LawOfDemeter", "FeatureEnvy", "LocalVariableOfConcreteClass"})
    @Override
    public boolean removeIf(final Predicate<? super E> predicate) {

        final SinglyLinkedList<E> tmpList = new SinglyLinkedList<>();

        for (Node<E> node = head; node != null; node = node.getRight())
            // test on the value stored in each node not the node itself
            if (predicate.test(node.getLeft())) tmpList.add(node.getLeft());

        // make this SinglyLinkedList the tmpList
        // because I cannot just assign to this eg this = tmpList
        head = tmpList.head;
        tail = tmpList.tail;
        size = tmpList.size;
        return true;
    }

    /**
     * Modify the SinglyLinkedList by applying the operator to all elements.
     *
     * @param unaryOperator ie a unary function that produces an element of type
     * E.
     */

    @SuppressWarnings({"LawOfDemeter", "FeatureEnvy", "LocalVariableOfConcreteClass"})
    @Override
    public void replaceAll(final UnaryOperator<E> unaryOperator) {
        for (Node<E> node = head; node != null; node = node.getRight())
            node.setLeft(unaryOperator.apply(node.getLeft()));
    }

    /**
     * Sort the SinglyLinkedList in-place using quicksort.
     *
     * @param comparator ie a function that imposes a total ordering on the
     * objects
     */

    @SuppressWarnings({"LocalVariableOfConcreteClass", "MethodWithMultipleReturnPoints", "MismatchedQueryAndUpdateOfCollection"})
    @Override
    public void sort(final Comparator<? super E> comparator) {

        // size is 0 or 1 - nothing to do
        if ((head == null) || head.equals(tail)) return;

        final SinglyLinkedList<E> tmpList = new SinglyLinkedList<>();

        stream().sorted(comparator).forEach(tmpList::add);

        // make this SinglyLinkedList the same as tmpList
        size = tmpList.size;
        head = tmpList.head;
        tail = tmpList.tail;
    }
}
