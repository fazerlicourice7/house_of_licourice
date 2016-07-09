//EX 2.4 and 2.5

#include <stdio.h>
#include <stdbool.h>

/*
Exercise 2-4. Write an alternative version of squeeze(s1,s2) that deletes each character
in s1 that matches any character in the string s2.

Exercise 2-5. Write the function any(s1,s2) , which returns the first location in a
string s1 where any character from the string s2 occurs, or -1 if s1 contains no 
characters from s2.
 */

#define MAXLENGTH 100

char s1[MAXLENGTH],s2[MAXLENGTH];

void getLine(char[]);
void squeeze(char[], char[]);
int any(char[],char[]);
bool isCharinStr(char, char[]);

main(){
    getLine(s1);
    //printf("got input 1: %s\n", s1);
    getLine(s2);
    //printf("got input 2: %s\n", s2);
    int a = any(s1,s2);
    printf("any(): %d\n", a);
    squeeze(s1,s2);
    printf("squeeze(): %s\n", s1);
    return 0;
}

void getLine(char s[]){
    int current = 0;
    char c;
    while((c=getchar()) != '\n'){
        s[current] = c;
        ++current;
    }
    s[current] = '\0';
}

void squeeze(char s1[], char s2[]){
    int i = 0;
    while(s1[i] != '\0'){
        if(isCharinStr(s1[i], s2)){
            int i1 = i, i2 = i + 1;
            while((s1[i1] = s1[i2]) != '\0'){
                ++i1;
                ++i2;
            }
        }
        ++i;
    }
}

int any(char s1[], char s2[]){
    int i = 0;
    while(s1[i] != '\0'){
        //printf("In loop. current char: %c\n", s1[i]);
        if(isCharinStr(s1[i], s2))
            return i;
        ++i;
    }
    return -1;
}

bool isCharinStr(char c, char s[]){
    int i = 0;
    while(s[i] != '\0'){
        if(s[i] == c)
            return true;
        ++i;
    }
    return false; 
}
