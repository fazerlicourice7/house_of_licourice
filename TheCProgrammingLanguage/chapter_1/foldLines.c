// EX 1.22

#include <stdio.h>

// program to 'fold' lines that are 80 chars or longer. Folds only at whitespaces.

# define MAXLENGTH 1000
# define FOLDLENGTH 80

char line[MAXLENGTH];


int getLine(char l[], int p);
void splitLine(char l[], int p);

main(){
    int len = getLine(line, MAXLENGTH);
    splitLine(line, len);
    printf("%s\n",line);
}

int getLine(char line[], int limit){
    char c;
    int len;
    while((c=getchar()) != '\n' && c != EOF && len < limit - 1){
        line[len] = c;
        ++len;
    }
    line[len] = '\0';
    return len;
}

void splitLine(char line[], int len){
    int lines = (len / FOLDLENGTH) + 1;
    int numLines = 0;   
    for(int i = 1; i <= lines; ++i){
        if(numLines < (i - 1)){
            int counter = FOLDLENGTH * (i-1);
            while(counter < len && counter < i * FOLDLENGTH){
                if(line[counter] == ' '){
                    line[counter] = '\n';
                    ++numLines;
                    break;
                }
                counter++;
            } 
        }
        else {
            int counter = FOLDLENGTH * i;
            while(counter < len && counter > (i-1) * FOLDLENGTH){
                if(line[counter] == ' '){
                    line[counter] = '\n';
                    ++numLines;
                    break;
                }
                --counter;
            }
        }
    }
}


