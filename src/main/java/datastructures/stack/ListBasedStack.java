package datastructures.stack;

import java.util.ArrayList;
import java.util.List;

public class ListBasedStack<T> implements Stack<T> {
    private List<T> list = new ArrayList<>();

    @Override
    public T pop() throws EmptyStackException {
        if (list.isEmpty()) {
            throw new EmptyStackException();
        }
        int index = list.size() - 1;
        T topElement = list.get(index);
        list.remove(index);
        return topElement;
    }

    @Override
    public void push(T value) {
        list.add(value);
    }

    @Override
    public int size() {
        return list.size();
    }
}
