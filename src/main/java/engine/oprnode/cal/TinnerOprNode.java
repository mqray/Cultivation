package engine.oprnode.cal;

import constants.OprConstants;
import engine.Node;

/**
 * @Author mqray
 * @Date 2021/11/22
 */
public class TinnerOprNode extends CalOprNode{

    public TinnerOprNode(Node left, Node right) {
        super(left, right);
    }

    @Override
    public String getName() {
        return OprConstants.CAL_OPR_TINNER;
    }

    @Override
    protected boolean compare(Object left, Object right) {
        if (left == right){
            return false;
        }
        if (left == null || right == null){
            return false;
        }
        if (left instanceof Number && right instanceof Number){
            return ((Number) left).doubleValue() < ((Number) right).doubleValue();
        }
        if (left instanceof Comparable && right instanceof Comparable){
            return ((Comparable) left).compareTo(right)<0;
        }
        return false;
    }
}
