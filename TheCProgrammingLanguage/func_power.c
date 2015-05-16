#include<stdio.h>

//creates a function which computes the value of 'x' to the power 'y'

int main(){
printf("Enter two values separated by a space.\n");
int number, exponent;
scanf("%d %d", &number, &exponent);
power(number, exponent);
}

int power(int x, int y){
    int result = 1, i;
    for(i = 0; i < y; i++)
        result = result * x;
    printf("%d\n", result);
}

