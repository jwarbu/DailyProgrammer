import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jenniferwartick on 8/17/17.
 */
public class E321
{
    public static void main(String[] args) throws IOException
    {
        List<String> times = new ArrayList<>();
        times.add("00:00");
        times.add("01:30");
        times.add("12:05");
        times.add("14:01");
        times.add("20:29");
        times.add("21:00");
        
        int loop = times.size();
        for(int i = 0; i<loop; i++)
        {
            List<String> full_time = Arrays.asList(times.get(i).split(":")); //should contain hour in (0) and minutes in (1)
            String hour = full_time.get(0);
            String minutes = full_time.get(1);
            
        }
    }
}
