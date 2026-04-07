
public class IndiceLetras {
  private ArbolLetras arbol = new ArbolLetras();

  public void insertar(String palabra) {
    char[] palabraChar = palabra.toCharArray();
    for (char letra : palabraChar) {
      if (!estaIndexada(letra)) {
        insertar(letra);
      }
    }
  }

  private boolean estaIndexada(char letra) {
    return arbol.estaIndexada(letra);
  }

  public void insertar(char letra) {
    arbol.insertar(letra);
  }

}
