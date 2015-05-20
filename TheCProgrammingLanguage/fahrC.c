#include <stdio.h>
main(){
    float celc = 0.0, fahr;
    printf("Fahrenheit to Celsius scale \n");
    for(fahr = 300.0; fahr >= 0.0; fahr -= 20.0){
        celc = 5.0 * (fahr - 32.0) / 9.0;        
        printf("%5.1f F%7.2f C \n",fahr, celc);
    }    
}
