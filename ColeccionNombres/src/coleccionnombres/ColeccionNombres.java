/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package coleccionnombres;

/**
 *
 * @author usuario
 */
public class ColeccionNombres {
       
    private static final int FACTOR_CRECIMIENTO = 5;
    private static String[] nombres = new String[FACTOR_CRECIMIENTO];
    private static int contadorNombres = 0;

    private static void agregar(String nuevoNombre) {
        if (contadorNombres == nombres.length) {
            String[] listaAuxiliar = new String[nombres.length + FACTOR_CRECIMIENTO];
            System.arraycopy(nombres, 0, listaAuxiliar, 0, nombres.length);
            nombres = listaAuxiliar;
        }

        nombres[contadorNombres++] = nuevoNombre;
    }
    
    private static void agregar(String[] listaDeNombres) {
        String[] listaAuxiliar = new String[contadorNombres + listaDeNombres.length];

        System.arraycopy(nombres, 0, listaAuxiliar, 0, nombres.length);
        System.arraycopy(listaDeNombres, 0, listaAuxiliar, contadorNombres, listaDeNombres.length);

        contadorNombres += listaDeNombres.length;
        nombres = listaAuxiliar;
    }

    private static void mostrarNombres() {
        for (int i = 0; i < contadorNombres; i++) {
            System.out.print(nombres[i] + ", ");
        }
        System.out.println();
    }
    
     private static void eliminar(String nombreBuscado, 
                                 boolean ignorarMayusculaMinuscula, 
                                 boolean eliminarTodasOcurrencias) {
        for (int i = 0; i < contadorNombres; i++) {
            if (nombres[i].equals(nombreBuscado) ||
                (nombres[i].equalsIgnoreCase(nombreBuscado) && ignorarMayusculaMinuscula)) {
                for (int j = i; j < nombres.length - 1; j++) {
                    nombres[j] = nombres[j + 1];
                }
                contadorNombres--;

                if (!eliminarTodasOcurrencias) return;
            }
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         agregar("Huarac");
         agregar("Ramos");
         agregar(new String[]{"Otaiza","Luna","Jorge" } );
         agregar(new String[]{"Jose","Jesus","Joaquin","Frandy" } );
         agregar("Andrés");
         mostrarNombres();
         eliminar ("Jesus",true,true);
         mostrarNombres();
    }
    
}
