package info.songbo;


import java.util.Calendar;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
//
//        20170630---zhangsan 9:00 18:00,lisi 9:00 18:00,wangwu 10:00 21:00
//        20170629---zhangsan 9:00 18:00,lisi 9:00 ,wangwu 10:00 21:00
//        Map<String,List<KaoqinRecord>>
//
//        map.put("20170630",[{name:hanwei,startTime:8:00,endTime:00},xiuwei])

        Company company = new Company();

        company.getLstEmps().add("马云");
        company.getLstEmps().add("李连杰");
        company.getLstEmps().add("赵本山");

        Scanner sc = new Scanner(System.in);
        int cmd = -1;
        Calendar calendar = Calendar.getInstance();
        String str = calendar.toString();
        do
        {
            System.out.println("员工考勤系统");
            System.out.println("0------exit");
            System.out.println("1------签到");
            System.out.println("2------签退");
            System.out.println("3------显示考勤信息");

            cmd = sc.nextInt();
            switch (cmd)
            {
                case 1: {
                    company.qiandao();
                    break;
                }
                case 2: {
                    company.qiantui();
                    break;
                }
                case 3: {
                    company.showKaoqinInfo();
                    break;
                }
                default:
                {
                    break;
                }
            }

        }while (cmd != 0);

        return;
    }
}
