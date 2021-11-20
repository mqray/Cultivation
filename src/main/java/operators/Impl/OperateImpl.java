package operators.Impl;

import org.apache.commons.lang3.StringUtils;

/**
 * @author ray
 * Date 2021/11/20
 */
public class OperateImpl {

    private Boolean equalString(String source, String target){
        return StringUtils.equals(source, target);
    }
    private Boolean equalInteger(Integer source, Integer target){
        return source.equals(target);
    }
}
