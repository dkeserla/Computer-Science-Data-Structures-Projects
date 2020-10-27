
public class CustomList<T>
{
    private Node<T> head;
    
    public CustomList()
    {
        this.head = null;
    }
    
    public CustomList(T data)
    {
        this.head = new Node<T>(null,data);
    }
    
    public void add(T data){
        if(head != null){
            Node<T> before = get(size()-1);
            before.setNext(new Node<T>(before,data));
        }
        else
            head = new Node<T>(head,data,null);
    }
    
    public void add(int index, T data){
        if(index < size()-1)
            if(index == 0)
                head = new Node<T>(null,data,head);
            else if (index == size()-1)
                get(index).setNext(new Node<T>(data));
            else{
                Node<T> before = get(index-1);
                before.setNext(new Node<T>(before,data,before.getNext()));
            }
    }
    
    public Node<T> get(int index){
        if(index > size()-1)
            return null;
        Node<T> out = head;
        for(int i = 0; i < index; i++)
            out = out.getNext();
        return out;
    }
    
    public Node<T> remove(int index){
        Node<T> get = get(index);
        if(index > size()-1)
            return null;
        else
            if(index == 0)
                head = head.getNext();
            else if (index == size()-1)
                get(index-1).setNext(null);
            else{
                Node<T> rem = get(index-1);
                Node<T> newNext = rem.getNext().getNext();
                rem.setNext(newNext);
                newNext.setPrevious(rem);
            }
        return get;
    }
    
    public Node<T> set(int index, T data){
        if(index < size()-1){
            Node<T> curr = get(index);
            Node<T> backUp = new Node<T>(curr.getPrevious(), curr.getData(), curr.getNext());
            curr.setData(data);
            return backUp;
        }
        return null;
    }
    
    public int size(){
        int counter = 0;
        if(head != null){
            counter++;
            for(Node<T> current = head; current.getNext() != null;counter++)
                current = current.getNext();
        }
        return counter;
    }
    
    public String toString(){
        String out = "[";
        Node<T> current;
        for(current = head; current.getNext() != null; current = current.getNext())
            out += current + ", ";
        out += current + "]";
        return out;
    }
    
    public String revToString(){
        String out = "[";
        Node current;
        for(current = get(size()-1); current.getPrevious() != null; current = current.getPrevious())
            out += current + ", ";
        out += current + "]";
        return out;
    }
    
    
}
