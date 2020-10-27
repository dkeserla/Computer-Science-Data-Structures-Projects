
public class Node<T>
{
    private Node<T> previous;
    private T data;
    private Node<T> next;

    public Node(T data)
    {
        this.previous = null;
        this.data = data;
        this.next = null;
    }
    
    public Node(Node<T> previous, T data)
    {
        this.previous = previous;
        this.data = data;
        this.next = next;
    }
    
    public Node(Node<T> previous, T data, Node<T> next)
    {
        this.previous = previous;
        this.data = data;
        this.next = next;
    }
    
    public void setPrevious(Node<T> previous){
        this.previous = previous;
    }
    
    public void setData(T data){
        this.data = data;
    }
    
    public void setNext(Node<T> next){
        this.next = next;
    }
    
    public Node<T> getPrevious(){
        return this.previous;
    }

    public T getData(){
        return this.data;
    }
    
    public Node<T> getNext(){
        return this.next;
    }
    
    public String toString(){
        return this.data.toString();
    }
}
