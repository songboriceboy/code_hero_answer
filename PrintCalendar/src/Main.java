import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by Administrator on 2017/10/29.
 */
public class Main {
    public static void main(String ... args) throws ParseException {
        String date_str = "2017-10-29";
        getMyCalendar(date_str);
    }

    private static void getMyCalendar(String date_str) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = sdf.parse(date_str);
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(date);
            //获取给定的时间是几号
            int day = calendar.get(Calendar.DATE);
            //将日期改为该月1号
            calendar.set(Calendar.DATE, 1);
            //获取该月1号是本周第几天
            int firstDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
            //获取该月的最后一天是几号
            int lastDay = calendar.getActualMaximum(Calendar.DATE);
            //每个月多需要6行7列即可显示完整
            int [] days = new int[6*7];
            //为数组填充值
            for(int i=1 ; i <= lastDay ; i++){
                days[i+(firstDayOfWeek-1)-1] = i;
            }
            //打印日历
            System.out.println("日\t一\t二\t三\t四\t五\t六");
            for(int i = 0 ; i < days.length ; i++){
                if(days[i]!=0){
                    if(days[i]==day){
                        System.out.print("*");
                    }
                    System.out.print(days[i]);
                }
                System.out.print("\t");
                if((i+1)%7==0){
                    System.out.println("");
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
