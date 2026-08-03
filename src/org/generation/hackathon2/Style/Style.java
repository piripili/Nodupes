package org.generation.hackathon2.Style;

public class Style {
    // Estilos
    public static final String RESET = "\u001B[0m";
    public static final String BOLD = "\u001B[1m";

    // Colores de texto
    public static final String CYAN = "\u001B[36m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String RED = "\u001B[31m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String GRAY = "\u001B[90m";

    // Método para limpiar la consola en Windows
    public static void limpiarPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
