//EX 2.7

#include <stdio.h>

/* Write a function invert(x,p,n) that returns x with the n bits that begin at
 * position p inverted (i.e., 1 changed into 0 and vice versa), leaving the others  
 * unchanged.
*/

#define BINARYMAX 9
#define DECMAX 2

char x[BINARYMAX],p[DECMAX], n[DECMAX];


int getLine(char[]);
void invert(char[], int, int);

main(){
    printf("Enter a number in binary(8 bits).\n");
    getLine(x);
    printf("Enter a number  <= 7 in decimal.\n");
    getLine(p);
    int P = p[0] - '0';
    printf("Enter a number <= the previous number, in decimal.\n");
    getLine(n);
    int N = n[0] - '0';
    invert(x, P, N);
    printf("%s\n", x);
    return 0;
}

int getLine(char s[]){
    int current = 0;
    char c;
    while((c=getchar()) != '\n'){
        s[current] = c;
        ++current;
    }
    s[current] = '\0';
    return current;
}

void invert(char x[], int p, int n){
    for(int i = 0; i < n; ++i){
        int current = x[7 - p + i] - '0';
        x[7 - p + i] = (current == 1)? '0': '1';
    }
}
