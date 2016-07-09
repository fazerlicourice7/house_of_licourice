// EX 4.2

#include <stdio.h>
#include <ctype.h>
#include <math.h>

/* Extend atof to handle scientific notation of the form 123.45e-6 where a 
 * floating-point number may be followed by e or E and an optionally signed exponent.
 */

int getLine(char[], int);
double atof(char[]);
void startStrAt(char[], int);

#define MAXLENGTH 256

main(){
    char number[MAXLENGTH];
    getLine(number, MAXLENGTH);
    printf("%f\n", atof(number));    
    return 0;
}

int getLine(char s[], int lim){
    char c;
    int i = 0;
    while (--lim > 0 && (c=getchar()) != EOF && c != '\n')
        s[i++] = c;
    /*if (c == '\n')
        s[i++] = c;*/
    s[i] = '\0';
    return i;
}

double atof(char s[]){    
    double val, power;
    int i, sign;
    
    for (i = 0; isspace(s[i]); i++); /* skip white space */
    sign = (s[i] == '-') ? -1 : 1;
    if (s[i] == '+' || s[i] == '-')
        i++;
    for (val = 0.0; isdigit(s[i]); i++)
        val = 10.0 * val + (s[i] - '0');
    if (s[i] == '.')
        i++;
    for (power = 1.0; isdigit(s[i]); i++) {
        val = 10.0 * val + (s[i] - '0');
        power *= 10;
    } 
    double part1 = sign * val / power, part2 = 1.0;
    printf("part1 = %f\n", part1);
    if(tolower(s[i++]) == 'e') {
        int sign2 = (s[i++] == '-') ? -1 : 1;
        startStrAt(s, --i);
        double exp = atof(s);
        part2 = pow(10, exp);
    }
    return part1 * part2;
}

void startStrAt(char s[], int start){
    int i = 0, j = start;
    
    while(!isspace(s[j]))
        s[i++] = s[j++];
    s[i] = '\0';
}
