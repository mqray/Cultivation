package engine;

import java.util.Collections;
import java.util.List;

/**
 * @author: mqray
 * Date: 2021/11/21
 */
public class ConstantNode implements Node{

    private final Object value;

    public ConstantNode(Object value) {
        this.value = value;
    }


    @Override
    public List<Node> getChildren() {
        return Collections.emptyList();
    }

    @Override
    public Object eval(Context context) {
       return value;
    }
}
