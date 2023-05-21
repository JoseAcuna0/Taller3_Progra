/**
 * Clase de la lista de los intrumento de viento
 */
public class WindList {

    /**
     *  Cantidad Maxima
     */
    private int maxAmount;

    /**
     * Cantidad Actual
     */
    private int windAmount;

    /**
     * Lista Intrumeto de viento
     */
    private WindInstrument[] windLists;

    /**
     * Contrusctor de la lista Intrumeto de viento
     * @param maxAmount int
     */
    public WindList(int maxAmount) {
        this.windAmount = 0;
        if (maxAmount <= 0) {
            throw new IllegalArgumentException("La lista debe ser mayor a 0.");
        }
        this.maxAmount = maxAmount;
        this.windLists = new WindInstrument[this.maxAmount];
    }

    /**
     * Metodo para agregar instrumento a la lista Intrumento de viento
     * @param instrument instrumento de viento
     */
    public void addInstrument(WindInstrument instrument) {
        if (this.maxAmount == this.windAmount) {
            throw new IllegalArgumentException("No se puede añadir");
        }
        for (int i = 0; i < this.windAmount; i++) {
            if (this.windAmount != 0) {
                if (this.windLists[i].getCode().equals(instrument.getCode())) {
                    java.lang.System.out.println("Instrumento " + instrument.getCode() + " ya en el inventario!");
                    return;
                } else if (this.windLists[i].getCode().equals(instrument.getCode()) && this.windLists[i].getStock() != instrument.getStock()) {
                    this.windLists[i] = instrument;
                    java.lang.System.out.println("Instrumento " + instrument.getCode() + " actualizado!");
                    return;
                }
            }
        }
        this.windLists[this.windAmount] = instrument;
        this.windAmount++;
    }

    /**
     *
     * @return la lista de datos de cada instrumento de viento en la lista
     */
    public boolean getWindLists() {
        for (int i = 0; i < this.windAmount; i++) {
            java.lang.System.out.println("Nombre:" + this.windLists[i].getName());
            java.lang.System.out.println("Precio:" + this.windLists[i].getPrice());
            java.lang.System.out.println("Codigo:" + this.windLists[i].getCode());
            java.lang.System.out.println("Stock:" + this.windLists[i].getStock());
            java.lang.System.out.println(" ");
        }
        if (this.windAmount == 0) {
            java.lang.System.out.println("No hay instrumentos de viento");
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
        return this.windLists[position].toCSV();
    }

    /**
     *
     * @return cantidad maxima
     */
    public int getMaxAmount() {
        return maxAmount;
    }

    /**
     *
     * @return cantidad actual
     */
    public int getWindAmount() {
        return windAmount;
    }

    /**
     * Metodo para vender instrumento de percusion
     * @param code String
     */
    public void sellW(String code){
        // recorre la lista de instrumentos de percusion
        for (int i = 0; i < this.windAmount; i++){
            // revisa el codigo si es igual
            if (this.windLists[i].getCode().equals(code)){
                //verifica si hay stock
                if(this.windLists[i].getStock() != 0){
                    // le resta uno
                    this.windLists[i].setStock((this.windLists[i].getStock() - 1));
                    // crea la boleta
                    Voucher n = new Voucher(this.windLists[i].getName(), this.windLists[i].getPrice());
                    java.lang.System.out.println("Boleta Virtual: ");
                    java.lang.System.out.println("Articulo vendido: " + n.getInstrumentSold());
                    java.lang.System.out.println("Precio articulo vendido: " + n.getPriceInstrumentSold());


                }else{
                    java.lang.System.out.println("No hay Stock de " + this.windLists[i].getName());

                }
            }
        }
    }
}
