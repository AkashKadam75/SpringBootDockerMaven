package demo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Interval {
	      int start;
	      int end;
	     Interval() { start = 0; end = 0; }
	      Interval(int s, int e) { start = s; end = e; }
	  }
public class Solution {
	
	public static void main(String[] args) {
		List<Interval> list = merge(new ArrayList<Interval>(Arrays.asList(new Interval(1,3),new Interval(2,6),new Interval(8,10),new Interval(15,18))));
		for (int i = 0; i < args.length; i++) {
			System.out.println(list);
		}
	}
    public static List<Interval> merge(List<Interval> intervals) {
    	Collections.sort(intervals, (Interval a1, Interval a2) -> a1.start-a2.start);
        List<Interval> finalintervalsList = null;
       int currentStartIndex = 1;
       int currentStartIndexStart = intervals.get(currentStartIndex).start;
       for(int index = 0; index < intervals.size() - 1; index++){
           if(intervals.get(index).end > currentStartIndexStart){
               finalintervalsList.add(new Interval(intervals.get(index).start,intervals.get(index + 1).end));
               intervals.set(currentStartIndex,new Interval(intervals.get(index).start,intervals.get(index + 1).end));
           }else if(finalintervalsList == null) {
        	   finalintervalsList = new ArrayList<>();
        		finalintervalsList.add(new Interval(intervals.get(index).start,intervals.get(index).end));
           }else if(finalintervalsList.get(finalintervalsList.size() - 1).end != intervals.get(index).end) {
        	   finalintervalsList.add(new Interval(intervals.get(index).start,intervals.get(index).end));
           }
           
           if(currentStartIndex < intervals.size() -1){
                   currentStartIndexStart = intervals.get(currentStartIndex + 1).start;
                   currentStartIndex++;
               }
       }
       
       if(intervals.get(intervals.size() -1).end != finalintervalsList.get(finalintervalsList.size() -1).end) {
       	finalintervalsList.add(new Interval(intervals.get(intervals.size() -1).start,intervals.get(intervals.size() -1).end));
       }
       return finalintervalsList;
    }
}
