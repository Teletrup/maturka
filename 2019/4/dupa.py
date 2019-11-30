import math as M


f = open("przyklad.txt")
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


for i in range(0, len(liczby) - 1):
	x1 = int(liczby[i])
	x2 = int(liczby[i + 1])
	print(M.gcd(x1, x2))
#tutaj póki co wymiękam

f = open("wyniki4.txt", "w")
f.write(odp)
f.close()
