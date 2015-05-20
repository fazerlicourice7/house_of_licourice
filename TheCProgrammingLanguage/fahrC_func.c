#include <stdio.h>

//convert celsius to fahrenheit and vice versa, with functions for each conversion.

main(){
    printf("Type 'F' and hit enter to convert a value from Celsius to fahrenheit, and type 'C' to convert a value to the Celsius scale.\n");
    int check = getchar(), Otemp;
    if(check != 'F' && check != 'C'){
        printf("Error, please re-try.\n");
        main();
        return 0;
    }
    printf("Now enter the value you want to convert.\n");
    scanf("%d", &Otemp);
    if(check == 'F')
        fahrenheit(Otemp);
    else if(check == 'C')
        celsius(Otemp);
    return 0;
}

int celsius(int fahrenheit){
    int cels;
    cels = 5 * (fahrenheit - 32) / 9;
    printf("%d\n", cels);
}

int fahrenheit(int celsius){
    int fahr;
    fahr = (9 * celsius / 5) + 32;
    printf("%d\n", fahr);
}
