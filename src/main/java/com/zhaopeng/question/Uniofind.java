package com.zhaopeng.question;

/**
 * Created by zhaopeng on 2018/4/22.
 */
public class Uniofind {

    int set[] = new int[100];

    public int find(int x) {
        if (x == set[x]) {
            return x;
        } else {
            set[x] = find(set[x]);
            return set[x];
        }
    }

    public void unio(int x, int y) {

        int p1 = set[x];
        int p2 = set[y];
        if (p1 == p2) {
            return;
        }
        set[x] = y;
    }

    public boolean check(int x, int y) {

        return find(x) == find(y);
    }

    public void init() {
        for (int i = 0; i < set.length; i++) {
            set[i] = i;
        }
    }

}
