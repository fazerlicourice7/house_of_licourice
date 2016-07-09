// EX 1.19

#include <stdio.h>

// a program that reverses the input, one line at a time.

# define MAXLENGTH 1000

char line[MAXLENGTH];

void reverse(char l[], int length);
int getLine(char l[], int lim);

main(){
    int len = 0;
    while((len = getLine(line, MAXLENGTH)) != 0){
        reverse(line,len);
        printf("%s\n",line);
    }
    return 0;
}

int getLine(char line[], int lim){
    char c;
    int charC = 0;
    while((c = getchar()) != '\n' && c != EOF && charC < lim - 1){
        line[charC] = c;
        ++charC;
    }
    return charC;
}

void reverse(char line[], int len){
    int i1 = 0, i2 = len-1;
    char temp;
    while(i1 < len/2){
        temp = line[i1];
        line[i1] = line[i2];
        line[i2] = temp;
        ++i1;
        --i2;
    }
    line[len] = '\0';
}
