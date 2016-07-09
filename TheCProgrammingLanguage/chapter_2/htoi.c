//EX 2.3

#include <stdio.h>
#include <math.h>
#include <ctype.h>

/* Write a function htoi(s) , which converts a string of hexadecimal digits 
(including an optional 0x or 0X ) into its equivalent integer value. 
The allowable digits are 0 through 9 , a through f , and A through F.
 */

#define MAXDIGITS 30

char num[MAXDIGITS];

int hex2Dec(char[], int);
void getIn(char[], int);
int remPre(char[]);
double pow(double,double);

main(){
    getIn(num, MAXDIGITS);
    int digits = remPre(num);
    long value = hex2Dec(num, digits);
    printf("%ld\n",value);
    return 0;
}

/*
 * Takes a hexadecimal string without the 0x prefix, and converts it to base 10.
 */
int hex2Dec(char hex[], int digits){
    int result = 0, I = 0;
    while(digits > 0){
        int currentDig;
        if(isdigit(hex[I])){
            currentDig = hex[I] - '0';
        } else{
            char c = tolower(hex[I]);
            if(c == 'a')
                currentDig = 10;
            else if(c =='b')
                currentDig = 11;
            else if(c =='c')
                currentDig = 12;
            else if(c =='d')
                currentDig = 13;
            else if(c =='e')
                currentDig = 14;
            else if(c =='f')
                currentDig = 15;
        }
        result += currentDig * (int) (pow(16, digits - 1));
        ++I;
        --digits;
    }
    return result;
}

void getIn(char num[], int digiLim){
    int digi = 0;
    char c;
    while(digi < digiLim -1 && (c=getchar()) != '\n' && c != EOF){
        num[digi] = c;
        ++digi;
    }
    num[digiLim] = '\0';
    //printf("digits b4 remPre: %d", digi);
}

/*
 * Removes the 0x prefix if it is there.
 * Returns the number of digits.
 */
int remPre(char num[]){
    int i1 = 0, i2;
    if(num[0] == '0' && (tolower(num[1]) == 'x')){
        i2 = 2;
    } else{
        i2 = 0;
    }
    while((num[i1] = num[i2]) != '\0'){
        ++i1;
        ++i2;
    }
    //printf("digits: %d", i1);
    return i1;
}
