// EX 3.3

#include <stdio.h>
#include <ctype.h>

/* Write a function expand(s1,s2) that expands shorthand notations like a-z in
 * the string s1 into the equivalent complete list abc...xyz in s2. Allow for letters
 * of either case and digits, and be prepared to handle cases like a-b-c and a-z0-9 and
 * -a-z. Arrange that a leading or trailing - is taken literally.
 */

#define MAXSIZE 1000

char line[MAXSIZE], final[MAXSIZE];

void getLine(char[], int);
void expand(char[], char[]);


main(){
    getLine(line, MAXSIZE);
    expand(line, final);
    printf("%s\n", final);
    return 0;
}

void getLine(char line[], int lim){
    char c;
    int charC = 0;
    while((c = getchar()) != '\n' && c != EOF && charC < lim - 1){
        line[charC] = c;
        ++charC;
    }
    line[charC] = '\0';
}

void expand(char s1[], char s2[]){
    int i; // index for first string
    int j; // index for 2nd string
    
    for(i = 0, j = 0; s1[i] != '\0'; ++i){
        if(isalnum(s1[i]) && s1[i+1] == '-'){
            char c = s1[i];
            char end;
            if(s1[i+2] == ' '){
                if(isdigit(s1[i])){
                    end = '9';
                } else if(isalpha(s1[i])){
                    end = islower(s1[i])?'z':'Z';
                }
            } else {
                end = s1[i+2];
            }
            for(char c = s1[i]; c < end; ++c){
                s2[j++] = c;
            }
            if(s1[i+2] == ' '){
                s2[j++] = end;
            }
            ++i;
        } 
        else{
            s2[j++] = s1[i];
        }
    }
    s2[j] = '\0';
}
