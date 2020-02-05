liczby = []

f = open("../dane/59/liczby.txt")
for l in f.read().split():
	liczby.append(int(l))
f.close()

ctr = 0					#licznik liczb spełniających warunki
for l in liczby:
	if l % 2 == 0:
		continue
	n = 3
	fctr = 0			#licznik wyjątkowych czynników pierwszych
	while n * n <= l and fctr <= 3:	#żadna liczba złożona nie ma czynników pierwszych
		if l % n == 0:					#większych od jej pierwiastka
			fctr += 1
			while l % n == 0:
				l /= n
		n += 2
	if l > 1:
		fctr += 1
	if fctr == 3:
		ctr += 1
print(ctr)
			
