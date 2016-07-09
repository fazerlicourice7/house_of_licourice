#include <stdio.h>

//print histogram of word lengths in input

main(){
    char c;
    int lengths[12];

    for(int i = 0; i < 12; i++){
        lengths[i] = 0;
    }

    int length = 0;
    while((c=getchar()) != '\n'){
        if(c== ' ' || c== '\t'){
            if(length <= 11 && length > 0)
                lengths[length-1]++;
            else
                lengths[11]++;
            //printf("%d\n",length);
            length = 0;
        }
        else
            length++;
    }
    if(length <= 11 && length > 0)
         lengths[length-1]++;
    else
         lengths[11]++;

    //printf("reached end of line");
    printf("Number of Letters\n");
    for(int i = 0; i < 11; i++){
        printf("%9d:", i + 1);
        for(int l = 0; l < lengths[i]; l++){
            printf("#");
        }
        printf("\n");
    }
    
    printf("%9s:",">11");
    for(int l = 0; l < lengths[11]; l++){
        printf("#");
    }
    printf("\n");
}
