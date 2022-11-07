package NumberExpression;

public class NumberExpression {
    public String operator = "";
    public Object leftNumber = null;
    public Object rightNumber = null;

    public NumberExpression(String operator, Object leftNumber, Object rightNumber){
        this.operator = operator;
        this.leftNumber = leftNumber;
        this.rightNumber = rightNumber;
    }
}
