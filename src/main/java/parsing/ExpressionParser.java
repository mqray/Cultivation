package parsing;

import engine.Node;

/**
 * @Author mqray
 * @Date 2021/11/22
 */
public interface ExpressionParser {

    /**
     *
     * @param expression
     * @return
     */
    Node parse(String expression);
}
