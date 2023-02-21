package Code.Lib;

public class ADSLinkedList<T> implements ADSListADT<T> {

    private Node<T> first;
    private int size;

    public ADSLinkedList()
    {
        first = null;
        size = 0;
    }

    @Override
    public void add(T elm)
    {
        // NOTE: IF element is null --> DO nothing
        if (elm == null)
        {
            return; // ! DO NOTHING!
        }

        // # Check if the is anything in the list yet.
        if(elm == null){
            return;
        }
        Node<T> newNode = new Node(elm, null);
        if(size == 0){
            first = newNode;
        }
        else // # Else search for the last node, and extend the chain.
        {
            Node<T> cur = first;
            while(cur.getNext() != null)
            {
                cur = cur.getNext();
            }
            cur.setNext(newNode);
        }
        size++;
    }

    @Override
    public void insert(int index, T elm)
    {
        // NOTE: If index is smaller than 0 --> Do nothing.
        if(index < 0)
        {
            return; // ! DO NOTHING
        }

        // NOTE: If index is larger than the size of the list --> Add it as the last element.
        if(index > size)
        {
            add(elm);
            return;
        }


        Node<T> newNode = new Node(elm, null);

        // # Check if index is 0, and replace the first node in the list.
        if(index == 0)
        {
            newNode.setNext(first);
            first = newNode;
        }
        else // # Find the index, and put the node at index.
        {
            Node<T> cur = first;
            int i = 0;
            while(i < index - 1)
            {
                cur = cur.getNext();
                i++;
            }
            newNode.setNext(cur.getNext());
            cur.setNext(newNode);
        }
        size++;
    }

    @Override
    public boolean remove(T elm)
    {
        // NOTE: Variables used to store information temporarily
        Node<T> current = first;
        Node<T> prev = null;

        // # Check if it is the first node
        if(elm.equals(current.getElm()) && current.getElm() != null)
        {
            first = current.getNext();
            size--;
            return true;
        }
        else // # Else find the node in the list and remove it.
        {
            for (int i = 0; i < size(); i++)
            {

                if(elm.equals(current.getElm()))
                {
                    prev.setNext(current.getNext());
                    first = prev;
                    size--;
                    return true;
                }
                prev = current;
                current = current.getNext();
            }
        }
        // ! If it isn't in the list --> Return false.
        return false;
    }

    @Override
    public int indexOf(T elm)
    {
        Node<T> cur = first;
        for (int i = 0; i < size(); i++)
        {
            if (cur.getElm().equals(elm))
            {
                return i; // NOTE: IF IT MATCHES, RETURNS I value (Pos in the list)
            }
            cur = cur.getNext();
        }
        return -1;
    }

    @Override
    public int size()
    {
        return size;
    }

    @Override
    public boolean contains(T elm)
    {
        Node<T> cur = first;

        for (int i = 0; i < size(); i++)
        {
            if(cur.getElm().equals(elm))
            {
                return true; // NOTE: IF IT MATCHES, RETURN TRUE
            }
            cur = cur.getNext();
        }
        return false;
    }

    @Override
    public T remove(int index)
    {
        // ¤ REMOVE THE ELEMENT AT INDEX -> RETURN THE ELEMENT & DELETE IT FROM THE LIST
        // # MOVE ALL ELEMENTS TO THE LEFT FROM THE RIGHT
        Node<T> cur = first;
        Node<T> prev = null;

        // # Check if index is 0?
        if(index == 0)
        {
            T element = first.getElm();
            if(first.getNext() != null)
            {

                first = first.getNext();
            }

            size--;
            return element;
        }
        else
        {
            for (int i = 0; i < index; i++)
            {
                prev = cur;
                cur = cur.getNext();
            }
        }

        if(cur.getNext() != null)
        {
            prev.setNext(cur.getNext());
            size--;
        }
        return cur.getElm();
    }

    @Override
    public T set(int index, T elm)
    {
        if(first == null)
        {
            return null;
        }
        // ¤ SET THE ELEMENT AT INDEX -> RETURN THE OLD ELEMENT AT INDEX
        Node<T> cur = first;
        for (int i = 0; i < index; i++)
        {
            cur = cur.getNext();
        }

        // NOTE: MAKE CHANGES
        T old = cur.getElm();
        cur.setElm(elm);
        return old;
    }
}
