#include <stdio.h>
//counts spaces, tabs, and lines
main(){
    int counter, spaces, lines, tabs = 0;
    while((counter = getchar()) != EOF){
        if(counter == '\t') //counts number of tabs
            tabs++;     
        if(counter == '\n') // counts number of lines
            lines++;
        if(counter == ' ') // counts number of spaces
            spaces++;
    }
    printf("%d spaces %d tabs & %d lines\n", spaces, tabs, lines);
}
