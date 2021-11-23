package engine.oprnode.logic;

import com.google.common.collect.ImmutableList;
import constants.OprConstants;
import engine.Context;
import engine.Node;
import engine.oprnode.Operator;

import java.util.List;

/**
 * @Author mqray
 * @Date 2021/11/21
 */
public class NotOprNode implements Operator {

    private final Node node;

    public NotOprNode(Node node) {
        this.node = node;
    }

    @Override
    public List<Node> getChildren() {
        return ImmutableList.of(node);
    }

    @Override
    public Object eval(Context context) {
        return (Boolean) node.eval(context);
    }

    @Override
    public String getName() {
        return OprConstants.LOGIC_OPR_NOT;
    }
}
