package edu.luc.cs271.arrayqueue;

import java.util.ArrayList;
import java.util.List;

public class FixedArrayQueue<E> implements SimpleQueue<E> {

  private final int capacity;

  private int size;

  private int front;

  private int rear;

  private final E[] data;

  // done why do we need an explicit constructor?

  @SuppressWarnings("unchecked")
  public FixedArrayQueue(final int capacity) {
    this.capacity = capacity;
    this.data = (E[]) new Object[capacity];
    this.size = 0;
    this.front = 0;
    this.rear = capacity - 1;
  }

  @Override
  public boolean offer(final E obj) {
    // done
    if (size == capacity) {
      return false;
    }
    size++;
    rear = (rear + 1) % capacity;
    data[rear] = obj;
    return true;
  }

  @Override
  public E peek() {
    // done
    if (!isEmpty()) {
      return data[rear];
    }
    return null;
  }

  @Override
  public E poll() {
    // done
    if (isEmpty()) {
      return null;
    }
    E result = data[front];
    front = (front + 1) % capacity;
    size--;
    return result;
  }

  @Override
  public boolean isEmpty() {
    // done
    if (size == 0) {
      return true;
    }
    return false;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public List<E> asList() {
    // done implement using an ArrayList preallocated with the right size
    List<E> list = new ArrayList<E>(capacity);
    while (!isEmpty()) {
      list.add(data[front]);
      front = (front + 1) % capacity;
      size--;
    }
    return list;
  }
}
