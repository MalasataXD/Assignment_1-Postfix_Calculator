package Code.Lib;

public class LinkedListStack<T> implements StackADT<T>
{
    // # Fields
    private ADSLinkedList<T> linkedList;

    // ¤ Constructor
    public LinkedListStack()
    {
        linkedList = new ADSLinkedList<>();
    }
    @Override
    public boolean isEmpty()
    {
        // NOTE: Check if there is any elements in the list.
        return linkedList.size() <= 0;
    }
    @Override
    public void push(T element)
    {
        // ! Check if element is null...
        if(element == null)
        {
            return;
        }

        // NOTE: Insert the element as the first node in the list.
        linkedList.insert(0, element);
    }
    @Override
    public T pop()
    {
        if(linkedList.size() == 0)
        {
            return null;
        }

        // NOTE: Remove the first element in the list.
        T element = linkedList.remove(0);
        return element;
    }
    @Override
    public T peek()
    {
        if(linkedList.size() == 0)
        {
            return null;
        }

        // NOTE: Take out the first element, and put it back...
        T element = linkedList.remove(0);
        linkedList.insert(0,element);
        return element;
    }
}
