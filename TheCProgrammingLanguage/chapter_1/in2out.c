#include <stdio.h>

main(){
    char character;
    while((character = getchar()) != EOF){
        if(character == ' ')
            printf("\n");
        else
            printf("%c", character);
    }
}
