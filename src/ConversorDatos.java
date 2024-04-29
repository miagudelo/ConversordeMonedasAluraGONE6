public class ConversorDatos {
    private String base_code;
    private String target_code;
    private double conversion_result;


    public ConversorDatos(DatosApi datosApi) {
        this.base_code = datosApi.base_code();
        this.target_code = datosApi.target_code();
        this.conversion_result = datosApi.conversion_result();
    }

    @Override
    public String toString() {
        return  "" + conversion_result;

    }
}
