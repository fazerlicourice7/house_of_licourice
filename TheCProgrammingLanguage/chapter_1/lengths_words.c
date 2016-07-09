#include <stdio.h>
#include <stdlib.h>
// prints a histogram of the lengths of words in the input
int main(){
    int upto2 = 0, upto4 = 0, upto6 = 0, upto8 = 0, rest = 0, input, length, loop = 0, index = 0, index2 = 0;
    int *lengths, *temporary; // declares array as a pointer
    lengths = malloc(1*sizeof(int)); //allocating default amount of memory(size of one integer value) to pointer(array)
    while((input = getchar())!= EOF){  //individually reads each character  
    	if(input == ' '||input == '\t' || input == '\n'){
            temporary = realloc(lengths,(index + 1)*sizeof(int)); //increases amount of memory allocated to pointer by the size of one integer value
            if(temporary != NULL)
                lengths = temporary;
            else {
                printf("Error allocating memory."); 
                free(lengths); 
            }
            index++; // goes to next word when a white space is encountered
        } 
        else if(input == '.'|| input == ','|| input == '"'|| input == '!'|| input == '?'|| input == ';'|| input == ':'|| input == '-') 
            ;
        else
        	lengths[index]++;  // counts length of each word
    }
    //printf("\n%d\n", (index+1));
    for(loop = 0; loop <= index; loop++){
    //printf("%d\n", lengths[loop]);
    if(lengths[loop] < 2)
        upto2++;       // counts number of words with length less than 2 characters
    else if(lengths[loop] < 4)
        upto4++;       // counts number of words with length less than 4 characters
    else if(lengths[loop] < 6)
        upto6++;       // counts number of words with length less than 6 characters
    else if(lengths[loop] < 8)
        upto8++;       // counts number of words with length less than 8 characters
    else if(lengths[loop] >= 8)
        rest++;        //counts number of words with lengths greater than or eqaual to 8 characters
    }
    //printf("%d %d %d %d %d\n", upto2, upto4, upto6, upto8, rest);

    //prints histogram
    printf("\n 0-2:");
    for(loop = 0; loop < upto2; loop++)
        printf("*");
    //printf("%d", upto2);
    printf("\n 2-4:");
    for(loop = 0; loop < upto4; loop++)
        printf("*");
    //printf("%d", upto4);
    printf("\n 4-6:");
    for(loop = 0; loop < upto6; loop++)
        printf("*");
    //printf("%d", upto6);
    printf("\n 6-8:");
    for(loop = 0; loop < upto8; loop++)
        printf("*");
    //printf("%d", upto8);
    printf("\n  8+:");
    for(loop = 0; loop < rest; loop++)
        printf("*");
    printf("\n");
    //printf("%d", rest);

}
