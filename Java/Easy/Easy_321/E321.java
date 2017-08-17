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
        try
        {
            File file = new File("Java/Easy/Easy_321/input.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String readLine = "";
            List<String> times = new ArrayList<String>();
            
            System.out.println("Reading file ...");
            while((readLine = br.readLine()) != null)
            {
                times.add(readLine);
            }
            
            String[] spoken_times = new String[times.size()];
            int loop = times.size();
            for(int i = 0; i<loop; i++)
            {
                List<String> full_time = Arrays.asList(times.get(i).split(":")); //should contain hour in (0) and minutes in (1)
                String hour = full_time.get(0);
                String minutes = full_time.get(1);
                
                switch(hour)
                {
                    case "00":
                    case "12":
                    {
                        full_time.add(0, "It's twelve ");
                        break;
                    }
                    case "01":
                    case "13":
                    {
                        full_time.add(0, "It's one ");
                        break;
                    }
                    case "02":
                    case "14":
                    {
                        full_time.add(0, "It's two ");
                        break;
                    }
                    case "03":
                    case "15":
                    {
                        full_time.add(0, "It's three ");
                        break;
                    }
                    case "04":
                    case "16":
                    {
                        full_time.add(0, "It's four ");
                        break;
                    }
                    case "05":
                    case "17":
                    {
                        full_time.add(0, "It's five ");
                        break;
                    }
                    case "06":
                    case "18":
                    {
                        full_time.add(0, "It's six ");
                        break;
                    }
                    case "07":
                    case "19":
                    {
                        full_time.add(0, "It's seven ");
                        break;
                    }
                    case "08":
                    case "20":
                    {
                        full_time.add(0, "It's eight ");
                        break;
                    }
                    case "09":
                    case "21":
                    {
                        full_time.add(0, "It's nine ");
                        break;
                    }
                    case "10":
                    case "22":
                    {
                        full_time.add(0, "It's ten ");
                        break;
                    }
                    case "11":
                    case "23":
                    {
                        full_time.add(0, "It's eleven ");
                        break;
                    }
                }
                
                
            }
        } 
        
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
