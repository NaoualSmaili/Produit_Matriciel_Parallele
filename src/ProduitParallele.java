import java.util.concurrent.*;

public class ProduitParallele {
    static MaMatriceEntiere m, m1, m2;
    static int NB_THREADS = 8;
    static int taillePool = 4;

    static ExecutorService exec = Executors.newFixedThreadPool(taillePool);

    public ProduitParallele(MaMatriceEntiere m, MaMatriceEntiere m1, MaMatriceEntiere m2) {
        ProduitParallele.m1 = m1;
        ProduitParallele.m2 = m2;
        ProduitParallele.m = m;
    }

    public static void Calcul() throws ExecutionException{
        for (int i = 0; i < NB_THREADS/m1.getNBColonnes(); i++){
            for (int j = 0; j < NB_THREADS/m2.getNBLignes(); j++){
                CalculElement el = new CalculElement(m, m1, m2, i, j);
                Future<Integer> f = exec.submit(el);
                try {
                    m.setElement(i, j, f.get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        exec.shutdown();

        while (exec.isTerminated()) {
            try {
                exec.awaitTermination(20000, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
