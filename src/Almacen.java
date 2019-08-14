import java.util.ArrayList;

public class Almacen {
    private Producto[] listaProducto;
    private int cantidadDeProductosIngresados;

    public Almacen(int cantidadPro) {
        listaProducto = new Producto[cantidadPro];
        this.cantidadDeProductosIngresados = 0;
    }

    public void agregarProducto(Producto nuevoProducto) {
        // Valida que el codigo de producto cumpla con las reglas de codigo
        if (this.validarProducto(nuevoProducto.getCodigo())) {
            // Si el producto no existe o si es el primer elemento a agregar,
            // lo ingresa a la lista
            if (this.buscarProductoPorCodigo(nuevoProducto.getCodigo()) == null
                    || this.cantidadDeProductosIngresados == 0) {
                this.listaProducto[cantidadDeProductosIngresados] = nuevoProducto;
                this.cantidadDeProductosIngresados++;
            } else
                System.out.println("El producto ya existe");
        } else
            System.out.println(
                    "No se puede crear producto ya que el codigo ingresado no cumple con las reglas de codigo");
    }

    public void incrementarUnidades(String codigo, int cantidad) {
        int posicion = this.obtenerPosicionProducto(codigo);
        // El obtener posicion prodcuto se encarga de ver si existe y donde esta
        // guardado
        if (posicion == -1) {
            System.out.println("El producto no existe");
        } else {
            this.listaProducto[posicion].setCantidad(this.listaProducto[posicion].getCantidad() + cantidad);
        }
    }

    private int obtenerPosicionProducto(String codigo) {
        for (int i = 0; i < cantidadDeProductosIngresados; i++) {
            if (this.listaProducto[i].getCodigo().equals(codigo)) {
                return i;
            } // Devuelve -1 si no existe el producto
        }
        return -1;
    }

    public double calcularPrecioPromedio() {
        double sumatoriaPrecios = 0.0;
        int sumatoriaCantidades = 0;
        double promedio;
        for (int i = 0; i < cantidadDeProductosIngresados; i++) {
            sumatoriaCantidades += this.listaProducto[i].getCantidad();
            sumatoriaPrecios += this.listaProducto[i].getPrecio();
        }
         promedio = (double) (sumatoriaPrecios / sumatoriaCantidades);
        if (sumatoriaCantidades == 0) {
            return 0;
        } else {
            return promedio;
        }

    }

    public void mostrarProductos() {
        if (this.cantidadDeProductosIngresados != 0) {
            for (int i = 0; i < cantidadDeProductosIngresados; i++) {
                System.out.println(this.listaProducto[i]);
            }
        } else {
            System.out.println("No hay productos en el almacen");
        }
    }

    public Producto obtenerProductoMasCaro() {
        Producto masCaro = null;
        for (int i = 0; i < cantidadDeProductosIngresados; i++) {
            if (i == 0) { // El primer producto siempre es el mas caro
                masCaro = this.listaProducto[i]; // no usa el .getPrecio porque guarda TODO el producto.
            }
            if (this.listaProducto[i].getPrecio() > masCaro.getPrecio()) {
                masCaro = this.listaProducto[i];
            }
        }
        return masCaro;// Devuelve el producto mas caro guardado
    }

    public boolean validarProducto(String codigo) {
        // Se verifica si el primer caracter es una letra y si el codigo tiene 4
        // unidades.
        if (Character.isLetter(codigo.charAt(0)) == true && codigo.length() == 4)
            return true;
        else
            return false;
    }

    public Producto buscarProductoPorCodigo(String codigoABuscar) {
        // usa equals porque String es tipo objeto
        for (int i = 0; i < this.cantidadDeProductosIngresados;i++) {
            if (this.listaProducto[i].getCodigo().equals(codigoABuscar))
                return this.listaProducto[i];
        }
        return null;
    }

    public void ordenarListaPorCantidad() {
        Producto auxiliar = null;
        for (int i = 0; i < this.cantidadDeProductosIngresados; i++) {
            for (int j = 0; j < this.cantidadDeProductosIngresados - 1; j++) {
                if (this.listaProducto[j].getCantidad() < this.listaProducto[j + 1].getCantidad()) {
                    auxiliar = listaProducto[j];
                    listaProducto[j] = listaProducto[j + 1];
                    listaProducto[j + 1] = auxiliar;
                }
            }
        }
        for (int i = 0; i < cantidadDeProductosIngresados; i++) {
            System.out.println(listaProducto[i]);
        }
    }

    public void eliminarProducto(String codigoAEliminar) {
        int posicion = this.obtenerPosicionProducto(codigoAEliminar);
        if (posicion == -1) {
            System.out.println("El producto no existe");
        } else {
            this.listaProducto[posicion] = null;
            cantidadDeProductosIngresados--;
            System.out.println("El producto con codigo " + codigoAEliminar + " ha sido eliminado");
            ordenarListaPorCantidad();
        }
    }
}



