public class TwoStrings{
    public static void main(String[] args) {
        
    }
    public static String twoStrings(String s1, String s2) {

        int n = s1.length();
        int m = s2.length();

        int[] freq = new int[26];

        for(int i=0;i<n;i++){
            freq[s1.charAt(i)-'a']++;
        }

        for(int i=0;i<m;i++){
            if(freq[s2.charAt(i)-'a']>0){
                return "YES";
            }
        }

        return "NO";

    }
}