import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

class TreeNodeX {
	int val;
	List<TreeNodeX> children;

	TreeNodeX(int x) {
		val = x;
		children = new ArrayList<TreeNodeX>();
	}
}

public class LevelTraverse {
	public List<List<Integer>> levelTraverse(TreeNodeX root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();

		if (root == null)
			return result;
		result.add(list);
		Queue<TreeNodeX> que = new LinkedList<TreeNodeX>();
		que.add(root);
		int length = 1;
		int level = 0;
		int l = 0;
		while (!que.isEmpty()) {
			TreeNodeX temp = que.poll();
			if (result.get(level).size() < length) {
				result.get(level).add(temp.val);
				if (!temp.children.isEmpty()) {
					for (TreeNodeX treeNodeX : temp.children) {
						que.add(treeNodeX);
						l++;
					}

				}
			} else {
				List<Integer> tempList = new ArrayList();
				tempList.add(temp.val);
				result.add(tempList);
				length = l;
				l = 0;
				level++;
				if (!temp.children.isEmpty()) {
					for (TreeNodeX treeNodeX : temp.children) {
						que.add(treeNodeX);
						l++;
					}

				}
			}

		}
		return result;

	}

	public static void main(String args[]) {
		LevelTraverse lt = new LevelTraverse();
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		TreeNodeX root = new TreeNodeX(0);
		TreeNodeX t1 = new TreeNodeX(1);
		TreeNodeX t2 = new TreeNodeX(2);
		TreeNodeX t3 = new TreeNodeX(3);
		TreeNodeX t4 = new TreeNodeX(4);
		TreeNodeX t5 = new TreeNodeX(5);
		TreeNodeX t6 = new TreeNodeX(6);
		TreeNodeX t7 = new TreeNodeX(7);
		root.children.add(t1);
		root.children.add(t2);
		root.children.add(t3);
		t2.children.add(t4);
		t2.children.add(t5);
		t3.children.add(t7);
		t4.children.add(t6);
		list = lt.levelTraverse(root);
		System.out.println(list);
	}

}
