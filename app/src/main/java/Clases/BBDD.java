package Clases;

public class BBDD {
    private String Id;
    private String Nombre;
    private String Destino;
    private String Promocion;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        this.Id = id;
    }

    public BBDD(){

    }
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }

    public String getDestino() {
        return Destino;
    }

    public void setDestino(String destino) {
        this.Destino = destino;
    }

    public String getPromocion() {
        return Promocion;
    }

    public void setPromocion(String promocion) {
        this.Promocion = promocion;
    }
    @Override
    public String toString() {
        return  " Nombre ='" + Nombre + '\'' +
                " Destino ='" + Destino + '\'' +
                " Promocion ='" + Promocion + '\'';
    }
}

