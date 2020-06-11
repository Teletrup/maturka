import random

random.seed(1)
l = [random.randint(1, 3000) for _ in range(256)]

#metoda liniowa
porownania_lin = 0
def minmax_lin():
	global porownania_lin
	_min = l[0]
	_max = l[0]
	for x in l[1:]:
		porownania_lin += 2
		if x < _min:
			_min = x
		if x > _max:
			_max = x
	return _min, _max
print(minmax_lin(), porownania_lin)


#metoda dziel i rządź
porownania_dac = 0
def minmax_dac(a, b):
	global porownania_dac
	if b == a:
		return l[a], l[a]
	elif b - a <= 1:
		porownania_dac += 1
		if l[a] < l[b]:
			return l[a], l[b]
		else:
			return l[b], l[a]
	else:
		porownania_dac += 2
		sr = (a + b) // 2 #średni indeks
		min1, max1 = minmax_dac(a, sr)
		min2, max2 = minmax_dac(sr + 1, b)
		if max1 > max2:
			_max = max1
		else:
			_max = max2
		if min1 < min2:
			_min = min1
		else:
			_min = min2
		return _min, _max
print(minmax_dac(0, len(l) - 1), porownania_dac)

