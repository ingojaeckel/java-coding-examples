package datastructures.stack;

public interface Stack<T> {
    T pop() throws EmptyStackException;
    void push(T value);
    int size();
}
