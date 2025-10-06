package org.example.includes;

public class range extends condition {

    private int lower_bound;
    private int upper_bound;
    private char lower_upper_choice;

    public range(int upper, int lower) {
        this.lower_bound = lower;
        this.upper_bound = upper;
        this.lower_upper_choice = 'n';
    }

    public range(char lower_upper, int bound) {
        if (lower_upper == 'u') this.upper_bound = bound;
        if (lower_upper == 'l') this.lower_bound = bound;
        this.lower_upper_choice = lower_upper;
    }

    @Override
    public boolean pass_condition(int i) {

        if (lower_upper_choice == 'n') {
            return (i > lower_bound && i < upper_bound);
        }

        if (lower_upper_choice == 'l') {
            return (i > lower_bound);
        }

        if (lower_upper_choice == 'u') {
            return (i < upper_bound);
        }

        return false;
    }

    @Override
    public void output_range() {
        System.out.println("upper bound " + upper_bound);
        System.out.println("lower bound " + lower_bound);
    }
}
