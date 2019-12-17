public static int silnia(int a) {
	int b = 1;
		for (int i = 1; i <= a; i++) {
			b = b * i;
		}
	return b;
}

public static int nwd(int a, int b) {
	for (int i = a; i >= 1; i--) {
		if(a % i == 0 && b % i == 0) {
			return i;
		}
	}
	return 0;
}
