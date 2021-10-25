package id.smaraputra.tugassqlite.model;

public class MahasiswaModel {
    private String name, nim;
    private int id;

    public MahasiswaModel(int id, String namein, String nimin) {
        this.id = id;
        this.name = namein;
        this.nim = nimin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) { this.nim = nim; }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
