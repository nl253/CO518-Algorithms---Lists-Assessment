import java.util.List;
import java.util.ListIterator;

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
     * Returns true if there is another element in the SinglyLinkedList that can
     * be produced using next() ie if advancing the pointer and looking up would
     * not produce null.
     *
     * @return boolean
     */

    @Override
    public boolean hasNext() {
        return list.get(nextIndex()) != null;
    }

    /**
     * Produces the next element from the SinglyLinkedList.
     *
     * @return the next element from the list
     */

    @Override
    public E next() {
        position++;
        return list.get(position);
    }


    /**
     * Returns a boolean that tells you if there is a previous item. If the
     * current position is 0 then there is no previous items and false is
     * returned, otherwise true is returned.
     *
     * @return boolean
     */

    @Override
    public boolean hasPrevious() {
        return previousIndex() >= 0;
    }

    /**
     * Produces the previous item.
     *
     * @return the previous item
     */

    @Override
    public E previous() {
        return list.get(previousIndex());
    }

    /**
     * Returns the current index + 1 ie the next index.
     *
     * @return the next index
     */

    @Override
    public int nextIndex() {
        return position + 1;
    }

    /**
     * Returns the current index - 1 ie the previous index.
     *
     * @return the previous index
     */

    @Override
    public int previousIndex() {
        return position - 1;
    }

    /**
     * Adds an element to the list.
     *
     * @param e new element of type E that you want to append to the SinglyLinkedList
     */

    @Override
    public void add(final E e) {
        list.add(e);
    }
}
