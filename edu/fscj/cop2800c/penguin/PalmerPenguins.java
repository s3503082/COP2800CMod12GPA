// PalmerPenguins.java
// J. Washington
// 04/09/2026
// Palmer Penguins application

package edu.fscj.cop2800c.penguin;

import java.util.ArrayList;
import java.util.List;
import edu.fscj.cop2800c.util.DataWrapper;

public class PalmerPenguins {
    public static void main(String[] args) {
        int numPenguins = 0;
        
        PenguinAnalyzer analyzer = new PenguinAnalyzer();
    
        numPenguins = analyzer.readPenguins();
        
        if (numPenguins == 0) {
            System.err.println(
                "Error: No penguins were read from the file. Exiting program.");
            System.exit(1);
        }
    
        if (numPenguins > 1) {
            System.out.println("Testing compareTo method:");
        
            Penguin p1 = analyzer.getPenguinBySampleNum(1);
            Penguin p2 = analyzer.getPenguinBySampleNum(2);
        
            if (p1 != null && p2 != null) {
                int comparisonResult = p1.compareTo(p2);
                System.out.println(
                    "Comparison result between first two penguins: " + comparisonResult);
        
                int selfComparison = p1.compareTo(p1);
                System.out.println(
                    "Comparison result of p1 to itself (should be 0): " + selfComparison);
            } else {
                System.out.println("Could not find both penguins for comparison.");
            }
        } else {
            System.out.println("Not enough penguins to test compareTo.");
        }
    
        analyzer.showRawData();
    
        analyzer.printPenguins();
    
        analyzer.writePenguins();
        
        System.out.println("Testing Custom Exception");

        for (int sample = 0; sample < 7; sample++) {
        
            try {
                switch (sample) {
                    case 0:
                        Penguin pNegSample = new Penguin(
                            -1, "Adelie", 1.0, 1.0, 1.0, "Male", 1.0);
                        break;
                    case 1:
                        Penguin pEmptySpecies = new Penguin(
                            1000 + sample, "", 1.0, 1.0, 1.0, "Male", 1.0);
                        break;
                    case 2:
                        Penguin pNullSpecies = new Penguin(
                            1000 + sample, null, 1.0, 1.0, 1.0, "Male", 1.0);
                        break;
                    case 3:
                        Penguin pNegFlipper = new Penguin(
                            1000 + sample, "Adelie", 1.0, 1.0, 1.0, "Male", -1.0);
                        break;
                    case 4:
                        Penguin pEmptySex = new Penguin(
                            1000 + sample, "Adelie", 1.0, 1.0, 1.0, "", 1.0);
                        break;
                    case 5:
                        Penguin pNullSex = new Penguin(
                            1000 + sample, "Adelie", 1.0, 1.0, 1.0, null, 1.0);
                        break;
                    case 6:
                        Penguin pNegCulmenLen = new Penguin(
                            1000 + sample, "Adelie", -1.0, 1.0, 1.0, null, 1.0);
                        break;
                }
            } catch (InvalidBirdDataException e) {
                System.out.println(e + ": sample = " + sample);
            }
        }

        System.out.println();
        System.out.println("Data Wrapper List:");

        List<DataWrapper<Penguin>> wrappedPenguins = new ArrayList<>();

        for (int sample = 1; sample <= 8; sample++) {
            Penguin penguin = analyzer.getPenguinBySampleNum(sample);

            if (penguin != null) {
                DataWrapper<Penguin> wrappedPenguin = new DataWrapper<>(penguin);
                wrappedPenguins.add(wrappedPenguin);
            }
        }

        if (!wrappedPenguins.isEmpty()) {
            DataWrapper.displayList(wrappedPenguins);
        }
    }
}