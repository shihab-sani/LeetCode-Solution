class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
 
class MergeKLists {

    public ListNode merge(ListNode list_1, ListNode list_2) {
        ListNode temp = new ListNode();
        ListNode result = temp;

        while (list_1 != null && list_2 != null) {
            if (list_1.val <= list_2.val) {
                result.next = list_1;
                list_1 = list_1.next;
            } else {
                result.next = list_2;
                list_2 = list_2.next;
            }
            result = result.next;
        }
        if (list_1 != null) {
            result.next = list_1;
        } else if (list_2 != null) {
            result.next = list_2;
        }
        return temp.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        ListNode list_1;
        ListNode list_2;

        while (lists.length > 1) {
            ListNode[] mergelist = new ListNode[(lists.length+1)/2];

            for (int i = 0; i < lists.length; i += 2) {
                list_1 = lists[i];
                if ((i + 1) < lists.length) {
                    list_2 = lists[i + 1];
                } else {
                    list_2 = null;
                }
                mergelist[i/2] = merge(list_1, list_2);
            }
            lists = mergelist;
        }
        return lists[0];
    }
}