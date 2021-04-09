import java.sql.Date;

public class IdleService {

    private final int MAX_SERVICE_NAME = 30;
    private final int MAX_COMMENT = 300;

    private String serviceName;
    private Date downFrom;
    private Date downTill;
    private Date curDate;
    private String comment;

    public IdleService(String s, Date f, Date t, Date c, String comm){
        if(s.length() > MAX_SERVICE_NAME){
            // ....
        }
        if(s.length() > MAX_COMMENT){
            // ....
        }
        serviceName = s;
        downFrom = f;
        downTill = t;
        curDate = c;
        comment = comm;
    }

    public String toString(){
        String str = "\n";
        str += "Service name is: " + serviceName + "\n";
        str += "Down from: " + downFrom.toString() + "\n";
        str += "Down till: " + downTill.toString() + "\n";
        str += "update date: " + curDate.toString() + "\n";

        return str;
    }
}
