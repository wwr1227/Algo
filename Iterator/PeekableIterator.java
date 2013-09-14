import java.util.Iterator;

public class PeekableIterator<T> implements Iterator<T> {
	private final Iterator<T> iterator;
	private boolean hasPeek = false;
	private T nextPeek = null;

	public PeekableIterator(Iterator<T> iterator) {
		this.iterator = iterator;
	}

	@Override
	public T next() {
		if (hasPeek) {
			hasPeek = false;
			return peek();
		}
		return (T) iterator.next();
	}

	public T peek() {
		if (hasNext()) {
			if (hasPeek == false) {
				nextPeek = next();
				hasPeek = true;
			}
		} else {
			nextPeek = null;
		}
		return nextPeek;
	}

	@Override
	public void remove() {
		iterator.remove();
	}

	@Override
	public boolean hasNext() {
		return iterator.hasNext();
	}

}
