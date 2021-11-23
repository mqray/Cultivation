package mapping;

import com.google.common.collect.Maps;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Map;

public class EntityMapping {

    private static volatile EntityMapping instance;
    private Map<Class, FieldMapping> entityMap;

    private EntityMapping() {
        entityMap = Maps.newConcurrentMap();
    }

    public static EntityMapping getInstance() {
        if (instance == null) {
            synchronized (EntityMapping.class) {
                if (instance == null) {
                    instance = new EntityMapping();
                }
            }
        }

        return instance;
    }

    public <T> T fromMap(Map<String, Object> valueMap, Class<T> clazz) {
        try {
            FieldMapping fieldMapping = getFieldMapping(clazz);

            Constructor noParamConstructor = clazz.getConstructor();
            T instance = (T) noParamConstructor.newInstance();

            valueMap.forEach((k, v) -> {
                Field field = null;
                try {
                    field = fieldMapping.getField(k);
                    field.setAccessible(true);
                    Object value = convertValue(v, field.getType());
                    if (value != null) {
                        field.set(instance, value);
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException("Set value failed: ", e);
                } finally {
                    if (field != null) {
                        field.setAccessible(false);
                    }
                }
            });

            return instance;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public FieldMapping getFieldMapping(Class clazz) {
        FieldMapping fieldMapping = entityMap.getOrDefault(clazz, new FieldMapping(clazz));
        entityMap.putIfAbsent(clazz, fieldMapping);
        return fieldMapping;
    }

    private <T> T convertValue(Object value, Class<T> type) {
        if (value == null) {
            return null;
        }

        if (value.getClass().equals(type)) {
            return (T) value;
        }

        Object convertedValue;
        switch (type.getName()) {
            case "java.lang.Integer":
                convertedValue = Integer.valueOf(value.toString());
                break;
            case "java.lang.Long":
                convertedValue = Long.valueOf(value.toString());
                break;
            case "java.lang.Short":
                convertedValue = Short.valueOf(value.toString());
                break;
            case "java.lang.Float":
                convertedValue = Float.valueOf(value.toString());
                break;
            case "java.lang.Double":
                convertedValue = Double.valueOf(value.toString());
                break;
            case "java.lang.Boolean":
                convertedValue = Boolean.valueOf(value.toString());
                break;
            case "java.lang.String":
                convertedValue = value.toString();
                break;
            default:
                throw new RuntimeException("Unsupported type: " + type.getName());
        }

        return (T) convertedValue;
    }
}
