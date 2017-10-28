package info.songbo;

/**
 * Created by Administrator on 2017/10/28.
 */

/**
 * Created by ttc on 2017/6/30.
 */
//某一个员工，某天的的考勤情况
public class KaoqinRecord {
    private String empName;//考勤员工姓名
    private String timeStart;//签到时间
    private String timeEnd;//签退时间

    public String getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public String getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }


}
