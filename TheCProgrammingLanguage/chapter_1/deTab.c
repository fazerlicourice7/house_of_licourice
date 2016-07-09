// EX 1.20

# include<stdio.h>

// removes tabs and replaces them with spaces. Assume tab width is 4 characters.

# define MAXLENGTH 1000
# define tSTOP 8

char line[MAXLENGTH];

main(){
    char c;
    int len = 0;
    int current = 0;
    while((c=getchar()) != '\n' && len < MAXLENGTH - 1){
        current = len % tSTOP;
        if(c == '\t'){
            for(int i = 0; i < tSTOP - current;i++){
                line[len] = ' ';
                len++;
            }
        }
        else{
            line[len] = c;
            len++;
        }
    }
    line[len] = '\0';
    printf("%s\n", line);
}
