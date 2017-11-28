import java.util.List;
import java.util.ListIterator;
import java.util.function.Consumer;

@SuppressWarnings("DesignForExtension")
public class SinglyListIterator<E> implements ListIterator<E> {

    /**
     * keeps track of the current position
     */

    private int position;

    /**
     * a reference to the SinglyLinkedList this ListIterator is iterating over
     */

    private List<E> list;


    public SinglyListIterator(List<E> list) {
        this.list = list;
    }

    /**
     * Returns true if this list iterator has more elements when traversing the
     * list in the forward direction.
     *
     * @return boolean
     */

    @Override
    public boolean hasNext() {
        return nextIndex() < list.size();
    }

    /**
     * Returns the next element in the list and advances the cursor position.
     *
     * @return the next element from the list
     */

    @Override
    public E next() {
        E item = list.get(position);
        position++;
        return item;
    }

    @SuppressWarnings("MethodCallInLoopCondition")
    @Override
    public void forEachRemaining(final Consumer<? super E> consumer) {
        for (int i = position; i < list.size(); i++)
            consumer.accept(list.get(i));
    }

    /**
     * Returns true if this list iterator has more elements when traversing the
     * list in the reverse direction.
     *
     * @return boolean
     */

    @Override
    public boolean hasPrevious() {
        return previousIndex() >= 0;
    }

    /**
     * Returns the previous element in the list and moves the cursor position
     * backwards.
     *
     * @return the previous item
     */

    @Override
    public E previous() {
        position--;
        return list.get(previousIndex());
    }

    /**
     * Returns the index of the element that would be returned by a subsequent
     * call to next().
     *
     * @return the next index
     */

    @Override
    public int nextIndex() {
        return position + 1;
    }

    /**
     * Returns the index of the element that would be returned by a subsequent
     * call to previous().
     *
     * @return the previous index
     */

    @Override
    public int previousIndex() {
        return position - 1;
    }

    /**
     * Inserts the specified element into the list (optional operation).
     *
     * @param e new element of type E that you want to append to the
     * SinglyLinkedList
     */

    @Override
    public void add(final E e) {
        list.add(e);
    }
}
