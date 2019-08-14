import java.util.Scanner;

public class AdministracionStock {
    public static void main(String[] args) {
        Scanner tecladoN= new Scanner(System.in);
        Scanner tecladoL= new Scanner(System.in);
        System.out.println("Ingrese la cantidad de productos en stock");
        int cantidadProductos=tecladoN.nextInt();

        Almacen miAlmacen= new Almacen(cantidadProductos);
        int opcion=0;

        do{
            System.out.println(" ");
            System.out.println("Ingresar opcion deseada");
            System.out.println("1 agregar productos al almacen");
            System.out.println("2 buscar producto por codigo");
            System.out.println("3 incrementar unidades de un producto");
            System.out.println("4 mostrar producto listado mas caro");
            System.out.println("5 ordenar lista por cantidad");
            System.out.println("6 mostrar lista de productos");
            System.out.println("7 para eliminar un producto");
            System.out.println("0 para salir");

            opcion=tecladoN.nextInt();
            switch (opcion){
                case 1:
                    System.out.println("Ingrese codigo a ingresar");
                    String codigo=tecladoL.nextLine();
                    System.out.println("Ingrese descripcion del producto");
                    String descripcion=tecladoL.nextLine();
                    System.out.println("Ingrese la cantidad");
                    int cantidad = tecladoN.nextInt();
                    System.out.println("Ingrese el precio");
                    double precio = tecladoN.nextDouble();

                    Producto nuevoProducto = new Producto(codigo, descripcion, cantidad, precio);
                    miAlmacen.agregarProducto(nuevoProducto);
                    break;
                case 2:
                    System.out.println("Ingrese el codigo del producto");
                    String codigoABuscar= tecladoL.next();
                    Producto productoBuscado= miAlmacen.buscarProductoPorCodigo(codigoABuscar);
                    if (productoBuscado==null){
                        System.out.println("No se encontraron coincidencias con "+ codigoABuscar);
                    } else{
                        System.out.println("El codigo "+codigoABuscar+" es: "+productoBuscado);
                    }
                    break;
                case 3:
                    System.out.println("Ingrese el codigo del producto a modificar su cantidad");
                    String codigoBuscar= tecladoN.next();
                    System.out.println("Ingrese la cantidad de unidades a aumentar");
                    int cantidadModificar= tecladoL.nextInt();
                    miAlmacen.incrementarUnidades(codigoBuscar, cantidadModificar);
                    break;
                case 4:
                    Producto productoMasCaro=miAlmacen.obtenerProductoMasCaro();
                    if (productoMasCaro==null){
                        System.out.println("No hay productos ingresados");
                    } else{
                        System.out.println("El producto mas caro es"+productoMasCaro);
                    }
                    break;
                case 5:
                    miAlmacen.ordenarListaPorCantidad();
                    break;
                case 6:
                    miAlmacen.mostrarProductos();
                    break;
                case 7:
                    System.out.println("Ingrese codigo del producto a eliminar");
                    String codigoAEliminar = tecladoL.nextLine();
                    miAlmacen.eliminarProducto(codigoAEliminar);
                    break;
                case 8:
                    miAlmacen.calcularPrecioPromedio();
                    break;
                default:
            }

        }while (opcion!=0);
    }
}