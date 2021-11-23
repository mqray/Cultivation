package engine.oprnode.logic;

import constants.OprConstants;
import engine.Context;
import engine.Node;
import engine.oprnode.Operator;

import java.util.Collections;
import java.util.List;

/**
 * @author: mqray
 * Date: 2021/11/21
 */
public class OrOprNode implements Operator {

    private final List<Node> children;

    public OrOprNode(List<Node> children) {
        this.children = children;
    }

    @Override
    public List<Node> getChildren() {
        return Collections.emptyList();
    }

    @Override
    public Object eval(Context context) {
        for(Node child: children){
            Boolean evalResult = (Boolean) child.eval(context);
            if(evalResult){
                return true;
            }
        }
        return false;
    }

    @Override
    public String getName() {
        return OprConstants.LOGIC_OPR_OR;
    }
}
