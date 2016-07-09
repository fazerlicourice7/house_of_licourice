// EX 1.23

#include <stdio.h>

// program to remove comments in a c program.

#define MAXSIZE 10000

//char file[MAXSIZE];

//void getFile(char f[], int l);
void remComs(char f[]);

/*main(){
    getFile(file, MAXSIZE);
    remComs(file);
    printf("%s\n", file);
}

void getFile(char file[], int limit){
    //printf("called getFile\n");
    char c;
    int currentChar = 0;
    while((c = getchar()) != EOF && currentChar < limit -1){
        file[currentChar] = c;
        currentChar++;
    }
    file[currentChar] = '\0';
}*/

void remComs(char file[]){
    //printf("called remComs\n");
    int current = 0;
    while(file[current] != '\0'){
        //printf("main while loop\n");
        if(file[current] == '/'){
            if(file[current + 1] == '/'){
                //printf("found a single line comment\n");
                int index = current;
                while(file[index] != '\n'){
                    ++index;
                }
                ++index;
                int currentI = current;
                while((file[currentI] = file[index]) != '\0'){
                    ++index;
                    ++currentI;
                }
            }
            else if(file[current + 1] == '*'){
                //printf("double line comment\n");
                int index = current;
                while(file[index] != '*' || file[index + 1] != '/'){
                    ++index;
                }
                index += 2;
                int currentI = current;
                while((file[currentI] = file[index]) != '\0'){
                    ++index;
                    ++currentI;
                }
            }
        }
        ++current;
    }
}
