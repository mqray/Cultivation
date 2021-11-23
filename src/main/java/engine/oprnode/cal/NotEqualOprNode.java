package engine.oprnode.cal;

import constants.OprConstants;
import engine.Node;

/**
 * @Author mqray
 * @Date 2021/11/22
 */
public class NotEqualOprNode extends CalOprNode{

    public NotEqualOprNode(Node left, Node right) {
        super(left, right);
    }

    @Override
    public String getName() {
        return OprConstants.CAL_OPR_NOT_EQUAL;
    }

    @Override
    protected boolean compare(Object left, Object right) {
        if(left == right){
            return false;
        }
        if(left == null || right == null){
            return true;
        }
        return !left.equals(right);
    }
}
