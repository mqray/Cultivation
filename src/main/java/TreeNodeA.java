import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TreeNodeA<T> implements Iterable<TreeNodeA<T>>{
    /**
     * 树节点
     */
    public T data;

    /**
     * 父节点，根没有父节点
     */
    public TreeNodeA<T> parent;

    /**
     * 子节点，叶子节点没有子节点
     */
    public List<TreeNodeA<T>> children;

    /**
     * 保存了当前节点及其所有子节点，方便查询
     */
    private List<TreeNodeA<T>> elementsIndex;

    public TreeNodeA(T data) {
        this.data = data;
        this.children = new LinkedList<TreeNodeA<T>>();
        this.elementsIndex = new LinkedList<TreeNodeA<T>>();
        this.elementsIndex.add(this);
    }
    /**
     * 判断是否为根：根没有父节点
     *
     * @return
     */
    public boolean isRoot() {
        return parent == null;
    }
    /**
     * 判断是否为叶子节点：子节点没有子节点
     *
     * @return
     */
    public boolean isLeaf() {
        return children.size() == 0;
    }

    /**
     * 添加一个子节点
     *
     * @param child
     * @return
     */
    public TreeNodeA<T> addChild(T child) {
        TreeNodeA<T> childNode = new TreeNodeA<T>(child);

        childNode.parent = this;

        this.children.add(childNode);

        this.registerChildForSearch(childNode);

        return childNode;
    }

    /**
     * 递归为当前节点以及当前节点的所有父节点增加新的节点
     *
     * @param node
     */
    private void registerChildForSearch(TreeNodeA<T> node) {
        elementsIndex.add(node);
        if (parent != null) {
            parent.registerChildForSearch(node);
        }
    }

    @Override
    public Iterator<TreeNodeA<T>> iterator() {
        TreeNodeIterator<T> iterator = new TreeNodeIterator<T>(this);
        return iterator;
    }
}
