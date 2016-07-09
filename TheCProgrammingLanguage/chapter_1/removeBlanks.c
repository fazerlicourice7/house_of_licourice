// EX 1.18

#include <stdio.h>

// program to remove all trailing blanks and tabs in each line and remove blank
// lines

#define MAXLENGTH 1000

char line[MAXLENGTH];
char lines[MAXLENGTH][MAXLENGTH];
int lineNum = 0;

int getLine(char line[], int lim);
void removeEnd(char in[], int len);

main(){
    int len = 0;
    while((len = getLine(line,MAXLENGTH)) > 0){
        if(len != 1){
            removeEnd(line, len);
            int i = 0;
            while((lines[lineNum][i] = line[i]) != '\0')
                ++i;
            lineNum++;
        }     
    }
    printf("\n");
    for(int j = 0; j < lineNum; j++){
        printf("%s",lines[j]);
    } 
}

int getLine(char line[], int lim){
    char c;
    int len = 0;
    while((c=getchar()) != '\n' && c != EOF && len < lim - 1){
        line[len] = c;
        ++len;
    }
    if(c == '\n'){
        line[len] = c;
        ++len;
    }
    line[len] = '\0';
    return len;
}

void removeEnd(char in[], int len){
    while(in[len] == ' ' || in[len] == '\t' || in[len] == '\0'){
        in[len] = '\0';
        --len;
    }
}
