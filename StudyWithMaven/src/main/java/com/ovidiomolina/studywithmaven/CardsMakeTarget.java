/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ovidiomolina.studywithmaven;

/**
 *
 * @author ovidiomolina
 */
public class CardsMakeTarget {
    
    
    private static boolean cardsMakeTarget(int array[], int target) {
        boolean result = cardsMakeTargetHelper(array, 0, target, 0);
        return result;
    }
    
    private static boolean cardsMakeTargetHelper(int[] array, int index, int target, int total) {
        if(index >= array.length) {
            return target == total;
        }
        if(index == 0) {
            return cardsMakeTargetHelper(array, index+1, target, total+array[index]);
        }
        boolean add = cardsMakeTargetHelper(array, index+1, target, total+(array[index-1] + array[index]));
        boolean sub = cardsMakeTargetHelper(array, index+1, target, total+(array[index-1] - array[index]));
        boolean mult = cardsMakeTargetHelper(array, index+1, target, total+(array[index-1] * array[index]));
        boolean div = cardsMakeTargetHelper(array, index+1, target, total+(array[index-1] / array[index]));
        return add || sub || mult || div;
    }
    
    public static void main(String args[]) {
        int array[] =  new int[]{1,2,3,4};
        boolean canmake15 = cardsMakeTarget(array,10);
        System.out.println(canmake15);
    }

    
}
