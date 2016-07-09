// EX 2.8

#include <stdio.h>

/* Write a function rightrot(x,n) that returns the value of the integer x rotated
 * to the right by n positions.
 */

unsigned char rightrot(unsigned char, int);

main(){
    unsigned char x = 135;
    int n = 2;
    printf("%u\n", rightrot(x, n));
    return 0;
}

unsigned char rightrot(unsigned char x, int n){
    unsigned char right = x << 8 - n;
    x = x >> n;
    while(right <= 127)
        right *= 2;
    x = x | right;
    return x;
}
