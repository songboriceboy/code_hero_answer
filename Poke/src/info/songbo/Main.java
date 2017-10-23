package info.songbo;

/**
 * Created by Administrator on 2017/10/23.
 */


public class Main {

    public static void main(String[] args) {
        // write your code here
        Poke poke = new Poke();

        poke.outputCards();
        poke.shuffle();
        System.out.println();
        System.out.println("\n洗牌以后");
        poke.outputCards();

        Card[] hands = poke.getOneHands();
        System.out.println();
        System.out.println();
        System.out.println("分到的一手牌是");
        System.out.println();
        for(int i = 0; i< 5; i++)
        {
            System.out.print(hands[i] + "  ");
        }
        System.out.print("\n牌型是：");
        poke.judgeHandType(hands);


    }
}
