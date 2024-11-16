package ar.nix.relevando.enums;

public enum EstadoPeligro {
    NUEVO(1, "Nuevo"), 
    TRAMITADO(2, "Tramitado"), 
    CANCELADO(3, "Cancelado"), 
    SOLUCIONADO(4, "Solucionado");

    private final int codigo;
    private final String descripcion;

    EstadoPeligro(int codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }
    
    public static EstadoPeligro getByCodigo(int codigo) {
        for (EstadoPeligro estado : EstadoPeligro.values()) {
            if (estado.getCodigo() == codigo) {
                return estado;
            }
        }
        return null;
    }
    
}
