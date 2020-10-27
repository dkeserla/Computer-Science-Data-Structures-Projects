public class TreeMethods
{ 
    public static String inOrder(TreeNode root){
        if(root == null)
            return "";
        return inOrder(root.getLeft()) + " " + root.getValue() + " " + inOrder(root.getRight());
    }
    
    public static String preOrder(TreeNode root){
        if(root == null)
            return "";
        return " " + root.getValue() + " " + preOrder(root.getLeft()) + preOrder(root.getRight());
    }
    
    public static String postOrder(TreeNode root){
        if(root == null)
            return "";
        return postOrder(root.getLeft()) + postOrder(root.getRight()) + " " + root.getValue() + " ";
    }
    
    public static String revOrder(TreeNode root){
        if(root == null)
            return "";
        return revOrder(root.getRight()) + " " + root.getValue() + " " + revOrder(root.getLeft());
    }
    
    public static int getHeight(TreeNode root){
        if(root == null)
            return 0;
        return getLevels(root) - 1;
    }
    
    public static int getWidth(TreeNode root){
        if(root == null)
            return 0; 
        return Math.max(getLevels(root.getLeft()) + getLevels(root.getRight()) + 1, Math.max(getWidth(root.getLeft()), getWidth(root.getRight())));
    }
    
    public static int getNumLeaves(TreeNode root){
        if(root == null)
            return 0;
        if(root.getLeft() == null && root.getRight() == null)
            return 1;
        return getNumLeaves(root.getLeft()) + getNumLeaves(root.getRight());
    }
    
    public static int getNumNodes(TreeNode root){
        if(root == null)
            return 0;
        return getNumNodes(root.getLeft()) + getNumNodes(root.getRight()) + 1;
    }
    
    public static int getLevels(TreeNode root){
        if(root == null)
            return 0;
        return Math.max(getLevels(root.getLeft()), getLevels(root.getRight())) + 1;
    }
    
    public static String toString(TreeNode root){
        return inOrder(root);
    }
    
    public static boolean isFull(TreeNode root){
        if(root == null)
            return true;
        if(root.getLeft() == null && root.getRight() != null || root.getLeft() != null && root.getRight() == null)
            return false;
        return isFull(root.getLeft()) && isFull(root.getRight());
    }
        
    public static TreeNode search(TreeNode root, Comparable data){
        if(root == null)
           return null;
        if(root.getValue().equals(data))
           return root;
        if(data.compareTo(root.getValue()) < 0 )
           return search(root.getLeft(), data);
        else
           return search(root.getRight(), data);
    }
    
    public static void add(TreeNode root, Comparable data){
        if(root == null)
            return;
        if(search(root, data) != null)
            return;
        if(root.getValue().compareTo(data) > 0)
            if(root.getLeft() == null)
                root.setLeft(new TreeNode(data,null,null));
            else 
                add(root.getLeft(), data);
        else
            if(root.getRight() == null)
                root.setRight(new TreeNode(data,null,null));
            else
                add(root.getRight(), data);
    }
    
    public static TreeNode buildTree(Comparable[] datas){
        if(datas.length == 0)
            return null;
        TreeNode root = new TreeNode(datas[0]);
        for(int i = 1; i < datas.length; i++)
            add(root, datas[i]);
        return root;
    }
    
    public static TreeNode getMin(TreeNode root){
        if(root == null)
            return null;
        if(root.getLeft() == null)
            return root;
        return getMin(root.getLeft());
    }
    
    public static TreeNode getMax(TreeNode root){
        if(root == null)
            return null;
        if(root.getRight() == null)
            return root;
        return getMax(root.getRight());
    }
    
    public static void delete(TreeNode root, Comparable data){
        if(root == null)
            return;
        TreeNode delete = search(root, data);
        if(delete == null)
            return;
        TreeNode newSpot = getMin(delete.getRight());
        if(newSpot != null){
            
        }
        else{
            newSpot = getMax(delete.getLeft());
        }
    }
}
