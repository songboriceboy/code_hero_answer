package info.songbo;

/**
 * Created by Administrator on 2017/10/28.
 */


import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by ttc on 2017/6/30.
 */
public class Company {
    //员工集合
    private List<String> lstEmps = new ArrayList<String>();
    //key是签到日期，值是当天考勤的考勤记录列表
    private Map<String,List<KaoqinRecord>> map = new HashMap<>();

    public void qiandao()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要签到的员工姓名");
        String strName = sc.nextLine();
        if(!lstEmps.contains(strName))
        {
            System.out.println("不存在该员工");
            return;
        }

        Date date = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat sdfTime = new SimpleDateFormat("hh:mm:ss");
        String strDate = sdf.format(date);
        String strTime = sdfTime.format(date);
        if(!map.containsKey(strDate))//第一个签到的员工
        {
            List<KaoqinRecord> lst = new ArrayList<>();

            KaoqinRecord kq = new KaoqinRecord();
            kq.setEmpName(strName);
            kq.setTimeStart(strTime);
            kq.setTimeEnd("");
            lst.add(kq);

            map.put(strDate,lst);
            System.out.println(strName+"签到成功");
        }
        else//说明之前，今天已经有人签过到了
        {
            List<KaoqinRecord> lst = map.get(strDate);

            //判断是否已经签到过
            boolean bIsFind = false;//假设没找到，没签到过
            for(KaoqinRecord qr : lst)
            {
                if(qr.getEmpName().equals(strName))
                {
                    System.out.println("已经签过到了");
                    bIsFind = true;
                    break;
                }
            }
            if(!bIsFind)
            {
                KaoqinRecord kq = new KaoqinRecord();
                kq.setEmpName(strName);
                kq.setTimeStart(strTime);
                kq.setTimeEnd("");
                lst.add(kq);
                System.out.println(strName+"签到成功");
            }

        }


    }
    public void qiantui()
    {
        System.out.println("请输入要签退的员工姓名");
        Scanner sc = new Scanner(System.in);
        String strName = sc.nextLine();
        if(!lstEmps.contains(strName))
        {
            System.out.println("不存在该员工");
            return;
        }
        Date date = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat sdfTime = new SimpleDateFormat("hh:mm:ss");
        String strDate = sdf.format(date);
        String strTime = sdfTime.format(date);

        if(!map.containsKey(strDate))//今天一个人也没签到
        {
            System.out.println("你没有签到，不能签退");
        }
        else
        {
            List<KaoqinRecord> lst = map.get(strDate);
            boolean bIsFind = false;//假设没找到
            for(KaoqinRecord kr : lst)
            {
                if(kr.getEmpName().equals(strName))
                {
                    kr.setTimeEnd(strTime);
                    bIsFind = true;
                    break;
                }
            }

            if(!bIsFind)//真的没找到，也即意味着没签到
            {
                System.out.println("你没有签到，不能签退");
            }
            else
            {
                System.out.println(strName+"签退成功");
            }
        }
    }
    public void showKaoqinInfo()
    {
        System.out.println("请输入要查找的日期（yyyyMMdd）");
        Scanner sc = new Scanner(System.in);
        String strDate = sc.nextLine();
        List<KaoqinRecord> lst = map.get(strDate);
        for(KaoqinRecord kr : lst)
        {
            System.out.println(kr.getEmpName() + "签到时间为" + kr.getTimeStart()
                    + "签退时间为" + kr.getTimeEnd());
        }
    }

    public List<String> getLstEmps() {
        return lstEmps;
    }

    public void setLstEmps(List<String> lstEmps) {
        this.lstEmps = lstEmps;
    }

    public Map<String, List<KaoqinRecord>> getMap() {
        return map;
    }

    public void setMap(Map<String, List<KaoqinRecord>> map) {
        this.map = map;
    }
}
