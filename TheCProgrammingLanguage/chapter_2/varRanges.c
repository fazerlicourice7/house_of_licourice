// EX 2.1

#include <stdio.h>
#include <limits.h>
#include <float.h>

/* determine the ranges of char , short , int , and long
 * variables, both signed and unsigned , by printing appropriate values from
 * standard headers and by direct computation. Harder if you compute them: 
 * determine the ranges of the various floating-point types.
 */


main(){
    printf("The range of values for an unsigned char is: %d < c < %d.\n", 0, 
           UCHAR_MAX);
    printf("The range of values for a signed char is: %d < c < %d.\n", SCHAR_MIN,     
           SCHAR_MAX);
    printf("The range of values for an unsigned short int is: %d < s < %d.\n", 0, 
           USHRT_MAX);
    printf("The range of values for a signed short int is: %d < s < %d.\n", SHRT_MIN, 
           SHRT_MAX);
    printf("The range of values for an unsigned int is: %d < i < %u.\n", 0, UINT_MAX);
    printf("The range of values for a signed int is: %d < i < %d.\n", INT_MIN, INT_MAX);
    printf("The range of values for an unsigned long int is: %d < l < %lu.\n", 0, 
           ULONG_MAX);
    printf("The range of values for a signed long int is: %ld < l < %ld.\n", LONG_MIN, 
           LONG_MAX);
    printf("\nThe range of values for a floating point number is: %f < f < %f.\n",
           FLT_MIN, FLT_MAX);
    printf("The decimal digits of precision for a floating point number is: %d.\n",
           FLT_DIG);
    printf("The range of values for a double floating point number is: %lf < d < %lf.\n",
           DBL_MIN, DBL_MAX);
    printf("The decimal digits of precision for a double floating point number is: %d.",
           DBL_DIG);
    return 0;
}
