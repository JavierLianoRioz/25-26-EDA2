public class Acertijo {
  public static void main(String[] args) {
    Algoritmo algoritmo = new Algoritmo();

    algoritmo.insertarPalabra("SEND");
    algoritmo.insertarPalabra("MORE");
    algoritmo.insertarResolucion("MONEY");

    boolean resultado = algoritmo.resolver();
    System.out.println(resultado);
    char[] letras = algoritmo.getLetras();
    int[] valoresLetras = algoritmo.getValoresLetras();
    for (int i = 0; i < letras.length; i++) {
      System.out.println(letras[i] + ":" + valoresLetras[i]);
    }
  }
}

class Algoritmo {
  IndiceLetras indiceLetras;
  PilaPalabras pilaPalabras;
  Palabra resolucion;

  public void insertarPalabra(String palabra) {
    indiceLetras.insertar(palabra);
  }

  public int[] getValoresLetras() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getValoresLetras'");
  }

  public char[] getLetras() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getLetras'");
  }

  public boolean resolver() {
    return pilaPalabras.valorTotal(indiceLetras) == resolucion.valor(indiceLetras);
  }

  public void insertarResolucion(String palabra) {
    resolucion = new Palabra(palabra);
  }

}
