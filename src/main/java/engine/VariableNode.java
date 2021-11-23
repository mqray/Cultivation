package engine;

import java.util.Collections;
import java.util.List;

/**
 * @author: mqray
 * Date: 2021/11/21
 */
public class VariableNode implements Node {

    private final String fieldName;

    public VariableNode(String fieldName) {
        this.fieldName = fieldName;
    }

    @Override
    public List<Node> getChildren() {
        return Collections.emptyList();
    }

    @Override
    public Object eval(Context context) {
        return context.getValue(fieldName);
    }
}
