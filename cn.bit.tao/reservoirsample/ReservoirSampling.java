package cn.bit.tao.reservoirsample;

import java.util.Arrays;
import java.util.Random;

import org.junit.Test;

/*
 * @author Tao wenjun
 * @Date 2018/03/12
 * ��ˮ�س���
 */
public class ReservoirSampling {
	/*
	 * ��ˮ�س�����������ʵ��
	 * Ҫ���N��Ԫ��������ĳ�ȡk��Ԫ�أ�ÿ��Ԫ�صĸ�����ȣ�����N�޷�ȷ��
	 */
	public int[] reservoirSampling(int[] data,int k){
		if(data==null||data.length<k){
			return new int[0];
		}
		int[] sample=new int[k];
		int n=data.length;
		Random rand=new Random();
		for(int i=0;i<n;i++){
			if(i<k){
				sample[i]=data[i];
			}else{
				int j=rand.nextInt(i);
				if(j<k){
					sample[j]=data[i];
				}
			}
		}
		return sample;
	}
	
	@Test
	public void testSample(){
		int k=100;  
        int n=1000;  
        int[] data=new int[n];  
        for(int i=0;i<n;i++){  
            data[i]=i;  
        }  
        int[] sample=reservoirSampling(data,k);  
        System.out.println(Arrays.toString(sample));  
	}
}
