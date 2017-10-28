import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * Created by Administrator on 2017/10/28.
 */
public class Main {

    public static void main(String[] args) throws IOException {

        InputStream input = Main.class.getResourceAsStream("article.txt");
        // 读取输入流转换成字符串（使用commons-io-2.4.jar）
        String s = IOUtils.toString(input);
        s = s.replaceAll("[\\p{P}*]", " ");//正则去除标点符号
        System.out.println(s);
        String[] arrayLine = s.split("\n");

        Set<Integer> setLineNo = new HashSet<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要查找的单词");
        String strFind = scanner.nextLine();
        int nLineNo = 1;
        for(String strLine : arrayLine)
        {
            String[] wordArray = strLine.split(" ");
            for(String strWord : wordArray)
            {
                if(strWord.equals(strFind))
                {
                    setLineNo.add(nLineNo);
                    break;
                }

            }
            nLineNo++;
        }

        if(setLineNo.size()>0)
        {
            System.out.println(strFind+"共出现"+setLineNo.size()+"次");
            for(Integer iNo : setLineNo)
            {
                System.out.println("Line" + iNo + ":" + arrayLine[iNo-1]);
            }
        }
    }


}
