package Test;

import Code.Lib.LinkedListStack;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.*;

public class StackTest
{
    private LinkedListStack<String> stack;

     @Before
     public void setup()
     {
         stack = new LinkedListStack<>();
     }

     // # IsEmpty Tests
     @Test
    public void IsEmptyWithEmptyStack()
     {
         assertTrue(stack.isEmpty());
     }

    // # Push tests
    @Test
    public void PushNothingOnStack()
    {
        stack.push(null);
        assertTrue(stack.isEmpty());
    }
    @Test
    public void PushOneElementOnStack()
    {
        stack.push("A");
        assertFalse(stack.isEmpty());
    }

    @Test
    public void PushManyElementsOnStack()
    {
        stack.push("A");
        stack.push("B");
        stack.push("C");
        assertFalse(stack.isEmpty());
    }

    // # Pop tests
    @Test
    public void PopNothingfromStack()
    {
        assertNull(stack.pop());
    }

    @Test
    public void PopOnefromStack()
    {
        stack.push("A");
        assertEquals("A",stack.pop());
    }
    @Test
    public void PopManyfromStack()
    {
        stack.push("A");
        stack.push("B");
        stack.push("C");

        stack.pop();
        stack.pop();
        stack.pop();

        assert (stack.isEmpty());
    }

    // # Peek tests
    @Test
    public void PeekNothingOnStack()
    {
        assertNull(stack.peek());
    }

    @Test
    public void PeekOneOnStack()
    {
        stack.push("A");
        assertEquals("A",stack.pop());
    }

    @Test
    public void PeekOneOnModificedStack()
    {
        stack.push("A");
        stack.push("B");
        stack.pop();
        stack.push("C");
        stack.pop();
       assertEquals("A",stack.peek());
    }


}