
public class NodoLetras {
  NodoLetras nodoIzquierdo;
  NodoLetras nodoDerecho;

  char letra;

  public NodoLetras(char letra) {
    this.letra = letra;
  }

  public void insertar(char nuevaLetra) {
    if (nuevaLetra < letra) {
      insertarLetraEnArbol(nodoIzquierdo, nuevaLetra);
    } else {
      insertarLetraEnArbol(nodoDerecho, nuevaLetra);
    }
  }

  private void insertarLetraEnArbol(NodoLetras nodo, char nuevaLetra) {
    if (nodo == null) {
      nodo = new NodoLetras(nuevaLetra);
    } else {
      nodo.insertar(nuevaLetra);
    }
  }

  public boolean buscar(char letraABuscar) {
    if (this.letra == letraABuscar) {
      return true;
    }

    if (nodoIzquierdo != null && letraABuscar < this.letra) {
      return nodoIzquierdo.buscar(letraABuscar);
    } else if (nodoDerecho != null && letraABuscar > this.letra) {
      return nodoDerecho.buscar(letraABuscar);
    }

    return false;
  }

}
