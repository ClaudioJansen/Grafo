public class Cidade{
    private String nome;
    private double latitude;
    private double longitude;

    public Cidade(){
        this.nome = "";
        this.latitude = 0;
        this.longitude = 0;
    }

    public Cidade(String nome, double latitude, double longitude){
        this.nome = nome;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }

    public void setLatitude(double latitude){
        this.latitude = latitude;
    }

    public double getLatitude(){
        return this.latitude;
    }

    public void setLongitude(double longitude){
        this.longitude = longitude;
    }

    public double getLongitude(){
        return this.longitude;
    }
    
}