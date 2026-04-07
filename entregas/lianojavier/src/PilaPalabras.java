
public class PilaPalabras {
  NodoPalabra primerNodo;

  public void push(String palabra) {
    if (primerNodo == null) {
      primerNodo = new NodoPalabra(palabra);
    } else {
      primerNodo.push(palabra);
    }
  }

}
