import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

/**
 * Clase inventario
 */
public class Inventory {

    /**
     * lista de instrumentos de percusion
     */
    private PercussionList percussionList;

    /**
     * lista de instrumentos de viento
     */
    private WindList windList;

    /**
     * lista de instrumentos de cuerda
     */
    private StringList stringList;


    public Inventory() {
        this.stringList = new StringList(100);
        this.percussionList = new PercussionList(100);
        this.windList = new WindList(100);
    }

    /**
     * metodo para leer el csv y añadirlo a la lista correspondiente
     */
    public void readInventory() {
        String[] data;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("C:\\Users\\jotom\\Downloads\\TallerProgramacionV0.2\\TallerProgramacionV0.2\\TallerProgramacion\\src\\instumentos.csv"));
            String line = br.readLine();
            boolean firstLine = false;
            while (null != line) {
                data = line.split(",");
                if (firstLine == false) {
                    for (int i = 0; i < 1; i++) {
                        line = br.readLine();
                        data = line.split(",");
                    }
                    firstLine = true;
                }
                String code = data[1];
                int price = Integer.parseInt(data[2]);
                int stock = Integer.parseInt(data[3]);
                String type = data[4];
                String name = data[5];
                String stringType = data[6];
                int strNumber = 0;
                if (!stringType.equals("null")) {
                    strNumber = Integer.parseInt(data[7]);
                }
                String material = data[8];
                String soundType = data[9];
                String heightDef = data[10];
                boolean height = false;
                if (heightDef.equals("Indefinido")) {
                    height = false;
                } else if (heightDef.equals("Definido")) {
                    height = true;
                }
                line = br.readLine();
                if (type.equals("Cuerda")) {
                    StringInstrument s = new StringInstrument(code, price, stock, material, name, stringType, strNumber, soundType);
                    this.stringList.addInstrument(s);
                } else if (type.equals("Percusi�n")) {
                    PercussionInstrument s = new PercussionInstrument(code, price, stock, material, name, soundType, height);
                    this.percussionList.addInstrument(s);
                } else if (type.equals("Viento")) {
                    WindInstrument s = new WindInstrument(code, price, stock, material, name);
                    this.windList.addInstrument(s);
                }

            }
        } catch (Exception e) {
            java.lang.System.out.println("Error leyendo el archivo.");
        }
    }

    /**
     * metodo para guardar el inventario actualizado
     *
     * @param percussion lista percusion
     * @param wind lista viento
     * @param string lista cuerda
     * @param inventoryOpen revisa si el inventario fue importado antes
     */
    public void saveInventory(PercussionList percussion, WindList wind, StringList string, boolean inventoryOpen) {
        if (inventoryOpen == true) {
            Scanner sc = new Scanner(java.lang.System.in);
            File f = new File("C:\\Users\\jotom\\Downloads\\TallerProgramacionV0.2\\TallerProgramacionV0.2\\TallerProgramacion\\src\\instumentos.csv");
            try (FileWriter fw = new FileWriter(f);) {
                int num = 0;
                fw.write("num,codigo_ean,precio,stock,tipo,instrumento,tipo_cuerda,numero_cuerdas,material,tipo_sonido,altura\n");
                for (int i = 0; i < percussion.getPercussionAmount(); i++) {
                    fw.write(Integer.toString(num) + ",");
                    fw.write(percussion.ListToCSV(i) + "\n");
                    num++;
                }
                for (int i = 0; i < string.getStrAmount(); i++) {
                    fw.write(Integer.toString(num) + ",");
                    fw.write(string.ListToCSV(i) + "\n");
                    num++;
                }
                for (int i = 0; i < wind.getWindAmount(); i++) {
                    fw.write(Integer.toString(num) + ",");
                    fw.write(wind.ListToCSV(i) + "\n");
                    num++;
                }
                java.lang.System.out.println("Inventario guardado! Saliendo del sistema...");
            } catch (Exception e) {
                java.lang.System.out.println("Error guardando el archivo.");
            }
        } else {
            java.lang.System.out.println("Saliendo del sistema...");
            return;
        }


    }

    /**
     * @return lista de instrumentos de percusion
     */
    public PercussionList getPercussionList() {
        return this.percussionList;
    }

    /**
     * @returnlista de instrumentos de viento
     */
    public WindList getWindList() {
        return this.windList;
    }

    /**
     * @return lista de instrumentos de cuerda
     */
    public StringList getStringList() {
        return this.stringList;
    }

    /**
     *
     * @return true cuando el inventario esta cargado y false cuando no esta cargado
     */
    public boolean getInventory() {
        boolean value = false;
        boolean value2 = false;
        boolean value3 = false;
        value = this.windList.getWindLists();
        value2 = this.stringList.getStringLists();
        value3 = this.percussionList.getPercussionLists();
        if (value == false && value2 == false && value3 == false) {
            return false;
        }
        return true;
    }

    /**
     * Metodo para vender el instrumento de viento
     *
     * @param code codigo de instrumento
     */
    public void sellWindInstrument(String code) {
        this.windList.sellW(code);
    }


    /**
     * Metodo para vender el instrumento de viento
     * @param code codigo de instrumento
     */
    public void sellPercussionInstrument(String code){
        this.percussionList.sellP(code);
    }

    /**
     * Metodo para vender el instrumento de viento
     * @param code codigo de instrumento
     */
    public void sellStringInstrument(String code){
        this.stringList.sellS(code);
    }
}
