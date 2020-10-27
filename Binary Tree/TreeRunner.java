public class TreeRunner
{
    public static void main(String[] args){
        // TreeNode left = new TreeNode(new Integer(80), new TreeNode(new Integer(70)), new TreeNode(new Integer(85)));
        // TreeNode right = new TreeNode(new Integer(100), new TreeNode(new Integer(98)), new TreeNode(new Integer(120)));
        // TreeNode root = new TreeNode(new Integer(90),left,right);
        
        TreeNode root = TreeMethods.buildTree(new Integer[]{1, 7, 4, 23, 8, 9, 4, 3, 5, 7, 9, 67, 6345, 324});
        
        System.out.println(" Min " + TreeMethods.getMin(root));
        System.out.println(" Max " + TreeMethods.getMax(root));
        System.out.println();
        System.out.println(" IN ORDER\n" + TreeMethods.inOrder(root));
        System.out.println(" PRE ORDER\n" + TreeMethods.preOrder(root));
        System.out.println(" POST ORDER\n" + TreeMethods.postOrder(root));
        System.out.println(" REV ORDER\n" + TreeMethods.revOrder(root));
        System.out.println(" \n\n Tree Height is " + TreeMethods.getHeight(root));
        System.out.println(" Tree Width is " + TreeMethods.getWidth(root));
        System.out.println(" Number of Leaves is " + TreeMethods.getNumLeaves(root));
        System.out.println(" Number of Nodes is " + TreeMethods.getNumNodes(root));
        System.out.println(" Number of Levels is " + TreeMethods.getLevels(root));
        System.out.println(" Tree as a String " + TreeMethods.toString(root));
        System.out.println( TreeMethods.isFull(root) ? " The tree is full" : " the tree is not full");
    }
}