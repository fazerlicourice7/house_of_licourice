#include <stdio.h>
//prints histogram of the frequencies of characters in the input

int main(){
    int letters[25], input, i;
    for(i = 0; i < 26; i++)
        letters[i] = 0;
    while((input = getchar()) != '\n'){
        if(input == 'A'||input == 'a')
            letters[0]++;
        else if(input == 'B'||input == 'b')
            letters[1]++;
        else if(input == 'C'||input == 'c')
            letters[2]++;
        else if(input == 'D'||input == 'd')
            letters[3]++;
        else if(input == 'E'||input == 'e')
            letters[4]++;
        else if(input == 'F'||input == 'f')
            letters[5]++;
        else if(input == 'G'||input == 'g')
            letters[6]++;
        else if(input == 'H'||input == 'h')
            letters[7]++;
        else if(input == 'I'||input == 'i')
            letters[8]++;
        else if(input == 'J'||input == 'j')
            letters[9]++;
        else if(input == 'K'||input == 'k')
            letters[10]++;
        else if(input == 'L'||input == 'l')
            letters[11]++;
        else if(input == 'M'||input == 'm')
            letters[12]++;
        else if(input == 'N'||input == 'n')
            letters[13]++;
        else if(input == 'O'||input == 'o')
            letters[14]++;
        else if(input == 'P'||input == 'p')
            letters[15]++;
        else if(input == 'Q'||input == 'q')
            letters[16]++;
        else if(input == 'R'||input == 'r')
            letters[17]++;
        else if(input == 'S'||input == 's')
            letters[18]++;
        else if(input == 'T'||input == 't')
            letters[19]++;
        else if(input == 'U'||input == 'u')
            letters[20]++;
        else if(input == 'V'||input == 'v')
            letters[21]++;
        else if(input == 'W'||input == 'w')
            letters[22]++;
        else if(input == 'X'||input == 'x')
            letters[23]++;
        else if(input == 'Y'||input == 'y')
            letters[24]++;
        else if(input == 'Z'||input == 'z')
            letters[25]++;
    }
   // for(i = 0; i < 26; i++)
       // printf("%d\n", letters[i]);
    int loop = 0;
    printf("a: ");
    for(loop = 0; loop < letters[0]; loop++)
        printf("*");
    printf("\nb: ");
    for(loop = 0; loop < letters[1]; loop++)
        printf("*");
    printf("\nc: ");
    for(loop = 0; loop < letters[2]; loop++)
        printf("*");
    printf("\nd: ");
    for(loop = 0; loop < letters[3]; loop++)
        printf("*");
    printf("\ne: ");
    for(loop = 0; loop < letters[4]; loop++)
        printf("*");
    printf("\nf: ");
    for(loop = 0; loop < letters[5]; loop++)
        printf("*");
    printf("\ng: ");
    for(loop = 0; loop < letters[6]; loop++)
        printf("*");
    printf("\nh: ");
    for(loop = 0; loop < letters[7]; loop++)
        printf("*");
    printf("\ni: ");
    for(loop = 0; loop < letters[8]; loop++)
        printf("*");
    printf("\nj: ");
    for(loop = 0; loop < letters[9]; loop++)
        printf("*");
    printf("\nk: ");
    for(loop = 0; loop < letters[10]; loop++)
        printf("*");
    printf("\nl: ");
    for(loop = 0; loop < letters[11]; loop++)
        printf("*");
    printf("\nm: ");
    for(loop = 0; loop < letters[12]; loop++)
        printf("*");
    printf("\nn: ");
    for(loop = 0; loop < letters[13]; loop++)
        printf("*");
    printf("\no: ");
    for(loop = 0; loop < letters[14]; loop++)
        printf("*");
    printf("\np: ");
    for(loop = 0; loop < letters[15]; loop++)
        printf("*");
    printf("\nq: ");
    for(loop = 0; loop < letters[16]; loop++)
        printf("*");
    printf("\nr: ");
    for(loop = 0; loop < letters[17]; loop++)
        printf("*");
    printf("\ns: ");
    for(loop = 0; loop < letters[18]; loop++)
        printf("*");
    printf("\nt: ");
    for(loop = 0; loop < letters[19]; loop++)
        printf("*");
    printf("\nu: ");
    for(loop = 0; loop < letters[20]; loop++)
        printf("*");
    printf("\nv: ");
    for(loop = 0; loop < letters[21]; loop++)
        printf("*");
    printf("\nw: ");
    for(loop = 0; loop < letters[22]; loop++)
        printf("*");
    printf("\nx: ");
    for(loop = 0; loop < letters[23]; loop++)
        printf("*");
    printf("\ny: ");
    for(loop = 0; loop < letters[24]; loop++)
        printf("*");
    printf("\nz: ");
    for(loop = 0; loop < letters[25]; loop++)
        printf("*");
    printf("\n");
}
