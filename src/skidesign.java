/*
ID: elj_4321
LANG: JAVA
TASK: skidesign
*/

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.io.PrintStream;

public class skidesign {

  private static boolean debug = false;
  private static final String task = "skidesign";
  private static PrintStream outs = System.out;

  /**
   * @param args
   */
  public static void main(String[] args) throws IOException, FileNotFoundException
  {
//    long start = System.currentTimeMillis();
    final String infile = task + ".in";
    final String outfile = task + ".out";
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(outfile)));
    Scanner scanr = new Scanner(new File(infile));

    // Up to 1<=N<=1000 hills followed by hill heights
    // Hill heights 0<=H<=100

    int MAX_DIFF = 17;

    List<Integer> hills = new ArrayList<Integer>();
    // Read in number of hill heights
    int numHills = scanr.nextInt();
    outd("Num hills: " + numHills);

    int maxH = -1;
    int minH = 101;
    for (int i=0; i<numHills; i++) {
      Integer hx = scanr.nextInt();
      outd("Hill: " + hx);
      if (hx < minH) minH = hx;
      if (hx > maxH) maxH = hx;
      hills.add(hx);
    }

    outd("Min hill:" + minH);
    outd("Max hill:" + maxH);


    // Brute force this by examining every possible solution from the lowest hill
    //   to the tallest hill - MAX_DIFF
    int startH = minH;
    int stopH = maxH - MAX_DIFF;
    long minCost = Integer.MAX_VALUE;
    for (int h = startH; h <= stopH; h++)
    {
      long totCost = computeTotalCost(h, h + MAX_DIFF, hills);
      if (totCost < minCost) minCost = totCost;
    }
    outd("minCost: " + minCost);
    out.println(minCost);
    scanr.close();
    out.close();
    System.exit(0);
  }

  static long computeTotalCost(int minHH, int maxHH, List<Integer> allHills)
  {
    long totCost = 0;
    outd("Compute: " + minHH + ":" + maxHH);
    for (Integer hh : allHills)
    {
      if (hh < minHH)
      {
        totCost += (minHH-hh)*(minHH-hh);
      }
      else if (hh > maxHH)
      {
        totCost += (hh-maxHH)*(hh-maxHH);
      }
    }
    outd("totCost: " + totCost);
    return totCost;
  }

  static void outd(String msg)
  {
    if (debug) outs.println(msg);
  }
}
