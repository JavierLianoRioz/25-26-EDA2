public class Acertijo {
  public static void main(String[] args) {
    Algoritmo algoritmo = new Algoritmo();

    algoritmo.insertarPalabra("SEND");
    algoritmo.insertarPalabra("MORE");
    algoritmo.insertarResolucion("MONEY");

    boolean resultado = algoritmo.resolver();
    System.out.println(resultado);
    Letra[] letras = algoritmo.getLetras();
    for (int i = 0; i < letras.length; i++) {
      System.out.println(letras[i].caracter + ":" + letras[i].valor);
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

  public Letra[] getLetras() {
    return indiceLetras.listarLetras();
  }

  public boolean resolver(IndiceLetras indiceLetras) {
    return resolver(indiceLetras.siguientePaso());
  }

  private boolean esConvinacionValida() {
    return pilaPalabras.valorTotal(indiceLetras) == resolucion.valor(indiceLetras);
  }

  public void insertarResolucion(String palabra) {
    resolucion = new Palabra(palabra);
  }

}
