package parsing;

import com.google.common.collect.Lists;
import constants.EntitiyConstant;
import engine.ConstantNode;
import engine.Node;
import engine.VariableNode;
import engine.oprnode.cal.BiggerOprNode;
import engine.oprnode.cal.EqualOprNode;
import engine.oprnode.logic.AndOprNode;
import engine.oprnode.logic.OrOprNode;

/**
 * @Author mqray
 * @Date 2021/11/22
 */
public class DefaultExprParser implements ExpressionParser{

    @Override
    public Node parse(String expression) {
        return generateDefaultExpr();
    }

    private Node generateDefaultExpr(){
        return new AndOprNode(
                Lists.newArrayList(
                        new EqualOprNode(new VariableNode(EntitiyConstant.SRC_IP), new ConstantNode("10.111.11.11")),
                        new EqualOprNode(new VariableNode(EntitiyConstant.DST_IP), new ConstantNode("10.111.193.11")),
                        new EqualOprNode(new VariableNode(EntitiyConstant.SESSION_STATE), new ConstantNode(4)),
                        new OrOprNode(
                                Lists.newArrayList(
                                        new BiggerOprNode( new VariableNode(EntitiyConstant.DOWN_APP_LENGTH), new ConstantNode(100)),
                                        new BiggerOprNode( new VariableNode(EntitiyConstant.DOWN_APKTS), new ConstantNode(100))
                                )
                        )
                )
        );
    }
}
