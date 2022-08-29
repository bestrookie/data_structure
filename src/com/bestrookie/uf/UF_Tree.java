package com.bestrookie.uf;

/**
 * @author bestrookie
 * @version 1.0
 * @date 2022/8/29 21:41
 */
public class UF_Tree {
    //记录节点元素和该元素的该元素所在分组的标识
    private int[] eleAndGroup;
    // 记录并查集中数据的分组个数
    private int count;

    public UF_Tree(int N) {
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
       while (true){
           if (p == eleAndGroup[p]){
               return p;
           }
           p = eleAndGroup[p];
       }
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }
        eleAndGroup[pRoot] = qRoot;
        this.count--;
    }
}
