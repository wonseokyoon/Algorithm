import java.util.Arrays;
import java.util.PriorityQueue;
class Solution {


        public int solution(String[][] book_time) {
        int maxRoom = 1;
        convert(book_time);
        PriorityQueue<String[]> rooms = new PriorityQueue<>((a,b) -> a[1].compareTo(b[1]));

        rooms.add(book_time[0]);

        for (int i = 1; i < book_time.length; i++) {
            String[] time = book_time[i];

            // 다음 사용자의 입실 시간
            String checkIn_time = time[0];

            if(!rooms.isEmpty() && Integer.parseInt(rooms.peek()[1]) <= Integer.parseInt(checkIn_time)){
                rooms.poll();
            }

            rooms.add(time);

            maxRoom = Math.max(maxRoom,rooms.size());
        }
        return maxRoom;
    }

    private void convert(String[][] bookTime) {

        for (int i = 0; i < bookTime.length; i++) {
            String checkIn_time = bookTime[i][0];
            String checkOut_time = bookTime[i][1];

            String[] params = checkIn_time.split(":");
            String[] params2 = checkOut_time.split(":");

            int checkInHour = Integer.parseInt(params[0]);
            int checkInMinute = Integer.parseInt(params[1]);

            int checkOutHour = Integer.parseInt(params2[0]);
            int checkOutMinute = Integer.parseInt(params2[1]);

            checkOutMinute += 10;
            if (checkOutMinute >= 60) {
                checkOutMinute -= 60;
                checkOutHour += 1;
            }

            bookTime[i][0] = String.format("%02d%02d", checkInHour, checkInMinute);
            bookTime[i][1] = String.format("%02d%02d", checkOutHour, checkOutMinute);
        }

        // 시작 시간을 기준으로 정렬
        Arrays.sort(bookTime, (a, b) -> a[0].compareTo(b[0]));
    }
}