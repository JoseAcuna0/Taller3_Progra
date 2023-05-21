/**
 * Clase de instrumento de viento
 *
 */
public class WindInstrument extends Instrument{

    /**
     * Creador del instrumento de viento
     * @param code String
     * @param price int
     * @param stock int
     * @param material String
     * @param name String
     */
    public WindInstrument(String code, int price, int stock, String material, String name) {
        super(code, price, stock, material, name);
    }

    /**
     *
     * @return datos del instrumento para el nuevo csv
     */
    public String toCSV(){
        return this.getCode() + "," + this.getPrice() + "," + this.getStock() + ",Viento," + this.getName() + ",null,null," + this.getMaterial() + ",null,null";
    }
}
