package dynamic_programming;
/*
The Tribonacci sequence Tn is defined as follows:

T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.

Given n, return the value of Tn.
 */

public class Tribonacci {
    public int tribonacci(int n) {
        if(n == 0)
            return 0;
        if(n == 1)
            return 1;
        if(n == 2 )
            return 1;
        int first = 0, second = 1, third = 1;
        for(int i=3;i<=n;i++){
            int current = first + second + third;
            first = second;
            second = third;
            third = current;
        }
        return third;
    }
}
