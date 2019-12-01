import math as M


f = open("liczby.txt")
liczby = f.read().split()
f.close()

odp = ""

odp += "4.1:\n"
pot3_ile = 0
for l in liczby:
	x = int(l)
	pot3 = 1
	while pot3 <= x:
		if pot3 == x:
			pot3_ile += 1
			break
		pot3 *= 3
odp += str(pot3_ile) + "\n\n"

odp += "4.2:\n"
for l in liczby:
	x = int(l)
	s_silni = 0
	for cyfra in l:
		s_silni += M.factorial(int(cyfra))
	if x == s_silni:
		odp += l + "\n"
odp += "\n"

odp += "4.3:\n"
elem_best = liczby[0]
dlug_best = 1
nwd_best = 1
for i in range(0, len(liczby) - 1):
	x1 = int(liczby[i])
	x2 = int(liczby[i + 1])
	nwd = M.gcd(x1, x2)
	if nwd > 1:
		elem = x1
		dlug = 2
		for j in range(i + 2, len(liczby)):
			nwd2 = M.gcd(nwd, int(liczby[j]))
			if nwd2 == 1:
				break
			nwd = nwd2
			dlug += 1
		if dlug > dlug_best:
			dlug_best = dlug
			elem_best = elem
			nwd_best = nwd
odp += str(elem_best) + " " + str(dlug_best) + " " + str(nwd_best) + "\n"

f = open("wyniki4.txt", "w")
f.write(odp)
f.close()
