import java.util.*;

public class MySimpleArrayList<E> implements List<E> {

    private static final int startCapacity = 10;
    private int capacity = startCapacity;
    private int indexOfData;
    private Object[] data;



    public MySimpleArrayList() {
        data = new Object[startCapacity];
    }

    public MySimpleArrayList(int size) {
        this.capacity = size;
        data = new Object[capacity];
    }

    public MySimpleArrayList(Collection<? extends E> c) {
        addAll(c);
    }

    @Override
    public int size() {
        return indexOfData;
    }

    @Override
    public boolean isEmpty() {
        return size()==0;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {
        if (data.length - size() < 2) {
            newArray();
        }
        data[indexOfData] = e;
        indexOfData++;
        return true;
        
    }

    @Override
    public void add(int index, E element) {
        checkIndex(index);
        if (index == indexOfData)
        {
            add(element);
        }
        else {
            newArray(index, element);
            indexOfData++;
        }
    }

    private void newArray() {
        capacity = indexOfData + startCapacity;
        Object[] newData = new Object[capacity];
        System.arraycopy(data, 0, newData, 0, indexOfData);
        data = newData;
    }

    private void newArray(int index, E element) {
        if (data.length - size() < 2) {
            capacity = indexOfData + startCapacity;
        }
        Object[] newData = new Object[capacity];
//        if (index == 0) {
//            newData[index] = element;
//            System.arraycopy(data, 0, newData, index + 1, indexOfData);
//        } else {
//            System.arraycopy(data, 0, newData, 0, index);
//            newData[index] = element;
//            System.arraycopy(data, index, newData, index + 1, indexOfData - index);
//        }
        System.arraycopy(data, 0, newData, 0, index);
        newData[index] = element;
        System.arraycopy(data, index, newData, index + 1, indexOfData - index);
        data = newData;
    }

    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);
        if (index >= 0) {
            remove(index);
            return true;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        Object[] col = c.toArray();
        if (isEmpty()) {
            data = col;
            indexOfData = c.size();
        } else {
            Object[] newData = new Object[data.length + col.length];
            System.arraycopy(data, 0, newData, 0, indexOfData);
            System.arraycopy(col, 0, newData, indexOfData, col.length);
            data = newData;
            indexOfData += c.size();
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public E get(int index) {
        if (checkIndex(index))
        {
            E item = (E) data[index];
            return item;
        }
        return null;
    }

    @Override
    public E set(int index, E element) {
        return null;
    }






    @Override
    public E remove(int index) {
        checkIndex(index);
        E item = (E) data[index];
        newArray(index);
        indexOfData--;
        return item;
    }

    @Override
    public int indexOf(Object o) {
        int index = -1;
        for (int i = 0; i < indexOfData; i++)
        {
            if (data[i].equals(o))
            {
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

    private void newArray(int index)
    {
        Object[] newData = new Object[data.length];
        System.arraycopy(data,0,newData,0,index);
        System.arraycopy(data, index+1, newData,index,data.length-index-1);
        data = newData;
    }

    private void clearData(Object[] data, int startIndex)
    {
        for (int i = startIndex; i < data.length; i++)
        {
            data[i] = null;
        }
    }


    private boolean checkIndex(int index)
    {
        if (index < 0 || index > indexOfData)
            throw new IndexOutOfBoundsException("index: " + index + ", Size: " + size());
        return true;
    }



    @Override
    public String toString() {
        return "MySimpleArrayList{" +
                "data=" + Arrays.toString(data) +
                '}';
    }
}
