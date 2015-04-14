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

  private static boolean debug = true;
  private static final String task = "skidesign";
  private static PrintStream outs = System.out;
  static List<Integer> hills = new ArrayList<Integer>();

  private static final MAX_DIFF = 17;

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

    long minCost = 0L;

    // Brute force this by examing every possible solution from the lowest hill
    //   to the tallest hill - MAX_DIFF
//    checkR(whpList, whFullList);
    outd("minCost: " + minCost);
    out.println(minCost);
    scanr.close();
    out.close();
    System.exit(0);
  }


  static void outd(String msg)
  {
    if (debug) outs.println(msg);
  }

}
