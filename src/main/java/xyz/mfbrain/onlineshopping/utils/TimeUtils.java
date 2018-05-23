package xyz.mfbrain.onlineshopping.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtils {
    private static TimeUtils timeutils=new TimeUtils();

    private String timeStamptoString1(Timestamp t){
        String timeString="";
        timeString=t.toString();
        return timeString;
    }


    private Timestamp stringtoTimestamp1(int year,int month,int day,int h,int m,int s,int ss){
        String timeString="";
        Timestamp timestamp=null;
        if(checkTimeRange(year, month, day, h, m, s)){
            timeString=String.valueOf(year)+"-"+String.valueOf(month)+"-"+String.valueOf(day)+" "+String.valueOf(h)+":"+String.valueOf(m)
                    +":"+String.valueOf(s)+"."+String.valueOf(ss);
            timestamp=Timestamp.valueOf(timeString);

        }
        return timestamp;
    }

    private String datetoString1(Date d){
        String str="";
        DateFormat dateformat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.sss");
        str=dateformat.format(d);
        return str;
    }

    private Date stringtoDate1(int year, int month, int day, int h, int m, int s){
        String timeString="";
        Date date=new Date();
        if(checkTimeRange(year, month, day, h, m, s)){
            timeString=String.valueOf(year)+"-"+String.valueOf(month)+"-"+String.valueOf(day)+" "+String.valueOf(h)+":"+String.valueOf(m)
                    +":"+String.valueOf(s);
            DateFormat dateformat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                date=dateformat.parse(timeString);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        return date;
    }

    private boolean checkTimeRange(int year, int month, int day, int h, int m, int s){
        boolean yearOk=false;
        boolean monthOk=false;
        boolean dayOK=false;
        boolean hOK=false;
        boolean mOK=false;
        boolean sOK=false;
        boolean isleap=false;

        if(year>1800){
            yearOk=true;
        }

        if(year%4==0&&year%100!=0){
            isleap=true;
        }else if(year%400==0){
            isleap=true;
        }

        if(month>=1&&month<=12){
            monthOk=true;
        }

        if(isleap&&month==2){
            if(day>0&&day<30){
                dayOK=true;
            }
        }else if(month==1||month==3||month==5||month==7||month==8||month==10||month==12){
            if(day>0&&day<32){
                dayOK=true;
            }
        }else{
            if(day>0&&day<31){
                dayOK=true;
            }
        }

        if(h>=0&&h<=24){
            hOK=true;
        }

        if(m>=0&&m<=60){
            mOK=true;
        }

        if(s>=0&&s<=60){
            sOK=true;
        }


        if(yearOk&&monthOk&&dayOK&&hOK&&mOK&&sOK){
            return true;
        }else{
            System.out.println("输入时间范围有误");
            return false;
        }

    }


    public static TimeUtils getTimeutils(){
        return timeutils;
    }

    public String timeStamptoString(Timestamp t){
        return getTimeutils().timeStamptoString1(t);
    }

    public Timestamp setTimestamp(int year, int month, int day, int h, int m, int s, int ss){
        return getTimeutils().stringtoTimestamp1(year, month, day, h, m, s, ss);
    }

    public String datetoString(Date d){
        return getTimeutils().datetoString1(d);
    }

    public Date setDate(int year, int month, int day, int h, int m, int s){
        return getTimeutils().stringtoDate1(year, month, day, h, m, s);
    }

}
