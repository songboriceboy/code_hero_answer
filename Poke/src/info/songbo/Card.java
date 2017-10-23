package info.songbo;

/**
 * Created by Administrator on 2017/10/23.
 */
public class Card{
    private String     color;
    private Integer    value;
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public Integer getValue() {
        return value;
    }
    public void setValue(Integer value) {
        this.value = value;
    }

    public String toString()
    {
        String strValue = "";
        switch(value)
        {
            case 1:
            {
                strValue = "A";
                break;
            }
            case 11:
            {
                strValue = "J";
                break;
            }
            case 12:
            {
                strValue = "Q";
                break;
            }
            case 13:
            {
                strValue = "K";
                break;
            }
            default:
                strValue = value.toString();
                break;
        }
        return color+strValue;
    }
}
