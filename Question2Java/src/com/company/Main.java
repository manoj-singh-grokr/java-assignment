package com.company;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int N = 4;
        int arr[] = {1, 5, 3, 2};
        int count=0;
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<N;i++){
            for(int j=i+1;j<N;j++){
                set.add(arr[i] + arr[j]);
            }
        }
        for(Integer value: set){
            for(int i=0;i<N;i++){
                if(value == arr[i]){
                    count+=1;
                }
            }
        }

        System.out.println(count);
    }
}
