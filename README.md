# CreateLevelLinkedListOfBTree
Given a binary tree, create an ArrayList which contains LinkedLists of TreeNodes at each level

BFS: Level Order
ArrayList<LinkedList<TreeNode>> al, LinkedList<TreeNode> ll, add ll1, ll2, ll3 for each level
al.add(ll), we don't need ll anymore, then We could pass level information, switch names in while loop, instead of created ll1,ll2,ll3. Only one ll is enough

DFS:
Pass level information at function calls
createLevelLL(TreeNode t){al; createLevelLL(t,0,al)}
createLevelLL(TreeNode t, int level, ArrayList<> al){ createLevelLL(t.left,level+1,al);createLevelLL(t.right,level+1,al);}

Both of methods run in O(n) Time and O(n) Space





