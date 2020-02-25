package Controlador;

import Modelo.Carro;

public class Tablero {

    private Carro[][] tablero; 
    private int[][] tableroMostrar;


    private final int CAGUANO = 2;
    private final int TRUPALLA = 1;
    private final int KROMI = 3;

    private final int ARRIBA = 0;
    private final int DER = 1;
    private final int ABAJO = 2;
    private final int IZQ = 3;

    private final int NO_EXPLORADO = 0;
    private final int BARCO = 1;
    private final int AGUA = 2;

    private int[] numeroBarcos;
    private String nombre;

    private Barco[] hundidos;
    private int indHundidos;

    private Barco[] barcosCreados;
    private int indCreados;

    public Tablero(String nombre) {
        crearTablero();
        generarNumBarcos();
        generarBarcos();
        this.tiempoInicio = new Date();
        this.nombre = nombre;
        this.indHundidos = 0;
        this.indCreados = 0;
    }

    public Tablero() {

        this.numeroBarcos = new int[4];

        this.indHundidos = 0;
        this.indCreados = 0;
    }

    private void crearTablero() {
        int tamanio = 10;
        /*MetodosSueltos.generaNumeroAleatorio(10, 20);*/

        System.out.println("Se va a crear un tablero de " + tamanio + " filas y " + tamanio + " columnas");

        this.tablero = new Barco[tamanio][tamanio];
        this.tableroMostrar = new int[tamanio][tamanio];
    }

    private void generarNumBarcos() {

        this.numeroBarcos = new int[4];
        int num;
        int suma = 0;
        for (int i = 0; i < this.numeroBarcos.length; i++) {
            num = MetodosSueltos.generaNumeroAleatorio(1, 3);
            numeroBarcos[i] = num;
            suma += num;
        }

        this.hundidos = new Barco[suma];
        this.barcosCreados = new Barco[suma];
    }

    private boolean yaHundido(Barco b) {

        for (int i = 0; i < this.indHundidos; i++) {
            if (b.equals(this.hundidos[i])) {
                return true;
            }
        }
        return false;
    }

    private void generarBarcos() {

        Barco b = null;
        int x, y, direccion, direccionX = 0, direccionY = 0, posXFinal, posYFinal, longitud;
        boolean posCorrecta;
        for (int i = 0; i < numeroBarcos.length; i++) {

            for (int j = 0; j < this.numeroBarcos[i]; j++) {

                switch (i) {
                    case CRUCERO:
                        b = new Crucero();
                        break;
                    case DESTRUCTOR:
                        b = new Destructor();
                        break;
                    case FRAGATA:
                        b = new Fragata();
                        break;
                    case PORTAAVION:
                        b = new Portaavion();
                        break;
                }

                longitud = b.getLongitud();

                do {
                    posCorrecta = true;
                    x = MetodosSueltos.generaNumeroAleatorio(0, this.tablero.length - 1);
                    y = MetodosSueltos.generaNumeroAleatorio(0, this.tablero.length - 1);
                    direccion = MetodosSueltos.generaNumeroAleatorio(0, 3);

                    switch (direccion) {
                        case ARRIBA:
                            direccionX = -1;
                            direccionY = 0;
                            break;
                        case DER:
                            direccionX = 0;
                            direccionY = 1;
                            break;
                        case ABAJO:
                            direccionX = 1;
                            direccionY = 0;
                            break;
                        case IZQ:
                            direccionX = 0;
                            direccionY = -1;
                            break;

                    }

                    posXFinal = x + (longitud * direccionX);
                    posYFinal = y + (longitud * direccionY);

                    System.out.println("final X " + posXFinal);
                    System.out.println("final Y " + posYFinal);

                    if (posXFinal > 0 && posXFinal < this.tablero.length - 1
                            && posYFinal > 0 && posYFinal < this.tablero.length) {

                        // k es x
                        // m es y
                        for (int k = x, m = y; (k != posXFinal || m != posYFinal) && posCorrecta; k += direccionX, m += direccionY) {

                            if (this.tablero[k][m] != null) {
                                posCorrecta = false;
                            }

                        }

                    } else {
                        posCorrecta = false;
                    }

                } while (!posCorrecta);

                Point[] coordenadas = new Point[b.getLongitud()];
                for (int k = x, m = y, ind = 0;
                        (k != posXFinal || m != posYFinal) && posCorrecta;
                        k += direccionX, m += direccionY, ind++) {

                    this.tablero[k][m] = b;
                    coordenadas[ind] = new Point(k, m);

                }
                b.setCoordernadas(coordenadas);

                this.barcosCreados[this.indCreados] = b;
                this.indCreados++;

                System.out.println("El barco se ha generado entre [" + x + "," + y + "] y [" + posXFinal + "," + posYFinal + "]");
            }
        }

    }

    public void mostrarTiempo() {
        Date despues = new Date();
        long segundos = (despues.getTime() - this.tiempoInicio.getTime()) / 1000;

        int minutos = (int) (segundos / 60);
        int segundosRestantes = (int) (segundos % 60);
        System.out.print("Tiempo de juego: ");
        if (minutos < 10) {
            System.out.print("0" + minutos);
        } else {
            System.out.print(minutos);
        }

        System.out.print(":");
        if (segundosRestantes < 10) {
            System.out.print("0" + segundosRestantes);
        } else {
            System.out.print(segundosRestantes);
        }
        System.out.println("");
    }

    public void comprobarCasilla(int x, int y) {

        if (x >= 0 && x < this.tablero.length && y >= 0 && y < this.tableroMostrar.length) {
            if (this.tablero[x][y] != null) {
                this.tableroMostrar[x][y] = this.BARCO;
                this.tablero[x][y].parteDañada(x, y);
                if (this.tablero[x][y].hundido()) {
                    System.out.println("Hundido");

                    Barco b = this.tablero[x][y];

                    if (yaHundido(b)) {
                        System.out.println("Ya has hundido este");
                    } else {
                        if (b instanceof Crucero) {
                            this.numeroBarcos[this.CRUCERO]--;
                        } else if (b instanceof Destructor) {
                            this.numeroBarcos[this.DESTRUCTOR]--;
                        } else if (b instanceof Fragata) {
                            this.numeroBarcos[this.FRAGATA]--;
                        } else {
                            this.numeroBarcos[this.PORTAAVION]--;
                        }
                        this.hundidos[this.indHundidos] = b;
                        this.indHundidos++;
                    }

                } else {
                    System.out.println("Tocado");
                }

            } else {
                this.tableroMostrar[x][y] = this.AGUA;
                System.out.println("Haz fallado! Solo le diste al agua!");
                this.indicarHayBarco(x, y);
            }
        } else {
            System.out.println("Te has salido del limite");
        }

    }

    public boolean finJuego() {
        for (int i = 0; i < this.numeroBarcos.length; i++) {
            if (this.numeroBarcos[i] > 0) {
                return false;
            }
        }
        return true;
    }

    public void mostrarNumBarcos() {

        System.out.println("Quedan: " + this.numeroBarcos[this.PORTAAVION] + " Portaaviones "
                + this.numeroBarcos[this.CRUCERO] + " Cruceros "
                + this.numeroBarcos[this.DESTRUCTOR] + " Destructores "
                + this.numeroBarcos[this.FRAGATA] + " Fragatas");

    }

    public void indicarHayBarco(int x, int y) {

        boolean algunBarcoEncontrado = false;
        for (int i = x - 1; i <= (x + 1) && !algunBarcoEncontrado; i++) {
            for (int j = y - 1; j <= (y + 1) && !algunBarcoEncontrado; j++) {
                if (i > 0 && i < this.tablero.length && j > 0 && j < this.tablero.length
                        && i != x && j != y && this.tablero[i][j] != null) {
                    System.out.println("Hay un barco cerca");
                    algunBarcoEncontrado = true;
                }
            }
        }

        if (!algunBarcoEncontrado) {
            System.out.println("Ningun barco cerca");
        }

    }

    public void mostrarTableroTest() {
        for (int i = 0; i < this.tableroMostrar.length; i++) {

            for (int j = 0; j < this.tableroMostrar[0].length; j++) {
                if (this.tablero[i][j] != null) {
                    System.out.print("B ");
                } else {
                    System.out.print("N ");
                }
            }
            System.out.println("");
        }
    }

    public void mostrarTablero() {

        // Cabecera
        System.out.print("  ");
        for (char letra = 'A'; letra < ('A' + this.tablero.length); letra++) {
            System.out.print(letra + " ");
        }
        System.out.println("");

        // Contenido
        char letra = 'A';
        for (int i = 0; i < this.tableroMostrar.length; i++) {
            System.out.print(letra + " ");
            for (int j = 0; j < this.tableroMostrar[0].length; j++) {
                switch (this.tableroMostrar[i][j]) {
                    case NO_EXPLORADO:
                        System.out.print("  ");
                        break;
                    case BARCO:
                        System.out.print("X ");
                        break;
                    case AGUA:
                        System.out.print("A ");
                        break;
                }

            }
            System.out.println("");
            letra++;
        }

        System.out.println("Jugador/a: " + nombre);
        this.mostrarTiempo();
        this.mostrarNumBarcos();

    }

    public void guardarPartida() {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File("partida.txt")))) {

            bw.write(nombre + "\r\n"); // nombre
            bw.write(this.tiempoInicio.getTime() + "\r\n"); // tiempo
            bw.write(this.barcosCreados.length + "\r\n"); // num barcos creados

            for (int i = 0; i < this.barcosCreados.length; i++) {
                bw.write(this.barcosCreados[i].toString());
            }

            for (int i = 0; i < this.tableroMostrar.length; i++) {
                for (int j = 0; j < this.tableroMostrar.length; j++) {
                    if (this.tableroMostrar[i][j] != this.NO_EXPLORADO) {
                        bw.write(this.tableroMostrar[i][j] + "," + i + "," + j + ";");
                    }
                }
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public void cargarPartida() {

        this.indCreados = 0;
        crearTablero();

        try (BufferedReader br = new BufferedReader(new FileReader(new File("partida.txt")))) {

            String linea = "";
            int numLinea = 1;
            int numBarcos = 0;
            while ((linea = br.readLine()) != null) {

                switch (numLinea) {
                    case 1:
                        this.nombre = linea;
                        break;
                    case 2:
                        this.tiempoInicio = new Date(Long.parseLong(linea));
                        break;
                    case 3:
                        numBarcos = Integer.parseInt(linea);
                        this.barcosCreados = new Barco[numBarcos];
                        this.hundidos = new Barco[numBarcos];
                        break;
                    default:

                        String[] datos = linea.split(";");
                        String tipo = datos[0];

                        if (!tipo.equals("C") && !tipo.equals("D")
                                && !tipo.equals("F") && !tipo.equals("P")) {

                            for (int i = 0; i < datos.length; i++) {
                                String[] datos_tablero = datos[i].split(",");

                                this.tableroMostrar[Integer.parseInt(datos_tablero[1])][Integer.parseInt(datos_tablero[2])]
                                        = Integer.parseInt(datos_tablero[0]);
                            }

                        } else {

                            String coord = datos[1];
                            String[] coord_separadas = coord.split(":");

                            Point[] coordenadas = new Point[coord_separadas.length];

                            for (int i = 0; i < coordenadas.length; i++) {
                                String[] coord_aun_mas_separada = coord_separadas[i].split(",");
                                coordenadas[i] = new Point(Integer.parseInt(coord_aun_mas_separada[0]),
                                        Integer.parseInt(coord_aun_mas_separada[1]));
                            }

                            String danios = datos[2];
                            String[] danios_separados = danios.split(",");

                            boolean[] partes = new boolean[danios_separados.length];

                            for (int i = 0; i < partes.length; i++) {
                                partes[i] = Boolean.parseBoolean(danios_separados[i]);
                            }

                            Barco b = null;
                            switch (tipo) {
                                case "C":
                                    b = new Crucero(coordenadas, partes);
                                    if (!b.hundido()) {
                                        this.numeroBarcos[this.CRUCERO]++;
                                    } else {
                                        this.hundidos[this.indHundidos] = b;
                                        this.indHundidos++;
                                    }
                                    break;
                                case "D":
                                    b = new Destructor(coordenadas, partes);
                                    if (!b.hundido()) {
                                        this.numeroBarcos[this.DESTRUCTOR]++;
                                    } else {
                                        this.hundidos[this.indHundidos] = b;
                                        this.indHundidos++;
                                    }
                                    break;
                                case "F":
                                    b = new Fragata(coordenadas, partes);
                                    if (!b.hundido()) {
                                        this.numeroBarcos[this.FRAGATA]++;
                                    } else {
                                        this.hundidos[this.indHundidos] = b;
                                        this.indHundidos++;
                                    }
                                    break;
                                case "P":
                                    b = new Portaavion(coordenadas, partes);
                                    if (!b.hundido()) {
                                        this.numeroBarcos[this.PORTAAVION]++;
                                    } else {
                                        this.hundidos[this.indHundidos] = b;
                                        this.indHundidos++;
                                    }
                                    break;
                            }

                            barcosCreados[this.indCreados] = b;
                            this.indCreados++;

                        }
                        break;
                }

                numLinea++;
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        completarTablero();

    }

    private void completarTablero() {

        for (int i = 0; i < this.barcosCreados.length; i++) {
            Barco b = this.barcosCreados[i];
            Point[] coordenadas = b.getCoordernadas();
            for (int j = 0; j < coordenadas.length; j++) {
                int x = coordenadas[j].x;
                int y = coordenadas[j].y;

                this.tablero[x][y] = b;

            }
        }

    }

}

