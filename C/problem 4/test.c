#include <stdbool.h>
#include <assert.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

/*
 A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 99.
 
 Find the largest palindrome made from the product of two 3-digit numbers.
 * */


void intToCharArray(int number, char* array) {
    sprintf(array, "%s%d", "", number);
}

static void test_intToCharArray() {
    char array[10];
    
    intToCharArray(1,array);
    assert(strcasecmp(array,"1") == 0);
    
    intToCharArray(99,array);
    assert(strcasecmp(array,"99") == 0);

    intToCharArray(-1,array);
    assert(strcasecmp(array,"-1") == 0);
}





int isPalindrome(int number) {
    
    char digitArray[10];
    intToCharArray(number,digitArray);

    int sizeOfArray = 0;
    while (digitArray[sizeOfArray] != '\0') {
        sizeOfArray++;
    }
    
    for (int i=0; i<=sizeOfArray/2; i++) {
        if (digitArray[i] != digitArray[sizeOfArray -1 -i]) {
            return 0;
        }
    }
    
    return 1;
}

static void test_isPalindrome() {
    assert(isPalindrome(1) == 1);
    assert(isPalindrome(9) == 1);
    assert(isPalindrome(10) == 0);
    assert(isPalindrome(11) == 1);
    assert(isPalindrome(101) == 1);
    assert(isPalindrome(1001) == 1);
    assert(isPalindrome(9191101) == 0);
    assert(isPalindrome(-1) == 0);
}


int getHighestPalindrome() {
    int currentNumber = 0;
    int highestPalindromeFound = 0;
    int oldi, oldj, i, j = 0;
    
    for (i = 999; i > 0; i--) {
        if (i*999 < highestPalindromeFound) {
            printf("highest palindrome: %d, reached for i=%d, j=%d\n", highestPalindromeFound, oldi, oldj);
            return highestPalindromeFound;
        }
        for (j = 999; j > 0; j--) {
            currentNumber = i*j;
            if (currentNumber > highestPalindromeFound && isPalindrome(currentNumber) == 1) {
                highestPalindromeFound = currentNumber;
                oldi = i;
                oldj = j;
            }
        }
    }
    
    return 0;
}



// to go further

int getHighestPalindrome_ThreeThreeDigitNumbers() {
    int currentNumber = 0;
    int highestPalindromeFound = 0;
    int oldi, oldj, oldk, i, j, k = 0;
    
    for (i = 999; i > 0; i--) {
        if (i*999*999 < highestPalindromeFound) {
            printf("highest palindrome: %d, reached for i=%d, j=%d, k=%d\n", highestPalindromeFound, oldi, oldj, oldk);
            return highestPalindromeFound;
        }
        for (j = 999; j > 0; j--) {
            if (i*j*999 < highestPalindromeFound) {
                break;
            }
            for (k = 999; k > 0; k--) {
                currentNumber = i*j*k;
                if (currentNumber > highestPalindromeFound && isPalindrome(currentNumber) == 1) {
                    highestPalindromeFound = currentNumber;
                    oldi = i;
                    oldj = j;
                    oldk = k;
                }
            }
        }
    }
    
    return 0;
}



int main() {
    printf("STARTING TESTS \n");
    test_intToCharArray();
    test_isPalindrome();
    printf("TESTS ARE ALL GREEN \n");
    getHighestPalindrome();
    return 0;
}

