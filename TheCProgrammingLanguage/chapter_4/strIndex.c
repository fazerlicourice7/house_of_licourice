// EX 4.1

#include <stdio.h>
#include <string.h>

/* Write the function strindex(s,t) which returns the position of the rightmost
 * occurrence of t in s , or -1 if there is none.
 */

#define MAXLENGTH 256

int strindex(char[], int, char[], int, int);
int getLine(char[], int);
void reverse(char[]);

main(){
    char line[MAXLENGTH], phrase[MAXLENGTH];
    int lineLen = getLine(line, MAXLENGTH);
    int pLen = getLine(phrase, MAXLENGTH);
    printf("%d\n", strindex(line, lineLen, phrase, pLen, MAXLENGTH));
    return 0;
}

int getLine(char s[], int lim){
    char c;
    int i = 0;
    while (--lim > 0 && (c=getchar()) != EOF && c != '\n')
        s[i++] = c;
    /*if (c == '\n')
        s[i++] = c;*/
    s[i] = '\0';
    return i;
}

int strindex(char s[], int sLen, char t[], int tLen, int max){
    int i = sLen - 1, j, k;
    
    while(i >= 0) {

        j=i;
        k=tLen - 1;
        
        while ( k >= 0) {
            if(s[j] != t[k])
                break;
            --j;
            --k;            
        }

        if (k < 0)
            return j + 1; // +1 because j decrements after each check, including the 
                          //  last one.
        --i;
    }
    return -1;
}
