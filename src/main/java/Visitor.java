import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.Calendar;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Visitor
{

    private static final Logger logger = LogManager.getLogger(Visitor.class.getName());

    private static String fullname,comments,assistance;
    private static int age;


//  public Visitor(String fullname,int Age,String comments,String assistance)
//  {
//      this.fullname = fullname;
//      this.comments = comments;
//      this.assistance = assistance;
//      this.age = Age;
//  }


    public static void saveFile(String fullname,int Age,String comments,String assistance) throws IOException
    {
         Calendar calobj = Calendar.getInstance();

        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();

        File myFile = new File("visitor_{"+fullname.toLowerCase()+"}.txt");
        FileWriter myWriter = new FileWriter(myFile);



            myWriter.write("full-name: "+fullname+"\n" +
                    "age :"+Age+"\n " +
                    "date of Visit: "+ date+"\n " +
                    "Time of visit: " + time+
                    "\n  Comments:"+comments+
                    "\n Assistance :"+assistance);

            myWriter.close();

            if(myFile.createNewFile())
            {
                logger.debug("File created"+myFile.getName());
            }
           else
           {
               logger.error("File already exist");
           }


    }

    public static void loadFile()
    {

    }


    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);






        try
        {
            System.out.println("Enter the your fullname ");
            String name =scan.nextLine();

            System.out.println("Enter the your age ");
            int age =scan.nextInt();

            System.out.println("Enter the your Assistance ");
            String assistance =scan.next();

            System.out.println("Enter the your comments ");
            String comments =scan.next();


                saveFile(name,age,comments,assistance);
            logger.info("File created");

        }catch (Exception e)
        {
            logger.error("Error!"+e.getMessage());
        }
    }
}
