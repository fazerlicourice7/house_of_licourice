#include <stdio.h>
// count characters in an input
main(){
    int chars = 0;
    while(getchar() != EOF){
        ++chars; // increment value each time a character is read
    }
    printf("%d\n", chars);
}
