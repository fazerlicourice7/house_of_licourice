#include <stdio.h>
#include <stdbool.h>

//prints all lines that are greater than 80 characters in length.
#define MAXLENGTH 1000
#define MAXLINES 100

main(){
    printf("Enter stuff\n");
    char cline[MAXLINES][MAXLENGTH];
    int a, b, input, loop1, loop, length, line = 0, loop2;
    bool lines[MAXLINES];
    for(a = 0; a < MAXLINES; a++)
        for(b = 0; b < MAXLENGTH; b++)
            cline[a][b] = ' ';
    for (loop = 0; loop < MAXLINES; loop++)
        lines[loop] = false;
    while((input = getchar()) != EOF){
        for(loop = 0; loop < MAXLENGTH; loop++){
            cline[line][loop] = (char)input;
            length++;
            if(input == '\n')
                break;
            input = getchar();
        }
        if(length > 80)
            lines[line] = true;
        line++;
    }
    printf("Lines that are longer than 80 characters are:\n");
    for(loop1 = 0; loop1 < MAXLINES; loop1++){
        if (lines[loop1] == true)
            for(loop2 = 0; loop2 < MAXLENGTH; loop2++)
                putchar(cline[loop1][loop2]);
        printf("\n");
    }
}

