/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Jes015
 */
public class Dia {

    private String nombre, rutaArchivoDia;

    private Actividad[] actividades;

    public static final int maximoActividadesPorDia = 20;

    public Dia(String nombre, String ruta) {
        this.inicializarAtributosGlobales(nombre, ruta);
        this.cargarActividades();
    }

    public final void inicializarAtributosGlobales(String nombre, String ruta) {
        this.nombre = nombre;
        this.rutaArchivoDia = ruta;
        this.actividades = new Actividad[Dia.maximoActividadesPorDia];
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRuta() {
        return this.rutaArchivoDia;
    }

    public boolean addActividad(Actividad actividad) {
        int posicionDisponible = buscarEspacioDisponibleEnLista();

        if (posicionDisponible == -1) {
            ComplementaryMethods.showMessage("No hay espacio disponible para agregar mas actividades.");
            return false;
        } else {
            this.actividades[posicionDisponible] = actividad;
        }

        return true;

    }

    public boolean deleteActividad(Actividad actividad) {
        if (actividad != null) {
            for (int i = 0; i < actividades.length; i++) {
                if (actividad == actividades[i]) {
                    actividades[i] = null;
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean cargarActividades() {
        //try {
            this.borrarActividades();

            String actividadesSinProcesar = FileManager.readTextFile(rutaArchivoDia);

            String[] actividadesLista = actividadesSinProcesar.split("&");
            String[] actividadHorayNombre = null;
            if (actividadesLista.length <= Dia.maximoActividadesPorDia) {
                int posicion = 0;
                for (int i = 0; i < actividadesLista.length; i++) {
                    actividadHorayNombre = actividadesLista[i].split(" - ");
                    if (actividadHorayNombre.length == 2) { //En caso de que me metodo split retorne un espacio vacio se usa esta condicion
                        this.actividades[posicion] = new Actividad(actividadHorayNombre[0], actividadHorayNombre[1]);
                        posicion++;
                    }
                }
                this.organizarActividadesPorHora();
                return true;
            } else {
                ComplementaryMethods.showMessage("Cantidad de actividades supera a las maximas por dia");
            }
        //} catch (Exception io) {
        //    ComplementaryMethods.showMessage("Error al cargar actividades");
        //}
        return false;
    }

    public void borrarActividades() {
        for (int i = 0; i < this.actividades.length; i++) {
            this.actividades[i] = null;
        }
    }

    public Actividad[] getActividades() {
        return this.actividades;
    }

    public int buscarEspacioDisponibleEnLista() {

        if (actividades != null) {
            for (int i = 0; i < this.actividades.length; i++) {
                if (this.actividades[i] == null) {
                    return i;
                }
            }
        }
        return -1;
    }

    public void organizarActividadesPorHora() {

        Actividad[] actividadesOrganizadasPorHora = new Actividad[this.actividades.length];

        byte horaMayor = 25;
        
        byte actividadConHoraMenor = horaMayor;
        
        Actividad ActividadConHoraMenor = null;

        boolean actividadDentroDeListaActualizada = false;

        boolean hayActividades = false;

        int posicionE = 0;

        /*
        Bucle para poder agregar cada dia.
         */
        for (int ii = 0; ii < this.actividades.length; ii++) {

            /*
            Estructura de seleccion para determinar si hay actividades o no (si no las hay no se asignara la lista actividadesOrganizadasPorHora a la lista actividades)
             */
            if (this.actividades[ii] != null) {
                hayActividades = true;
            }
            /*
            Bucle para encontrar la actividad menor en la lista (se procede a evaluar si se agregan o no las actividades dependiendo si ya se habian agregado antes a la lista actividadesOrganizadasPorHora)
            Se reestablece la actividadConHoraMenor a su estado inicial para seguir evaluando actividades sin problemas
             */
            ActividadConHoraMenor = null;
            actividadConHoraMenor = horaMayor;

            for (int i = 0; i < this.actividades.length; i++) {
                if (this.actividades[i] != null) {

                    /*
                    Vemos si el dia en la posicion i de la lista actividades esta dentro de la lista actividadesOranizadasPorHora
                    Si lo esta le asignata true a la variable de tipo booleano y esta no permitira que el dia se evalue otra vez
                    Si no permitira evaluar el dia.
                     */
                    actividadDentroDeListaActualizada = false;

                    for (int i2 = 0; i2 < this.actividades.length; i2++) {

                        /*
                        Si la actividad en la posicion i de la lista actividades esta dentro de la lista  actividadesOrganizadasPorHora en la posicion i2
                        cambiara el valor de la variable actividadDentroDeListaActualizada a true(Significa que no permitira evaluar el elemento nuevamente) 
                        y usara la palabra reservada break para parar el este bucle.
                         */
                        if (this.actividades[i] == actividadesOrganizadasPorHora[i2]) {
                            actividadDentroDeListaActualizada = true;
                            break;

                        }
                    }
                    /*
                    Estructura de seleccion que evalua si la variable actividadDentroDeListaActualizada tiene el valor false(si lo tiene procedera a evaluar)
                    Si la hora de la actividad en la posicion i de la lista actividades es menor que la hora de la actividad actividadConHoraMenor procedera
                    a asigarnle a la variable ActividadConHoraMenor la actividad en la posicion i y el valor de la hora a la variable actividadConHoraMenor.
                     */
                    if (actividadDentroDeListaActualizada == false) {
                        if (Byte.valueOf(this.actividades[i].getHoraActividad().substring(0, 2)) < actividadConHoraMenor) {
                            ActividadConHoraMenor = this.actividades[i];
                            actividadConHoraMenor = ActividadConHoraMenor.getHora();
                        }
                    }

                }
            }

            /*
            Esctructura de seleccion para verificar que se halla encontrado elementos.
            Si se encuentra la actividad con la hora menor, se procedera a asinarle el objeto que contiene la variable ActividadConHoraMenor en la posicionE a la lista actividadesOrganizadasPorHora
            se le suma +1 a la posicionE para poder guardar mas elementos
             */
            if (actividadConHoraMenor!=horaMayor) {
                actividadesOrganizadasPorHora[posicionE] = ActividadConHoraMenor;
                posicionE++;
            }
        }
        
        

        /*
        Estructura de seleccion para determinar si hay actividades en la lista actividades
         */
        if (hayActividades == true) {
            this.actividades = actividadesOrganizadasPorHora;
        }
    }

}
