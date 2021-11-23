package engine.oprnode.cal;

import constants.OprConstants;
import engine.Node;

/**
 * @Author mqray
 * @Date 2021/11/21
 */
public class EqualOprNode extends CalOprNode {

    public EqualOprNode(Node left, Node right) {
        super(left,right);
    }

    @Override
    protected boolean compare(Object left, Object right) {
        if (left == right){
            return true;
        }
        if (left == null || right == null){
            return false;
        }
        return left.equals(right);
    }

    @Override
    public String getName() {
        return OprConstants.CAL_OPR_EQUAL;
    }
}
