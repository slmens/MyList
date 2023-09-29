import java.util.Arrays;

public class Arr<T> {
    private int capacity;
    private Object[] myGenericArray;

    public Arr() {
        this.capacity = 10;
        this.myGenericArray = new Object[this.capacity];
    }

    public Arr(int capacity) {
        this.capacity = capacity;
        this.myGenericArray = new Object[capacity];
    }


    public void setArr(T[] arr){
        try {
            myGenericArray = arr;
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
    }

    public void setArr(T value) {
        try {

            int counter = 0;
            for (int i = 0; i < myGenericArray.length; i++){
                if (myGenericArray[i] != null){
                    counter++;
                }
            }
            myGenericArray[counter] = value;

        }catch (IndexOutOfBoundsException e){
            this.capacity = this.capacity * 2;
            myGenericArray = Arrays.copyOf(myGenericArray, this.capacity);
            System.out.println("Your capacity has been doubled due to the insufficient space. Please try again.");
        }
    }

    public void setArr(int index, T value) {

        try {
            myGenericArray[index] = value;

        }catch (IndexOutOfBoundsException e){
            this.capacity = this.capacity * 2;
            myGenericArray = Arrays.copyOf(myGenericArray, this.capacity);
            System.out.println("Your capacity has been doubled due to the insufficient space. Please try again.");
        }
    }


    public void getArr() {
        for (int i = 0; i < myGenericArray.length ; i++){
            System.out.println(myGenericArray[i]);
        }
    }

    public T getArr(int index) {

        try {
            return (T) myGenericArray[index];
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
            return null;
        }
    }

    public int indexOf(T item) {
        for (int i = 0; i < capacity; i++) {
            if (item.equals(myGenericArray[i])) {
                return i; // Return the index if the item is found
            }
        }
        return -1; // Return -1 if the item is not found in the array
    }

    public void remove(int index) {
        if (index < 0 || index >= capacity) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        // Shift elements to the left to fill the gap
        for (int i = index; i < capacity - 1; i++) {
            myGenericArray[i] = myGenericArray[i + 1];
        }

        // Set the last element to null
        myGenericArray[capacity - 1] = null;
    }

    public int size(){
        return myGenericArray.length;
    }

    public void getCapacity(){
        System.out.println("Capacity of this array is " + capacity);
    }

}
