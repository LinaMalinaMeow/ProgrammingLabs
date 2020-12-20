public class Day {
    private String Name;
    private String up=" увеличивался ";
    private String down= " уменьшался ";
    private  String date;
    public String getDate(String date){ return this.date= date;}
    public String getUp(){return this.Name+this.up;}
    public String getDown(){return this.Name+this.down;}
    public void setName(String name) {
        this.Name = name;
    }
    public String getName() {
        return this.Name;
    }
}
