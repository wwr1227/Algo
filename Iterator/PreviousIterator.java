import java.util.Iterator;

public class PreviousIterator<T> implements Iterator<T> {
	private final Iterator<T> iterator;
	private boolean hasPrevious = false;
	private T previous;
	private T current;

	public PreviousIterator(Iterator<T> iterator) {
		this.iterator = iterator;
	}

	public T pre() {
		if (!hasPrevious)
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
			hasPrevious = true;
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
