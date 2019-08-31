/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siplapro;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;

/**
 *
 * @author reyes
 */
public class run {
    int Time = 0;
    Queue <procesos> cola1 = new LinkedList<>();
    Queue <procesos> cola2 = new LinkedList<>();
    List historial = new ArrayList();
    int quantum=0;
    int q=0;
    procesos[] iProcesos;
    
    public void planner(procesos Procesos[], int quantum){
        this.quantum = quantum;
        q = quantum;
        iProcesos = Procesos;
        while(unfin()){                         //unfin sera false cuando las cpu y e/s de todos los procesos sean 0
            System.out.println("------------------------------------------------");
            System.out.println("Tiempo: " + Time);
            if (Time == 9) {
                System.out.println("El estado de P0 es: " + "cpu1: " + iProcesos[0].Cpu1 + "  cpu2: " + iProcesos[0].Cpu2);
            }
            pLlegada();                                 //Esta funcion encola los procesos que van llegando a cola1
            encolarEs();                        //Esta funcion encola los procesos que acaben e/s en la cola que corresponda
            runES();                                //Esta funcion resta las e/s si el proceso ya ejecuto la cpu1
            
            if (!cola1.isEmpty()) {                 //La cola1 tiene mayor prioridad por tanto se ejecuta primero si tiene algun proceso
                System.out.println("RR");
                rr();
            }else if(!cola2.isEmpty()){             //Si la cola1 no tiene procesos y la cola2 si, cola2 ejecuta sus procesos. 
                System.out.println("FIFO");
                fifo();
                
            }
            System.out.println("Estado Cola1: ");
            showProCola(cola1);
            System.out.println("Estado Cola2: ");
            showProCola(cola2);
            System.out.println("----------------------------------------------");
            Time++;                             // En cada iteracion de while el tiempo aumenta
        }
        System.out.println("Termino");
    }
    
    public void rr(){
        System.out.println("Cola1: ");
        showProCola(cola1);
        if( q>0 && cola1.peek().Cpu1 != 0){
            iProcesos[proCola(iProcesos, cola1.peek().Name)].setCpu1(iProcesos[proCola(iProcesos, cola1.peek().Name)].Cpu1 - 1);
            iProcesos[proCola(iProcesos, cola1.peek().Name)].setpCola("Cola1");
            System.out.println(cola1.peek().Name + ". cpu1: " + cola1.peek().Cpu1);
            q--;
            if(q==0 && cola1.peek().Cpu1 != 0){
                cola2.add(cola1.peek());
                cola1.remove();
                q = quantum;
            }else if(q==0 || cola1.peek().Cpu1 == 0){
                cola1.remove();
                q = quantum;
            }
        }else if( q>0 && cola1.peek().Cpu1 == 0 && cola1.peek().Cpu2 != 0){
            iProcesos[proCola(iProcesos, cola1.peek().Name)].setCpu2(iProcesos[proCola(iProcesos, cola1.peek().Name)].Cpu2 - 1);
            iProcesos[proCola(iProcesos, cola1.peek().Name)].setpCola("Cola1");
            System.out.println(cola1.peek().Name + ". cpu2: " + cola1.peek().Cpu2);
            q--;
            if(q==0 && cola1.peek().Cpu2 != 0){
                cola2.add(cola1.peek());
                cola1.remove();
                q = quantum;
            }else if(q==0 || cola1.peek().Cpu2 == 0){
                cola1.remove();
                q = quantum;
            }
        }
    }
    
    public void fifo(){
        if( cola2.peek().Cpu1 != 0){
            iProcesos[proCola(iProcesos, cola2.peek().Name)].setCpu1(iProcesos[proCola(iProcesos, cola2.peek().Name)].Cpu1 - 1);
            iProcesos[proCola(iProcesos, cola2.peek().Name)].setpCola("Cola2");
            System.out.println("Cola2: " + cola2.peek().Name + ". cpu: " + cola2.peek().Cpu1);
            q--;
            if(cola2.peek().Cpu1 == 0){
                cola2.remove();
                q = quantum;
            }
        }else if(cola2.peek().Cpu1 == 0 && cola2.peek().Cpu2 != 0){
            iProcesos[proCola(iProcesos, cola2.peek().Name)].setCpu2(iProcesos[proCola(iProcesos, cola2.peek().Name)].Cpu2 - 1);
            iProcesos[proCola(iProcesos, cola2.peek().Name)].setpCola("Cola2");
            System.out.println("Cola2: " + cola2.peek().Name + ". cpu: " + cola2.peek().Cpu2);
            q--;
            if(cola2.peek().Cpu2 == 0){
                cola2.remove();
                q = quantum;
            }
        }
    }
    
    
    //Funciones auxiliares ------------------------------------------------------
    
    public boolean encoladois(Queue cola, procesos proceso){
        int count =0;
        for (int i = 0; i < cola.size(); i++) {
            if (cola.peek().equals(proceso)) {
                count++;
            }
            cola.add(cola.peek());
            cola.remove();
        }
        if (count>0) {
            return true;
        }else{
            return false;
        }    
    }
    
    public void showProCola(Queue cola){
        for (int i = 0; i < cola.size(); i++) {
            for (int j = 0; j < iProcesos.length; j++) {
                if (cola.peek().equals(iProcesos[j])) {
                    System.out.println(iProcesos[j].Name);
                }
            }
            cola.add(cola.peek());
            cola.remove();
        }
    }
    
    public void encolarEs(){
        for (int i = 0; i < iProcesos.length; i++) {
            if(iProcesos[i].Es == 0 && iProcesos[i].pCola.equals("Cola1") && iProcesos[i].pEs == 0){
                iProcesos[i].setpEs(1);
                cola2.add(iProcesos[i]);
                System.out.println("Se encolo en cola2 despues de acabar E/S: " + iProcesos[i].Name + "  ----------------------------------------------");
            }
            if(iProcesos[i].Es == 0 && iProcesos[i].pCola.equals("Cola2") && iProcesos[i].pEs == 0){
                iProcesos[i].setpEs(1);
                cola1.add(iProcesos[i]);
                System.out.println("Se encolo en cola1 despues de acabar E/S: " + iProcesos[i].Name + "  ----------------------------------------------");
            }
            
        }
    }
    
    public void runES(){
        for (int i = 0; i < iProcesos.length; i++) {
            if(iProcesos[i].Cpu1 == 0 && iProcesos[i].Es > 0){
                iProcesos[i].Es--;
            }
        }
    }
    
    public int proCola(procesos iProcesos[], String Name){ // Funcion que retorna el indice en el array del proceso que esta en peek de cola
        int count=-1;
        for (int i = 0; i < iProcesos.length; i++) {
            if (Name.equals(iProcesos[i].Name)) {
                count = i;
            }
        }
        return count;
    }
    
    public void pLlegada(){ // Funcion que va encolando los procesos cuando su tiempo de llegada sea igual a el Time
        for (int i = 0; i < iProcesos.length; i++) {
            if (iProcesos[i].Tlleg == Time) {
                cola1.add(iProcesos[i]);
            }
        }  
    }
    
    public boolean unfin(){ // Funcion que retorna false cuando todos los procesos acaben 
        int count = 0;
        for (int i = 0; i < iProcesos.length; i++) {
            count += iProcesos[i].Cpu1+ iProcesos[i].Cpu2 + iProcesos[i].Es;
        }
        if (count <= 0) {
            return false;
        }else{
            return true;
        }
    }
    
    
  /*  
    public void start(procesos iProcesos[], int quantum){
        int q = quantum;
        Queue <procesos> cola1 = new LinkedList<>();
        while(unfin(iProcesos)){
            System.out.println("Tiempo: " + Time);
            System.out.println("quantum: " + q);
            cola1 = pLlegada(iProcesos,cola1);
            if (cola1.peek() == null) {
                
            }/*else if(cola1.peek() != null && q>0 && cola1.peek().Cpu1 != 0 && cola1.peek().Es>0){
                cola1.add(cola1.peek());
                cola1.remove();
                q = quantum;
            }Aqui cierra comentario!! else if(cola1.peek() != null && q>0 && cola1.peek().Cpu1 != 0) {
                iProcesos[proCola(iProcesos, cola1.peek().Name)].setCpu1(iProcesos[proCola(iProcesos, cola1.peek().Name)].Cpu1 - 1);
                System.out.println(cola1.peek().Name + ". cpu: " + cola1.peek().Cpu1);
                q--;
                if(cola1.peek().Cpu1 == 0){
                    cola1.remove();
                    q = quantum;
                }
            }else if(cola1.peek() != null && q==0){
                cola1.add(cola1.peek());
                cola1.remove();
                q = quantum;
                iProcesos[proCola(iProcesos, cola1.peek().Name)].setCpu1(iProcesos[proCola(iProcesos, cola1.peek().Name)].Cpu1 - 1);
                System.out.println(cola1.peek().Name + ". cpu: " + cola1.peek().Cpu1);
                q--;
                if(cola1.peek().Cpu1 == 0){
                    cola1.remove();
                }
            }
            Time++;
        }
        System.out.println("Termino");
    }
    
    
    */
    
    
}
