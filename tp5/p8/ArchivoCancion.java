public class ArchivoCancion {
    private String nombre;
    private String genero;
    private double duracion;
    private double tamanio;

    public ArchivoCancion(String nombre, String genero, double duracion, double tamanio){
        this.nombre = nombre;
        this.genero = genero;
        this.duracion = duracion;
        this.tamanio = tamanio;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getGenero() {
        return this.genero;
    }

    public double getDuracion() {
        return this.duracion;
    }

    public double getTamanio() {
        return this.tamanio;
    }

    @Override
    public boolean equals(Object o) {
        try {
            ArchivoCancion otro_archivo = (ArchivoCancion) o;
            return this.getNombre().equalsIgnoreCase(otro_archivo.getNombre()) && this.getGenero().equalsIgnoreCase(otro_archivo.getGenero()) && this.getDuracion() == otro_archivo.getDuracion() && this.getTamanio() == otro_archivo.getTamanio();
        }
        catch(Exception exc) {
            return false;
        }
    }

    @Override
    public String toString() {
        return this.getNombre() + "-" + this.getGenero() + "(" + this.getTamanio() + "KB)";
    }
}