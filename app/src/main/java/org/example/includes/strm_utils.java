package org.example.includes;

import java.util.Scanner;

public class strm_utils {

    public static int get(Scanner by_stream, condition Condition) {

        while (true) {

            try {

                int i = by_stream.nextInt();
                if (Condition.pass_condition(i - 1)) {
                    return i;
                } else {
                    System.out.println("invalid data");
                }

            } catch (Exception e) {
                System.out.println("invalid data");
                by_stream.nextLine();
            }
        }
    }
}
