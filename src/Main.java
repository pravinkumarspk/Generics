import java.util.*;

class ListArray<T>
{
    private Object[] array;
    private int size;

    public ListArray()
    {
        array = new Object[10];
        size = 0;
    }
    public void add(T item)
    {
        checkSize();
        array[size++] = item;
    }
    public void add(int ind , T item)
    {
        if(ind<0 || ind>size)
        {
            throw new IndexOutOfBoundsException("Index: "+ind);
        }
        checkSize();

        for(int i=size;i>ind;i--)
        {
            array[i]=array[i-1];
        }
        array[ind]=item;
        size++;
    }
    @SuppressWarnings("unchecked")
    //this annotation is used to mention the change in datatype at the return type
    public T get(int ind)
    {
        if(ind<0 || ind>=size)
        {
            throw new IndexOutOfBoundsException("Index: "+ind);
        }
        return (T)array[ind];
    }
    @SuppressWarnings("unchecked")
    public T remove(int ind)
    {
        if(ind<0 || ind>size)
        {
            throw new IndexOutOfBoundsException("Index: "+ind);
        }
        T removed =  (T)array[ind];
        for(int i=ind;i<size-1;i++)
        {
            array[i]=array[i+1];
        }
        array[--size]=null;
        return removed;
    }
    public void checkSize()
    {
        if(size == array.length)
        {
            array = Arrays.copyOf(array, size*2);
        }
    }
    public int size()
    {
        return size;
    }
    public boolean isEmpty()
    {
        return size==0;
    }
    public void clear()
    {
        for(int i=0;i<size;i++)
        {
            array[i]=null;
        }
        size=0;
    }
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<size;i++)
        {
            sb.append(array[i]);
        }
        return sb.toString();
    }
    public void sort()
    {
        Arrays.sort((T[])array,0,size);
    }
}
public class Main {
    public static void print(ListArray<?> list)
    {
        for(int i=0;i<list.size();i++)
        {
            System.out.print(list.get(i)+" ");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ListArray<Integer> intList = new ListArray<>();
        for (int i = 0; i < 5; i++) intList.add(sc.nextInt());
        intList.add(2, sc.nextInt());
        System.out.println("Get: " + intList.get(3));
        intList.remove(1);
        print(intList);
        intList.sort();
        System.out.println();
        print(intList);
        System.out.println();

        ListArray<Float> floatList = new ListArray<>();
        for (int i = 0; i < 5; i++) floatList.add(sc.nextFloat());
        floatList.add(2, sc.nextFloat());
        System.out.println("Get: " + floatList.get(3));
        floatList.remove(1);
        print(floatList);
        floatList.sort();
        System.out.println();
        print(floatList);
        System.out.println();

        ListArray<Character> charList = new ListArray<>();
        for (int i = 0; i < 5; i++) charList.add(sc.next().charAt(0));
        charList.add(2, sc.next().charAt(0));
        System.out.println("Get: " + charList.get(3));
        charList.remove(1);
        print(charList);
        charList.sort();
        System.out.println();
        print(charList);

    }
}