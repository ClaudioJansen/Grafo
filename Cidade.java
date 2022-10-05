public class Cidade{
    private String nome;
    private double latitude;
    private double longitude;
    private int posicaoCidade1;
    private int posicaoCidade2;
    private int posicaoCidade3;
    private int posicaoCidade4;

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

    public void setCidade1(int posicaoCidade1){
        this.posicaoCidade1 = posicaoCidade1;
    }

    public int getCidade1(){
        return this.posicaoCidade1;
    }

    public void setCidade2(int posicaoCidade2){
        this.posicaoCidade2 = posicaoCidade2;
    }

    public int getCidade2(){
        return this.posicaoCidade2;
    }

    public void setCidade3(int posicaoCidade3){
        this.posicaoCidade3 = posicaoCidade3;
    }

    public int getCidade3(){
        return this.posicaoCidade3;
    }

    public void setCidade4(int posicaoCidade4){
        this.posicaoCidade4 = posicaoCidade4;
    }

    public int getCidade4(){
        return this.posicaoCidade4;
    }
}