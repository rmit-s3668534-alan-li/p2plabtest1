import java.util.ArrayList;

public class HashMapLinearProbing<T> {
	private ArrayList<KeyValue<T>> hashArray;
	private int size;
	private KeyValue<T> nonData;

	public HashMapLinearProbing(int size) {
		this.size = size;
		hashArray = new ArrayList<KeyValue<T>>(size);

		for (int i = 0; i < size; i++)
			hashArray.add(new KeyValue<>(-1));

		nonData = new KeyValue<T>(-1);
	}

	public int hash(int key) {
		return key % size;
	}

	public int hash2(int key) {
		return 7 - (key % 7);
	}

	public void add(KeyValue<T> data) {
		int key = data.getKey();
		int hash = hash(key);

		while (hashArray.get(hash) != null && hashArray.get(hash).getKey() != -1) {
			hash = hash2(hash);
			hash %= size;
		}

		hashArray.set(hash, data);
	}

	public KeyValue<T> find(int key) {
		int hash = hash(key);
		KeyValue<T> hash1 = null;
		while (hashArray.get(hash) != null) {
			if (hashArray.get(hash).getKey() == key) {
				hash1 = hashArray.get(hash);
			}

			hash++;
			hash %= size;
		}

		return hash1;

	}

	public void delete(int key) {
		int hash = hash(key);

		while (hashArray.get(hash) != null) {
			if (hashArray.get(hash).getKey() == key) {
				hashArray.set(hash, nonData);
			}

			hash++;
			hash %= size;
		}

	}

	public void display() {
		System.out.print("Map");

		for (int i = 0; i < size; i++) {
			if (hashArray.get(i).getValue() != null) {
				System.out.println(hashArray.get(i).getValue());
				System.out.println(hashArray.get(i).getKey());
			}

		}
	}
}