#include <stdbool.h>
#include <assert.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>

/*
 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 
 What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 * */


int smallestDivisible_bruteForce(int number) {
    if (number == 1) {
        return 1;
    }
    
    int minimumSmallestDivisible = number * (number - 1);
    int smallestDivisible = minimumSmallestDivisible;
    
    int isSmallestDivisible = 0;
    while (!isSmallestDivisible) {
        isSmallestDivisible = 1;
        for (int i = 2; i < number; i++) {
            if (smallestDivisible % i != 0) {
                isSmallestDivisible = 0;
                smallestDivisible += minimumSmallestDivisible;
                break;
            }
        }
    }
    
    return smallestDivisible;
}


// to go further

int smallestDivisible(int number) {
    if (number < 1) {
        return 0; //TODO throw exception
    }
    if (number == 1) {
        return 1;
    }
    
    int* dividers = (int *) malloc(sizeof(int));
    for (int i = 0; i <= number; i++) {
        dividers[i] = 0; // 0 to number included
    }
    
    
    for (int currentNumber = 2; currentNumber <= number; currentNumber ++) {
        // decompose current number into prime numbers, and add them to the dividers table  
        int theNumber = currentNumber;
        for (int prime = 2; prime <= theNumber; prime++) {
            int count = 0;
            while(theNumber % prime == 0) {
                count ++;
                theNumber = theNumber / prime;
            }
            if (dividers[prime] < count) {
                dividers[prime] = count;
            }
        }
    }
    
    int result = 1;
    for (int i = 2; i <= number; i++) {
        result *= pow(i, dividers[i]);;
    }

    
    free(dividers);
    return result;
}

static void test_smallestDivisible() {
    assert(smallestDivisible(1) == 1);
    assert(smallestDivisible(2) == 2);
    assert(smallestDivisible(4) == 12);
    assert(smallestDivisible(5) == 60);
    assert(smallestDivisible(10) == 2520);
    assert(smallestDivisible(20) == 232792560);
}



int main() {
    printf("STARTING TESTS \n");
    test_smallestDivisible();
    printf("TESTS ARE ALL GREEN \n");
    return 0;
}
