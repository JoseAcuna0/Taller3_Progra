import java.util.Scanner;

/**
 * Clase SystemImpl
 */
public class SystemImpl implements System {

    /**
     *  Inicializa las listas de cada tipo de instrumento
     */
    Inventory i = new Inventory();
    /**
     * Opcion para usar en el menu
     */
    String option = "";

    /**
     * Escaner para las opciones que se piden por pantalla
     */
    Scanner sc = new Scanner(java.lang.System.in);

    /**
     * Establece false debido que el inventario no ha sido cargado aun
     */
    private boolean openInventory = false;

    /**
     * Menu de tienda
     */
    public SystemImpl(){

        java.lang.System.out.println("Bienvenido al menú del Sistema.");


        while (!option.equals("4.")) {
            java.lang.System.out.println(" ");
            java.lang.System.out.println("[1] Agregar instrumentos al inventario.");
            java.lang.System.out.println("[2] Vender instrumento.");
            java.lang.System.out.println("[3] Consultar inventario.");
            java.lang.System.out.println("[4] Salir.");
            java.lang.System.out.println("Ingrese lo que desea hacer:");
            option = sc.nextLine();

            if (option.equals("1")) {
                if (openInventory == false){
                    openInventory = addInstrument();
                }
                if (openInventory == true){
                    java.lang.System.out.println("Inventario ya cargado! ");
                }



            } else if (option.equals("3")) {
                consultInventory();
            }

            else if (option.equals("2")) {
                sellInstrument();
            }

            else if (option.equals("4")){
                exitMenu(openInventory);
            }

        }
    }

    /**
     * El main
      * @param args
     */
    public static void main(String[] args) {
        SystemImpl s = new SystemImpl();
    }

    /**
     * Metodo para añadir instrumento
     * @return
     */
    @Override
    public boolean addInstrument() {
        i.readInventory();
        return true;
    }

    /**
     * Metodo para vender instrumentos
     */
    @Override
    public void sellInstrument() {
        boolean value = false;
        value = i.getInventory();
        if (value == true){
            String code = "";
            java.lang.System.out.println("Ingrese el codigo del instrumento que desea: ");
            code = sc.nextLine();
            i.sellWindInstrument(code);
            i.sellPercussionInstrument(code);
            i.sellStringInstrument(code);
        }
        else {
            return;
        }
    }

    /**
     * Metodo para consultar el inventario
     */
    @Override
    public void consultInventory() {
        i.getInventory();
    }


    /**
     * Metodo para salir del menu y guardar el inventario actualizado
     * @param inventoryOpen booleano
     */
    @Override
    public void exitMenu(boolean inventoryOpen) {
        i.saveInventory(i.getPercussionList(),i.getWindList(),i.getStringList(),inventoryOpen);
        option = "4.";
    }
}
