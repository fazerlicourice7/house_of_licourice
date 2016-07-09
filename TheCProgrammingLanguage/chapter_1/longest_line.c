#include <stdio.h>

//finds the longest line in an input and prints it's length

main(){
    int length, longest;
    while((length = get_line()) != 0)
        if(length > longest)
            longest = copy(length);
    printf("%d\n",longest);
}

int copy(int new_longest){
    int longest;
    longest = new_longest;
    return longest;
}

int get_line(){
    int character, length = 0;
    while((character = getchar()) != '\n'){
        if(character == EOF){
            return 0;
        }
        else
            length++;
    }
    return length;
}
