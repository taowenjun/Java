package cn.bit.tao.divide;

import org.junit.Test;
/*
 * @Author:TaoWenjun
 * @CreateTime:2018/03/06
 * <除法运算（不使用加减乘除）>
 */
public class Divide {
	public int divide(int dividend, int divisor) {
		//检查除数
        if(divisor==0){
            return Integer.MAX_VALUE; 
        }
        if(dividend == Integer.MIN_VALUE && divisor == -1){  
           return ~dividend;  
       }  
        //被除数和除数取绝对值，注意转换为long类型
        long dividend1=Math.abs((long)dividend);
        long divisor1=Math.abs((long)divisor);
        int result=0;
        while(dividend1>=divisor1){
           int shiftnum = 0;  
           while(dividend1 >= divisor1<<shiftnum){  
               shiftnum++;//记录左移次数（比实际次数多1）  
           } 
            dividend1-=(divisor1<<(shiftnum-1));
            result+=(1<<(shiftnum-1));
        }
        if(dividend>=0&&divisor>0||dividend<0&&divisor<0){
            return result;
        }else{
            return -result;
        }
    }
	
	@Test
	public void test(){
		Divide divide=new Divide();
		int result=divide.divide(1, -1);
		System.out.println(result);
	}
}
