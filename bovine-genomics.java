import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new File("cownomics.in"));
        int perCow = sc.nextInt();
        int alleles = sc.nextInt();
        String[] genome = new String[perCow * 2];
        
        for (int i = 0; i < perCow * 2; i++) {
            genome[i] = sc.next();
        }
        int counter = 0;
        
        for (int i = 0; i < alleles - 2; i++) {
            for (int j = i + 1; j < alleles - 1; j++) {
                for (int k = j + 1; k < alleles; k++) {
                    HashMap<String, Integer> map = new HashMap<>();
                    
                    for (int cows = 0; cows < perCow; cows++) {
                        String seq = "";
                        seq += Character.toString(genome[cows].charAt(i));
                        seq += Character.toString(genome[cows].charAt(j));
                        seq += Character.toString(genome[cows].charAt(k));
                        
                        map.put(seq, 1);
                    }
                    
                    boolean allGood = true;
                    
                    for (int cows = perCow; cows < perCow * 2; cows++) {
                        String seq = "";
                        seq += Character.toString(genome[cows].charAt(i));
                        seq += Character.toString(genome[cows].charAt(j));
                        seq += Character.toString(genome[cows].charAt(k));
                        
                        if (map.get(seq) != null) {
                            allGood = false;
                            break;
                        }
                    }
                    
                    if (allGood) {
                        counter++;
                    }
                }
            }
        }

        PrintWriter out = new PrintWriter(new File("cownomics.out"));
        out.println(counter);
    }
}
