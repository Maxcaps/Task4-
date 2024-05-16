import java.util.Arrays;

public class Array {
    private final int[] data;

    public Array(int size) {
        if (size < 0) {
            throw new ArrayInitializationException("Size must be non-negative");
        }
        this.data = new int[size];
    }

    public Array(int[] initialData) {
        if (initialData == null) {
            throw new ArrayInitializationException("Initial data cannot be null");
        }
        this.data = Arrays.copyOf(initialData, initialData.length);
    }

    public Array(Array another) {
        if (another == null) {
            throw new ArrayInitializationException("Another array cannot be null");
        }
        this.data = Arrays.copyOf(another.data, another.data.length);
    }

    public int get(int index) {
        if (index >= data.length || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return data[index];
    }

    public void set(int index, int value) {
        if (index >= data.length || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        data[index] = value;
    }


    public int size() {
        return data.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(data);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Array array = (Array) obj;
        return Arrays.equals(data, array.data);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(data);
    }
}
