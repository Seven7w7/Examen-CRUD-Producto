import java.util.Scanner;

public class Main {
    private static ProductoService productoService = new ProductoService();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean continuar = true;

        while (continuar) {
            mostrarMenu();
            int opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            switch (opcion) {
                case 1:
                    crearProducto();
                    break;
                case 2:
                    buscarProducto();
                    break;
                case 3:
                    actualizarProducto();
                    break;
                case 4:
                    eliminarProducto();
                    break;
                case 5:
                    listarProductos();
                    break;
                case 6:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("Menú:");
        System.out.println("1. Crear producto");
        System.out.println("2. Buscar producto por código");
        System.out.println("3. Actualizar producto por código");
        System.out.println("4. Eliminar producto por código");
        System.out.println("5. Listar productos");
        System.out.println("6. Salir");
        System.out.print("Selecciona una opción: ");
    }

    private static void crearProducto() {
        System.out.print("Ingrese código: ");
        String codigo = scanner.nextLine();
        System.out.print("Ingrese nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese descripción: ");
        String descripcion = scanner.nextLine();
        System.out.print("Ingrese cantidad: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine();  // Limpiar el buffer

        Producto producto = new Producto(codigo, nombre, descripcion, cantidad);
        productoService.crearProducto(producto);
        System.out.println("Producto creado exitosamente.");
    }

    private static void buscarProducto() {
        System.out.print("Ingrese código: ");
        String codigo = scanner.nextLine();
        Producto producto = productoService.buscarProductoPorCodigo(codigo);

        if (producto != null) {
            System.out.println(producto);
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    private static void actualizarProducto() {
        System.out.print("Ingrese código del producto a actualizar: ");
        String codigo = scanner.nextLine();
        Producto productoExistente = productoService.buscarProductoPorCodigo(codigo);

        if (productoExistente != null) {
            System.out.print("Ingrese nuevo nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese nueva descripción: ");
            String descripcion = scanner.nextLine();
            System.out.print("Ingrese nueva cantidad: ");
            int cantidad = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            Producto nuevoProducto = new Producto(codigo, nombre, descripcion, cantidad);
            productoService.actualizarProducto(codigo, nuevoProducto);
            System.out.println("Producto actualizado exitosamente.");
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    private static void eliminarProducto() {
        System.out.print("Ingrese código del producto a eliminar: ");
        String codigo = scanner.nextLine();

        if (productoService.eliminarProducto(codigo)) {
            System.out.println("Producto eliminado exitosamente.");
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    private static void listarProductos() {
        for (Producto producto : productoService.listarProductos()) {
            System.out.println(producto);
        }
    }
}