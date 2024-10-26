package ar.nix.relevando.enums;

public enum EstadoTramite {
    PENDIENTE(1), 
    EJECUTADO(2), 
    CANCELADO(3), 
    SOLUCIONADO(4);

    private final int codigo;

    EstadoTramite(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }
}