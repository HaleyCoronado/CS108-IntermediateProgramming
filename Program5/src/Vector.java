import java.util.Arrays;

public class Vector<E> extends AbstractListADT<E> implements ListADT<E>{
    E[] array;
    int increment = 5;
    int initialCapacity = 0;
    int size = 0;

    @Override
    public String toString() {
        String arrayString = "[";
        for(int i = 0; i < (size - 1); i++){
            arrayString += array[i] + ", ";
        }
        arrayString += array[size - 1] + "]";
        return arrayString;
    }

    /**
     * Creates an array with initial capacity of 10
     */
    @SuppressWarnings("unchecked")
    public Vector(){
        array = (E[]) new Object[10];
        this.initialCapacity = 10;
    }

    /**
     * creates an array with the given initial capacity
     * @param initialCapacity the given initial capacity
     */
    @SuppressWarnings("unchecked")
    public Vector(int initialCapacity){
        array = (E[]) new Object[initialCapacity];
        this.initialCapacity = initialCapacity;
    }

    /**
     * Creates an array with the given initial capacity
     * and assigns a value to capacity increment
     * @param initialCapacity the given initial capacity
     * @param capacityIncrement the given capacity increment
     */
    @SuppressWarnings("unchecked")
    public Vector(int initialCapacity, int capacityIncrement){
        array = (E[]) new Object[initialCapacity];
        increment = capacityIncrement;
        this.initialCapacity = initialCapacity;
    }

    /**
     * Appends the specified element to the end of this list
     * @param data
     * @return boolean
     */
    public boolean add(E data){
        //resize capacity if needed
        size++;
        if (size >= array.length){
            array = resize(array);
        }
        array[size - 1] = data;
        return true;
    }

    /**
     * Inserts the specified element at the specified position in this list.
     * Shifts the element currently at that position (if any) and any subsequent
     * elements by adding one to their indices.
     * @param index - index at which the specified element is to be inserted
     * @param data - element to be inserted
     * @return boolean
     * @throws IllegalArgumentException - if the index is out of range (index < 0 || index > size())
     */
    public boolean add(int index, E data) {
        if(index < 0 || index > size()) {
            throw new IllegalArgumentException("Index " + index + " out of bounds for length " + size);
        } else {
            if(index >= array.length){
                array = resize(array);
            }

            size++;
            for(int i = (array.length - 1); i > index; i--){
                array[i] = array[i - 1];
            }
            array[index] = data;
            return true;
        }
    }

    /**
     * Removes all of the elements from this list
     */
    public void clear(){
        Arrays.fill(array, null);
        size = 0;
    }

    /**
     * Returns true if this list contains the specified element
     * @param data
     * @return boolean
     */
    public boolean contains(E data){
        for(int i = 0; i < size; i++){
            if(array[i].equals(data)){
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the element at the specified position in this list
     * @param index
     * @return E
     */
    public E get(int index){
        return array[index];
    }

    /**
     * Returns the index of the first occurrence of the specified element in this list
     * Return, or -1 if this list does not
     * contain the element
     * @param data
     * @return int
     */
    public int indexOf(E data){
        for(int i = 0; i < size; i++){
            if(array[i].equals(data)){
                return i;
            }
        }
        return -1;
    }

    /**
     * Returns the index of the last matching of the element in this list
     * Return -1 if no match
     * @param data
     * @return int
     */
    public int lastIndexOf(E data){
        int lastIndex = -1;
        for(int i = 0; i < size; i++){
            if(array[i].equals(data)){
                lastIndex =  i;
            }
        }
        return lastIndex;
    }

    /**
     * Returns true if this list contains no elements
     * @return boolean
     */
    public boolean isEmpty(){
        if(size == 0){
            return true;
        } else {
            return false;
        }
    }

    /**
     * Removes the  element at the specified position in this list.
     * Shifts any subsequent elements by subtracting one from their indices.
     * @param index - index of the element to be removed
     * @return E - the element that was removed from the list
     * @throws IllegalArgumentException - if the index is out of range (index < 0 || index >= size())
     */
    public E remove (int index){
        if(index < 0 || index > size()) {
            throw new IllegalArgumentException("Index " + index + " out of bounds for length " + size);
        } else {
            E t = array[index];
            size--;
            for(int i = index; i < array.length; i++){
                array[index] = array[index + 1];
            }
            return t;
        }
    }

    /**
     * Trims the capacity of this Vector instance to be the list's current size. An application
     * can use this operation to minimize the storage of a Vector instance.
     */
    public void trimToSize() {
        //change capacity to be size
        array = Arrays.copyOf(array, size);
    }

    public E[] resize(E[] e){
        E[] tmp = Arrays.copyOf(e, (array.length + increment));
        return tmp;
    }

    /**
     * Returns the number of elements in this list
     */

    public int size(){
        return size;
    }

    /**
     * @return a String: "Program 5, Haley Coronado"
     */
    public String getID(){
        return "Program 5, Haley Coronado";
    }

    /**
     * @return the capacity (not size) of the internal array structure
     */
    public int getCapacity(){
        return array.length;
    }

    /**
     * @return the capacity increment of the vector
     */
    public int getIncrement(){
        return increment;
    }
}