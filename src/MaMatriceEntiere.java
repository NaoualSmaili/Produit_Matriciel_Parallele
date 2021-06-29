public class MaMatriceEntiere {
    int lignes;
    int colonnes;
    int[][] m;

    public MaMatriceEntiere(int lignes, int colonnes, int p) {
        int Min = 1;
        int Max = 100;

        if (p == 0) {
            m = new int[0][0];
        } else if (p == 1) {
            this.lignes = lignes;
            this.colonnes = colonnes;
            m = new int[lignes][colonnes];
            for (int i = 0; i < lignes; i++) {
                for (int j = 0; j < colonnes; j++) {
                    m[i][j] = Min + (int) (Math.random() * (Max - Min) + 1);
                }
            }
        }
    }

    public int getElement(int i, int j) {
        return m[i][j];
    }

    public void setElement(int i, int j, int val) {
        m[i][j] = val;
    }

    public int getNBLignes() {
        return m.length;
    }

    public int getNBColonnes() {
        return m[0].length;
    }

    public void printMatrice() {
        for (int[] ints : m) {
            for (int j = 0; j < m[0].length; j++) {
                System.out.print(ints[j] + "\t");
            }
            System.out.println();
        }
    }

    public static int produitUneLigneColonne(MaMatriceEntiere m1, int i, MaMatriceEntiere m2, int j) throws TaillesNonConcordantesException {
        int prod = 0;
        if (m1.getNBColonnes() != m2.getNBLignes()) throw new TaillesNonConcordantesException();
        for (int k = 0; k < m1.getNBColonnes(); k++) {
            prod += m1.getElement(i, k) * m2.getElement(k, j);
        }
        return prod;
    }
}
