public class insertionSort {
  public static void main(String[] args) {
    int[] array = { 5, 2, 8, 1, 9, 3 };
    ordenar(array);
  }

  public static void ordenar(int[] array) {
    new Traza().seleccionarArray(array)
        .mensajeLog("Array inicial")
        .imprimir();

    for (int i = 1; i < array.length; i++) {
      int actual = array[i];
      new Traza().seleccionarArray(array)
          .seleccionarItem(new int[] { i })
          .mensajeLog("Seleccionamos " + actual + " en posicion " + i)
          .imprimir();
      int j = i - 1;

      while (j >= 0 && array[j] > actual) {
        array[j + 1] = array[j];
        new Traza().seleccionarArray(array)
            .seleccionarItem(new int[] { j + 1, j })
            .mensajeLog("Arrastramos " + array[j] + " a la posicion " + (j + 1))
            .imprimir();
        j--;
      }
      array[j + 1] = actual;
      new Traza().seleccionarArray(array)
          .seleccionarItem(new int[] { (j + 1) })
          .mensajeLog("Arrastramos " + actual + " a la posicion " + (j + 1))
          .imprimir();
    }
  }

  public static void ordenar(int[] array, int n) {
    if (n <= 1) {
      return;
    }
    ordenar(array, n - 1);
    int ultimo = array[n - 1];
    int j = n - 2;
    while (j >= 0 && array[j] > ultimo) {
      array[j + 1] = array[j];
      j--;
    }
    array[j + 1] = ultimo;
  }
}
