/**
 * Clase de la boleta
 */
public class Voucher {

    /**
     * El instrumento vendido
     */
    private String instrumentSold;
    /**
     * El precio del intrumento vendido
     */
    private int priceInstrumentSold;


    /**
     * Constructor de la boleta
     * @param instrumentSold string
     * @param priceInstrumentSold inr
     */
    public Voucher(String instrumentSold, int priceInstrumentSold) {
        this.instrumentSold = instrumentSold;
        this.priceInstrumentSold = priceInstrumentSold;
    }

    /**
     *
     * @return instrumento vendido
     */
    public String getInstrumentSold() {
        return instrumentSold;
    }

    /**
     *
     * @return precio del intrumento vendido
     */
    public int getPriceInstrumentSold() {
        return priceInstrumentSold;
    }
}
