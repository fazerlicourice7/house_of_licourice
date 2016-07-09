// EX 1.24

#include <stdio.h>
#include "remCom.c"
// program to check a C program for rudimentary syntax errors like
// unmatched parentheses, brackets and braces. Don't forget about quotes, both   
// single and double, escape sequences, and comments.


/* ==============ONLY CHECKS FOR BRACKETS, BRACES & PARANTHESES============*/
#define MAXSIZE 10000

char file[MAXSIZE];

void getFile(char f[], int l);
int unMatchedBrackParanthBrace(char f[], char s, int l);
extern void remComs(char f[]);

main(){
    getFile(file, MAXSIZE);
    remComs(file);
    int current = 0;
    int r;
    while(file[current] != '\0'){
        if(file[current] == '['){
            r = unMatchedBrackPranthBrace(file, file[current], current);
            if(r == -1){
                printf("syntax errors");
            }
        }
    }
    if (r != -1)
        printf("no syntax errors.");
    return 0;
}

void getFile(char file[], int limit){
    char c;
    int chars = 0;
    while((c = getchar()) != EOF && chars < limit){     
        file[chars] = c;
        ++chars;
    }
    file[chars] = '\0';
}

int unMatchedBrackParanthBrace(char file[], char start, int loc){
    /* Returns the index number at which the ending character is located.
       Returns '-1' if the character is unmatched. */
    while(file[loc] != '\0'){
        if(file[loc] == '}' || file[loc] == ')' ||
            file[loc] == ']'){
            return loc;
        } else if ((file[loc] == '(' || file[loc] == '[' || 
                  file[loc] == '{' ) && file[loc-1] != '\'' &&
                  file[loc+1] != '\'' && file[loc-1] != '"' &&
                  file[loc+1] != '"'){
            int result = unMatchedBrackParanthBrace(file, file[loc], loc);
            if(result == -1){
                return -1;
            }
        } else 
            ++loc;
    }
}

/*

Planning on using "remove comments" instead.


bool isLineComment(char file[][], int line){
    int col = 0;
    while(file[line][col] != ' '){
        ++col;
    }
    if(file[line][col] == '/' && file[line][col + 1] == '/'){
        return true;
    }
}*/
