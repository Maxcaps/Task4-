import java.util.Arrays;

public class Array {
    private int[] data;

    public Array(int size) {
        this.data = new int[size];
    }

    public Array(int[] initialData) {
        this.data = Arrays.copyOf(initialData, initialData.length);
    }

    public Array(Array another) {
        this.data = Arrays.copyOf(another.data, another.data.length);
    }

    public int get(int index) {
        return data[index];
    }

    public void set(int index, int value) {
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
