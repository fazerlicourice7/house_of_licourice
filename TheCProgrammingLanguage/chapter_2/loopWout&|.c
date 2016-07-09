// EX 2.2

#include <stdio.h>

/* Write a loop equivalent to the for loop above 
 {
 for (i=0; i < lim-1 && (c=getchar()) != '\n' && c != EOF; ++i)
     s[i] = c; 
 }
 without using && or || .
 */

main(){
    int lim =1000;
    char c, s[lim];
    int i;
    for(i = 0; i < lim-1; ++i){
        if((c=getchar()) != '\n'){
            if(c != EOF){
                s[i] = c;
            } else {
                break;
            }
        } else {
            break;
        }
    }
    s[i] = '\0';
    printf("%s\n", s);
    return 0;
}
