#include <stdio.h>

void main(){
    int spaces, counter;
    while((counter = getchar()) != EOF){
        if(counter == ' ')
            spaces++;
        else if (counter != ' '){
            if(spaces > 0)
                putchar(' ');
            spaces = 0;
            putchar(counter);  
        }
    }
}
