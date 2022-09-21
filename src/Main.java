import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
    static String[] a;
    static String[] b;

    public static void main(String[] args) {
        int noRowsA;
        int noColumnsA;
        int noRowsB;
        int noColumnsB;

        Scanner input = new Scanner(System.in);
        List<String> matrixRowsA = new ArrayList<String>();
        List<String> matrixColumnsB = new ArrayList<String>();
        List<Integer> ans = new ArrayList<Integer>();

        System.out.print("Enter the number of rows in matrix A: ");
        noRowsA = input.nextInt();
        System.out.print("Enter the number of columns in matrix A: ");
        noColumnsA = input.nextInt();
        System.out.print("Enter the number of rows in matrix B: ");
        noRowsB = input.nextInt();
        System.out.print("Enter the number of columns in matrix B: ");
        noColumnsB = input.nextInt();
        // Consumes leftover \n that nextInt leaves behind so inputting matrix section works
        input.nextLine();

        // Check multiplication can occur
        if (noColumnsA != noRowsB) {
            System.out.println("The number of columns in matrix A does not equal the number of rows in matrix B and therefore the operation A*B cannot be completed");
        }
        else {
            // Add rows of matrix A to list
            for (int i = 0; i < noRowsA; i++) {
                System.out.print("Enter row " + (i+1) + " of matrix A: ");
                matrixRowsA.add(input.nextLine());
                // Check the number of integers entered = the number of columns stated
                if (matrixRowsA.get(i).split(" ").length != noColumnsA) {
                    System.out.println("The incorrect amount of numbers were provided for this row.");
                    exit(0);
                }
            }
            // Add columns of matrix B to list
            for (int i = 0; i < noColumnsB; i++) {
                System.out.print("Enter column " + (i+1) + " of matrix B: ");
                matrixColumnsB.add(input.nextLine());
                // Check the number of integers entered = the number of rows stated
                if (matrixColumnsB.get(i).split(" ").length != noRowsB) {
                    System.out.println("The incorrect amount of numbers were provided for this column.");
                    exit(0);
                }
            }

            for (int i = 0; i < matrixRowsA.size(); i++) {
                // Split row into singular numbers
                a = matrixRowsA.get(i).split(" ");
                for (int x =0; x < matrixColumnsB.size(); x++) {
                    // Split column into singular numbers
                    b = matrixColumnsB.get(x).split(" ");
                    // Apply formula and add final value to ans list
                    ans.add(formula(0));
                }
            }
            // Prints ans in matrix format
            for (int i = 0; i < ans.size(); i++) {
                if (i % noColumnsB == 0) {
                    System.out.println();
                }
                System.out.print(ans.get(i) + " ");
            }
        }
    }

    public static int formula(int position) {
        if (position < a.length) {
            return Integer.parseInt(a[position])*Integer.parseInt(b[position]) + formula(position+1);
        }
        else {
            return 0;
        }
    }
}