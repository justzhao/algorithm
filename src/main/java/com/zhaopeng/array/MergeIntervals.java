package com.zhaopeng.array;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode.com/problems/merge-intervals/description/
 * Created by zhaopeng on 2018/1/10.
 */
public class MergeIntervals {

    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() < 1) {
            return intervals;
        }
        List<Interval> res = new ArrayList<>();
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        Interval pre = null;
        for (Interval o : intervals) {
            if (pre == null || pre.end < o.start) {
                res.add(o);
                pre = o;
            } else {
                pre.end = Math.max(pre.end,o.end);
            }
        }
        return res;
    }
}

class Interval {

    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}