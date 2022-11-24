package xxq20210713;

public class Perm {
    static int count;
    public static void main(String[] args)throws Exception {
        // TODO Auto-generated method stub
        count=0;
        String str="aabb";
        char[] cs=str.toCharArray();
        perm(cs,0);
        System.out.print(count);
        System.exit(0);
    }
    //全排列的递归算法
    private static void perm(char[] c,int index)throws Exception{
        //打印当前序列
        if(index>=c.length){
            for(int i=0;i<c.length;i++)
                System.out.print(c[i]+" ");
            System.out.print("\n");
            count++;
        }
        //进行交换和递归
        for(int i=index;i<c.length;i++){
            if(!check(c,index,i)){     //对于重复元素，先与第一次出现的字符交换并求全排列，后面再出现的就不进行交换和求全排列的过程
                swap(c,index,i);
                perm(c,index+1);
                swap(c,index,i);
            }
        }
    }
    //数组里两个值交换
    private static void swap(char[] c,int index1,int index2)throws Exception{
        char t=c[index1];
        c[index1]=c[index2];
        c[index2]=t;
    }
    //去重函数
    private static boolean check(char[] c,int index1,int index2) {
        while (index1 < index2) {
            if (c[index1] == c[index2])
                return true;
            index1++;
        }
        return false;
    }
}
