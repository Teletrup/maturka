"""
Czemu?
a^11 = a^(1 + 2 + 8) = a * a^2 * ((a^2)^2)^2)

"""

def potega(a, b):
	wynik = 1
	while b:
		if b % 2:
			wynik *= a
		a *= a
		b //= 2
	return wynik
