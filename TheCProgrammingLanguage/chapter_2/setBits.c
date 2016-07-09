//EX 2.6

#include <stdio.h>
#include <math.h>

/* Write a function setbits(x,p,n,y) that returns x with the n bits that begin at
 * position p set to the rightmost n bits of y , leaving the other bits unchanged.
*/

#define BINARYMAX 9
#define MAXDEC 2

int getLine(char[]);
unsigned setbits(unsigned char, int, int, unsigned char);
void printBin(unsigned char);

char x[BINARYMAX], p[MAXDEC], n[MAXDEC], y[BINARYMAX];

main(){
    printf("Enter  2 integers <= 7 on new lines.\n");
    printf("Function: setbits(x,p,n,y) that returns x with the n bits that begin at" 
           " position p set to the rightmost n bits of y , leaving the other bits"
           " unchanged.\n");
    getLine(p);
    getLine(n);

    unsigned X = 170;
    int P = p[0] - '0';
    int N = n[0] - '0';
    unsigned Y = 255;
    /*for(int i = 0; i < lenX; ++i){
        X += x[i] * pow(2, lenX-1-i);
    }
    for(int i = 0; i < lenY; ++i){
        Y += y[i] * pow(2, lenY-1-i);
    }
    printf("x: %u, ", X);
    printBin(X);
    printf("\n");
    printf("Y: %u, ", Y);
    printBin(Y);
    printf("\n");*/
    unsigned char var = setbits(X,P,N,Y);
    printBin(var);
    printf("\n");
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

unsigned setbits(unsigned char x, int p, int n, unsigned char y){
    unsigned char partY = (y & ~(~0 << n)) << p+1-n;
    /*printf("partY: ");
    printBin(partY);
    printf("\n");*/
    unsigned char andX = ~(~(~0 << n) << p+1-n);
    /*printf("andX: ");
    printBin(andX);
    printf("\n");*/
    unsigned char x2 = x & andX;
    /*printf("x after andX: ");
    printBin(x2);
    printf("\n");*/
    unsigned char x3 = x2 | partY;
    /*printf("x after partY: ");
    printBin(x3);
    printf("\n");*/
    return x3;
}

void printBin(unsigned char n){   
    if (n > 1)
        printBin(n/2);
 
    printf("%d", n % 2);
}
