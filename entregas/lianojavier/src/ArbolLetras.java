
public class ArbolLetras {
  private NodoLetras raiz;

  public void insertar(char nuevaLetra) {
    if (raiz == null) {
      raiz = new NodoLetras(nuevaLetra);
    } else {
      raiz.insertar(nuevaLetra);
    }
  }

  public boolean estaIndexada(char letra) {
    return raiz.buscar(letra);
  }

}
