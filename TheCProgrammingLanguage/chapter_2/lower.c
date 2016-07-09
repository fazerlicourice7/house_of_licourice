// EX 2.10

#include <stdio.h>

/* Rewrite the function lower , which converts upper case letters to lower case,
 * with a conditional expression instead of if-else .
 */

char lower(char);

main(){
    printf("enter a char to convert to lower case.\n");
    printf("%c\n", lower(getchar()));
    return 0;
}

char lower(char c){
    return (c >= 'A' && c <= 'Z')? (c + 'a' - 'A') : c;
}
