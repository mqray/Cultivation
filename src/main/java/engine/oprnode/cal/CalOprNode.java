package engine.oprnode.cal;

import com.google.common.collect.ImmutableList;
import engine.Context;
import engine.Node;
import engine.oprnode.Operator;

import java.util.List;

/**
 * @Author mqray
 * @Date 2021/11/21
 */
public abstract class CalOprNode implements Operator {

    private final Node left;

    private final Node right;

    public CalOprNode(Node left, Node right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public List<Node> getChildren() {
        return ImmutableList.of(left, right);
    }

    @Override
    public Object eval(Context context) {
        Object leftResult = left.eval(context);
        Object rightResult = right.eval(context);
        return compare(leftResult, rightResult);
    }

    protected abstract boolean compare(Object left, Object right);

}
