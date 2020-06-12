"""
Obliczanie pierwiastka kwadratowego metodą Herona

Czemu tak?

a * S/a = S

jeśli a < sqrt(S),
	S/a > S/sqrt(S)
	S/a > sqrt(S)

analogicznie, jeśli a > sqrt(S),
	S/a < sqrt(S)

średnia a oraz S/a jest bliższa sqrt(S) niż co najmniej jedna z tych wartości
dobra, nie ma czasu

"""

def sqrt(x, epsilon):		#epsilon - dokładność przybliżenia
	a = x					#może być dowolna liczba > 0
	while abs(a - x / a) > epsilon:
		a = (a + x / a) / 2
	return a

print(sqrt(2, 0.0000001))
