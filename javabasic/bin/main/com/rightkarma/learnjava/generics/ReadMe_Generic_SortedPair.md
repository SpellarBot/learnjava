#### SortedPair - to understand generics
* SortedPair will take any class as generic that implements Comparable.
* Comparable<T> in class definition- here T signifies that class should be comparable to itself.
* To understand look at java.lang.Comparable interface. "public interface Comparable<T>"

```
public class SortedPair<T extends Comparable<T>> {
	private final T first;
	private final T second;

	public SortedPair(T left, T right) {
		if ( left.compareTo(right)<0) {
			first=left; second=right;
		} else {
			first=right; second=left;
		}
	}

	public T getFirst() {
		return first;
	}

	public T getSecond() {
		return second;
	}
}
```


Look at following examples to understand how a class compareTo method would look like based upon what it puts in Comparable interface.
 
    ```
    Person implements Comparable 
    @Override
	public int compareTo(Object o) {
		return -1;
	}

    Person implements Comparable<Person>
	@Override
	public int compareTo(Person o) {
		return Integer.compare(this.age, o.getAge());
	}

    Person implements Comparable<Integer>
	@Override
	public int compareTo(Integer o) {
		return o> 0 ? 1:0;
	}
	```
