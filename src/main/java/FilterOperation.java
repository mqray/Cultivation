import org.apache.commons.lang3.StringUtils;

public class FilterOperation {

    static {

    }

    public boolean getOprResult(Object source, CustomOperator operator, Object target) {
        if (operator.equals(CustomOperator.OPERATOR_EQUAL)) {
            //xxx
            // 写这种操作的逻辑
            // operate(left,right) 还要判断是什么类型才能继续操作
            if (source instanceof String && target instanceof String) {
                return FilterEquals(String.valueOf(source), String.valueOf(target));
            } else if (source instanceof Integer && target instanceof Integer) {
                return FilterEquals((Integer) source, (Integer) target);
            }
        } else if (operator.equals(CustomOperator.OPERATOR_NOT_EQUAL)) {
            if (source instanceof String && target instanceof String) {
                return FilterNotEquals(String.valueOf(source), String.valueOf(target));
            } else if (source instanceof Integer && target instanceof Integer) {
                return FilterNotEquals((Integer) source, (Integer) target);
            }
        } else if (operator.equals(CustomOperator.OPERATOR_GREATER_THAN)) {
            return FilterGreaterThan((Integer) source, (Integer) target);
        } else if (operator.equals(CustomOperator.OPERATOR_LESS_THAN)) {
            return FilterLessThan((Integer) source, (Integer) target);
        } else if (operator.equals(CustomOperator.OPERATOR_LOGICAL_AND)) {
            if (source instanceof Boolean && target instanceof Boolean) {
                return FilterAnd((Boolean) source, (Boolean) target);
            }
        }
        return true;
    }

    public boolean FilterEquals(String source, String target) {
        // 可能是 String、integer、 实体类的比较
        return StringUtils.equals(source, target);
    }

    public boolean FilterEquals(Integer source, Integer target) {
        // 可能是 String、integer、 实体类的比较
        return source.equals(target);
    }

    public boolean FilterNotEquals(String source, String target) {
        return !FilterEquals(source, target);
    }

    public boolean FilterNotEquals(int source, int target) {
        return !FilterEquals(source, target);
    }

    public boolean FilterLessThan(int source, int target) {
        return source > target;
    }

    public boolean FilterGreaterThan(int source, int target) {
        return source < target;
    }

    public boolean FilterAnd(boolean source, boolean target) {
        return source && target;
    }

    public boolean FilterOr(boolean source, boolean target) {
        return source || target;
    }

    public boolean FilterNot(boolean source, boolean target) {
        return source && target;
    }


}
