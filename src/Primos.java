import java.util.ArrayList;

public class CribaEratostenes {

    public static ArrayList<Integer> CrearLista(boolean[] listado){
        ArrayList<Integer> primos = new ArrayList<>();

        for(int i = 2; i < listado.length; i++){
            if(listado[i]){
                primos.add(i);
            }
        }
        return primos;
    }

    public static void RellenarArregloBoleano(boolean[] lista, int n){
        for(int i = 0; i < n; i++){
            lista[i] = true;
        }

        lista[0] = lista[1] = false;
    }

    public static ArrayList<Integer> ObtenerPrimos(int n){
        boolean[] primos = new boolean[n+1];
        RellenarArregloBoleano(primos,n+1);

        for(int valor = 2; valor * valor <= n; valor++){
            if(primos[valor]){
                for(int i = valor * valor; i <= n; i += valor){
                    primos[i] = false;
                }
            }
        }

        return CrearLista(primos);
    }

    public static void main(String[] args) {
        int n = 1000;
        ArrayList<Integer> lista;

        long inicio = System.nanoTime();
        lista = ObtenerPrimos(n);
        long fin = System.nanoTime() - inicio;

        System.out.println("Tiempo (T): " + fin + " ns | Cantidad de Entradas (N): " + n);

        for(Integer valor : lista){
            System.out.println(valor);
        }
    }

}