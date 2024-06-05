import java.util.ArrayList;
import java.util.List;

public class ProductoService {
    private List<Producto> productos = new ArrayList<>();

    public void crearProducto(Producto producto) {
        productos.add(producto);
    }

    public Producto buscarProductoPorCodigo(String codigo) {
        for (Producto producto : productos) {
            if (producto.getCodigo().equals(codigo)) {
                return producto;
            }
        }
        return null;
    }

    public boolean actualizarProducto(String codigo, Producto nuevoProducto) {
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getCodigo().equals(codigo)) {
                productos.set(i, nuevoProducto);
                return true;
            }
        }
        return false;
    }

    public boolean eliminarProducto(String codigo) {
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getCodigo().equals(codigo)) {
                productos.remove(i);
                return true;
            }
        }
        return false;
    }

    public List<Producto> listarProductos() {
        return productos;
    }
}