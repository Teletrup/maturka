f = open("dane/dane4.txt")
dane = list(map(int, f.read().splitlines()))
f.close()

luka_min = 10**10 #4.1
luka_max = 0
luka_last = 0 #4.2
flen = 0
flen_max = 0
elem_first = 0
elem_last = 0
elem_first_max = 0
elem_last_max = 0 # czy init z tablicy przed pętlą?
krot = {} #4.3
for i in range(len(dane) - 1):
	luka = abs(dane[i+1] - dane[i])
	luka_max = max(luka_max, luka) #4.1
	luka_min = min(luka_min, luka)
	if luka != luka_last: #4.2
		flen_max = max(flen_max, flen)
		elem_last = dane[i]
		if flen == flen_max:
			elem_first_max = elem_first
			elem_last_max = elem_last
		elem_first = dane[i] #ostatni element to dane[i-1], a tak nie może być... Gówno prawda! 1_2_3-4
		flen = 1
	else:
		flen += 1
	luka_last = luka
	if luka not in krot:
		krot[luka] = 1
	else:
		krot[luka] += 1
krot_max = max(krot.values())
krot_max_luki = []
for k, v in krot.items():
	if v == krot_max:
		krot_max_luki.append(k)

print(luka_max, luka_min)
print(flen_max, elem_first_max, elem_last_max);
print(krot_max, krot_max_luki)

