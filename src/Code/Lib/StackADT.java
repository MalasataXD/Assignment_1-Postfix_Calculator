package Code.Lib;

public interface StackADT<T>
{
    // # Test for an empty stack
    boolean isEmpty();
    // # Insepct the top element
    <T> T peek();
    // # Retrieve the top element
    <T> T pop();
    // # Put a new element on the stack
    void push(T element);


}
