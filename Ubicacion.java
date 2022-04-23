import java.util.ArrayList;

public class Ubicacion {
    private  String nombreCiudad;
    private float distanciaAlexandria;
    private int cantidadZombies;

    public Ubicacion(String nombre, float distanciaAlexandria, int cantidadZombies){
        this.nombreCiudad = nombre;
        this.distanciaAlexandria = distanciaAlexandria;
        this.cantidadZombies = cantidadZombies;
    }

    public void setNombre(String nombre){
        this.nombreCiudad = nombre;
    }

    public void setDistanciaAlexandria(float distanciaAlexandria){
        this.distanciaAlexandria = distanciaAlexandria;
    }

    public void setCantidadZombies(int cantidadZombies){
        this.cantidadZombies = cantidadZombies;
    }

    public String getNombreCiudad(){
        return this.nombreCiudad;
    }

    public float getDistanciaAlexandria(){
        return this.distanciaAlexandria;
    }

    public int getCantidadZombies(){
        return this.cantidadZombies;
    }

    public static String mostrarUbicaciones(){
        String infoUbicacion = "";
        for(int i=0; i<Principal.ubicaciones.size(); i++){
            infoUbicacion= Principal.ubicaciones.get(i).toString()+infoUbicacion;      
        }
        return infoUbicacion;
    }

    public String toString(){
        String infoCiudad= "El nombre de la ciudad es "+this.getNombreCiudad()+", su distancia a Alexandria es "+this.getDistanciaAlexandria()+"m y hay "+this.getCantidadZombies()+" zombies vivos\n";
        return infoCiudad;
    }

    public static String ubicacionSegura(){
        int menosZombies = Principal.ubicaciones.get(0).getCantidadZombies();
        int posicion = 0;
        String masSegura = "";
        for(int i=0; i<Principal.ubicaciones.size(); i++){
            if(Principal.ubicaciones.get(i).getCantidadZombies()<menosZombies){
                menosZombies = Principal.ubicaciones.get(i).getCantidadZombies();
                posicion = i;
                masSegura = Principal.ubicaciones.get(posicion).toString();
            }else if(Principal.ubicaciones.get(i).getCantidadZombies()==menosZombies){
                masSegura = Principal.ubicaciones.get(i).toString();
                masSegura = masSegura + Principal.ubicaciones.get(posicion).toString();
            }
        }
        return masSegura;
    }

    public static String ubicacionOrdenada(){
        int posicion = Principal.ubicaciones.size();
        String ubicacionesOrdenadas = "" ;
        for(int i = 1; i < posicion; i++){
            for(int j = 0; j < posicion - i; j++){
                if(Principal.ubicaciones.get(j).getDistanciaAlexandria()> Principal.ubicaciones.get(j+1).getDistanciaAlexandria()){
                    Ubicacion ubicacionTemporal = new Ubicacion(Principal.ubicaciones.get(j).getNombreCiudad(),
                            Principal.ubicaciones.get(j).getDistanciaAlexandria(),Principal.ubicaciones.get(j).getCantidadZombies());
                    Principal.ubicaciones.set(j, Principal.ubicaciones.get(j+1));
                    Principal.ubicaciones.set(j+1, ubicacionTemporal);
                }
            }
        }

        for(int k = 0; k < posicion; k++){
            ubicacionesOrdenadas = ubicacionesOrdenadas + "\n" + Principal.ubicaciones.get(k).toString();
        }
        return ubicacionesOrdenadas;
    }

    public static String limpiezaCiudad(int cantidadSoldados, String nombreCiudad){
        int posicion = 100;
        String limpieza = "\n......No hay ninguna ciudad llamada asi......\n";
        for(int i = 0; i < Principal.ubicaciones.size(); i++){
            if((Principal.ubicaciones.get(i).getNombreCiudad()).equalsIgnoreCase(nombreCiudad)){
                posicion = i;
            }
        }
        
        if(posicion != 100){
            if(Principal.ubicaciones.get(posicion).getCantidadZombies() <= cantidadSoldados){
                limpieza = "\n......La limpieza de la ciudad se realizo con exito......\n";
                Principal.ubicaciones.get(posicion).setCantidadZombies(0);
            } else {
                limpieza = "\n......No han logrado sobrevivir......\n";
            }
        }
        return limpieza;
    }
}

