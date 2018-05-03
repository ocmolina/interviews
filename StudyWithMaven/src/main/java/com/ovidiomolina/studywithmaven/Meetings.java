/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ovidiomolina.studywithmaven;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author ovidiomolina
 */
public class Meetings {
    static class Meeting implements Comparable<Meeting>{
        public int startTime;
        public int endTime;
        public Meeting(int start, int end) {
            startTime = start;
            endTime = end;
        }

        @Override
        public int compareTo(Meeting o) {
            return this.startTime - o.startTime;
        }
        
        @Override
        public String toString() {
            return String.format("Start: %s End: %s", startTime, endTime);
        }
    }
    
    private static List<Meeting> consolidate(List<Meeting> meetings) {
        List<Meeting> result = new ArrayList<>();
        Collections.sort(meetings);
        result.add(meetings.get(0));
        for(int i = 1; i < meetings.size(); i++) {
            Meeting current = meetings.get(i);
            Meeting lastMeeting = result.get(result.size() - 1);
            if(current.startTime > lastMeeting.endTime) {
                result.add(current);
            }
            else if (lastMeeting.endTime < current.endTime){
                lastMeeting.endTime = current.endTime;
            }
        }
        return result;
    }
    
    private static List<Meeting> insertMeeting(List<Meeting> meetings, Meeting m) {
        meetings.add(m);
        return consolidate(meetings);
    }
    
    public static void main(String args[]) {
        List<Meeting> meetings = new ArrayList<>();
        meetings.add(new Meeting(1,2));
        meetings.add(new Meeting(3,5));
        meetings.add(new Meeting(6,7));
        meetings.add(new Meeting(8,10));
        meetings.add(new Meeting(4,9));
        meetings.add(new Meeting(12,16));
        List<Meeting> available = consolidate(meetings);
        for(Meeting m: available){
            System.out.println(m);
        }
        
    }
}
