package org.example.includes;

import java.util.Scanner;

public class conditional {

    private condition Condition;

    public conditional() {}

    public conditional(condition C) {
        this.Condition = C;
    }

    public int move(Scanner universal_stream) {

        int integer = universal_stream.nextInt();
        if (Condition.pass_condition(integer)) {
            return integer;
        }
        return -1;
    }

    public int moveif(Scanner by_stream, condition Cotn) {

        int integer = by_stream.nextInt();
        if (Cotn.pass_condition(integer)) {
            return integer;
        }
        return -1;
    }

    public String moveif(Scanner by_stream, condition Cotn, String object) {

        StringBuilder container = new StringBuilder();
        while (by_stream.hasNext()) {
            String token = by_stream.next();
            for (char ch : token.toCharArray()) {
                if (Cotn.pass_condition(ch)) {
                    container.append(ch);
                }
            }
        }
        return container.toString();
    }

    public String getline(Scanner stream, String string_container) {

        return "";
    }
}
