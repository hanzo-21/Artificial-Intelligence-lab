import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class cityReader {


    public static String[] readCity(){
        Scanner sc ;
        String file ="D:\\drive\\OneDrive - Everest Engineering College\\7th sem\\Artifical Intilience\\lab\\problem " +
                "solving and uniform search\\cityname.txt\\";
        String[] cityName = new String[20];
        try {
            sc = new Scanner(new File(file));
            sc.useDelimiter(",");
            for (int i = 0 ; sc.hasNext() ; i++){
                cityName[i] = sc.nextLine();
            }

        }
        catch (Exception e) {
            System.out.println(e);
        }
        return cityName;
    }
}
