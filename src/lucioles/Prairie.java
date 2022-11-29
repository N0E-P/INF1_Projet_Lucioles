package lucioles;

//import outils.*;

public class Prairie {

	public static final double SEUIL = 100.0;
	public static final int ENERGIE = 0;
	public static final int DELTA = 1;

	public static double[] creerLuciole() {
		double[] luciole = new double[2];
		luciole[ENERGIE] = 100 * RandomGen.rGen.nextDouble();
		luciole[DELTA] = RandomGen.rGen.nextDouble();

		return luciole;
	}

	public static double[] incrementeLuciole(double[] luciole) {
		luciole[ENERGIE] = luciole[ENERGIE] + luciole[DELTA];

		return luciole;
	}

	public static double[][] creerPopulation(int nbLucioles) {
		double[][] population = new double[nbLucioles][];

		for (int i = 0; i < nbLucioles; i++) {
			population[i] = creerLuciole();
		}
		return population;
	}

	public static void afficheTab(double[][] tab) {
		for (int i = 0; i < tab.length; i++) {
			System.out.println("Luciole: " + i + " Energie: " + tab[i][ENERGIE] + " Delta: " + tab[i][DELTA]);
		}
	}

	public static int[][] prairieVide(int nbLignes, int nbColonnes) {
		int[][] prairieVide = new int[nbLignes][nbColonnes];
		for (int i = 0; i < nbLignes; i++) {
			for (int j = 0; j < nbColonnes; j++) {
				prairieVide[i][j] = -1;
			}
		}

		return prairieVide;
	}

	public static void afficheLigneHashTag(int[][] tab) {
		for (int i = 0; i < tab[0].length + 4; i++) {
			System.out.print("#");
		}
		System.out.println();
	}

	public static void afficheLuciole(double energie) {
		if (energie >= SEUIL) {
			System.out.print("*");
		} else {
			System.out.print(".");
		}
	}

	public static void affichePrairie(int[][] prairie, double[][] population) {
		afficheLigneHashTag(prairie);

		for (int ligne = 0; ligne < prairie.length; ligne++) {
			System.out.print("# ");
			for (int colonne = 0; colonne < prairie[ligne].length; colonne++) {
				if (prairie[ligne][colonne] == -1) {
					System.out.print(" ");
				} else {
					afficheLuciole(population[prairie[ligne][colonne]][ENERGIE]);
				}
			}
			System.out.println(" #");
		}
		afficheLigneHashTag(prairie);
	}

	public static int[][] prairieLucioles(int nbLignes, int nbColonnes, double[][] population) {
		int[][] prairie = prairieVide(nbLignes, nbColonnes);

		int numeroLuciole = 0;

		for (int ligne = 0; ligne < nbLignes; ligne++) {
			for (int colonne = 0; colonne < nbColonnes; colonne++) {
				if (50 < RandomGen.rGen.nextInt(100)
						& numeroLuciole < population.length) {
					prairie[ligne][colonne] = numeroLuciole;
					numeroLuciole++;
				}
			}
		}
		return prairie;
	}

	public static void main(String[] args) {
		double[][] population = creerPopulation(500);
		int[][] prairie = prairieLucioles(25, 50, population);
		affichePrairie(prairie, population);

		/*
		 * Revoir le if pour la randomness des cases affichées
		 * 
		 * int nbEspacesAFaireEnTout = nbLignes * nbColonnes - population.length;
		 * faire en sorte qu'il y ait autant d'espaces que ce nombre
		 * 
		 * int nbCasesEnTout = nbLignes * nbColonnes;
		 * 
		 * int recurenceMoyenneDesEspaces = nbEspacesAFaireEnTout / nbCasesEnTout;
		 */
	}
}
