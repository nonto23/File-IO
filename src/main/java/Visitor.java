
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import java.util.Scanner;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Visitor
{

    private static final Logger logger = LogManager.getLogger(Visitor.class.getName());



    public static String saveFile(String fullname,int Age,String date,String time,String comments,String assistance)
    {

        try
        {


            String full_Name = fullname.replace(" ", "_");      //replacing spaces with underscore
            File myFile = new File("visitor_{"+full_Name.toLowerCase()+"}.txt");
            FileWriter myWriter = new FileWriter(myFile);

            myWriter.write("full-name: "+full_Name+"\n" +
                    "age :"+Age+"\n " +
                    "date of Visit: "+ date+"\n " +
                    "Time of visit: " + time+
                    "\n  Comments:"+comments+
                    "\n Assistance :"+assistance);

            myWriter.close();
            logger.info("File successfully created");
        }catch (Exception e)
        {
            logger.error("Error"+e.getMessage());
        }


       return "File created";

    }

    public static void loadFile(String name )
    {
        try {

            File file = new File("visitor_" +name.toLowerCase().replace(" ", "_") + ".txt");
            Scanner readers = new Scanner(file);
            while (readers.hasNextLine()) {
                String read = readers.nextLine();
                logger.info(read);
            }
            readers.close();
        } catch (FileNotFoundException e) {
            logger.error("An error occurred.");
            e.printStackTrace();
        }

//
    }

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the your fullname ");
        String name =scan.nextLine();



            System.out.println("Enter the your age ");
            int age =scan.nextInt();

             System.out.println("Enter the currents date ");
             String date =scan.next();
             System.out.println("Enter the current time ");
             String Time =scan.next();
            System.out.println("Enter the your Assistance ");
            String assistance =scan.next();

            System.out.println("Enter the your comments ");
            String comments =scan.next();

            //calling save method
            saveFile(name,age,date,Time,comments,assistance);

            //calling load method
             loadFile(name);
    }


}
