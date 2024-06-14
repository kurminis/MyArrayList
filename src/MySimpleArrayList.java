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
        if (size == 0) {
            capacity = startCapacity;
        } else {
            capacity = size;
        }
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
        if (index == indexOfData) {
            add(element);
        } else {
            addElementByIndex(index, element);
            indexOfData++;
        }
    }

    private void newArray() {
        capacity = indexOfData + startCapacity;
        Object[] newData = new Object[capacity];
        System.arraycopy(data, 0, newData, 0, indexOfData);
        data = newData;
    }

    private void addElementByIndex(int index, E element) {
        if (data.length - size() < 2) {
            newArray();
        }
        moveElements(index, true);
        set(index, element);
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
        checkIndex(index);
        E el = (E) data[index];
        data[index] = element;
        return el;
    }

    @Override
    public E remove(int index) {
        checkIndex(index);
        E item = (E) data[index];
        moveElements(index, false);
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

    private void moveElements(int index, boolean add)
    {
        if (add) {
            System.arraycopy(data,index, data, index + 1, indexOfData - index);
        } else {
            System.arraycopy(data, index + 1, data, index, indexOfData - index);
        }
    }

    private boolean checkIndex(int index)
    {
        if (index < 0 || index > indexOfData)
            throw new IndexOutOfBoundsException("index: " + index + ", Size: " + size());
        return true;
    }

    private String printData(){
        StringBuilder str = new StringBuilder();
        if (isEmpty()) {
            str.append("{}");
            return str.toString();
        }
        str.append("{");
        for (int i = 0; i < size(); i++) {
            str.append(data[i]);
            str.append(",");
        }
        int i = str.lastIndexOf(",");
        str.replace(i,i+1,"}");
        //System.out.println("index=" + i);
        return str.toString();
    }

    private String printData2(){
        StringBuilder str = new StringBuilder();
        if (isEmpty()) {
            str.append("{}");
            return str.toString();
        }
        str.append("{");
        for (int i = 0; i < data.length; i++) {
            str.append(data[i]);
            str.append(",");
        }
        int i = str.lastIndexOf(",");
        str.replace(i,i+1,"}");
        //System.out.println("index=" + i);
        return str.toString();
    }





    @Override
    public String toString() {
        return "MySimpleArrayList = " + printData() +
                "\n Data = " + printData2();
    }
}
