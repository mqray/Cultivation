package operators.Impl;

import operators.IOperate;

/**
 * @author ray
 * Date 2021/11/20
 */
public class EqualOperateImpl<T> implements IOperate<T> {

    @Override
    public Boolean operate(T source, T target) {
        return source==target;
    }


}
