package com.bestrookie.uf;

/**
 * @author bestrookie
 * @version 1.0
 * @date 2022/8/29 21:41
 */
public class UF {
    //记录节点元素和该元素的该元素所在分组的标识
    private int[] eleAndGroup;
    // 记录并查集中数据的分组个数
    private int count;

    public UF( int N) {
        this.eleAndGroup = new int[N];
        this.count = N;
        for (int i = 0; i < N; i++) {
            this.eleAndGroup[i] = i;
        }
    }

    public int count() {
        return count;
    }

    public Boolean connected(int p , int q){
        return eleAndGroup[p] == eleAndGroup[q];
    }

    public int find(int p){
        return eleAndGroup[p];
    }

    public void union(int p, int q){
        if (connected(p,q)){
            return;
        }
        int pIndex = find(p);
        int qIndex = find(q);
        for (int i = 0; i < eleAndGroup.length; i++) {
            if (eleAndGroup[i] == pIndex) {
                eleAndGroup[i] = qIndex;
            }
        }
        this.count--;
    }
}
