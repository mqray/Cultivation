package engine.oprnode.cal;

import engine.Context;
import engine.Node;
import engine.oprnode.Operator;

import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author: mqray
 * Date: 2021/11/21
 */
public class RegOprNode implements Operator {

    private static final String REG_FLAG = "REG";

    private final Pattern pattern;

    private final Node node;

    public RegOprNode(Pattern pattern, Node node) {
        this.node = node;
        this.pattern = pattern;
    }

    @Override
    public List<Node> getChildren() {
        return Collections.singletonList(node);
    }

    @Override
    public Object eval(Context context) {
        return null;
    }

    @Override
    public String getName() {
        return REG_FLAG;
    }
}
