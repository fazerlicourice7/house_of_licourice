// EX 1.21

#include <stdio.h>

// Program to replace blank spaces with minimum tabs and blank spaces required to fill that space.

# define MAXLENGTH 1000
# define tSTOP 8

char line[MAXLENGTH];

int tab(char line[], int current, int len, int spaces);

main(){
    int current = 0;   // the number of chars since the last tStop.
    int len = 0;      // the number of characters in the string.
    int spaces = 0;  // counts the number of spaces in this gap.
    char c;
    
    while((c=getchar()) != '\n' && len < MAXLENGTH - 1){
        current = len % tSTOP;
        if(c == ' '){
            spaces = 0;
            while(c == ' '){
                spaces++;
                c = getchar();
            }
            len = tab(line, current, len, spaces);
        }
        line[len] = c;
        len++;
    }
    line[len] = '\0';
    printf("%s\n",line);
}

int tab(char line[], int current, int len, int spaces){
    //printf("%d\n",spaces);
    while(spaces > (tSTOP - current)){
        spaces -= (tSTOP - current);
        current = 0;
        line[len] = '\t';
        len++;
    }
    while(spaces > 0){
        --spaces;
        line[len] = ' ';
        len++;
    }
    return len;
}
