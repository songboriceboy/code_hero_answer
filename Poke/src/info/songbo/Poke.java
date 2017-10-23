package info.songbo;

import java.util.*;

/**
 * Created by ttc on 2017/6/30.
 */
public class Poke {
    String[] colors = {"红桃","黑桃","方片","草花"};
    Integer[] values = {1,2,3,4,5,6,7,8,9,10,11,12,13};
    Card[] cards = new Card[52];//

    public Poke()
    {
        //生成52张扑克，印刷扑克
        int index = 0;
        for(int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                cards[index] = new Card();
                cards[index].setValue(values[j]);
                cards[index].setColor(colors[i]);
                index++;
            }
        }

    }

    public void outputCards()
    {
        int index2 = 0;
        for(Card card : cards)
        {
            if(index2 % 13 == 0)
                System.out.println();

            System.out.print(card.toString()+" ");
            index2++;
        }
    }

    public void shuffle()
    {
        Collections.shuffle(Arrays.asList(cards));
    }

    //一手牌
    public Card[] getOneHands()
    {
        Card[] cardHands = new Card[5];

        for(int i = 0; i < 5; i++)
        {
            cardHands[i] = cards[i];
        }
        return cardHands;
    }

    public void judgeHandType(Card[] hands)
    {
        boolean bIsSameColor = false;
        boolean bIsShunzi = false;
        //先判断这手牌是不是同花
        Set<String> colorSets = new HashSet<String>();
        for(int i = 0; i < hands.length; i++)
        {
            colorSets.add(hands[i].getColor());
        }
        if(colorSets.size()==1)
        {
            bIsSameColor=true;
            //System.out.println("同花");
        }

        Set<Integer> valueSets = new HashSet<Integer>();
        List<Integer> valueLists = new ArrayList<Integer>();
        for(int i = 0; i < hands.length; i++)
        {
            valueSets.add(hands[i].getValue());
            valueLists.add(hands[i].getValue());
        }

        Collections.sort(valueLists);//排序
        int diff = valueLists.get(4) - valueLists.get(0);

        if(diff == 4 && valueSets.size() == 5)
        {
            bIsShunzi = true;
            //System.out.println("顺子");
        }

        if(bIsSameColor&&bIsShunzi)
        {
            System.out.println("同花顺");
        }
        else if(bIsSameColor)
        {
            System.out.println("同花");
        }
        else if(bIsShunzi)
        {
            System.out.println("顺子");
        }
        else if(valueSets.size() == 5)//这5张牌不是顺子，并且值都不同
        {
            System.out.println("杂牌");
        }
        else if(valueSets.size() == 4)
        {
            System.out.println("一对");
        }
        else
        {
            //map的key保存的是牌的值，map的值保存的是同样值的牌的列表
            Map<Integer,List<Card>> map = new HashMap<Integer,List<Card>>();
            //将一手牌的数据，从数组结构，转变成map结构

            for(int i = 0; i < hands.length; i++)
            {
                Card card = hands[i];
                //看card这张牌的值是否在map的key中存在
                if(map.containsKey(card.getValue()))//如果存在
                {
                    List<Card> lst = map.get(card.getValue());
                    lst.add(card);
                }
                else//不存在
                {
                    List<Card> lst = new ArrayList<Card>();
                    lst.add(card);
                    map.put(card.getValue(),lst);
                }

            }

            if(map.size() == 2)//4带1,3带2
            {
                boolean bIsFourWithOne = false;
                for(Map.Entry<Integer,List<Card>> entry : map.entrySet())
                {
                    //entry的值是一个List
                    if(entry.getValue().size() == 4)
                    {
                        bIsFourWithOne = true;
                        break;
                    }
                }
                if(bIsFourWithOne == true)
                {
                    System.out.println("四带一");
                }
                else
                {
                    System.out.println("三带二");
                }
            }
            else if(map.size() == 3)//221,311
            {
                boolean bIsThreeOneOne = false;
                for(Map.Entry<Integer,List<Card>> entry : map.entrySet())
                {
                    //entry的值是一个List
                    if(entry.getValue().size() == 3)
                    {
                        bIsThreeOneOne = true;
                        break;
                    }
                }
                if(bIsThreeOneOne == true)
                {
                    System.out.println("三条");
                }
                else
                {
                    System.out.println("两对");
                }
            }
        }

        return;
    }

}