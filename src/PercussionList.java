/**
 * Clase que representa a la lista de los instrumentos de percusion
 */
public class PercussionList {


    /**
     * Cantidad maxima
     *
     */
    private int maxAmount;

    /**
     * Cantidad Actual
     *
     */
    private int percussionAmount;

    /**
     *  Lista
     */
    private PercussionInstrument[] percussionLists;

    /**
     * Creacion de lista
     * @param maxAmount
     */
    public PercussionList(int maxAmount){
        this.percussionAmount = 0;
        if (maxAmount <= 0){
            throw new IllegalArgumentException("La lista debe ser mayor a 0.");
        }
        this.maxAmount = maxAmount;
        this.percussionLists = new PercussionInstrument[this.maxAmount];
    }

    /**
     * Metodo para agregar instrumento
     * @param instrument
     */
    public void addInstrument(PercussionInstrument instrument){
        // Revisa si esta llena la lista.
        if (this.maxAmount == this.percussionAmount){
            throw new IllegalArgumentException("No se puede añadir");
        }

        //Recorre la lista
        for (int i=0; i<this.percussionAmount; i++){
            if (this.percussionAmount != 0){
                //Revisa si ya esta el instrumento en la lista para que no se dupliquen
                if (this.percussionLists[i].getCode().equals(instrument.getCode()) && this.percussionLists[i].getStock() == instrument.getStock()){
                    java.lang.System.out.println("Instrumento " + instrument.getCode() + " ya en el inventario!");
                    return;
                } else if(this.percussionLists[i].getCode().equals(instrument.getCode()) && this.percussionLists[i].getStock() != instrument.getStock()){
                    this.percussionLists[i] = instrument;
                    java.lang.System.out.println("Instrumento " + instrument.getCode() + " actualizado!");
                    return;
                }
            }
        }
        this.percussionLists[this.percussionAmount] = instrument;
        this.percussionAmount++;
    }

    /**
     *
     * @return la cantidad maxima
     */
    public int getMaxAmount() {
        return maxAmount;
    }

    /**
     *
     * @return la cantidad actual
     */
    public int getPercussionAmount() {
        return percussionAmount;
    }

    /**
     *
     * @return datos de cada instrumento de percusion
     */
    public boolean getPercussionLists() {
        for (int i=0; i<this.percussionAmount; i++){
            java.lang.System.out.println("Nombre:" + this.percussionLists[i].getName());
            java.lang.System.out.println("Precio:" + this.percussionLists[i].getPrice());
            java.lang.System.out.println("Codigo:" + this.percussionLists[i].getCode());
            java.lang.System.out.println("Tipo de percusion:" + this.percussionLists[i].getTypePercussion());
            java.lang.System.out.println("Stock:" + this.percussionLists[i].getStock());
            java.lang.System.out.println(" ");
        }
        if (this.percussionAmount == 0){
            java.lang.System.out.println("No hay instrumentos de percusión");
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
        return this.percussionLists[position].toCSV();
    }


    /**
     * Metodo para vender instrumento de percusion
     * @param code Codigo de intrumento
     */
    public void sellP(String code){
        // recorre la lista de instrumentos de percusion
        for (int i = 0; i < this.percussionAmount; i++){
            // revisa el codigo si es igual
            if (this.percussionLists[i].getCode().equals(code)){
                //verifica si hay stock
                if(this.percussionLists[i].getStock() != 0){
                    // le resta uno
                    this.percussionLists[i].setStock((this.percussionLists[i].getStock() - 1));
                    // crea la boleta
                    Voucher n = new Voucher(this.percussionLists[i].getName(), this.percussionLists[i].getPrice());
                    java.lang.System.out.println("Boleta Virtual: ");
                    java.lang.System.out.println("Articulo vendido: " + n.getInstrumentSold());
                    java.lang.System.out.println("Precio articulo vendido: " + n.getPriceInstrumentSold());
                }else{
                    java.lang.System.out.println("No hay Stock de " + this.percussionLists[i].getName());
                }
            }
        }
    }
}
