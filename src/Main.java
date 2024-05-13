public class Main {
    public static void main(String[] args) {
        Array myArray = new Array(10);
        ArrayUtils.fillRandom(myArray, 100);
        System.out.println(myArray);

        ArrayUtils.fillFromConsole(myArray);
        System.out.println(myArray);

        ArrayUtils.fillFromFile(myArray, "numbers.txt");
        System.out.println(myArray);

        ArrayUtils.mergeSort(myArray);
        System.out.println(myArray);
    }
}