import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        Arrays.sort(timetable, (a,b) -> {
            return a.compareTo(b);
        });
        
        String time = "09:00";
        int idx = 0;
        int lastCnt = 0;
        for(int i=0;i<n;i++) {
            int cnt = 0;
            while(cnt < m && idx < timetable.length && timetable[idx].compareTo(time) <= 0) {
                cnt++;
                idx++;
            }
            if(i == n-1) { // 막차면 마지막 탑승 명수 기억
                lastCnt = cnt;
            }
            
            if(i < n-1) time = nxtTime(time, t);
            System.out.println(time);
        }
        
        if(lastCnt < m) {
            return time;
        }
        
        return prevTime(timetable[idx-1]);
    }
    
    String nxtTime(String now, int t) {
        String[] arr = now.split(":");
        int hour = Integer.parseInt(arr[0]);
        int min = Integer.parseInt(arr[1]) + t;
        
        int total = hour*60 + min;
        hour = total / 60;
        min = total % 60;
        
        return String.format("%02d:%02d", hour, min);
    }
    
    String prevTime(String time) {
        String[] arr = time.split(":");
        int hour = Integer.parseInt(arr[0]);
        int min = Integer.parseInt(arr[1])-1;
        
        int total = hour*60 + min;
        hour = total / 60;
        min = total % 60;
        
        return String.format("%02d:%02d", hour, min);
    }
}