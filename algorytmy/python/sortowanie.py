import random

#random.seed(1)
liczby = [random.randint(1, 100) for _ in range(10)]
print(liczby)


#sortowanie przez wybieranie
def wybieranie(l):
	n = len(l)
	for i in range(n-1):
		min_idx = i
		for j in range(i+1, n):
			if l[j] < l[min_idx]:
				min_idx = j
		t = l[min_idx]
		l[min_idx] = l[i]
		l[i] = t
	return l

print(wybieranie(liczby.copy()))


#sortowanie bąbelkowe
def babelkowe(l):
	n = len(l)
	zmieniono = True
	while zmieniono:
		zmieniono = False
		for i in range(1, n):
			if l[i-1] > l[i]:
				zmieniono = True
				t = l[i-1]
				l[i-1] = l[i]
				l[i] = t
		n -= 1					#ostatni element na właściwym miejscu, nie trzeba go brać pod uwagę
	return l

print(babelkowe(liczby.copy()))


#sortowanie przez wstawianie
def wstawianie(l)
	n = len(l)
