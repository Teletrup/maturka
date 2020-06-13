#wyszukiwanie pierwszego elementu o danej wartości w posortowanym ciągu metodą dziel i rządź

l = [0, 0, 0, 1, 1, 2, 3, 3, 3, 5, 5, 9, 9, 9, 11, 100, 100]

def szukaj(l, x):
	a = 0
	b = len(l) - 1
	while a < b:
		s = (b + a) // 2
		if l[s] >= x:
			b = s
		else:
			a = s + 1
	if l[a] == x:
		return a
	else:
		return None
print(szukaj(l, 2))
