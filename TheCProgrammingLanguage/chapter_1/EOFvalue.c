#include <stdio.h>

main(){
    int c;
    while((c = getchar()) != EOF)
        printf("%d \n", c); //prints integer value of each character upto EOF
    c = EOF;
    printf("%d", c); // prints integer value of EOF
}
    	
    
    
        
