#include <stdio.h>

void printBin(unsigned char);

main(){
    unsigned char a = 170;
    unsigned char b = 231;
    unsigned char c = (a & b);
    printBin(c);
    printf(" = %d\n", c);
}

void printBin(unsigned char n){   
    if (n > 1)
        printBin(n/2);
 
    printf("%d", n % 2);
}
