// EX 3.6

#include <stdio.h>
#include <string.h>

/* Write a version of itoa that accepts three arguments instead of two. The third
 * argument is a minimum field width; the converted number must be padded with blanks on
 * the left if necessary to make it wide enough.
 */

void itoa(int, char[], int);
void reverse(char[]);

main(){
    char s[256];
    char n = -10;
    int minW = 7;
    itoa(n, s, minW);
    printf("%s\n", s);
    return 0;
}

void itoa(int n, char s[], int minWid){
    int i, sign;
    if ((sign = n) < 0) /* record sign */
        n = -n; /* make n positive */
    i = 0;
    do { /* generate digits in reverse order */
        s[i++] = n % 10 + '0'; /* get next digit */
    } while ((n /= 10) > 0); /* delete it */
    if (sign < 0)
        s[i++] = '-';
    while(i < minWid){
        s[i++] = ' ';
    }
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
