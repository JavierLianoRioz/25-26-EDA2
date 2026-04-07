
public class NodoPalabra {
  NodoPalabra siguienteNodo;
  Palabra palabra;

  public NodoPalabra(String palabra) {
    this.palabra = new Palabra(palabra);
  }

  public void push(String palabra) {
    if (siguienteNodo == null) {
      siguienteNodo = new NodoPalabra(palabra);
    } else {
      siguienteNodo.push(palabra);
    }
  }

}
