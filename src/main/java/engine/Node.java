package engine;

import java.util.List;

/**
 * @author: mqray
 * Date: 2021/11/21
 */
public interface Node {

    /**
     *
     * @return
     */
    List<Node> getChildren();

    /**
     *
     * @param context
     * @return
     */
    Object eval(Context context);
}
