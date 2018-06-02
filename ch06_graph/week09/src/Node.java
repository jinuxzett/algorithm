public class Node {
    Object location;
    Object longitude;
    Object latitude;
    Node next;

    //generator
    public Node(Object location, Object longitude, Object latitude) {
        this.location = location;
        this.longitude = longitude;
        this.latitude = latitude;
        next = null;
    }


    //method

//    public void addNode(Node n) {
//        Node node = n;
//
//    }


}
