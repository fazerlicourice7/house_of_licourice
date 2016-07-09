// EX 3.2

#include <stdio.h>

/* Write a function escape(s,t) that converts characters like newline and tab into
 * visible escape sequences like \n and \t as it copies the string t to s. Use a switch.
 * Write a function for the other direction as well, converting escape sequences into
 * the real characters.
 */

#define MAXLENGTH 1000

char file[MAXLENGTH], newFile1[MAXLENGTH], newFile2[MAXLENGTH];

void getFile(char[], int);
void escape(char[], char[]);
void escapeBack(char[], char[]);

main(){
    getFile(file, MAXLENGTH);
    escape(file,newFile1);
    printf("%s\n", newFile1);
    escapeBack(newFile1, newFile2);
    printf("%s\n", newFile2);
    return 0;
}

void getFile(char file[], int limit){
    char c;
    int currentChar = 0;
    while((c = getchar()) != EOF && currentChar < limit -1){
        file[currentChar] = c;
        currentChar++;
    }
    file[currentChar] = '\0';
}

void escape(char from[], char to[]){
    int currentF = 0, currentT = 0;
    while(from[currentF] != '\0'){
        switch(from[currentF]){
            case '\n': 
                to[currentT] = '\\';
                to[currentT + 1] = 'n';
                ++currentT;
                break;
            case '\t':
                to[currentT] = '\\';
                to[currentT + 1] = 't';
                ++currentT;
                break;
            default:
                to[currentT] = from[currentF];
                break;
        }
        ++currentF;
        ++currentT;
    }
}

void escapeBack(char from[], char to[]){
    int currentF = 0, currentT = 0;
    while(from[currentF] != '\0'){
        switch(from[currentF]){
            case '\\':
                switch(from[currentF + 1]){
                    case 'n':
                        to[currentT] = '\n';
                        ++currentF;
                        break;
                    case 't':
                        to[currentT] = '\t';
                        ++currentF;
                        break;
                    default:
                        to[currentT] = from[currentF];
                        break;
                }
                break;
            default:
                to[currentT] = from[currentF];
                break;
        }
        ++currentF;
        ++currentT;
    }
}
