// EX 2.9

#include <stdio.h>

/* In a two's complement number system, x &= (x-1) deletes the rightmost 1-bit
 * in x . Explain why. Use this observation to write a faster version of bitcount .
 */

int bitcount(unsigned);

main(){
    unsigned x = 170;
    printf("%d\n",bitcount(x));
    return 0;
}

int bitcount(unsigned x){
    int b;
    for(b = 0; x != 0; x &= x-1){
        ++b;
    }
    return b;
}
