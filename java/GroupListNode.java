package google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import leetcode.ListNode;

public class GroupListNode {
	public List<List<ListNode>> groupList(Set<ListNode> set){
		List<List<ListNode>> result = new ArrayList<>();
		HashMap<ListNode, List<ListNode>> map = new HashMap<>();
		Set<ListNode> visited = new HashSet<>();
		for(ListNode node: set){
			if (visited.contains(node)) {
				continue;
			}
			if(node.next!=null && map.containsKey(node.next)){
				map.get(node.next).add(0,node);
				map.put(node, map.get(node.next));
				map.remove(node.next);
				continue;
			}
			if(!map.containsKey(node))
				map.put(node, new ArrayList<ListNode>());
			map.get(node).add(node);
			visited.add(node);
			ListNode n = node.next;
			while(n!=null && set.contains(n)){
				map.get(node).add(n);
				visited.add(n);
				n = n.next;
			}
		}
		for(ListNode key: map.keySet())
			result.add(map.get(key));
		return result;
	}
	public static void main(String args[]){
		GroupListNode gln = new GroupListNode();
		ListNode l0 = new ListNode(0);
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		ListNode l6 = new ListNode(6);
		ListNode l7 = new ListNode(7);
		ListNode l8 = new ListNode(8);
		ListNode l9 = new ListNode(9);
		Set<ListNode> set = new HashSet<ListNode>();
		l0.next = l1;
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;
		l6.next = l7;
		l7.next = l8;
		l8.next = l9;
		
		set.add(l2);
		set.add(l4);
		set.add(l3);
		set.add(l7);
		set.add(l8);

		List<List<ListNode>> result = gln.groupList(set);
		System.out.println(result);
		for(List<ListNode> list: result){
			for(ListNode node:list)
				System.out.print(node.val+"\t");
			System.out.println();
		}
	}
}

