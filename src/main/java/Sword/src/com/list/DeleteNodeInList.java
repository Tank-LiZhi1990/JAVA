package Sword.src.com.list;

import com.node.ListNode;

public class DeleteNodeInList {

	public void deleteNodeInList(ListNode head, ListNode toBeDelete) {
		if (toBeDelete == null) {
			return;
		}

		if (toBeDelete.next != null) {
			toBeDelete.value = toBeDelete.next.value;
			toBeDelete.next = toBeDelete.next.next;
		} else if (toBeDelete == head) {
			head = null;
			toBeDelete = null;
		} else {
			ListNode pNode = head;
			while (pNode.next != toBeDelete) {
				pNode = pNode.next;
			}

			pNode.next = null;
			toBeDelete = null;
		}
	}
}
