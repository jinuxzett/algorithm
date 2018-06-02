/*
* 리스트에 추가 될 노드 만들기.
*
* */

public class ListNode {
    Object location;
    Object longitude;
    Object latitude;
    Node head;
    int count;   //노드 갯수
    ListNode next;

    //diverse generator
    public ListNode(){
        this.location = null;
        this.longitude = null;
        this.latitude = null;
        this.head = null;
        this.count = 0;
        this.next = null;
    }
    public ListNode(Object location) {
        this.location = location;
        this.longitude = null;
        this.latitude = null;
        this.count = 0;
        this.next = null;
    }
    public ListNode(Object location, Object longitude, Object latitude){
        this.location = location;
        this.longitude = longitude;
        this.latitude = latitude;
        this.count = 0;
        this.next = null;
    }

    //methods

    //ListNode에 연결된 Node 추가하기
    public void addNode(Node n) {
        Node node = n;
        //ListNode와 연결된 노드가 없는 경우
        if(this.head == null) {
            this.head = n;
            count++;
        }
        //연결된 노드가 있는 경우
        else {
            Node p = this.head;

            while(p.next != null){
                p = p.next;
            }
            p.next = n;
            count++;
        }
    }


    // check longitude
    public Object getLongitude() {
        return this.longitude;
    }

    // check latitude
    public Object getLatitude() {
        return this.latitude;
    }
    public void info() {
        System.out.println("location  : " + this.location);
        System.out.println("Longitude : " + this.longitude);
        System.out.println("Latitude  : " + this.latitude);
        System.out.println();
    }
}
