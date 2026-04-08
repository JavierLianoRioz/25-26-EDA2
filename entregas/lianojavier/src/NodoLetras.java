
public class NodoLetras {
  NodoLetras nodoIzquierdo;
  NodoLetras nodoDerecho;

  Letra letra;

  public NodoLetras(Letra letra) {
    this.letra = letra;
  }

  public void insertar(Letra letraAInsertar) {
    if (letraAInsertar.caracter < letra.caracter) {
      insertarLetraEnArbol(nodoIzquierdo, letraAInsertar);
    } else {
      insertarLetraEnArbol(nodoDerecho, letraAInsertar);
    }
  }

  private void insertarLetraEnArbol(NodoLetras nodo, Letra letraAInsertar) {
    if (nodo == null) {
      nodo = new NodoLetras(letraAInsertar);
    } else {
      nodo.insertar(letraAInsertar);
    }
  }

  public boolean buscar(char caracterABuscar) {
    if (this.letra.caracter == caracterABuscar) {
      return true;
    }

    if (nodoIzquierdo != null && caracterABuscar < this.letra.caracter) {
      return nodoIzquierdo.buscar(caracterABuscar);
    } else if (nodoDerecho != null && caracterABuscar > this.letra.caracter) {
      return nodoDerecho.buscar(caracterABuscar);
    }

    return false;
  }

}
