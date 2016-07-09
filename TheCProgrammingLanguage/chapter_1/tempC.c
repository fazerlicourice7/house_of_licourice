#include <stdio.h>

//program to print table of celsius values converted to fahrenheit and fahrenheit values converted to celsius.


// EX 1.15


float fahr2C(float f);
float celc2F(float c);

# define LOWERF -40
# define UPPERF 300

# define LOWERC -40
# define UPPERC 120

# define STEP 10
main(){
    printf("  C =   F\n");
    float counterC = LOWERC;
    while(counterC <= UPPERC){
        printf("%3.1f = %3.1f\n", counterC, celc2F(counterC));
        counterC += STEP;
    }

    printf("\n\n\n   F =    C\n");
    float counterF = LOWERF;
    while(counterF <= UPPERF){
        printf("%3.1f = %3.1f\n", counterF, fahr2C(counterF));
        counterF += STEP;
    }

    return 0;
}

float fahr2C(float f){
    return (5.0/9.0) * (f - 32.0);
}

float celc2F(float c){
    return ((9.0/5.0) * c) + 32.0;
}
