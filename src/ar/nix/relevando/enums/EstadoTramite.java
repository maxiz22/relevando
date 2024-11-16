package ar.nix.relevando.enums;

public enum EstadoTramite {
    PENDIENTE(1, "Pendiente"), 
    EJECUTADO(2, "Ejecutado"), 
    CANCELADO(3, "Cancelado"), 
    SOLUCIONADO(4, "Solucionado");

    private final int codigo;
    private final String descripcion;

    EstadoTramite(int codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public static EstadoTramite getByCodigo(int codigo) {
        for (EstadoTramite estado : EstadoTramite.values()) {
            if (estado.getCodigo() == codigo) {
                return estado;
            }
        }
        return null;
    }
}