import java.text.DecimalFormat;
import java.util.Scanner;

class ExpressionTreeNode {
    public static enum WordType {
        NUMBER, OPERATION
    };
    public ExpressionTreeNode(WordType _wordType, double _value) {
        this.wordType = _wordType;
        this.value = _value;
        this.left = null;
        this.right = null;
    }
    WordType wordType;
    double value;
    ExpressionTreeNode left;
    ExpressionTreeNode right;
}

class ExpressionTree {
    private static final Scanner in = new Scanner(System.in);
    private static final DecimalFormat df = new DecimalFormat("#0.######");



    public static void main(String[] args) {
        ExpressionTreeNode tree = createPrefix();
        printInfix(tree);
        System.out.printf("Result: %s\n", df.format( eval(tree) ) );
    }

    public static ExpressionTreeNode createPrefix() {
        if( in.hasNextDouble() ) {
            return new ExpressionTreeNode(ExpressionTreeNode.WordType.NUMBER, in.nextDouble());
        } else {
            ExpressionTreeNode ret = new ExpressionTreeNode(ExpressionTreeNode.WordType.OPERATION, in.next().charAt(0));
            ret.left = createPrefix();
            ret.right = createPrefix();
            return ret;
        }
    }

    private static String printInfixHelper(ExpressionTreeNode node) {
        switch(node.wordType) {
            case NUMBER:
                return String.format("%s", df.format(node.value) );
            case OPERATION:
                if( (int)node.value == '+' || (int)node.value == '-' ) {
                    return String.format("(%s %c %s)", 
                        printInfixHelper(node.left),
                        (int) node.value,
                        printInfixHelper(node.right)
                    );
                } else {
                    return String.format("%s %c %s", 
                        printInfixHelper(node.left),
                        (int) node.value,
                        printInfixHelper(node.right)
                    );
                }
            default:
                return "Error";
        }
    }

    public static void printInfix(ExpressionTreeNode node) {
        System.out.println(printInfixHelper(node));
        
    }

    public static Double eval(ExpressionTreeNode node) {
        switch(node.wordType) {
            case NUMBER:
                return node.value;
            case OPERATION:
                if( (int)node.value == '+' ) {
                    return eval(node.left) + eval(node.right);
                } else if( (int)node.value == '-' ) {
                    return eval(node.left) - eval(node.right);
                } else if( (int)node.value == '*' ) {
                    return eval(node.left) * eval(node.right);
                } else if( (int)node.value == '/' ) {
                    return eval(node.left) / eval(node.right);
                }
            default:
                return 0.0;
        }
    }
}