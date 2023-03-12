import java.util.*;
import java.time.*;
import java.time.temporal.ChronoUnit;
class User
{
    LocalTime time;
    String name;
    static long h,m,s;
    User()
    {
        time = LocalTime.now();
    }
    public void check_in()
    {
        time = LocalTime.now();
    }
    public void sum(long phour,long pminute,long psecond)
    {
        h = h + phour;
        if(pminute+m>=60)
        {
            h++;
            m = m % 60;
        }
        if(psecond+s>=60)
        {
            m++;
            s = s % 60;
        }
    }
    public void check_out()
    {  
       long hp=h,mp=m,sp=s; 
       h = ChronoUnit.HOURS.between(time,LocalTime.now());
       m = ChronoUnit.MINUTES.between(time,LocalTime.now()) % 60;
       s = ChronoUnit.SECONDS.between(time, LocalTime.now()) % 60;
       sum(hp,mp,sp);
       System.out.println("Your total working hours is " + h + ":" + m + ":" + s);
    }
    public void show()
    {
        check_out();
    }
    public void break_in()
    {
        check_out();
    }

    public void break_out()
    {
        check_in();    
    }
}
public class Problem_3 {
    public static void main(String[] args) 
    {
        int i=0,id,choise=0;
        User users[]= new User[9]; 
        while(choise!=5)
        {
            Scanner sc = new Scanner(System.in);
            System.out.println("\n\n\n1:check in");
            System.out.println("2:Check out");    
            System.out.println("3:Break in");
            System.out.println("4:break out");
            System.out.println("5:show working hours:");
            System.out.println("6:close");
            System.out.println("Etry enter your input");
            //users[i] = new User();
            choise = sc.nextInt();
            //System.out.println("Enter your Empoyee id:");
            //id = sc.nextInt();
            //
            switch(choise)
            {
                case 1:
                    System.out.println("Enter your id");
                    id = sc.nextInt();
                    users[id] = new User();
                    break;
                case 2:
                    System.out.println("enter your id:");
                    id = sc.nextInt();
                    users[id].check_out();
                    break;
                case 3:
                    System.out.println("enter your id:");
                    id = sc.nextInt();
                    users[id].break_in();
                    break;
                case 4:
                    System.out.println("enter your id:");
                    id = sc.nextInt();
                    users[id].break_out();        
                    break;
                case 5:
                    System.out.println("enter your id:");
                    id = sc.nextInt();
                    users[id].show();
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Invalid input pleace enter again");
            }
        }
    }
}