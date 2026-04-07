public class Acertijo {
  public static void main(String[] args) {
    Algoritmo algoritmo = new Algoritmo();

    algoritmo.insertarPalabra("SEND");
    algoritmo.insertarPalabra("MORE");
    algoritmo.insertarResolucion("MONEY");

    algoritmo.resolver();
  }
}

class Algoritmo {
  private PilaSumandos pilaSumandos = new PilaSumandos();
  private String resolucion;
  private ListaLetras listaLetras = new ListaLetras();

  public void insertarPalabra(String palabra) {
    char[] palabraChar = palabra.toCharArray();
    pilaSumandos.insertar(palabraChar);
  }

  public void insertarResolucion(String palabra) {
    resolucion = palabra;
  }

  public void resolver() {
    listarLetras(pilaSumandos);
  }

  private void listarLetras(PilaSumandos unaPilaSumandos) {
    for (int i = 0; i < unaPilaSumandos.length(); i++) {
      char[] palabra = unaPilaSumandos.leer().toCharArray();
      for (char c : palabra) {
        boolean estaLetraEnLista = listaLetras.contiene(c);
        if (!estaLetraEnLista) {
          listaLetras.insertar(c);
        } else if (estaLetraEnLista) {
          listaLetras.contiene(c);
        }
      }
    }
  }

}
