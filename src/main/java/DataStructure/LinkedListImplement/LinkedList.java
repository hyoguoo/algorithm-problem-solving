package DataStructure.LinkedListImplement;

public interface LinkedList<E> {

    boolean add(E value);

    void add(int index, E value);

    void addFirst(E value);

    void addLast(E value);


    E remove();

    E remove(int index);


    int getSize();

    E getData(int index);

    Node<E> getNode(int index);

    int indexOf(E value);

    void clear();
}
