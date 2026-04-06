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
    private String[] sumandos = new String[0];
    private String resultadoEsperado;
    private char[] letrasUnicas;
    private int[] valores;
    private boolean[] digitosEnUso = new boolean[10];

    public void insertarPalabra(String palabra) {
        sumandos = añadirEspacioAlFinalEnLista(sumandos);
        sumandos[sumandos.length - 1] = palabra;
    }

    public void insertarResolucion(String resolucion) {
        this.resultadoEsperado = resolucion;
    }

    public void resolver() {
        prepararEstructuras();
        if (buscarSolucionRecursiva(0)) {
            mostrarResultado();
        }
    }

    private void prepararEstructuras() {
        String textoCompleto = resultadoEsperado;
        for (String s : sumandos) textoCompleto += s;

        String unicas = "";
        for (char c : textoCompleto.toCharArray()) {
            if (unicas.indexOf(c) == -1) unicas += c;
        }

        letrasUnicas = unicas.toCharArray();
        valores = new int[letrasUnicas.length];
    }

    private boolean buscarSolucionRecursiva(int indice) {
        if (indice == letrasUnicas.length) {
            return validarOperacion();
        }

        for (int d = 0; d <= 9; d++) {
            if (esAsignacionValida(letrasUnicas[indice], d)) {
                asignarDato(indice, d);
                if (buscarSolucionRecursiva(indice + 1)) return true;
                liberarDato(indice, d);
            }
        }
        return false;
    }

    private boolean esAsignacionValida(char letra, int digito) {
        if (digitosEnUso[digito]) return false;
        if (digito == 0 && esLetraNoNula(letra)) return false;
        return true;
    }

    private void asignarDato(int indice, int digito) {
        valores[indice] = digito;
        digitosEnUso[digito] = true;
    }

    private void liberarDato(int indice, int digito) {
        digitosEnUso[digito] = false;
    }

    private boolean esLetraNoNula(char c) {
        if (resultadoEsperado.charAt(0) == c) return true;
        for (String s : sumandos) {
            if (s.charAt(0) == c) return true;
        }
        return false;
    }

    private boolean validarOperacion() {
        long sumaSumandos = 0;
        for (String s : sumandos) {
            sumaSumandos += transformarPalabraANumero(s);
        }
        return sumaSumandos == transformarPalabraANumero(resultadoEsperado);
    }

    private long transformarPalabraANumero(String palabra) {
        long numero = 0;
        for (char c : palabra.toCharArray()) {
            numero = numero * 10 + obtenerValorDeLetra(c);
        }
        return numero;
    }

    private int obtenerValorDeLetra(char c) {
        for (int i = 0; i < letrasUnicas.length; i++) {
            if (letrasUnicas[i] == c) return valores[i];
        }
        return -1;
    }

    private void mostrarResultado() {
        for (int i = 0; i < letrasUnicas.length; i++) {
            System.out.print(letrasUnicas[i] + ":" + valores[i] + " ");
        }
        System.out.println();
    }

    public String[] añadirEspacioAlFinalEnLista(String[] lista) {
        String[] nueva = new String[lista.length + 1];
        System.arraycopy(lista, 0, nueva, 0, lista.length);
        return nueva;
    }
}
