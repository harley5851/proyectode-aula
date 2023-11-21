package administrador;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Administrador {

    public static void main(String[] args) {
        Libreria libreria = new Libreria();
        Scanner opc = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu de Administrador:");
            System.out.println("1. Registrar Producto");
            System.out.println("2. Actualizar Precio");
            System.out.println("3. Actualizar Cantidad");
            System.out.println("4. Mostrar Inventario");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");

            int opcion = opc.nextInt();
            opc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre del producto: ");
                    String nombre = opc.nextLine();
                    System.out.print("Precio del producto: ");
                    double precio = opc.nextDouble();
                    System.out.print("Cantidad del producto: ");
                    int cantidad = opc.nextInt();

                    libreria.registrarProducto(nombre, precio, cantidad);
                    System.out.println("Producto registrado correctamente.");
                    break;

                case 2:
                    System.out.print("Nombre del producto: ");
                    nombre = opc.nextLine();
                    System.out.print("Nuevo precio: ");
                    precio = opc.nextDouble();

                    libreria.actualizarPrecio(nombre, precio);
                    break;

                case 3:
                    System.out.print("Nombre del producto: ");
                    nombre = opc.nextLine();
                    System.out.print("Nueva cantidad: ");
                    cantidad = opc.nextInt();

                    libreria.actualizarCantidad(nombre, cantidad);
                    break;

                case 4:
                    libreria.mostrarInventario();
                    break;

                case 5:
                    System.out.println("Proceso terminado.");
                    System.exit(0);

                default:
                    System.out.println("Opcion no valida. Por favor, elija nuevamente.");
            }
        }
    }
}

class Libreria {

    private final Map<String, Producto> inventario;

    public Libreria() {
        this.inventario = new HashMap<>();
    }

    public void registrarProducto(String nombre, double precio, int cantidad) {
        Producto producto = new Producto(nombre, precio, cantidad);
        inventario.put(nombre, producto);
    }

    public void actualizarPrecio(String nombre, double nuevoPrecio) {
        Producto producto = inventario.get(nombre);
        if (producto != null) {
            producto.setPrecio(nuevoPrecio);
            System.out.println("Precio actualizado correctamente.");
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    public void actualizarCantidad(String nombre, int nuevaCantidad) {
        Producto producto = inventario.get(nombre);
        if (producto != null) {
            producto.setCantidad(nuevaCantidad);
            System.out.println("Cantidad actualizada correctamente.");
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    public void mostrarInventario() {
        System.out.println("Inventario:");
        for (Producto producto : inventario.values()) {
            System.out.println(producto);
        }
    }
}

class Producto {

    private String nombre;
    private double precio;
    private int cantidad;

    public Producto(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", cantidad=" + cantidad +
                '}';
    }
}
