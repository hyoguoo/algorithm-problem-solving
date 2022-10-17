package DataStructure.LinkedListImplement;

public class SingleLinkedList<T> implements LinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public SingleLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public boolean add(T value) {
        if (this.size == 0) {
            addFirst(value);
        } else {
            addLast(value);
        }
        return true;
    }

    @Override
    public void add(int index, T value) {
        if (index == 0) {
            addFirst(value);
            return;
        }
        if (index == this.size) {
            addLast(value);
            return;
        }
        if (this.isInvalidIndex(index)) return;

        Node<T> newNode = new Node<>(value);
        Node<T> prevNode = this.getNode(index - 1);
        Node<T> nextNode = prevNode.next;

        prevNode.next = newNode;
        newNode.next = nextNode;
        this.size++;

    }

    @Override
    public void addFirst(T value) {
        Node<T> newNode = new Node<>(value);

        newNode.next = this.head;
        this.head = newNode;
        this.size++;
        if (this.head.next == null) {
            this.tail = this.head;
        }
    }

    @Override
    public void addLast(T value) {
        Node<T> newNode = new Node<>(value);

        this.tail.next = newNode;
        this.tail = newNode;
        this.size++;
    }

    @Override
    public T remove() {
        Node<T> headNode = this.head;

        if (headNode == null) return null;


        T deletedData = headNode.data;
        Node<T> nextNode = headNode.next;

        headNode.data = null;
        headNode.next = null;

        this.head = nextNode;
        size--;

        if (size == 0) this.tail = null;

        return deletedData;
    }

    @Override
    public T remove(int index) {
        if (index == 0) return this.remove();

        if (this.isInvalidIndex(index)) return null;

        Node<T> prevNode = this.getNode(index - 1);
        Node<T> removeNode = prevNode.next;
        Node<T> nextNode = removeNode.next;

        T deletedData = removeNode.data;

        prevNode.next = nextNode;


        removeNode.next = null;
        removeNode.data = null;
        size--;

        if (prevNode.next == null) this.tail = prevNode;

        return deletedData;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public T getData(int index) {
        return this.getNode(index).data;
    }

    @Override
    public Node<T> getNode(int index) {
        if (this.isInvalidIndex(index)) return null;

        Node<T> currentNode = this.head;

        for (int i = 0; i < index; i++) currentNode = currentNode.next;
        return currentNode;
    }

    @Override
    public int indexOf(T value) {
        Node<T> currentNode = this.head;
        int index = 0;

        while (currentNode != null) {
            if (value.equals(currentNode.data)) return index;
            currentNode = currentNode.next;
            index++;
        }
        return -1;
    }

    @Override
    public void clear() {
        Node<T> currentNode = this.head;

        while (currentNode != null) {
            Node<T> nextNode = currentNode.next;
            currentNode.data = null;
            currentNode.next = null;
            currentNode = nextNode;
        }
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public boolean isInvalidIndex(int index) {
        return index >= this.size || index < 0;
    }
}
