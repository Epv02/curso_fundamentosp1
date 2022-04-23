import java.util.ArrayList;
import java.util.Random;

public class Zombie{
    private String nombre;
    private float salud;
    private String tipoSangre;
    private int anioNacimiento;
    private int mesNacimiento;
    private int diaNacimiento;

    public Zombie(String nombre,float salud,String tipo,int anio,int mes, int dia){
        this.nombre=nombre;
        this.salud=salud;
        this.tipoSangre=tipo;
        this.anioNacimiento=anio;
        this.mesNacimiento=mes;
        this.diaNacimiento=dia;
    }

    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public String getNombre(){
        return this.nombre;
    }

    public void setSalud(float salud){
        if(salud>=0){
            this.salud=salud;
        }else{
            this.salud=0;
        }
    }

    public float getSalud(){
        return this.salud;
    }

    public void setTipoSangre(String tipo){
        this.tipoSangre=tipo;
    }

    public String getTipoSangre(){
        return this.tipoSangre;
    }

    public void setAnioNacimiento(int anio){
        this.anioNacimiento=anio;
    }
    
    public int getAnioNacimento(){
        return this.anioNacimiento;
    }

    public int getDiaNacimento(){
        return this.diaNacimiento;
    }
    
    public void setDiaNacimiento(int dia){
        if((dia<=31)&&(dia>0)){
            this.diaNacimiento=dia;
        }else{
            this.diaNacimiento=0;
        }
    }

    public int getMesNacimento(){
        return this.mesNacimiento;
    }
    
    public void setMesNacimiento(int mes){
        if((mes<=12)&&(mes>0)){
            this.mesNacimiento=mes;
        }else{
            this.mesNacimiento=0;
        }
        
    }

    public String toString(){
        String infoZombie= "El nombre del Zombie es "+this.getNombre()+", su salud es "+this.getSalud()+", su tipo de sangre es "+this.getTipoSangre()+" y nació el "+this.getDiaNacimento()+"/"+this.getMesNacimento()+"/"+this.getAnioNacimento()+"\n";
        return infoZombie;
    }

    public static String mostrarZombies(){
        String infoZombie = "";
        for(int i=0; i<Principal.zombies.size(); i++){
            infoZombie =  Principal.zombies.get(i).toString()+infoZombie;      
        }
        return infoZombie;
    }

    public static String buscarSangre(){
        String zombiesSangre = "";
        for(int i = 0; i<Principal.zombies.size(); i++){
            if((Principal.zombies.get(i).getTipoSangre()).equals("O+") || (Principal.zombies.get(i).getTipoSangre()).equals("AB+")){
                zombiesSangre = zombiesSangre + Principal.zombies.get(i).toString();
            }
        }
        return zombiesSangre;
    }

    public static String buscarAnio(){
        String zombiesAnio = "";
        for(int i = 0; i<Principal.zombies.size(); i++){
            if(Principal.zombies.get(i).getAnioNacimento()>2000){
                zombiesAnio = zombiesAnio + Principal.zombies.get(i).toString();
            }
        }
        return zombiesAnio;
    }

    public static void disminuirSalud(){
        for(int i = 0; i<Principal.zombies.size(); i++){
            Principal.zombies.get(i).setSalud(Principal.zombies.get(i).getSalud()/2);
        }

    }

    public static String fraseZombie(){
        Random random = new Random();
        int min = 1;
        int max = 4;
        int numero = random.nextInt(max + min)+min;
        String frase = "";

        switch(numero){
            case 1: 
                frase = "Es mejor que tengas cuidado porque voy por tu cerebro";
                break;

            case 2: 
                frase = "Mmm veo que tu cabeza está más vacía de lo que esperaba, muy poco cerebro para cenar";
                break;

            case 3: 
                frase = "Que rico cerebro, es mejor que te cuides, no sé cuando pueda tener hambre";
                break;

            case 4: 
                frase = "¿Qué es ese olor....? Ujum! Ya sé, Cerebroooooo";
                break;

            case 5: 
                frase = "No importa cuánto corras, ese cerebro será mi cena, estoy bastante hambriento";
                break;
        }
        return frase;
    }
}

