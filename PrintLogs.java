import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintLogs {
    public static void main(String[] args) {
        List<List<String>> list = new ArrayList<>();

        list.add(Arrays.asList("01-01-2003","14:00","ERROR","failed"));
        list.add(Arrays.asList("01-01-2003","15:00","INFO","established"));
        list.add(Arrays.asList("01-01-2003","01:30","ERROR","failed"));
        // list.add(Arrays.asList("05-08-2003","12:00","SUCCESS","established"));
        // list.add(Arrays.asList("03-07-2003","16:00","SUCCESS","established"));
        // list.add(Arrays.asList("04-12-2022","18:00","SUCCESS","established"));
        getLogs(list);
    }
    public static List<List<String>> getLogs(List<List<String>> list){

        List<List<String>> ans = new ArrayList<>();

        list.sort((one, two) -> {

            // String date1 = one.get(0);
            // String date2 = two.get(0);

            // int year1 = ;

            // int day1 = 10*(date1.charAt(0)-'0') + (date1.charAt(1)-'0');
            // int day2 = 10*(date2.charAt(0)-'0') + (date2.charAt(1)-'0');



            String time1 = one.get(1);
            String time2 = two.get(1);

            int hour1 = 10*(time1.charAt(0)-'0') + (time1.charAt(1)-'0');
            int hour2 = 10*(time2.charAt(0)-'0') + (time2.charAt(1)-'0');
            if(hour1!=hour2){
                return Integer.compare(hour1, hour2);
            }
            else{
                int min1 = 10*(time1.charAt(3)-'0') + (time1.charAt(4)-'0');
                int min2 = 10*(time2.charAt(3)-'0') + (time2.charAt(4)-'0');
                return Integer.compare(min1, min2);
            }
        });

        for(List<String> i:list){
            String status = i.get(2);
            if(status.equals("ERROR") || status.equals("CRITICAL")){
                System.out.println(i);
                ans.add(i);
            }
        }
        System.out.println("Code completed");
        return ans;
    }
}
