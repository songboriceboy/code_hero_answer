package info.songbo;
//海龟作图问题
//
//        使用一个50*50的数组，并把数组初始化为0。从一个安装有命令的数组中读取各种命令。
//        不管笔朝上还是朝下，都要跟踪海龟的当前位置。假定海龟总是从地板上（0，0）出发，并且开始时笔是朝上的。程序必须处理的一组命令如下：
//
//        命令	含义
//
//        1	笔朝上
//
//        2	笔朝下
//
//        3	右转弯
//
//        4	作转弯
//
//        5，10	向前走10格
//
//        6 	打印50*50的数组
//
//        9  	数组结束（标记）
//
//        假设海龟现在处于靠近地板中心的某个位置，下面的“程序”绘制并打印出了一个12*12的方框。
//
//        2	5，12	    3	    5，12        3         5，12
//
//        3        5，12        1         6            9
//
//        在海龟爬行过程中，如果笔朝下，把数组floor中对应于海龟所处位置的元素置1。当给出命令6（打印）后，
//        在数组中元素为1的位置全部用星号显示，元素为0的位置全部用空格显示。
//        编写一个c语言程序，画出有趣的形状。在世这加入其他命令来增强海龟作图语言的功能。

public class Main {

    public static void main(String[] args) {
	// write your code here
        Graph graph = new Graph();
        graph.parseCmd();

    }
}
