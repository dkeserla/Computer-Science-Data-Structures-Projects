public class TreeNode
{
    private Comparable value;
    private TreeNode left;
    private TreeNode right;
    
    public TreeNode()
    {
        value = null;
        left = null;
        right = null;
    }
    
    public TreeNode(Comparable value)
    {
        this.value = value;
        this.left = null;
        this.right = null;
    }
    
    public TreeNode(Comparable value, TreeNode left, TreeNode right)
    {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public Comparable getValue(){
        return value;
    }
    
    public TreeNode getLeft(){
        return left;
    }
    
    public TreeNode getRight(){
        return right;
    }
    
    public void setValue(Comparable value){
        this.value = value;
    }
    
    public void setLeft(TreeNode left){
        this.left = left;
    }
    
    public void setRight(TreeNode right){
        this.right = right;
    }
    
    public String toString(){
        return value.toString();
    }
}