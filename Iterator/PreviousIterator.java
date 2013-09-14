import java.util.Iterator;

public class PreviousIterator<T> implements Iterator<T> {
	private final Iterator<T> iterator;
	private T previous;
	private T current;
	private int count = 0;

	public PreviousIterator(Iterator<T> iterator) {
		this.iterator = iterator;
	}

	public T pre() {
		if (count < 2)
			return null;
		return previous;
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return iterator.hasNext();
	}

	@Override
	public T next() {
		// TODO Auto-generated method stub
		if (hasNext()) {
			count++;
			previous = current;
			current = iterator.next();
		}
		return current;
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		iterator.remove();
	}

}
