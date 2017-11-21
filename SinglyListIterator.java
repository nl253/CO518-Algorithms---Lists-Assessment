import java.util.List;
import java.util.ListIterator;

public class SinglyListIterator<E> implements ListIterator<E> {

    private int position;
    private List<E> list;


    public SinglyListIterator(List<E> list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return list.get(nextIndex()) != null;
    }

    @Override
    public E next() {
        position++;
        return list.get(position);
    }

    @Override
    public boolean hasPrevious() {
        return previousIndex() >= 0;
    }

    @Override
    public E previous() {
        return list.get(previousIndex());
    }

    @Override
    public int nextIndex() {
        return position + 1;
    }

    @Override
    public int previousIndex() {
        return position - 1;
    }

    @Override
    public void add(final E e) {
        list.add(e);
    }
}
