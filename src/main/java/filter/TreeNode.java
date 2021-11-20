package filter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ray
 * Date 2021/11/20
 */
@Data
@AllArgsConstructor
public class TreeNode<T> {
    private TreeNode<T> left;
    private TreeNode<T> right;
    private T val;
}