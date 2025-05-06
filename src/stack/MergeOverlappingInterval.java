package stack;

import java.util.*;

class Interval {
    int startTime;
    int endTime;

    public Interval(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "["+ startTime +" "+endTime+"]";
    }
}
public class MergeOverlappingInterval {
    public static void merge(List<Interval> intervals){
        intervals.sort(Comparator.comparingInt(Interval::getStartTime));
        Stack<Interval> stack =  new Stack<>();
        for(Interval i :intervals){
            if(!stack.isEmpty() && stack.peek().endTime>=i.getStartTime()){
                Interval m =stack.pop();
                int max = Math.max(m.getEndTime(), i.getEndTime());
                stack.push(new Interval(m.getStartTime(),max));
            }else stack.push(i);
        }
        System.out.println(stack);
    }


    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        Scanner s = new Scanner(System.in);
        intervals.add(new Interval(22,28));
        intervals.add(new Interval(1,8));
        intervals.add(new Interval(25,27));
        intervals.add(new Interval(14,19));
        intervals.add(new Interval(29,30));
        intervals.add(new Interval(5,12));
        System.out.println(intervals);
        merge(intervals);
    }
}
