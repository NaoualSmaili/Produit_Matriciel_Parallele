public class CalculElement implements Runnable {
    MaMatriceEntiere m, m1, m2;
    int i, j;
    int val = 0;

    public CalculElement(MaMatriceEntiere m, MaMatriceEntiere m1, MaMatriceEntiere m2, int i, int j) {
        this.m = m;
        this.m1 = m1;
        this.m2 = m2;
        this.i = i;
        this.j = j;
    }

    @Override
    public void run() {
        try {
            val = MaMatriceEntiere.produitUneLigneColonne(m1, i, m2, j);
            m.setElement(i, j, val);
        } catch (TaillesNonConcordantesException e) {
            e.printStackTrace();
        }
        System.out.format("\nCalcul: [%d,%d] = %d Fin du calcul", i, j, val);
    }
}
