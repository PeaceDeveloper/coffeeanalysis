import java.util.Date;

public class CoffeeEntity {

//constructor
    
    public CoffeeEntity(){
        
    }
    
    public CoffeeEntity(String id, Date date, double arabicaTipo6, double arabicaTipo7, double arabicaTipo8,
            double conilonTipo7, double conilonTipo8){
        this.id = id;
        this.date = date;
        this.arabicaTipo6 = arabicaTipo6;
        this.arabicaTipo7 = arabicaTipo7;
        this.arabicaTipo8 = arabicaTipo8;
        this.conilonTipo7 = conilonTipo7;
        this.conilonTipo8 = conilonTipo8;
    }
    
    private String id;
    private Date date;
    private double arabicaTipo6;
    private double arabicaTipo7;
    private double arabicaTipo8;
    private double conilonTipo7;
    private double conilonTipo8;

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the arabicaTipo6
     */
    public double getArabicaTipo6() {
        return arabicaTipo6;
    }

    /**
     * @param arabicaTipo6 the arabicaTipo6 to set
     */
    public void setArabicaTipo6(double arabicaTipo6) {
        this.arabicaTipo6 = arabicaTipo6;
    }

    /**
     * @return the arabicaTipo7
     */
    public double getArabicaTipo7() {
        return arabicaTipo7;
    }

    /**
     * @param arabicaTipo7 the arabicaTipo7 to set
     */
    public void setArabicaTipo7(double arabicaTipo7) {
        this.arabicaTipo7 = arabicaTipo7;
    }

    /**
     * @return the arabicaTipo8
     */
    public double getArabicaTipo8() {
        return arabicaTipo8;
    }

    /**
     * @param arabicaTipo8 the arabicaTipo8 to set
     */
    public void setArabicaTipo8(double arabicaTipo8) {
        this.arabicaTipo8 = arabicaTipo8;
    }

    /**
     * @return the conilonTipo7
     */
    public double getConilonTipo7() {
        return conilonTipo7;
    }

    /**
     * @param conilonTipo7 the conilonTipo7 to set
     */
    public void setConilonTipo7(double conilonTipo7) {
        this.conilonTipo7 = conilonTipo7;
    }

    /**
     * @return the conilonTipo8
     */
    public double getConilonTipo8() {
        return conilonTipo8;
    }

    /**
     * @param conilonTipo8 the conilonTipo8 to set
     */
    public void setConilonTipo8(double conilonTipo8) {
        this.conilonTipo8 = conilonTipo8;
    }   
}
