public class Producto {

    private String codigo;
    private String descripcion;
    private int cantidad;
    private double precio;

    public Producto(String codigo, String descripcion, int cantidad, double precio){
        this.codigo=codigo;
        this.descripcion=descripcion;
        this.cantidad=cantidad;
        this.precio=precio;
    }
    public Producto() {

        this.cantidad=0;
        this.precio=0.0;

    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return " Producto{" +
                "codigo='" + codigo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", cantidad=" + cantidad +
                ", precio=" + precio +
                '}';
    }
}