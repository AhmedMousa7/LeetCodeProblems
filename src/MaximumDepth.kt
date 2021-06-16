import kotlin.math.max

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}


fun main(){
    val ti = TreeNode(3)
    val left = TreeNode(20)
    val left1 = TreeNode(20)
    val left2 = TreeNode(20)
    left2.left = TreeNode(15)
    left1.left = left2
    left.left = left1
    ti.left = left

    val right = TreeNode(20)
    right.left = TreeNode(15)
    right.right = TreeNode(7)

    ti.right = right
    println(maxDepth(ti))
}

fun maxDepth(root: TreeNode?): Int {
    return depth(root)
}

private fun depth(root: TreeNode?, count: Int = 0) : Int {
    return if (root == null) {
        count
    } else{
        max(depth(root.left,count + 1), depth(root.right,count + 1));
    }
}
