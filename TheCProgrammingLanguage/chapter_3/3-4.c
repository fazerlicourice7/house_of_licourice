// EX 3.4

/* In a two's complement number representation, our version of itoa does not
 * handle the largest negative number, that is, the value of n equal to -(2 wordsize-1 ).
 * Explain why not. Modify it to print that value correctly, regardless of the machine
 * on which it runs.
 */

/* The reason the given version of itoa doesn't work for the largest negative number in
 * a two's complement system is because values range from -(2^(bits-1)) to (2^(bits-1)-1)
 * This is because 0 is also a number that has to be represented, and the total number
 * of representable values is even. Therefore there are not equal amounts of values on
 * either side of 0.
 */

#include <stdio.h>
//#include <ctype.h>
#include <stdbool.h>
#include <string.h>

void itoa(int , char[]);
void reverse(char[]);
main(){
    char s[256];
    char n = -128;
    itoa(n, s);
    printf("%s\n", s);
    return 0;
}

void itoa(int n, char s[]){
    int i, sign;
    bool negative = false;
    if ((sign = n) < 0){ /* record sign */
        negative = true;
        ++n;
        n = -n; /* make n positive */
    }
    i = 0;
    if(negative){
        s[i++] = ((n % 10) + 1) + '0';
    } else {
        s[i++] = n % 10 + '0';
    }
    while ((n /= 10) > 0) {   /* generate digits in reverse order */
        s[i++] = n % 10 + '0';   /* get next digit */
    }
    if (sign < 0)
        s[i++] = '-';
    s[i] = '\0';
    reverse(s);
}

void reverse(char s[]){
    int length = strlen(s) ;
    int c, i, j;

    for (i = 0, j = length - 1; i < j; i++, j--)
    {
        c = s[i];
        s[i] = s[j];
        s[j] = c;
    }
}
