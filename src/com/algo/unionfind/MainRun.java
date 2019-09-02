package com.algo.unionfind;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MainRun
{

   public static void main(String[] args)
   {
      Scanner scanner = null;
      try
      {
         scanner = new Scanner(new File("res/number.txt"));
         int N = scanner.nextInt();
         QuickFind QF = new QuickFind(N);
         
         while(scanner.hasNextInt()){
            int p = scanner.nextInt();
            System.out.println(p);

            int q = scanner.nextInt();
            System.out.println(q);
            QF.union(p, q);
         }
         
         System.out.println("-------check connect : " + QF.connected(18, 2));
      }
      catch (FileNotFoundException e)
      {
         e.printStackTrace();
      }
   }

}
