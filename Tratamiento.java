
import java.io.*;
import java.util.*;

public class Tratamiento {

    public static Scanner teclado = new Scanner(System.in);

    public static void crearFicheroPares( String ruta, ArrayList<String> palabrasPares ) throws IOException {

        String[] splitted = ruta.split("/");

        File rutaArchivo = new File(splitted[1] + "/" + splitted[2] + "/" + splitted[3]);

        File ficheroPares = new File( rutaArchivo, "pares" );

        if ( ficheroPares.createNewFile() ){

            FileWriter fw = null;
            BufferedWriter bw = null;

            try{

                fw = new FileWriter(ficheroPares);
                bw = new BufferedWriter(fw);

                // Escribimos las palabras pares
                for ( String s : palabrasPares ) {
                    bw.write(s + ". Cantidad letras: " + s.length());
                    bw.newLine();
                }

                // Cerramos
                fw.close();
                bw.close();

            }catch( Exception e ) {
                System.out.println("Algo ha fallado.");
            }

        }else{
            System.out.println("Ha habido un problema creando el fichero de pares.");
        }

    }

    public static void crearFicheroImpares( String ruta, ArrayList<String> palabrasImpares ) throws IOException {

        String[] splitted = ruta.split("/");

        File rutaArchivo = new File(splitted[1] + "/" + splitted[2] + "/" + splitted[3]);

        File ficheroImpares = new File( rutaArchivo, "impares" );

        if ( ficheroImpares.createNewFile() ){

            FileWriter fw = null;
            BufferedWriter bw = null;

            try{

                fw = new FileWriter(ficheroImpares);
                bw = new BufferedWriter(fw);

                // Escribimos las palabras pares
                for ( String s : palabrasImpares ) {
                    bw.write(s + ". Cantidad letras: " + s.length());
                    bw.newLine();
                }

                // Cerramos todo
                fw.close();
                bw.close();

            }catch( Exception e ) {
                System.out.println("Algo ha fallado.");
            }

        }else{
            System.out.println("Ha habido un problema creando el fichero de pares.");
        }

    }

    public static void main(String args[] ) throws IOException {

        File f = null;
        String ruta = "";
        ArrayList pares = new ArrayList<String>();
        ArrayList impares = new ArrayList<String>();

        try{

            System.out.println("Ruta del fichero a analizar: ");

            ruta = teclado.nextLine();
            f = new File( ruta );

        }catch( Exception e ){

            System.out.println( "Has puesto el nombre de la ruta o el fichero mal." );

        }

        System.out.println("Vas a tratar el fichero " + f.getAbsolutePath());


        FileReader fr = null;
        FileWriter fw = null;

        BufferedReader br = null;
        BufferedWriter bw = null;

        try{



            fr = new FileReader(f);
            br = new BufferedReader(fr);

            while( br.ready() ){

                String linia = br.readLine();
                ArrayList palabras = new ArrayList<String>();

                String[] palabras_ = linia.split(" ");

                // Analizamos todas las palabras y las distribuimos en pares e impares
                for( String palabra : palabras_ ){

                    palabras.add(palabra);

                    if( palabra.length() % 2 == 0 ){
                        pares.add(palabra);
                    }else{
                        impares.add(palabra);
                    }

                }

            }

        }catch( Exception e ){
            System.out.println("Algo ha fallado en la ejecución.");
        }

        // Creamos el fichero para las pares
        crearFicheroPares(f.getAbsolutePath(), pares);

        // Creamos el fichero para las impares
        crearFicheroImpares(f.getAbsolutePath(), impares);

    }

}
