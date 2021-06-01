public class Test {

    public static void main(String[] args) throws TaillesNonConcordantesException, InterruptedException {
        System.out.println("Matrice 1");
        MaMatriceEntiere m1= new MaMatriceEntiere(2,4,1);
        m1.printMatrice();

        System.out.println("\nMatrice 2");
        MaMatriceEntiere m2= new MaMatriceEntiere(3,2,1);
        m2.printMatrice();

        System.out.print("\nCalcul des éléments:");
        MaMatriceEntiere m= new MaMatriceEntiere(m1.getNBLignes(),m2.getNBColonnes(),1);
        ProduitParallele p = new ProduitParallele(m,m1,m2);
        p.Calcul();

        System.out.println("\n\nLa matrice calculée:");
        m.printMatrice();
    }
}
