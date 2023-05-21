/**
 * Clase StringList
 */
public class StringList {

    /**
     * Cantidad maxima
     */
    private int maxAmount;

    /**
     * Cantidad Actual
     */
    private int strAmount;

    /**
     * Lista StringInstrument
     */
    private StringInstrument[] stringLists;

    /**
     * Creador de Stringlist
     *
     * @param maxAmount int
     */
    public StringList(int maxAmount) {
        this.strAmount = 0;
        if (maxAmount <= 0) {
            throw new IllegalArgumentException("La lista debe ser mayor a 0.");
        }
        this.maxAmount = maxAmount;
        this.stringLists = new StringInstrument[this.maxAmount];
    }

    /**
     * Metodo que añade un instrumento de cuerda a la lista
     *
     * @param instrument intrumento de cuerda
     */
    public void addInstrument(StringInstrument instrument) {
        if (this.maxAmount == this.strAmount) {
            throw new IllegalArgumentException("No se puede añadir");
        }
        for (int i = 0; i < this.strAmount; i++) {
            if (this.strAmount != 0) {
                if (this.stringLists[i].getCode().equals(instrument.getCode())) {
                    java.lang.System.out.println("Instrumento " + instrument.getCode() + " ya en el inventario!");
                    return;
                } else if (this.stringLists[i].getCode().equals(instrument.getCode()) && this.stringLists[i].getStock() != instrument.getStock()) {
                    this.stringLists[i] = instrument;
                    java.lang.System.out.println("Instrumento " + instrument.getCode() + " actualizado!");
                    return;
                }
            }
        }
        this.stringLists[this.strAmount] = instrument;
        this.strAmount++;
    }

    /**
     * @return cantidad maxima
     */
    public int getMaxAmount() {
        return maxAmount;
    }

    /**
     * @return cantidad actual
     */
    public int getStrAmount() {
        return strAmount;
    }

    /**
     * @return la lista de datos de cada instrumento de cuerda en la lista
     */
    public boolean getStringLists() {
        for (int i = 0; i < this.strAmount; i++) {
            java.lang.System.out.println("Nombre:" + this.stringLists[i].getName());
            java.lang.System.out.println("Precio:" + this.stringLists[i].getPrice());
            java.lang.System.out.println("Codigo:" + this.stringLists[i].getCode());
            java.lang.System.out.println("Numero de cuerdas:" + this.stringLists[i].getNumberStrings());
            java.lang.System.out.println("Tipo de cuerda:" + this.stringLists[i].getTypeString());
            java.lang.System.out.println("Stock:" + this.stringLists[i].getStock());

            if (this.stringLists[i].getStock() == 0) {
                java.lang.System.out.println("SIN STOCK!");
            }
            java.lang.System.out.println(" ");
        }
        if (this.strAmount == 0) {
            java.lang.System.out.println("No hay instrumentos de cuerda");
            return false;
        }
        return true;
    }


    /**
     *
     * @param position int
     * @return lista con los datos de cada instrumento actualizado
     */
    public String ListToCSV(int position){
        return this.stringLists[position].toCSV();
    }

    /**
     * Metodo para vender instrumento de percusion
     * @param code codigo de instrumento
     */
    public void sellS(String code){
        // recorre la lista de instrumentos de percusion
        for (int i = 0; i < this.strAmount; i++){
            // revisa el codigo si es igual
            if (this.stringLists[i].getCode().equals(code)){
                //verifica si hay stock
                if(this.stringLists[i].getStock() != 0){
                    // le resta uno
                    this.stringLists[i].setStock((this.stringLists[i].getStock() - 1));
                    // crea la boleta
                    Voucher n = new Voucher(this.stringLists[i].getName(), this.stringLists[i].getPrice());
                    java.lang.System.out.println("Boleta Virtual: ");
                    java.lang.System.out.println("Articulo vendido: " + n.getInstrumentSold());
                    java.lang.System.out.println("Precio articulo vendido: " + n.getPriceInstrumentSold());


                }else{
                    java.lang.System.out.println("No hay Stock de " + this.stringLists[i].getName());
                }
            }
        }
    }


}

