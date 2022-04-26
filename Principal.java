import java.util.Scanner;
import java.util.ArrayList;

public class Principal{
    public static ArrayList<Zombie> zombies = new ArrayList<Zombie>();
    public static ArrayList<Ubicacion> ubicaciones = new ArrayList<Ubicacion>();

    public static void main(String[] args){
        Principal.mostrarMenu();
    }

    public static void mostrarMenu(){
        Scanner scan = new Scanner(System.in);
        int opcion;

        while(true){
            System.out.println("\n|--------------------------------------------------------------------|");
            System.out.println("|--------------------BASE DE DATOS THE WALKING DEAD------------------|");
            System.out.println("|--------------------------------------------------------------------|");
            System.out.println("|Bienvenido, seleccione que desea realizar                           |");
            System.out.println("|0.Cerrar el programa                                                |");
            System.out.println("|1.Crear un nuevo zombie                                             |");
            System.out.println("|2.Mostrar información de los zombies                                |");
            System.out.println("|3.Mostrar cantidad de zombies creados                               |");
            System.out.println("|4.Mostrar zombies con tipo de sangre O+ o AB+                       |");
            System.out.println("|5.Mostrar zombies nacidos después del 2000                          |");
            System.out.println("|6.Lanzar bomba sobre la ciudad(tranquilo, no vas a matar humanos)   |");
            System.out.println("|7.Crear una nueva ubicacion                                         |");
            System.out.println("|8.Mostrar información de las ubicaciones almacenadas                |");
            System.out.println("|9.Mostrar ubicacion más segura                                      |");
            System.out.println("|10.Mostrar toda las ubicaciones de la ciudad ordenadas por distancia|");
            System.out.println("|11.Mostrar Frase aleatoria zombie                                   |");
            System.out.println("|12.Limpieza de ciudad                                               |");
            System.out.println("|--------------------------------------------------------------------|");
            opcion=scan.nextInt();
            System.out.println("|--------------------------------------------------------------------|\n\n\n");

            if(opcion==0){
                System.out.println("......................................................................"); 
                System.out.println("................El programa se ha cerrado correctamente...............");
                System.out.println("......................................................................");
                break;
            }

            switch(opcion){
                case 1: 
                    System.out.println("Ingrese los siguientes datos: ");
                    System.out.print("Nombre: ");
                    String nombre = scan.next();
                    System.out.print("Salud: ");
                    float salud = scan.nextFloat();
                    if(salud<0){
                        salud = 0;
                    }
                    System.out.println("Fecha de nacimiento ");
                    System.out.print("Ingrese el año: ");
                    int anioNacimiento = scan.nextInt();
                    System.out.print("Ingrese el mes(número): ");
                    int mesNacimiento = scan.nextInt();
                    boolean validacionMes = false;
                    while(validacionMes  != true){
                        if(!((mesNacimiento<=12)&&(mesNacimiento>0))){
                            System.out.print("Valor inválido, ingrese otro: ");
                            mesNacimiento = scan.nextInt();
                        }else{
                            validacionMes = true;
                        }
                    }
                    System.out.print("Ingrese el día(número): ");
                    int diaNacimiento = scan.nextInt();
                    boolean validacionDia = false;

                    while(validacionDia  != true){
                        if(!((diaNacimiento<=31)&&(diaNacimiento>0))){
                            System.out.print("Valor inválido, ingrese otro: ");
                            diaNacimiento = scan.nextInt();
                        }else{
                            validacionDia = true;
                        }
                    }

                    System.out.println("Tipo de sangre: ");
                    String tipoSangre = scan.next();
                    Zombie z1 = new Zombie(nombre,salud,tipoSangre,anioNacimiento,mesNacimiento,diaNacimiento);
                    Principal.zombies.add(z1);
                    System.out.println(".........................");
                    System.out.println("......Zombie creado......");
                    System.out.println(".........................\n\n\n");
                    break;

                case 2:
                    System.out.println("\n-----Zombies almacenados-----\n");
                    System.out.println(Zombie.mostrarZombies());
                    System.out.println("\n-----------------------------\n\n\n");
                    break;

                case 3:
                    System.out.println("\n-----Zombies creados-----\n");
                    System.out.println("Se han creado "+zombies.size()+" zombies");
                    System.out.println("\n--------------------------\n\n\n");
                    break;

                case 4:
                    System.out.println("\n-------Zombies con tipo de sangre 0+ AB+ creados-------\n");
                    System.out.println(Zombie.buscarSangre());
                    System.out.println("\n--------------------------------------------------------\n\n\n");

                    break;

                case 5:
                    System.out.println("\n---Zombies nacidos después del 2000---\n");
                    System.out.println(Zombie.buscarAnio());
                    System.out.println("\n--------------------------------------\n\n\n");
                    break;

                case 6:
                    Zombie.disminuirSalud();
                    System.out.println("..........................................");
                    System.out.println("......Bomba desplegada correctamente......");
                    System.out.println("..........................................\n\n\n");
                    break;

                case 7: 
                    System.out.println("Ingrese los siguientes datos: ");
                    System.out.println("Nombre de la ciudad: ");
                    String nombreCiudad = scan.next();
                    System.out.println("Distancia Alexandria(metros): ");
                    float distanciaAlexandria = scan.nextFloat();
                    if(distanciaAlexandria<0){
                        distanciaAlexandria=0;
                    }
                    System.out.println("Cantidad de zombies: ");
                    int cantidadZombies = scan.nextInt();
                    if(cantidadZombies<0){cantidadZombies=0;}
                    Ubicacion u1 = new Ubicacion(nombreCiudad,distanciaAlexandria,cantidadZombies);
                    Principal.ubicaciones.add(u1);
                    System.out.println("..........................");
                    System.out.println("....Ubicación guardada....");
                    System.out.println("..........................\n\n\n");
                    break;

                case 8:
                    System.out.println("\n---Ubicaciones almacenadas---\n");
                    System.out.println(Ubicacion.mostrarUbicaciones());
                    System.out.println("\n-----------------------------\n\n\n");
                    break;

                case 9: 
                    System.out.println("\n---Ubicacion más segura---\n");
                    System.out.println(Ubicacion.ubicacionSegura());
                    System.out.println("\n--------------------------\n\n\n");
                    break;

                case 10:
                    System.out.println("\n---Ubicaciones ordenadas---\n");
                    System.out.println(Ubicacion.ubicacionOrdenada());
                    System.out.println("\n---------------------------\n\n\n");
                    break;

                case 11: 
                    System.out.println("\n-------------¡CUIDADO! Parece que alguien te está hablando-------------\n");
                    System.out.println(Zombie.fraseZombie());
                    System.out.println("\n-----------------------------------------------------------------------\n");
                    break;

                case 12:
                    System.out.println("\n---Ingrese el numero de soldados---\n");
                    int numeroSoldados = scan.nextInt();
                    System.out.println("\n---Ingresa el nombre de la ciudad---\n");
                    nombreCiudad = scan.next();
                    System.out.println(Ubicacion.limpiezaCiudad(numeroSoldados, nombreCiudad));
                    break;
            }
        }
    }
}
