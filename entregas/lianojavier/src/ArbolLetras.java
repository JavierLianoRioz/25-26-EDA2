
public class ArbolLetras {
  private NodoLetras raiz;

  public void insertar(Letra letra) {
    if (raiz == null) {
      raiz = new NodoLetras(letra);
    } else {
      raiz.insertar(letra);
    }
  }

  public boolean estaIndexada(char letra) {
    return raiz.buscar(letra);
  }

}
