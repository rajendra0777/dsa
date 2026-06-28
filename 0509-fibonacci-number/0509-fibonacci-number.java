/*
TC: o(n)
SC: o(n) // stack space
Approach : Call current and previous function and sum the result
*/
class Solution {
    public int fib(int n) {

        // base cases
        if (n == 0)
            return 0;
        if (n == 1 || n == 2)
            return 1;

        // recursive function call
        return fib(n - 1) + fib(n - 2);
    }
}
/*  DE-BUG
    Base case   n = 1 => 0 +  0 = 1 
	base case	n = 2 => 1 + 0 = 1
		        n = 3 => 1 + 0 = 2
		n = 4 => 1 + 1 = 3
		n = 5 => 2 + 1 = 5
		n = 6 => 3 + 2 = 8
		n = 7 => 5 + 3 = 13
		n = 8 => 8 + 5 = 21
		*/