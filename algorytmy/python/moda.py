import random

liczby = [random.randint(1, 10) for _ in range(10)]
print(liczby)


#moda z użyciem tablicy asocjacyjnej
def moda_aso(l):
	ilosci = {}
	for a in l:
		if a not in ilosci:
			ilosci[a] = 1
		else:
			ilosci[a] += 1
	ilosc_max = max(ilosci.values())
	if ilosc_max == 1:
		return []
	mody = []
	for liczba, ilosc in ilosci.items():
		if ilosc == ilosc_max:
			mody.append(liczba)
	return mody
	
print(moda_aso(liczby))


#moda z użyciem zwykłych tablic i wywoływania pojedyńczych elementów
def moda_tab(l):
	liczby = []	
	ilosci = []
	for a in l:
		znaleziono = False
		for i in range(len(liczby)):
			if liczby[i] == a:
				znaleziono = True
				ilosci[i] += 1
				break
		if not znaleziono:
			liczby.append(a)
			ilosci.append(1)
	ilosc_max = ilosci[0]
	for ilosc in ilosci[1:]:
		if ilosc > ilosc_max:
			ilosc_max = ilosc
	if ilosc_max == 1:
		return []
	mody = []
	for i in range(len(liczby)):
		if ilosci[i] == ilosc_max:
			mody.append(liczby[i])
	return mody

print(moda_tab(liczby))

