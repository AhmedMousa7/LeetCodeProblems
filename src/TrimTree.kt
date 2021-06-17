/**
 * https://leetcode.com/problems/trim-a-binary-search-tree/
 *
 * Runtime: 184 ms, faster than 100.00% of Kotlin online submissions for Trim a Binary Search Tree.
  Memory Usage: 36.5 MB, less than 100.00% of Kotlin online submissions for Trim a Binary Search Tree.
 */
fun main(){
    val ti = TreeNode(2)
    ti.left = TreeNode(1)
    ti.right = TreeNode(3)

    println(trimBST(ti, 3, 4)?.`val`)
}

fun trimBST(root: TreeNode?, low: Int, high: Int): TreeNode? {
    return trim(root, low, high)
}

private fun trim(root: TreeNode?, low: Int, high: Int): TreeNode? {
    if (root != null){
        if (root.`val` in low..high) {
            root.left = trim(root.left, low, high)
            root.right = trim(root.right, low, high)
        } else {
            return trim(root.left, low, high) ?: trim(root.right, low, high)
        }
    }

    return root
}