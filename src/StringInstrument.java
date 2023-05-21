/**
 * Clase de instrumento de cuerda
 *
 */
public class StringInstrument extends Instrument {


    /**
     * Tipo de cuerda
     */
    private String typeString;

    /**
     * Numero de cuerdas
     */
    private int numberStrings;

    /**
     * El tipo
     */
    private String type;


    /**
     * Creador del instrumento de cuerda
     *
     * @param code String
     * @param price int
     * @param stock int
     * @param material String
     * @param name String
     * @param typeString String
     * @param numberStrings int
     * @param type String
     */
    public StringInstrument(String code, int price, int stock, String material, String name, String typeString, int numberStrings, String type) {
        super(code, price, stock, material, name);
        this.numberStrings = numberStrings;
        this.type = type;
        this.typeString = typeString;
    }

    /**
     *
     * @return datos del instrumento para el nuevo csv
     */
    public String toCSV() {
        return this.getCode() + "," + this.getPrice() + "," + this.getStock() + ",Cuerda," + this.getName() + "," + this.typeString + "," + this.numberStrings + "," + this.getMaterial() + "," + this.getType() + ",null";

    }

    /**
     * @return Tipo de cuerda
     */
    public String getTypeString() {
        return typeString;
    }

    /**
     * Se utuliza para definir o editar el dato tipo de cuerda
     *
     * @param typeString String
     */
    public void setTypeString(String typeString) {
        this.typeString = typeString;
    }

    /**
     * @return el numero de cuerdas
     */
    public int getNumberStrings() {
        return numberStrings;
    }

    /**
     * Se utuliza para definir o editar el dato numero de cuerdas
     *
     * @param numberStrings int
     */
    public void setNumberStrings(int numberStrings) {
        this.numberStrings = numberStrings;
    }

    /**
     * @return el tipo
     */
    public String getType() {
        return type;
    }


    /**
     * Se utuliza para definir o editar el dato tipo
     * @param type String
     */
    public void setType(String type) {
        this.type = type;
    }
}
