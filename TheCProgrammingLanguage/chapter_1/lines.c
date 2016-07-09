#include <stdio.h>
// counts number of lines in input
main(){
    int c, lines = 0;
    while((c = getchar()) != EOF)
        if(c == '\n')
            lines++; 
    printf("%d lines\n",lines);
}
