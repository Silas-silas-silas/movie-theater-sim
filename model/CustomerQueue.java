package model;
import java.util.NoSuchElementException;

public class CustomerQueue {

    private Node front; // front of the queue
    private Node rear;  // rear of the queue
    private int size;

    // Node class for the linked list
    private static class Node {
        Customer data;
        Node next;

        Node(Customer data) {
            this.data = data;
        }
    }

    public CustomerQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    public void enqueue(Customer c) {
        Node newNode = new Node(c);
        if (rear == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    public Customer dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        Customer removed = front.data;
        front = front.next;

        if (front == null) {
            rear = null;
        }
        size--;
        return removed;
    }

    public Customer peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return front.data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size();
    }
}
