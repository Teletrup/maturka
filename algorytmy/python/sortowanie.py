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
def wstawianie(l):
	n = len(l)
	for i in range(1, n):
		if l[i-1] > l[i]:
			t = l[i-1]
			l[i-1] = l[i]
			l[i] = t
			for j in reversed(range(1, i)):
				if l[j-1] > l[j]:
					t = l[j-1]
					l[j-1] = l[j]
					l[j] = t
				else:
					break
	return l

print(wstawianie(liczby.copy()))
						

				
#sortowanie szybkie

def podzial(l, a, b):
	klucz = l[(a + b) // 2]
	i = a
	j = b
	while True:
		while l[i] < klucz:
			i += 1
		while l[j] > klucz:
			j -= 1
		if i >= j:
			return j
		t = l[i]
		l[i] = l[j]
		l[j] = t
		i += 1
		j -= 1

def szybkie(l, a, b):
	if a < b:
		p = podzial(l, a, b)
		szybkie(l, a, p)
		szybkie(l, p+1, b)
	return l

print(szybkie(liczby.copy(), 0, len(liczby) - 1))
	


#sortowanie przez scalanie
def scal(l, l2, al, ap, bp):
	i = al
	j = ap + 1
	for _ in range(al, bp+1):
		if j > bp or (i <= ap and l[i] < l[j]):
			l2.append(l[i])
			i += 1
		else:
			l2.append(l[j])
			j += 1
	
def scalanie(l):
	n = len(l)
	szerokosc = 1
	while szerokosc <= n:
		l2 = []
		for i in range(0, n, szerokosc*2):
			al = i
			ap = min(i + szerokosc - 1, n - 1)
			bp = min(i + szerokosc * 2 - 1, n - 1)
			scal(l, l2, al, ap, bp)
		l = l2.copy()
		szerokosc *= 2
	return l

print(scalanie(liczby.copy()))
