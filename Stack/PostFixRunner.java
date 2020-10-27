public class PostFixRunner
{
    public static void main(String[] args){
        PostFix test = new PostFix("9 3 / 2 * 7 9 * + 4 -");
        System.out.println(test);
        
        test.setExpression("1 2 3 4 + + +");
        System.out.println(test);
        
        test.setExpression("9 3 * 8 / 4 +");
        System.out.println(test);
        
        test.setExpression("3 3 + 7 * 9 2 / +");
        System.out.println(test);
        
        test.setExpression("9 3 / 2 * 7 9 * + 4 -");
        System.out.println(test);
        
        test.setExpression("5 5 + 2 * 4 / 9 +");
        System.out.println(test);
    }
}
