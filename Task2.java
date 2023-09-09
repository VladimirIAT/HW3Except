import java.io.File;
import java.io.FileWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Objects;
import java.util.Scanner;

public class Task2 {
    final static String DATE_FORMAT = "dd.mm.yyyy";
    public static void main(String[] args) throws Exception
    {
        boolean flag = true;
        //final String path = "C:/Users/Vladimir/Desktop/GeekBrains/Исключения/Lesson3/HW3Except/Data.txt";
        
        while (flag == true) {
            System.out.println("Введите данные разделенные пробелом <Фамилия Имя Отчество датаРождения номерТелефона пол>: ");
            System.out.println("дата рождения в формате dd.mm.yyyy; пол в формате f/m");         
            Scanner console = new Scanner(System.in);
            String a = console.nextLine();
            System.out.println(a);
            String[] peopleData = a.split(" ");   

            if (peopleData.length == 6) {
            try
                {
                    if (isDateValid(peopleData[3]) == true) {
                        boolean b = Objects.equals("f", new String(peopleData[5]));
                        boolean c = Objects.equals("m", new String(peopleData[5]));                    
                        if (b == true || c == true) {
                            try {
                                File output = new File(peopleData[0] + ".txt"); 
                                FileWriter pr = new FileWriter(output, true);   

                                for (int i=0; i<peopleData.length ; i++)
                                {
                                    pr.write(peopleData[i] + " ");
                                }
                                pr.write('\n');
                                pr.close();
                                flag = false; 
                            } catch (Exception e) {
                                e.printStackTrace();
                            }                        
                        } else {
                            System.out.println("Формат пола неверный, повторите ввод данных с правильным форматом пола f или m");                        
                        }

                    } else {
                        System.out.println("Формат даты неверный, повторите ввод данных с правильным форматом даты dd.mm.yyyy");
                    };

                }
                catch (Exception e)
                {
                    e.printStackTrace();
                    System.out.println("No such file exists.");
                }
                  
            } else {
                System.out.println("Вы ввели больше или меньше данных чем требуется");
            }           
        } 
    }

    public static boolean isDateValid(String date)
    {
        boolean flag2 = false;
        try {
            DateFormat df = new SimpleDateFormat(DATE_FORMAT);
            df.setLenient(false);
            df.parse(date);
            return flag2 = true;
        } catch (ParseException e) {

            return flag2 = false;
        }
    }
}
