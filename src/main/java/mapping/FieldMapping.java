package mapping;

import com.google.common.collect.Maps;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Map;

public class FieldMapping {

    private final Class clazz;
    private final Map<String, Field> columnFieldMap;

    public FieldMapping(Class clazz) {
        this.clazz = clazz;
        this.columnFieldMap = Maps.newHashMap();
        initFieldMap();
    }

    public Field getField(String columnName) {
        Field field = columnFieldMap.get(columnName);
        if (field == null) {
            throw new RuntimeException("Not found the mapping field of column '" + columnName + "' in class [" +
                    clazz.getName() + "]");
        }

        return field;
    }

    public Object getValue(Object instance, String columnName) {
        Field field = null;
        try {
            field = getField(columnName);
            field.setAccessible(true);

            return field.get(instance);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Get value failed: ", e);
        } finally {
            if (field != null) {
                field.setAccessible(false);
            }
        }
    }

    private void initFieldMap() {
        Field[] fields = clazz.getDeclaredFields();
        Arrays.stream(fields).filter(field -> field.getAnnotation(Column.class) != null).forEach(
                field -> columnFieldMap.put(field.getAnnotation(Column.class).value(), field)
        );
    }

}
