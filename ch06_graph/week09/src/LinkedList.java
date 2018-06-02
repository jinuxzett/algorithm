/*
* 인접 리스트 노드 만들기
*
* 리스트노드 추가까지 했음 2018.06.01
*
* */



public class LinkedList {
    ListNode head;
    ListNode tail;
    int size;

    //generator
    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;

    }

    //methods

    public void addListNode(Object location, Object longitude, Object latitude) {
        ListNode node = new ListNode(location, longitude, latitude);
        node.info();

        //리스트 비어있음
        if(head == null && size == 0){
            head = node;
            tail = node;
            size++;
        }
        //리스트에 있는 경우 뒤에 추가
        else {
            tail.next = node;
            tail = node;
            size++;
        }
    }


    // find ListNode in List
    public ListNode findListNode (Object location) {
        ListNode p = this.head;

        if(p == null){
            System.out.println("List가 비어있음.");
            return null;
        }

        while(p != null){
            if(p.location.equals(location)) {
                System.out.println("ListNode 노드 찾기 완료.");
                p.info();
                return p;
            }
            p = p.next;
        }
        System.out.println("ListNode 노드 없음.");
        return null;
    }

    public void print_ListNode() {
        ListNode p = this.head;

        while(p!=null) {
            System.out.println(p.location);
            System.out.println(p.longitude);
            System.out.println(p.latitude);
            System.out.println();
            p = p.next;
        }
    }

    public void print_all() {
        ListNode p = this.head;

        while(p!=null) {
            System.out.println(p.location);
            System.out.println(p.longitude);
            System.out.println(p.latitude);
            System.out.println();

            Node t = p.head;

            System.out.println("연결된 지점들 ");

            while(t != null){
                System.out.println(t.location);
                t = t.next;
            }
            System.out.println();

            p = p.next;
        }
    }

}
