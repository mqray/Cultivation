package engine.oprnode.logic;

import constants.OprConstants;
import engine.Context;
import engine.Node;
import engine.oprnode.Operator;

import java.util.List;

/**
 * @author: mqray
 * Date: 2021/11/21
 */
public class AndOprNode implements Operator {

    private final List<Node> children;

    public AndOprNode(List<Node> children) {
        this.children = children;
    }

    @Override
    public List<Node> getChildren() {
        return children;
    }

    @Override
    public Object eval(Context context) {
        for(Node child : children){
            Boolean calResult = (Boolean) child.eval(context);
            if (!calResult){
                return false;
            }
        }
        return true;
    }

    @Override
    public String getName() {
        return OprConstants.LOGIC_OPR_AND;
    }
}
