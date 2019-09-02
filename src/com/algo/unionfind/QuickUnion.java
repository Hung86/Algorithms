package com.algo.unionfind;

public class QuickUnion
{
   private int count;
   private int N;
   private int[] site;
   
   public QuickUnion (int n) {
      N = n;
      count = N;
      site = new int[N];
      for (int i = 0; i < N ; i++) {
         site[i] = i;
      }
   }
   
   public int find(int p) {
      while (p != site[p]) p = site[p];
      return p;
   }
   
   public void union(int p, int q) {
      int rootP = find (p);
      int rootQ = find (q);
      if (rootP != rootQ) {
        site[rootP] = rootQ;
        count--;
      }
   }
   
   public boolean connected(int p, int q) {
      return find(p) == find(q);
   }
   
}
