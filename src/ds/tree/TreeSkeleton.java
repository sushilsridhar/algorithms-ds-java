package ds.tree;

/*
    Traversal rule:
    - Visit left sub tree, before right sub tree

    1. root -> left -> right , called pre order traversal  (root first)
    2. left -> root -> right , called in order traversal   (root middle)
    3. left -> right -> root , called post order traversal (root last)
 */
public class TreeSkeleton {

    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);

        TreeNode leftLeaf = new TreeNode(4);

        left.left = leftLeaf;

        root.left = left;
        root.right = right;

        /*
            pseudocode

            pre order traversal:

            void preorder(root) {
                if(root == null) {
                   return;
                }

                print(root.data);
                preorder(root.left);
                preorder(root.right);
            }

            in order traversal:

            void inorder(root) {
                if(root == null) {
                    return;
                }

                inorder(root.left);
                print(root.data);
                inorder(root.right);
            }

            post order traversal:

            void postorder(root) {
                if(root == null) {
                    return;
                }

                postorder(root.left);
                postorder(root.right);
                print(root.data);
            }

         */
    }
}
