import datetime as Dtm
import calendar as Cal
import math as M

f = open("../dane/pogoda.txt")
linie = f.read().replace(',', '.').splitlines()
f.close()

dane = []
for l in linie[1:]:
	dane.append(list(map(float, l.split('\t'))))
print(dane)

woda_max = 25000
woda = woda_max
dolano_mies = 0
dolano_razem = 0
dolano_1 = 0
dolano_1_data = None
dzien = Dtm.date(2015, 3, 31)

dni_t_leq = 0
dni_t_gtr_o_leq = 0
dni_t_gtr_o_gtr = 0

zestawienie = []

for d in dane:
	dzien += Dtm.timedelta(days=1)
	ostatni_dz_m = Cal.monthrange(dzien.year, dzien.month)[1]
	if dzien.day == ostatni_dz_m:
		zestawienie.append([dzien, M.ceil(dolano_mies / 1000) * 11.74])
		dolano_mies = 0
		

	if d[0] > 15:
		if d[1] > 0.6:
			dni_t_gtr_o_gtr += 1
		else:
			dni_t_gtr_o_leq += 1
	else:
		dni_t_leq += 1

	roz_wody = 0
	if d[1] > 0:
		roz_wody = 700 * d[1]
	else:
		roz_wody = -0.0003 * d[0]**1.5 * M.ceil(woda)
	woda = max(0, min(woda_max, woda + roz_wody))
	if d[0] > 15 and d[1] <= 0.6:
		do_podlania = 12000					#kiedy robic tak, a kiedy z else?
		if d[0] > 30:
			do_podlania = 24000
		if woda < do_podlania:
			dolano = woda_max - woda	
			woda = woda_max
			dolano_razem += dolano
			dolano_mies += dolano
			if dolano_1 == 0:
				dolano_1 = dolano
				dolano_1_data = dzien
		woda -= do_podlania
print(dolano_razem)

print('5.1')
print('liczba dni, gdzie temperatura <= 15: ', dni_t_leq)
print('liczba dni, gdzie temperetura > 15 i opady <= 0.6: ', dni_t_gtr_o_leq)
print('liczba dni, gdzie temperetura > 15 i opady > 0.6: ', dni_t_gtr_o_gtr)

print('5.2')
print(dolano_1_data, M.ceil(dolano_1))

print('5.4')
for m in zestawienie:
	print('2015-%s: %.2f' % (m[0].month, m[1]))
