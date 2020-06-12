"""
n nie może mieć więcej niż jednego czynnika pierwszego > sqrt(n)
jeśli n nie ma czynników pierwszych <= sqrt(n)
	n może mieć tylko jeden czynnik pierwszy (samo n)
	n jest liczbą pierwszą

"""

#sprawdzanie czy liczba jest pierwsza
def czy_pierwsza(a):
	if a % 2 == 0:
		return False
	i = 3
	while i*i <= a:		# prawdziwe, jeśli i <= sqrt(a)
		if a % i == 0:
			return False
		i += 2
	return True

print(czy_pierwsza(17))
print(czy_pierwsza(81))
print(czy_pierwsza(49))

#rozkład na czynniki pierwsze
def czynniki_pierwsze(a):
	cz = []
	while a % 2 == 0:
		cz.append(2)
		a //= 2
	i = 3
	while i*i <= a:
		while a % i == 0:
			cz.append(i)
			a //= i
		i += 2
	if a != 1:
		cz.append(a)
	return cz

print(czynniki_pierwsze(411))
print(czynniki_pierwsze(49))
	
		
