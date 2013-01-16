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

/*
    We are going to divide each number from 2 to maxNumber into it's prime factors. 
    We are going to save the highest power value needed for each prime factor.
 */

int smallestDivisible(int maxNumber) {
    if (maxNumber < 1) {
        return 0; //TODO throw exception
    }
    if (maxNumber == 1) {
        return 1;
    }
    
    int* dividers = (int *) malloc(sizeof(int));
    for (int i = 0; i <= maxNumber; i++) {
        dividers[i] = 0; // considering prime dividers from 0 to number included
    } // we could optimize the memory by considering only prime numbers.
    
    
    for (int currentNumber = 2; currentNumber <= maxNumber; currentNumber ++) { // consider each number under maxNumber
        int theNumber = currentNumber;
        
        for (int prime = 2; prime <= theNumber; prime++) { // find it's prime dividers
            int count = 0; // count how many times they are needed
            while(theNumber % prime == 0) {
                count ++;
                theNumber = theNumber / prime;
            }
            if (dividers[prime] < count) { // If we don't have them already, add them to the divider table
                dividers[prime] = count;
            }
        }
    }
    
    int result = 1;
    for (int i = 2; i <= maxNumber; i++) {
        result *= pow(i, dividers[i]);
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
