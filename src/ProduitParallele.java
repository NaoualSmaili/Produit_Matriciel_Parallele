public class ProduitParallele {
    static MaMatriceEntiere m, m1, m2;

    public ProduitParallele(MaMatriceEntiere m, MaMatriceEntiere m1, MaMatriceEntiere m2) {
        ProduitParallele.m1 = m1;
        ProduitParallele.m2 = m2;
        ProduitParallele.m = m;
    }

    public static void Calcul() throws InterruptedException {
        for (int i = 0; i < m1.getNBLignes(); i++)
            for (int j = 0; j < m2.getNBColonnes(); j++){
                Thread th = new Thread(new CalculElement(m, m1, m2, i, j));
                th.start();
                th.join();
            }
    }

}
