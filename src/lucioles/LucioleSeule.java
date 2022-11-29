package lucioles;

// Étape 1 : Simulation d'une seule luciole

public class LucioleSeule {

	// Seuil au delà duquel une luciole émet un flash.
	public static final double SEUIL = 100.0;

	public static char symboliseLuciole(double niveauEnergie) {
		if (niveauEnergie > SEUIL) {
			return '*';
		} else {
			return '.';
		}
	}

	public static void afficheLuciole(double niveauEnergie, boolean verbeux) {
		System.out.print(symboliseLuciole(niveauEnergie));
		if (verbeux) {
			System.out.print(" " + niveauEnergie);
		}
		System.out.println();

	}

	public static double incrementeLuciole(double niveauEnergie, double deltaEnergie) {
		return niveauEnergie + deltaEnergie;
	}

	public static double afficheIncrementeLuciole(double niveauEnergie, boolean verbeux) {
		double deltaEnergie = RandomGen.rGen.nextDouble();
		niveauEnergie = incrementeLuciole(niveauEnergie, deltaEnergie);
		afficheLuciole(niveauEnergie, verbeux);
		return niveauEnergie;
	}

	public static void simuleLucioleNbPas(int rep, boolean verbeux) {
		double lucioleEnergie = 100 * RandomGen.rGen.nextDouble();

		for (int i = 0; i < rep; i++) {
			lucioleEnergie = afficheIncrementeLuciole(lucioleEnergie, verbeux);

			if (lucioleEnergie > SEUIL) {
				lucioleEnergie = 0;
			}
		}
	}

	public static void simuleLucioleNbFlashs(boolean verbeux) {
		double lucioleEnergie = 100 * RandomGen.rGen.nextDouble();
		int nbFlash = 0;

		while (nbFlash < 3) {
			lucioleEnergie = afficheIncrementeLuciole(lucioleEnergie, verbeux);

			if (lucioleEnergie > SEUIL) {
				lucioleEnergie = 0;
				nbFlash++;
			}
		}
	}

	public static void main(String[] args) {
		/*
		 * double lucioleEnergie = 100 * RandomGen.rGen.nextDouble();
		 * double lucioleDeltaEnergie = RandomGen.rGen.nextDouble();
		 * 
		 * for (int i = 0; i < 5; i++) {
		 * lucioleEnergie = 100 * RandomGen.rGen.nextDouble();
		 * afficheLuciole(lucioleEnergie, true);
		 * }
		 * 
		 * System.out.println();
		 * for (int i = 0; i < 5; i++) {
		 * lucioleEnergie = afficheIncrementeLuciole(lucioleEnergie, verbeux);
		 * }
		 * 
		 * simuleLucioleNbPas(100, true);
		 */

		simuleLucioleNbFlashs(true);
	}
}
