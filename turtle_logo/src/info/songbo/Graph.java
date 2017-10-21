package info.songbo;

/**
 * Created by Administrator on 2017/10/21.
 */
public class Graph
{
    private int[][] array = new int[50][50];//地图数组
    private Turtle turtle = new Turtle();
    private String[] commands = new String[]{"2","5,12","3","5,12","3","5,12","3","5,12","1" ,"6","9"};//海龟命令数组

    //解析海龟命令
    public void parseCmd()
    {
        for(int i = 0; i < commands.length; i++)
        {
            String[] strCmd = commands[i].split(",");//5号命令特殊
            switch (strCmd[0])
            {
                case "1":
                {
                    turtle.setbIsPenUp(true);
                    break;
                }
                case "2":
                {
                    turtle.setbIsPenUp(false);
                    break;
                }
                case "3":
                {
                    turtle.turnRight();
                    break;
                }
                case "4":
                {
                    turtle.turnLeft();
                    break;
                }
                case "5":
                {
                    int nStep = Integer.parseInt(strCmd[1]);
                    int xPos = turtle.getX();
                    int yPos = turtle.getY();
                    switch (turtle.getDirection())
                    {

                        case 0://向右走
                        {

                            for(int x = 0; x < nStep; x++)
                            {
                                if(xPos < 50)//限制海龟不要出右边界
                                {
                                    if(!turtle.isbIsPenUp())//如果笔朝下
                                    {
                                        array[yPos][xPos++] = 1;//海龟在地图中位置的值0变为1，同时海龟的x坐标加1，同时注意二维数组维度代入
                                    }

                                }
                                else//出界跳出循环
                                {
                                    break;
                                }
                            }
                            turtle.setX(--xPos);//存储本次海龟移动后的位置
                            break;
                        }
                        case 1://向下走，与向右走类似
                        {
                            for(int y = 0; y < nStep; y++)
                            {
                                if(yPos < 50)
                                {
                                    if(!turtle.isbIsPenUp())
                                    {
                                        array[yPos++][xPos] = 1;
                                    }
                                }
                                else
                                {
                                   // yPos--;
                                    break;
                                }
                            }
                            turtle.setY(--yPos);
                            break;
                        }
                        case 2://向左走，与向右走类似
                        {
                            for(int x = 0; x < nStep; x++)
                            {
                                if(xPos > -1)
                                {
                                    if(!turtle.isbIsPenUp())
                                    {
                                        array[yPos][xPos--] = 1;
                                    }
                                }
                                else
                                {
                                    //xPos++;
                                    break;
                                }
                            }
                            turtle.setX(++xPos);
                            break;
                        }
                        case 3://向上走，与向右走类似
                        {
                            for(int y = 0; y < nStep; y++)
                            {
                                if(yPos > -1)
                                {
                                    if(!turtle.isbIsPenUp())
                                    {
                                        array[yPos--][xPos] = 1;
                                    }
                                }
                                else
                                {
                                 //   yPos++;
                                    break;
                                }
                            }
                            turtle.setY(++yPos);
                            break;
                        }
                        default:
                            break;
                    }
                    break;
                }
                case "6":
                {
                    this.print();
                    break;
                }
                case "9":
                {
                    break;
                }
                default:
                {
                    break;
                }
            }

        }
    }

    //打印二维数组
    public void print()
    {
        for(int i=0; i<50; i++)
        {
            for(int j=0; j<50; j++)
            {
                if(array[i][j]==0)
                    System.out.print(" * ");
                else
                    System.out.print(" # ");
            }

            System.out.println();
        }

    }
}
