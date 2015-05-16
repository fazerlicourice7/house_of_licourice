#include <stdio.h>
// counts the number of words in the input. A word is defined as a sequence of characters that doesn't contain a blank, tab or newline.  

main(){
    int words = 0, word, state = 0;
    while((word = getchar()) != EOF){
        if(word != ' ' && state == 0||word != '\t' && state == 0||word != '\n' && state == 0)
            words++;        
        if(word == ' '||word == '\t'||word == '\n')
            state = 0;
        else 
            state = 1;
    }
    printf("%d\n",words);
}
 
