import mapping.FieldMapping;


public class EntityContext<T> implements Context {

    private T entityInstance;
    private FieldMapping fieldMapping;

    public EntityContext(T entityInstance, FieldMapping fieldMapping) {
        this.entityInstance = entityInstance;
        this.fieldMapping = fieldMapping;
    }

    @Override
    public Object getValue(String name) {
        return fieldMapping.getValue(entityInstance, name);
    }
}
