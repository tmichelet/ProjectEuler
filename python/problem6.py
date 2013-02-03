#Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.

import unittest

def sumOfSquares(n):
	if not isinstance(n, int) or  n < 0:
		raise NameError('invalid argument exception', n)	
	sum = 0
	i = 0
	for i in range(1,n+1):
		sum += i*i
	return sum

def squareOfSum(n):
	if not isinstance(n, int) or  n < 0:
		raise NameError('invalid argument exception', n)	
	sum = 0
	i = 0
	for i in range(1,n+1):
		sum += i
	return sum * sum

def differenceBetweenSqOfSuAndSuOfSq(n):
	if not isinstance(n, int) or  n < 0:
		raise NameError('invalid argument exception', n)	
	return squareOfSum(n) - sumOfSquares(n)



class Problem6Tests(unittest.TestCase):

	def test_sumOfSquares(self):
        	self.failUnless(sumOfSquares(1) == 1)
        	self.failUnless(sumOfSquares(2) == 5)
		self.failUnless(sumOfSquares(10) == 385)
		try:
			self.failUnless(sumOfSquares(-2) and 0)
		except NameError:
			pass
		try:
			self.failUnless(sumOfSquares('text') and 0)
		except NameError:
			pass
	
	def test_squareOfSum(self):
        	self.failUnless(squareOfSum(1) == 1)
        	self.failUnless(squareOfSum(2) == 9)
        	self.failUnless(squareOfSum(10) == 3025)
		self.failUnless(sumOfSquares(10) == 385)
		try:
			self.failUnless(squareOfSum(-2) and 0)
		except NameError:
			pass
		try:
			self.failUnless(squareOfSum('text') and 0)
		except NameError:
			pass

	def test_difference(self):
		self.failUnless(differenceBetweenSqOfSuAndSuOfSq(1) == 0)
		self.failUnless(differenceBetweenSqOfSuAndSuOfSq(10) == 2640)
		self.failUnless(differenceBetweenSqOfSuAndSuOfSq(100) == 25164150)
		#print differenceBetweenSqOfSuAndSuOfSq(100)
		try:
			self.failUnless(differenceBetweenSqOfSuAndSuOfSq(-2) and 0)
		except NameError:
			pass
		try:
			self.failUnless(differenceBetweenSqOfSuAndSuOfSq('text') and 0)
		except NameError:
			pass



def main():
    unittest.main()

if __name__ == '__main__':
    main()
