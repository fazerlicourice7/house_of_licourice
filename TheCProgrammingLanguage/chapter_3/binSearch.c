// EX 3.1

#include <stdio.h>

/* Our binary search makes two tests inside the loop, when one would suffice (at
 * the price of more tests outside.) Write a version with only one test inside the
 * loop and measure the difference in run-time.
 */

int binsearch(int, int[], int);

main(){
    int v[] = { 1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25, 27, 29 };
    int n = 15;
    int x = 5;
    printf("%d\n", binsearch(x, v, n));
}

int binsearch(int x, int v[], int n){
    int low = 0, high = n - 1, mid;
    
    mid = ( low + high ) / 2;

    while(low < high && x != v[mid])
    {
        if( x > v[mid])
            low = mid+1;
        else
            high = mid -1;

        mid = ( low + high)/2;
    }

    if(x==v[mid])
        return mid;
    else
        return -1;
}
