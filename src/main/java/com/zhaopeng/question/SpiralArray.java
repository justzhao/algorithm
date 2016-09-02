package com.zhaopeng.question;

/**
 * 螺旋数组 打印
 * Created by zhaopeng on 2016/9/2.
 */
public class SpiralArray {


    public  static  void  main(String args[]){

        /**
         * 思路 ：设数组长 高都为n 则从  n*n 开始 最小为1 一共 n*n个数字
         * 数组在初始化过程中，有四种转弯情况，设 row 为行，col 为列
         * 从 0行 0列开始 array[0][0]
         * 1  右边 向下转  col 不变  row++
         * 2  下向左边转  row 不变 col--
         * 3 左向上转  col 不变  row--
         * 4 上向右转  row 不变 col++
         *
         */
        System.out.println("123");

        int len=10;
        int [][]arry=initArray(len);

       print(arry,len);

    }

    public  static  void  print(int [][]array,int len){

        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                System.out.print(array[i][j]+" ");

            }
            System.out.println();
        }


    }

    public  static  direction getNextStep(int rows,int col,direction nowStep,int [][]array,int len){

        direction nextStep=nowStep;

        //先查看当前的方向
        switch (nextStep){
            case up:
                if(rows<=0||array[--rows][col]!=0){
                  // 向上走的时候，如果本行是第0行或者 上一行的值不为0.就需要右拐
                    nextStep=direction.right;
                }
                break;
            case down:
                if(rows>=len-1||array[++rows][col]!=0){
                //向下走的时候，如果本行是第len-1 行或者下一行的值不为0，就需要左拐
                    nextStep=direction.left;
                }
                break;
            case left:
                if(col<=0||array[rows][--col]!=0){
                // 向左边走的时候，如果本列是第o列或者下一列的值不为0，就需要上拐
                    nextStep=direction.up;
                }
                break;
            case right:
                if(col>=len-1||array[rows][++col]!=0){
                //向右走的时候，如果本列是第len-1列或者下一列的值部位0，就需要下拐
                    nextStep=direction.down;
                }
                break;
        }


        return  nextStep;
    }

    public static int[][] initArray(int len){

        int [][]array=new int[len][len];
        int rows=0;
        int col=0;
        int value=len*len;
        direction ostep=direction.right;//初始化方向是右边
        direction  nstep=ostep;
        while (value>0){
               //先从 00 开始
            //System.out.println(value);
              array[rows][col]=value;
            // 根据下一步的方向来决定row和col的加减
            //得到新的方向。
            nstep=getNextStep(rows,col,ostep,array,len);

             switch (ostep){
                 case up:
                       if (ostep==nstep){
                           rows--;
                       }else {
                           col++;

                       }

                     break;
                 case down:
                     if(ostep==nstep){
                        rows++;
                     }else {
                         col--;
                     }

                     break;
                 case left:
                     if(ostep==nstep){

                       col--;
                     }else {

                         rows--;
                     }

                     break;
                 case right:
                     if(ostep==nstep){

                       col++;
                     }else {

                        rows++;


                     }

                     break;
             }


           ostep=nstep;
            value--;
        }




        return array;
    }

      enum direction {
        up,down,left,right


    }
}

