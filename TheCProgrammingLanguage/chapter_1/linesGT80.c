// EX 1.17

#include <stdio.h>

// prints all the lines that are longer than 80 characters long.

# define MAXLENGTH 80
# define LIMIT 1000

char line[LIMIT];

int getLine(char line[], int lim);

main(){
    int length = getLine(line, LIMIT);
    while(length > 0){
        if(length > 80)
            printf(">80:%s\n", line);
        else
            printf("\n");
        length = getLine(line, LIMIT);
    }
    return 0;
}

int getLine(char line[], int lim){
    int length = 0;
    char c;
    while((c = getchar()) != '\n' && c != EOF && length < lim -1){
        line[length] = c;
        ++length;
    }
    line[length] = '\0';

    return length;
}
