package com.algo.unionfind;

public class QuickFind
{
   private int count;
   private int N;
   private int[] comp;
   public QuickFind(int n)
   {
      N = n;
      count = N;
      comp = new int[N];
      for (int i = 0; i < N ; i++) {
         comp[i] = i;
      }
   }
   public void union(int p, int q) {
      int valP = find (p);
      int valQ = find (q);
      
      if (valP == valQ) return ;
     
      
      for (int i = 0; i < N; i++) {
         if(find(i) == valP) {
            comp[i] = valQ;
         }
      }
      count--;
   }
   
   public int find(int p) {
      return comp[p];
   }
   
   public boolean connected(int p, int q) {
      return find(p) == find(q);
   }
   
   public int count() {
      return count;
   }
   
}
