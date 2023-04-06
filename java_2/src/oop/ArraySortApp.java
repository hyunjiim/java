package oop; //OOP(Object Oriented Programming): 객체 지향 프로그래밍

import java.util.Arrays;

//배열 요소값을 오름차순 정렬되도록 출력하는 프로그램
public class ArraySortApp {
	public static void main(String[] args) {
		
		/*
		int[] array= {30,50,10,40,20};
		
		System.out.println("정렬 전 >> ");
	      for(int num : array) {
	         System.out.println(num+" ");
	      }
	    System.out.println();
	      
	    //배열 요소값을 선택 정렬 알고리즘을 사용하여 오름차순 정렬하여 저장
	    for(int i=0;i<array.length-1;i++) {
	    	for(int j=i+1;j<array.length;j++) {
	    		if(array[i]>array[j]) {
	    			int temp=array[i];
	    			array[i]=array[j];
	    			array[j]=temp;
	    		}
	    	}
	    }
	    System.out.println("정렬 후 >> ");
	      for(int num : array) {
	         System.out.println(num+" ");
	      }
	    System.out.println();
	    */
		
		int[] array= {30,50,10,40,20};
		System.out.println("정렬 전>> "+Arrays.toString(array));
		Arrays.sort(array);
		System.out.println("정렬 후>> "+Arrays.toString(array)); 
		
	}
}
