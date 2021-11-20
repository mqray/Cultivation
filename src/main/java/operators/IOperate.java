package operators;

/**
 * @author ray
 * Date 2021/11/20
 */
public interface IOperate<T> {

    /**
     * 操作
     * @param source
     * @param target
     * @return
     */
    Boolean operate(T source, T target);
}
