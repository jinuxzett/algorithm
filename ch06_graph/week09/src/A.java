import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
* 데이터 파일 읽어와서 지명, 경도, 위도 저장하는 것 까지 함. 2018.05.31
*
* */


public class A {

    public static void main(String[] args) throws IOException {

        String[] array;
        int index = 0;
        String line;
        Object loc_name = new Object();  //
        Object loc_long = new Object();  //위도
        Object loc_lati = new Object();  //경도
        LinkedList list = new LinkedList();  //blank 인접리스트 만들기
        Object from = new Object(); // 가중치 파일 from
        Object to = new Object(); // 가중치 파일 to

        //alabama.txt 읽어오기
        BufferedReader br = new BufferedReader(new FileReader("alabama.txt"));
        while((line=br.readLine()) != null) {

            array = null;

            array = line.split("\t");
            loc_name = array[0];
            loc_long = array[1];
            loc_lati = array[2];

            list.addListNode(loc_name, loc_long, loc_lati);
//            System.out.println(loc_name);
//            System.out.println(loc_long);
//            System.out.println(loc_lati);
//
//            System.out.println(list.head.location);
//            System.out.println(list.head.longitude);
//            System.out.println(list.head.latitude);

            System.out.println(line);


        }
        br.close();

        list.print_ListNode();


       // roadList2.txt 읽어오기
        BufferedReader br1 = new BufferedReader(new FileReader("roadList2.txt"));

        System.out.println("파일 정상 읽기 완료.");

        while((line = br1.readLine()) != null) {
            array = null;

            array = line.split("\t");
            from = array[0];
            to = array[1];

            System.out.println("from : " + from);
            System.out.println("to   : " + to);
            System.out.println();

            ListNode add_from = list.findListNode(from);
            if(add_from != null){
                System.out.println();
                add_from.info();
            }
            ListNode add_to = list.findListNode(to);
            if(add_to != null){
                System.out.println();
                add_to.info();
            }

            if(add_from != null && add_to != null) {
                Node node_add_to = new Node(add_to.location, add_to.longitude, add_to.latitude);
                add_from.addNode(node_add_to);

                Node node_add_from = new Node(add_from.location, add_from.longitude, add_from.latitude);
                add_to.addNode(node_add_from);
            }
        }
        br1.close();


        Node p = list.head.head;

        while(p != null){
            System.out.println(p.location);
            p = p.next;
        }

        list.print_all();

    }

    // 매개변수는 첫번째 지점의 위도(lat1), 경도(lon1), 두번째 지점의 위도(lat2), 경도(lon2) 순서이다.
    public double calDistance(double lat1, double lon1, double lat2, double lon2) {
        double theta, dist;
        theta = lon1 - lon2;
        dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2))
                + Math.cos(deg2rad(lat1))
                * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));

        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;
        dist = dist * 1.609344;    // 단위 mile 에서 km 변환.
        dist = dist * 1000.0;      // 단위 km 에서 m 로 변환.
        return dist;
    }


    // 주어진 도(degree) 값을 라디언으로 변환
    private double deg2rad(double deg) {
        return (double)(deg * Math.PI / (double)180);
    }

    // 주어진 라디언(radian) 값을 도(degree) 값으로 변환
    private double rad2deg(double rad) {
        return (double)(rad * (double)180 / Math.PI);
    }

}
