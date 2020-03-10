import math

class Trans:
	def __init__(self, rekord):
		self.data = rekord[0]
		self.nip = rekord[1]
		self.ilosc = int(rekord[2])
	def __repr__(self):
		return "%s %s %s" % (self.data, self.nip, self.ilosc)


transakcje = []
klienci = {}# defaultdict(int) #gimmick
cennik = {}


f = open("../Dane_PR2/cukier.txt")
for line in f.read().splitlines():
	transakcje.append(Trans(line.split()))
f.close()

f = open("../Dane_PR2/cennik.txt")
for line in f.read().splitlines():
	key, val = line.split()
	cennik[key] = float(val.replace(',', '.'))
f.close()

rabaty_razem = 0
for t in transakcje:
	if t.nip not in klienci:
		klienci[t.nip] = 0
	klienci[t.nip] += t.ilosc
	rabat = 0
	if klienci[t.nip] >= 10000:
		rabat = 0.2	
	elif klienci[t.nip] >= 1000:
		rabat = 0.1
	elif klienci[t.nip] >= 100:
		rabat = 0.05
	rabaty_razem += t.ilosc * rabat



#dlaczego to jest źle?
'''
nip1 = nip2 = nip3 = ''
for n in klienci:
	if not nip1 or klienci[n] >= klienci[nip1]:
		nip3 = nip2
		nip2 = nip1
		nip1 = n
print(nip1, klienci[nip1])
print(nip2, klienci[nip2])
print(nip3, klienci[nip3])
'''
nip1 = nip2 = nip3 = ''
for n in klienci:
	if not nip3 or klienci[n] >= klienci[nip3]:
		nip3 = n
	if not nip2 or klienci[n] >= klienci[nip2]:
		nip3 = nip2
		nip2 = n
	if not nip1 or klienci[n] >= klienci[nip1]:
		nip2 = nip1
		nip1 = n
print("4.1:")
print(nip1, klienci[nip1])
print(nip2, klienci[nip2])
print(nip3, klienci[nip3])

przychod = 0
for t in transakcje:
	przychod += cennik[t.data[:4]] * t.ilosc
print("4.2:")
print("%.2f" % przychod)

print("4.3:")
print("%.2f" % rabaty_razem)

print("4.5:")
magazyn = 5000
licznik = 0
miesiac = transakcje[0].data[:7]
for t in transakcje:
	magazyn -= t.ilosc
	print(magazyn)
	if miesiac != t.data[:7]:
		miesiac = t.data[:7]
		if magazyn < 5000:
			ile_palet = math.ceil((5000 - magazyn) / 1000)
			do_kupienia = ile_palet * 1000
			print(miesiac, magazyn, ile_palet, do_kupienia)
			magazyn += do_kupienia
			if do_kupienia >= 4000:
				licznik += 1
if magazyn < 5000:
	ile_palet = math.ceil((5000 - magazyn) / 1000)
	do_kupienia = ile_palet * 1000
	magazyn += do_kupienia
	if do_kupienia >= 4000:
		licznik += 1
print(licznik)
