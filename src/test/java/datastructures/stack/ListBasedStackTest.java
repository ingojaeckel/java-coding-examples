package datastructures.stack;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ListBasedStackTest {
    private Stack<Integer> stack;

    @BeforeMethod
    public void setup() {
        this.stack = new ListBasedStack<>();
    }

    @Test(expectedExceptions = EmptyStackException.class)
    public void cannotPopFromEmptyStack() throws EmptyStackException {
        stack.pop();
    }

    @Test
    public void initialSize() {
        Assert.assertEquals(stack.size(), 0);
    }

    @Test
    public void pushPopSize() throws EmptyStackException {
        stack.push(1);
        stack.push(2);
        stack.push(3);

        Assert.assertEquals(stack.size(), 3);
        Assert.assertEquals(stack.pop().intValue(), 3);

        Assert.assertEquals(stack.size(), 2);
        Assert.assertEquals(stack.pop().intValue(), 2);

        Assert.assertEquals(stack.size(), 1);
        Assert.assertEquals(stack.pop().intValue(), 1);

        Assert.assertEquals(stack.size(), 0);
    }
}
