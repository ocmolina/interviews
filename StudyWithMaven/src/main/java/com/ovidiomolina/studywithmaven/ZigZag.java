/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ovidiomolina.studywithmaven;

/**
 *
 * @author nelly
 */
public class ZigZag {
    
    public static void main(String args[]) {
        int array[] = {1,2,3,4};
        System.out.println("Longest: " + zigzag(array));
    }
    static int zigzag(int[] a) {
        if(a.length == 1) {
            return 1;
        }

        boolean lessThan = false;
        boolean greaterThan = false;
        int maxLength = 0;
        int start = 0;
        int end = 0;
        for(int i = 1; i < a.length; i++) {
            if(a[i-1] == a[i]) {
                maxLength = Math.max(maxLength, end - start + 1);
                start = i;
                end = i;
                greaterThan = false; lessThan = false;
            }
            else {
                if( !lessThan && !greaterThan) {
                    end++;
                    if(a[i] > a[i-1]) {
                        lessThan = true; // next number must be less than
                    }
                    else {
                        greaterThan = true; // next must be greater than
                    }
                }
                else if(lessThan) {
                    if(a[i] < a[i-1]) {
                        end++;
                        lessThan = false;
                        greaterThan = true;
                    }
                    else {
                        maxLength = Math.max(maxLength, end - start + 1);
                        start = i;
                        end = i;
                        greaterThan = false; lessThan = false;
                    }
                }
                else if(greaterThan) {
                    if(a[i] > a[i-1]) {
                        end++;
                    }
                    else {
                        maxLength = Math.max(maxLength, end - start + 1);
                        start = i;
                        end = i;
                        greaterThan = false; lessThan = false;
                    }
                }
            }
        }
        return maxLength;
    }
}
