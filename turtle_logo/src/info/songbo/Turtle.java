package info.songbo;

/**
 * Created by Administrator on 2017/10/21.
 */

public class Turtle
{
    private int x;//海龟在地图中的x坐标
    private int y;//海龟在地图中的y坐标
    private int direction;//海龟头朝向：0右，1下，2左，3上
    private boolean bIsPenUp;//海龟笔是否朝上，true朝上，false朝下

    public void turnRight()
    {
        direction++;
        if(direction == 4)
        {
            direction = 0;
        }
    }
    public void turnLeft()
    {
        direction--;
        if(direction == -1)
        {
            direction = 3;
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public boolean isbIsPenUp() {
        return bIsPenUp;
    }

    public void setbIsPenUp(boolean bIsPenUp) {
        this.bIsPenUp = bIsPenUp;
    }
}
