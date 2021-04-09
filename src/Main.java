import java.sql.*;
import java.util.Scanner;

public class Main {


    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        MySqlConnect mysqlConnect = new MySqlConnect();
        IdleService idleService;

        /**
         * read input from user
         */
        String serviceName = enterServiceName(scan);
        System.out.println("Please enter Down From Date");
        Date downFromDate = enterDate(scan);
        System.out.println("Please enter Down Till Date");
        Date downTillDate = enterDate(scan);
        System.out.println("Please enter Down Current Date");
        Date curDate = enterDate(scan);
        String comment = enterComment(scan);

        idleService = new IdleService(serviceName, downFromDate, downTillDate, curDate, comment);

        System.out.println(idleService.toString());

        /*
        mysqlConnect.connect();


        try {





        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            mysqlConnect.disconnect();
        }
*/

    }

    public static String enterServiceName(Scanner s){
        String serviceName;
        while (true){
            System.out.print("Please enter service name: ");
            serviceName = s.nextLine();
            if(serviceName.length() > 300 || serviceName.length() == 0){
                if(serviceName.length() > 300 )
                    System.out.println("service name is too long");
                else
                    System.out.println("service name is too short");
                System.out.println("please enter valid one");
                continue;
            }
            break;
        }
        return serviceName;
    }

    public static String enterComment(Scanner s){
        String comment;
        while (true){
            System.out.print("Please enter comment: ");
            comment = s.nextLine();
            if(comment.length() > 300 || comment.length() == 0){
                if(comment.length() > 300 )
                    System.out.println("comment is too long");
                else
                    System.out.println("comment is too short");
                System.out.println("please enter valid one");
                continue;
            }
        break;
        }
        return comment;
    }

    public static java.sql.Date enterDate(Scanner s){
        java.sql.Date date;
        String year;
        String month;
        String day;
        boolean validYearValue = true;

        while(true){
            System.out.print("Year: ");
            year = s.nextLine();
            if (year.length() != 4){
                System.out.println("Please enter a valid year");

                continue;
            }
            for(int i = 0 ; i < 4 ; i++){
                if (year.charAt(i) < 48 || year.charAt(i) > 57){
                    System.out.println("Please enter a valid year");
                    validYearValue = false;
                    break;
                }
            }
            if (validYearValue == false)
                continue;

            break;
        }

        while(true){
            System.out.print("Month: ");
            month = s.nextLine();
            if (month.length() != 2){
                System.out.println("Please enter a valid month");
                continue;
            }
            if (Integer.parseInt(month) < 1 || Integer.parseInt(month) > 12){
                System.out.println("Please enter a valid month");
                continue;
            }

            break;
        }

        while(true){
            System.out.print("Day: ");
            day = s.nextLine();
            if (day.length() > 2 || day.length() < 1){
                System.out.println("Please enter a valid Day");
                continue;
            }
            if (Integer.parseInt(day) < 1 || Integer.parseInt(day) > 31){
                System.out.println("Please enter a valid Day");
                continue;
            }

            break;
        }



        date = new java.sql.Date(Integer.parseInt(year),(Integer.parseInt(month) - 1), Integer.parseInt(day));
        return date;
    }



}
