import java.util.Iterator;

public class TreeNodeIterator<T> implements Iterator<TreeNodeA<T>> {


    enum ProcessStages {
        ProcessParent, ProcessChildCurNode, ProcessChildSubNode
    }

    private ProcessStages doNext;

    private TreeNodeA<T> next;

    private Iterator<TreeNodeA<T>> childrenCurNodeIter;

    private Iterator<TreeNodeA<T>> childrenSubNodeIter;

    private TreeNodeA<T> treeNodeA;

    public TreeNodeIterator(TreeNodeA<T> treeNodeA) {
        this.treeNodeA = treeNodeA;
        this.doNext = ProcessStages.ProcessParent;
        this.childrenCurNodeIter = treeNodeA.children.iterator();
    }

    @Override
    public boolean hasNext() {

        if (this.doNext == ProcessStages.ProcessParent) {
            this.next = this.treeNodeA;
            this.doNext = ProcessStages.ProcessChildCurNode;
            return true;
        }

        if (this.doNext == ProcessStages.ProcessChildCurNode) {
            if (childrenCurNodeIter.hasNext()) {
                TreeNodeA<T> childDirect = childrenCurNodeIter.next();
                childrenSubNodeIter = childDirect.iterator();
                this.doNext = ProcessStages.ProcessChildSubNode;
                return hasNext();
            } else {
                this.doNext = null;
                return false;
            }
        }

        if (this.doNext == ProcessStages.ProcessChildSubNode) {
            if (childrenSubNodeIter.hasNext()) {
                this.next = childrenSubNodeIter.next();
                return true;
            } else {
                this.next = null;
                this.doNext = ProcessStages.ProcessChildCurNode;
                return hasNext();
            }
        }

        return false;
    }

    @Override
    public TreeNodeA<T> next() {
        return this.next;
    }

}
