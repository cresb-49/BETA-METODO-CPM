package com.cresb.proyectoio.fronted.entidades;

import java.util.ArrayList;
import javax.naming.spi.NamingManager;

public class ProcesadoActividades {

    public ProcesadoActividades() {

    }

    public void calcularTiemposInicio(ArrayList<Nodo> actividades) {
        for (Nodo actividad : actividades) {
            if (actividad.getPresendecia().isEmpty()) {
                actividad.setIniTemprano(0);
                actividad.setFinTemprano(actividad.getDuracion() + actividad.getIniTemprano());
            }
        }
        for (Nodo actividad : actividades) {
            if (!actividad.getPresendecia().isEmpty()) {
                actividad.setIniTemprano(this.finTempranoMayor(actividad.getPresendecia()));
                actividad.setFinTemprano(actividad.getDuracion() + actividad.getIniTemprano());
            }
        }
    }

    public void calcularTiemposFin(ArrayList<Nodo> actividades) {
        for (Nodo actividad : actividades) {
            if (actividad.getSiguiente().isEmpty()) {
                actividad.setFinTardio(actividad.getFinTemprano());
                actividad.setHolgura(actividad.getFinTardio() - actividad.getFinTemprano());
                actividad.setIniTardio(actividad.getFinTardio() - actividad.getDuracion());
            }
        }
        System.out.println("Cantidad de nodos: " + actividades.size());

        Nodo actividadFinal = null;

        for (Nodo actividad : actividades) {
            if (actividad.getSiguiente().isEmpty() && (!actividad.getPresendecia().isEmpty())) {
                actividad.setFinTardio(actividad.getFinTemprano());
                actividad.setHolgura(actividad.getFinTardio() - actividad.getFinTemprano());
                actividad.setIniTardio(actividad.getFinTardio() - actividad.getDuracion());
                actividadFinal = actividad;
                break;
            }
        }

        for (int i = 0; i <= actividades.size(); i++) {
            for (Nodo actividad : actividades) {
                if (!actividad.getSiguiente().isEmpty()) {
                    if (actividad.getFinTardio() == 0) {
                        double tmp = this.obtenerMenorIniTardio(actividad.getSiguiente());
                        if (tmp == -1) {
                            System.out.println("No hay datos para agregar");
                        } else {
                            actividad.setFinTardio(tmp);
                            actividad.setHolgura(actividad.getFinTardio() - actividad.getFinTemprano());
                            actividad.setIniTardio(actividad.getFinTardio() - actividad.getDuracion());
                        }
                    }
                }
            }
        }
    }

    public double finTempranoMayor(ArrayList<Nodo> actividades) {
        double tmp = 0;
        for (Nodo actividad : actividades) {
            if (actividad.getFinTemprano() > tmp) {
                tmp = actividad.getFinTemprano();
            }
        }
        return tmp;
    }

    private double obtenerMenorIniTardio(ArrayList<Nodo> siguiente) {
        double tmp = -1;
        for (Nodo nodo : siguiente) {
            if (nodo.getFinTardio() != 0) {
                if (tmp == -1) {
                    tmp = nodo.getIniTardio();
                    System.out.println("valor temporal: " + tmp);
                } else {
                    if (tmp > nodo.getIniTardio()) {
                        tmp = nodo.getIniTardio();
                        System.out.println("valor temporal: " + tmp);
                    }
                }
            } else {
                System.out.println("Fin tardio en 0");
                tmp = -1;
                break;
            }
        }
        System.out.println("----------------");
        return tmp;
    }
}
