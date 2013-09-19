// 单链表写快排
	public ListNode quickSort(ListNode head) {
		ListNode dummy = head;
		if (head == null || head.next == null)
			return head;
		ListNode tail = head;
		while (tail.next != null)
			tail = tail.next;
		Solve_QuickSort(head, tail);
		return dummy;
	}

	private void Solve_QuickSort(ListNode head, ListNode tail) {
		// TODO Auto-generated method stub
		if (head != tail) {
			ListNode partition = getPartition(head, tail);
			Solve_QuickSort(head, partition);
			Solve_QuickSort(partition.next, tail);
		}
	}

	private ListNode getPartition(ListNode head, ListNode tail) {
		// TODO Auto-generated method stub
		int pivot = head.val;
		ListNode p = head;
		ListNode q = head.next;

		while (q != tail) {
			if (q.val < pivot) {
				p = p.next;
				swap(p, q);
			}

			q = q.next;
		}
		swap(p, head);
		return p;
	}

	private void swap(ListNode p, ListNode q) {
		// TODO Auto-generated method stub
		int valTemp = p.val;
		p.val = q.val;
		q.val = valTemp;
	}
