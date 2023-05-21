/**
 * Clase que representa un instrumento
 *
 */
public class Instrument {

    /**
     * El codigo
     *
     */
    private String code;

    /**
     * EL precio
     */
    private int price;

    /**
     * El stock
     *
     */
    private int stock;

    /**
     * El material
     *
     */
    private String material;

    /**
     * El nombre
     *
     */
    private String name;


    /**
     *
     * El Constructor de Instrument
     *
     * @param code String
     * @param price int
     * @param stock int
     * @param material String
     * @param name String
     *
     */
    public Instrument(String code, int price, int stock, String material, String name){
        this.code = code;
        this.price = price;
        this.stock = stock;
        this.material = material;
        this.name = name;
    }


    /**
     *
     * @return el codigo
     */
    public String getCode() {
        return code;
    }


    /**
     * Se utuliza para definir o editar el dato codigo
     *
     * @param code String
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     *
     * @return el precio
     */
    public int getPrice() {
        return price;
    }


    /**
     * Se utuliza para definir o editar el dato precio
     *
     * @param price int
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     *
     * @return el stock
     */
    public int getStock() {
        return stock;
    }

    /**
     * Se utuliza para definiro editar el dato stock
     * @param stock int
     */
    public void setStock(int stock) {
        this.stock = stock;
    }


    /**
     *
     * @return el material
     */
    public String getMaterial() {
        return material;
    }


    /**
     * Se utuliza para definir o editar el dato Material
     * @param material String
     */
    public void setMaterial(String material) {
        this.material = material;
    }

    /**
     *
     * @return el nombre
     */
    public String getName() {
        return name;
    }


    /**
     * Se utuliza para definir o editar el dato nombre
     * @param name String
     */
    public void setName(String name) {
        this.name = name;
    }
}
