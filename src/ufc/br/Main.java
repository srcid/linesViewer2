package ufc.br;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void printLines(BufferedReader bReader, Integer p, Integer q) {

        try {
            if (bReader.ready()) {

                if (p == -1 && q == -1) {
                    bReader
                            .lines()
                            .forEach( i -> System.out.println(i) );
                }
                else if (p == -1) {
                    bReader
                            .lines()
                            .limit(q - 1)
                            .forEach( i -> System.out.println(i) );
                }
                else if (q == -1) {
                    bReader
                            .lines()
                            .skip(p)
                            .forEach( i -> System.out.println(i) );
                } else {
                    bReader
                            .lines()
                            .limit(q - 1)
                            .skip(p - 1)
                            .forEach(i -> System.out.println(i));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        String filename = "",
                n1 = "",
                n2 = "";
        Integer p = -1,
                q = -1;
        File pFile = null;
        FileReader fReader = null;
        BufferedReader bReader = null;
        Scanner scan = new Scanner(System.in);


        System.out.println(
                " ▄▄▄     ▄▄▄ ▄▄    ▄ ▄▄▄▄▄▄▄    ▄▄   ▄▄ ▄▄▄ ▄▄▄▄▄▄▄ ▄     ▄ ▄▄▄▄▄▄▄ ▄▄▄▄▄▄   \n" +
                "█   █   █   █  █  █ █       █  █  █ █  █   █       █ █ ▄ █ █       █   ▄  █  \n" +
                "█   █   █   █   █▄█ █    ▄▄▄█  █  █▄█  █   █    ▄▄▄█ ██ ██ █    ▄▄▄█  █ █ █  \n" +
                "█   █   █   █       █   █▄▄▄   █       █   █   █▄▄▄█       █   █▄▄▄█   █▄▄█▄ \n" +
                "█   █▄▄▄█   █  ▄    █    ▄▄▄█  █       █   █    ▄▄▄█       █    ▄▄▄█    ▄▄  █\n" +
                "█       █   █ █ █   █   █▄▄▄    █     ██   █   █▄▄▄█   ▄   █   █▄▄▄█   █  █ █\n" +
                "█▄▄▄▄▄▄▄█▄▄▄█▄█  █▄▄█▄▄▄▄▄▄▄█    █▄▄▄█ █▄▄▄█▄▄▄▄▄▄▄█▄▄█ █▄▄█▄▄▄▄▄▄▄█▄▄▄█  █▄█\n");

        System.out.print("filename: ");
        filename = scan.nextLine();
        System.out.print("n1: ");
        n1 = scan.nextLine();
        System.out.print("n2: ");
        n2 = scan.nextLine();

        try {
            p = Integer.parseInt(n1);
        } catch (NumberFormatException e) {
//            System.out.println(e.getMessage());
        }

        try {
            q = Integer.parseInt(n2);
        } catch (NumberFormatException e) {
//            System.out.println(e.getMessage());
        }

        try {
            pFile = new File(filename);
            fReader = new FileReader(pFile);
            bReader = new BufferedReader(fReader);

            printLines(bReader, p, q);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
