import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class E321
{
    public static void main(String[] args) throws IOException
    {
        List<String> input_times = new ArrayList<>();
        input_times.add("00:00");
        input_times.add("01:30");
        input_times.add("12:05");
        input_times.add("14:01");
        input_times.add("20:29");
        input_times.add("21:00");
        int input_size = input_times.size();

        String[] count = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        String[] tens = {"_zero", "_one", "twenty", "thirty", "forty", "fifty"};

        List<String> alpha_times = new ArrayList<>(input_size);
        for(int i = 0; i<input_size; i++)
        {
            //Creates a list in which (0)=hours and (1)=minutes
            List<String> full_time;
            full_time = Arrays.asList(input_times.get(i).split(":"));
            int hour = Integer.parseInt(full_time.get(0));
            int ten_min = Character.getNumericValue(full_time.get(1).charAt(0));
            int one_min = Character.getNumericValue((full_time.get(1).charAt(1)));

            String alpha_string = "It's";
            String hour_str = "";
            String ten_min_str = "";
            String one_min_str = "";
            String end_string = "";
            if(hour>11)
            {
                end_string = "pm";
            }
            else
            {
                end_string = "am";
            }

            //Set hour
            if(hour>12)
            {
                hour = hour - 12;
            }
            if(hour==0)
            {
                hour = 12;
            }
            hour_str = count[hour];

            //Set minutes' ones place
            if(one_min == 0 && ten_min == 0)
            {
                ten_min_str = "";
                one_min_str = "";
            }
            else if(ten_min == 1)
            {
                ten_min_str = count[one_min+10];
                one_min_str = "";
            }
            else
            {
                if(ten_min == 0)
                {
                    ten_min_str = "oh";
                }
                else
                {
                    ten_min_str = tens[ten_min];
                }
                one_min_str = count[one_min];
            }

            alpha_times.add(i, "It's " + hour_str + " " + ten_min_str + " " + one_min_str + " " + end_string);
        }

        //Print final 'spoken' times
        int print_loop = alpha_times.size();
        for(int i = 0; i<print_loop; i++)
        {
            System.out.println(alpha_times.get(i));
        }
    }
}
