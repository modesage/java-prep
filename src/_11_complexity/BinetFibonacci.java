package _11_complexity;

public class BinetFibonacci {
    public static void main(String[] args) {
        // It’s practical for n up to around 70-80,
        // but beyond that, precision issues may arise.
        System.out.println(fiboFormula(10));
    }
    static int fiboFormula(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be a non-negative integer.");
        }

        // Binet's formula components
        double phi = (1 + Math.sqrt(5)) / 2;  // Golden ratio
        double psi = (1 - Math.sqrt(5)) / 2;  // Conjugate of golden ratio

        // Compute the nth Fibonacci number using Binet's formula
        return (int) Math.round((Math.pow(phi, n) - Math.pow(psi, n)) / Math.sqrt(5));
    }

}
