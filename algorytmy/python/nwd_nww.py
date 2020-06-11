
x = 42
y = 105

def nwd_sub_itr(a, b):
	while a != b:
		if a > b:
			a -= b
		else:
			b -= a
	return a

def nwd_sub_rec(a, b):
	if a < b:
		return nwd_sub_rec(a, b - a)
	elif a > b:
		return nwd_sub_rec(a - b, b)
	else:
		return a

def nwd_mod_itr(a, b):
	while b != 0:
		a = a % b
		t = b
		b = a
		a = t
	return a

def nwd_mod_rec(a, b):
	if b == 0:
		return a
	else:
		return nwd_mod_rec(b, a % b)

print(nwd_sub_itr(x, y))
print(nwd_sub_rec(x, y))
print(nwd_mod_itr(x, y))
print(nwd_mod_rec(x, y))

def nww(a, b):
	return a * b // nwd_mod_itr(a, b)

print(nww(x, y))
