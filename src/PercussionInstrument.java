/**
 *
 * Clase que representa un instrumento de percusion
 */
public class PercussionInstrument extends Instrument{

    /**
     * El tipo de percusion
     */
    private String typePercussion;
    /**
     * La altura
     */
    private boolean heightDef;

    /**
     * El constructor del instrumento de percusion
     *
     * @param code String
     * @param price int
     * @param stock int
     * @param material String
     * @param name String
     * @param typePercussion String
     * @param heightDef booleano
     */
    public PercussionInstrument(String code, int price, int stock, String material, String name, String typePercussion, boolean heightDef) {
        super(code, price, stock, material, name);
        this.heightDef = heightDef;
        this.typePercussion = typePercussion;
    }

    /**
     *
     * @return la altura
     */
    public boolean getHeight(){
        return this.heightDef;
    }


    /**
     *
     * @return datos del instrumento para el nuevo csv
     */
    public String toCSV(){
        if (this.getHeight() == true){
            return this.getCode() + "," + this.getPrice() + "," + this.getStock() + ",Percusi�n," + this.getName() + ",null,null," + this.getMaterial() + "," + this.getTypePercussion() + ",Definido";
        } else {
            return this.getCode() + "," + this.getPrice() + "," + this.getStock() + ",Percusi�n," + this.getName() + ",null,null," + this.getMaterial() + "," + this.getTypePercussion() + ",Indefinido";
        }
    }

    /**
     *
     * @return el tipo de percusion
     */
    public String getTypePercussion() {
        return typePercussion;
    }


    /**
     * Se utuliza para definir o editar el dato tipo de percusion
     * @param typePercussion String
     */
    public void setTypePercussion(String typePercussion) {
        this.typePercussion = typePercussion;
    }


    /**
     * Se utuliza para definir o editar el dato altura
     * @param heightDef booleano
     */
    public void setHeightDef(boolean heightDef) {
        this.heightDef = heightDef;
    }
}
