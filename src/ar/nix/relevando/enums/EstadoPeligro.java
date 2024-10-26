package ar.nix.relevando.enums;

public enum EstadoPeligro {
    NUEVO(1), 
    TRAMITADO(2), 
    CANCELADO(3), 
    SOLUCIONADO(4);

    private final int codigo;

    EstadoPeligro(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }
}
