public class Q1 {

    public static void main(String[] args) {
        Node head = new Node(-1);
        Node p = head;
        for (int i = 0; i < 10; i++) {
            new Node((int) Math.random() * 10);

        }
    }


    static class Node {
        int v;
        Node next;
        public Node(int v) {
            this.v = v;
        }
    }

    Node delete(Node head, int k) {
        if (head == null) return null;
        Node p, q;
        p = head;
        q = head;
        int i = 0;
        while (i < k) {
            q = q.next;
            if (q == null) {
                return null;
            }
        }
        while (q != null) {
            p = p.next;
            q = q.next;
        }
        p.next = p.next.next;
        return head;
    }
}
