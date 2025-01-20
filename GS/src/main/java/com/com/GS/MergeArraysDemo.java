package com.GS;

/******************************************************************************

Given two sorted arrays, the task is to merge them in a sorted manner.

Input: arr1[] = { 1, 3, 4, 5}, arr2[] = {2, 4, 6, 8} 
Output: arr3[] = {1, 2, 3, 4, 4, 5, 6, 8}

Input: arr1[] = { 5, 8, 9}, arr2[] = {4, 7, 8} 
Output: arr3[] = {4, 5, 7, 8, 8, 9} 

*******************************************************************************/
import java.util.*;

public class MergeArraysDemo{
    
    public static void main(String[] args) {
        int arr1[] = {1,2,2,0,0,0};

        int arr2[] = {4,6,7};

 
        int arr3[] = mergeArrays(arr1, arr2);
 
        System.out.println("Array after merging - " + Arrays.toString(arr3));
    }
       
    public static int[] mergeArrays(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        
        int i =0, j=0;
//        int[] arr3 = new int[n+m] ;
        if(n>m)
            return mergeArrays(arr2,arr1);
//        int temp;    
        for(int k=0; k<n; k++){
        
            if(arr1[i]<=arr2[j]){
//                temp = arr2[j];
                arr2[k] = arr1[i];
                arr1[i] = k;
                i++;
            }    
        }
        return arr2;
    }
    
}
