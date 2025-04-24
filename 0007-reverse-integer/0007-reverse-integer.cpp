class Solution {
public:
    int reverse(int x) {
        long reversed_number = 0;
        while (x != 0) {
            int remainder = x % 10;
            reversed_number = reversed_number * 10 + remainder;
            x /= 10;
        }
        if (reversed_number > INT_MAX || reversed_number < INT_MIN)
            return 0; // Handle integer overflow
        return static_cast<int>(reversed_number);
    }
};