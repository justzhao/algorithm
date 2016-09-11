package com.zhaopeng.question;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * 1 找零钱问题，给定 几张面额的钞票{1,5,10} 问数额87 有多少种这一的钞票组成
 *
 * 参考资料
 *
 * Created by zhaopeng on 2016/9/11.
 */
public class ChangeMoneny {

    public  static  void  main(String args[]){

        int s[]={1,2,3};
        int n=5;

        List<String> resStr=new ArrayList<String>();
        DFS(n,s,0,resStr,"");
        for(String str:resStr){
            System.out.println(str);
        }
        //System.out.println(getAllChangeCount(s,s.length-1,n));
        //getAllChangeCountDynamically(s,n);



      /*   List<Integer> res=new ArrayList<Integer>();
       getAllChange(s,s.length-1,n,res);
       */
   /*     int changeUsed[]=new int[n+1];//索引从1开始
        int lastChanged[]=new int[n+1];
        makeChangeDynamically(n,s,changeUsed,lastChanged);*/
    }


    /**
     *
     * http://www.acmerblog.com/dp6-coin-change-4973.html
     * 获取总额为n的所有的零钱组合的个数，递归算法.
     * 思想：
     * 问题分为两部分： 结果中不含有硬币s[index]，  结果中含有硬币s[index]
     *
     * index 表示当前遍历面额的索引，
     *
     *
     *
     */
    public  static  int  getAllChangeCount(int s[],int index,int n){

        if(n==0){
            return 1;
        }
        if(n<0||index<0){// 当前数字不合法 ，需要返回
            return 0;
        }//不包含当前+//包含当前硬币
       return getAllChangeCount(s,index-1,n)+ getAllChangeCount(s,index,n-s[index]);
    }

    /**
     * http://www.mamicode.com/info-detail-1311262.html
     *  获取总额为n的所有的零钱组合的个数 动态规划的解法
     *  思想:
     *  根据前面的递归算法，保留子结果。
     *  动态规划， 数额为n，可以由数额为n 的组合和
     *   dp[n] 表示 n元钱的零钱的组合方式
     *  dp[n] = dp[n] + dp[n -s[i]] 。 因为s[i] 是当前的零钱，dp[n] 不断更新，保存着上次零钱的组合个数，
     *
     * @param s 零钱组合
     * @param n 总额
     * @return
     */
    public  static  void   getAllChangeCountDynamically(int s[],int n){

         int dp[]=new int[n+1];//从1开始
         dp[0]=1;//开始位置置为1

        for(int i=0;i<s.length;i++){
            for(int j=s[i];j<=n;j++){

                dp[j]=dp[j]+dp[j-s[i]];
            }
        }

       System.out.println(dp[n]);

    }



    /**
     * DFS 获取所有的零钱组合,并且输出结果
     * @param n
     * @param s
     * @param start
     * @param result
     * @param str
     */
    public  static void DFS(int n,int[]s,int start,List<String>result,String str){
        if(n == 0){
            result.add(str);
            return;
        }
        // 当前选取的s[start]  不合法，直接返回，否则继续寻找
        if(s[start]> n){
            return;
        }
        // 递从 最小的钞票开始寻找。
        for(int i = start;i<s.length;i++){
              //选取当前钞票s[i].继续遍历。如果选取的s[1] 不行，就会返回选取s[2]
            DFS(n - s[i],s,i,result,str+ " "+s[i]);
        }
    }

    /**
     * 动态规划,查找零钱最少的个数
     * 数额n，可做如下考虑：
     * 1）如果n = 1，则用1个1元来找零，这就是最优解；
     * 2）如果n > 1，则对于每个可能的值i，分别找出i元和n-i元来。
     */

    /**
     *
     * @param money
     * @param changes  零钱组成
     * @param changesUsed 保存 1 到 n 需要多少张零钱 在求解67的时候，会这样考虑：对于changes的每个数值，将67拆分为1+66，5+62，10+57，20+47，50+17，由于66、62、57、47、17这些值都已计算过，所以可以迅速得出对于67找零需要几张零钱；
     * @param lastChange 表示最后一张零钱使用的什么
     */
    public static void makeChangeDynamically(int money, int[] changes, int[] changesUsed, int[] lastChange)
    {
        changesUsed[0] = 0;
        lastChange[0] = 1;
        // 从 第1元开始
        for (int dollars = 1; dollars <= money; dollars++)
        {
            // 至少可以全部使用1元来找零
            int minChangeCount = dollars;
            int newChange = 1;

            // 零钱的个数
            for (int j = 0; j < changes.length; j++)
            {
                //当前零钱个数大于总数
                if (changes[j] > dollars)
                {
                    continue; // 不能使用该数额来找零
                }

                // 如果使用这个数额来找所需要的数目更小
                // 可以用当前零钱找零，如果changeUsed 当前总额适用当前零钱找零的数目是最小的
                // 比如当前 零钱为2   数额为20  。20=18+2,这样，changesUsed[20]=changesUsed[18]+1
                if (changesUsed[dollars - changes[j]] + 1 < minChangeCount)
                {
                    minChangeCount = changesUsed[dollars - changes[j]] + 1;
                    newChange = changes[j];//拿到最新的最后一张零钱，
                }
            }
            // 设置当前 数额的最小零钱数和最后使用的零钱,
            changesUsed[dollars] = minChangeCount;
            lastChange[dollars] = newChange;
        }

        System.out.println(changesUsed[money]+" "+lastChange[money]);
    }





}
