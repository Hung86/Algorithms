package com.algo.unionfind;

public class WeightedQuickUnion
{
   private int count;
   private int N;
   private int[] site;
   private int[] sSize;
   
   public WeightedQuickUnion (int n) {
      N = n;
      count = N;
      site = new int[N];
      sSize = new int[N];
      for (int i = 0; i < N ; i++) {
         site[i] = i;
         sSize[i] = 1;
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
        if (sSize[rootP] < sSize[rootQ]) {
           site[rootP] =  rootQ;
           sSize[rootQ] += sSize[rootP];
        } else {
           site[rootQ] =  rootP;
           sSize[rootP] += sSize[rootQ];
        }
        count--;
      }
   }
   
   public boolean connected(int p, int q) {
      return find(p) == find(q);
   }
}
