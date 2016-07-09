// EX 3.5

#include <stdio.h>
#include <string.h>

/* Write the function itob(n,s,b) that converts the integer n into a base b
 * character representation in the string s. In particular, itob(n,s,16) formats s as a
 * hexadecimal integer in s.
 */

void itob(int, char[], int);
void reverse(char[]);

main(){
    char s[256];
    char n = 10;
    int b = 16;
    itob(n, s, b);
    printf("%s\n", s);
    return 0;
}


void itob(int n, char s[], int b){
    int i, sign;
    
    if ((sign = n) < 0) /* record sign */
        n = -n; /* make n positive */
    i = 0;
    
    do { /* generate digits in reverse order */
        int j =  n % b;
        s[i++] = (j < 10)? j + '0': j - 10 + 'a'; /* get next digit */
    } while ((n /= b) > 0); /* delete it */
    
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
