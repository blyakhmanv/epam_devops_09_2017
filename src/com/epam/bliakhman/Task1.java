package com.epam.bliakhman;

import com.sun.org.apache.xpath.internal.SourceTree;



public class Task1 {
    public static void main(String[] args) {
        if (args.length==0) {
            System.out.println("Arguments are required");
            }
        else {
            String MinStr= args[0];
            String MaxStr= args[0];
            for (int i = 1; i < args.length; i++) {
             if (args[i].length() <= MinStr.length()) {
                 MinStr=args[i];
            }
            if (args[i].length()>= MaxStr.length()){
                 MaxStr=args[i];
            }

            }
            System.out.println("Min String "+MinStr);
            System.out.println("Max String "+MaxStr);

        }

    }
}
