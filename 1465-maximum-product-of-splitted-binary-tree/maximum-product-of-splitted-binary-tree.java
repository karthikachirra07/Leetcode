class Solution {
    private long totalSum = 0;
    private long maxProduct = 0;
    private static final int MOD = 1_000_000_007;

    public int maxProduct(TreeNode root) {
        // Step 1: compute total sum of tree
        totalSum = dfsTotal(root);

        // Step 2: compute max product
        dfsProduct(root);

        return (int)(maxProduct % MOD);
    }

    // DFS to compute total sum
    private long dfsTotal(TreeNode node) {
        if (node == null) return 0;
        return node.val + dfsTotal(node.left) + dfsTotal(node.right);
    }

    // DFS to compute subtree sums and products
    private long dfsProduct(TreeNode node) {
        if (node == null) return 0;

        long leftSum = dfsProduct(node.left);
        long rightSum = dfsProduct(node.right);

        long subSum = node.val + leftSum + rightSum;

        long product = subSum * (totalSum - subSum);
        maxProduct = Math.max(maxProduct, product);

        return subSum;
    }
}
