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
    procesos [] iProcesos;
    
    public void planner(procesos iProcesos[], int quantum){
        this.quantum = quantum;
        q = quantum;
        this.iProcesos = iProcesos;
        while(unfin()){                         //unfin sera false cuando las cpu y e/s de todos los procesos sean 0
            System.out.println("Tiempo: " + Time);
            pLlegada();                                 //Esta funcion encola los procesos que van llegando a cola1
            runES();                                //Esta funcion resta las e/s si el proceso ya ejecuto la cpu1
            pLlegadaCola2();                        //Esta funcion encola los procesos que acaben cpu1 y e/s en la cola2
            if (!cola1.isEmpty()) {                 //La cola1 tiene mayor prioridad por tanto se ejecuta primero si tiene algun proceso
                rr();
            }else if(!cola2.isEmpty()){             //Si la cola1 no tiene procesos y la cola2 si, cola2 ejecuta sus procesos.
                
                fifo();
            }
            Time++;                             // En cada iteracion de while el tiempo aumenta
        }
        System.out.println("Termino");
    }
    
    public void rr(){
        System.out.println("Cola1: ");
        showProCola(cola1);
        if( q>0 && cola1.peek().Cpu1 != 0){
            iProcesos[proCola(iProcesos, cola1.peek().Name)].setCpu1(iProcesos[proCola(iProcesos, cola1.peek().Name)].Cpu1 - 1);
            System.out.println(cola1.peek().Name + ". cpu1: " + cola1.peek().Cpu1);
            q--;
            if(cola1.peek().Cpu1 == 0){
                cola1.remove();
                q = quantum;
            }
        }else if( q>0 && cola1.peek().Cpu1 == 0 && cola1.peek().Cpu2 != 0){
            iProcesos[proCola(iProcesos, cola1.peek().Name)].setCpu1(iProcesos[proCola(iProcesos, cola1.peek().Name)].Cpu2 - 1);
            System.out.println(cola1.peek().Name + ". cpu2: " + cola1.peek().Cpu2);
            q--;
            if(cola1.peek().Cpu2 == 0){
                cola1.remove();
                q = quantum;
            }
        }else if(q==0){
            cola2.add(cola1.peek());
            cola1.remove();
            q = quantum;
            if (!cola1.isEmpty() && cola1.peek().Cpu1 != 0) {
                iProcesos[proCola(iProcesos, cola1.peek().Name)].setCpu1(iProcesos[proCola(iProcesos, cola1.peek().Name)].Cpu1 - 1);
                System.out.println(cola1.peek().Name + ". cpu1: " + cola1.peek().Cpu1);
                q--;
                if(cola1.peek().Cpu1 == 0){
                    cola1.remove();
                    q = quantum;
                }
            }else if (!cola1.isEmpty() && cola1.peek().Cpu1 == 0 && cola1.peek().Cpu2 != 0) {
                iProcesos[proCola(iProcesos, cola1.peek().Name)].setCpu1(iProcesos[proCola(iProcesos, cola1.peek().Name)].Cpu2 - 1);
                System.out.println(cola1.peek().Name + ". cpu2: " + cola1.peek().Cpu2);
                q--;
                if(cola1.peek().Cpu2 == 0){
                    cola1.remove();
                    q = quantum;
                }
            }else if(cola1.isEmpty() && !cola2.isEmpty()){
                showProCola(cola2);
            }
        }
    }
    
    public void fifo(){
        System.out.println("Cola2: ");
        System.out.println(cola2);
        if( cola2.peek().Cpu1 != 0){
            iProcesos[proCola(iProcesos, cola2.peek().Name)].setCpu1(iProcesos[proCola(iProcesos, cola2.peek().Name)].Cpu1 - 1);
            System.out.println("Cola1: " + cola2.peek().Name + ". cpu: " + cola2.peek().Cpu1);
            q--;
            if(cola2.peek().Cpu1 == 0){
                cola2.remove();
                q = quantum;
            }
        }else if(cola2.peek().Cpu1 == 0 && cola2.peek().Cpu2 != 0){
            iProcesos[proCola(iProcesos, cola2.peek().Name)].setCpu1(iProcesos[proCola(iProcesos, cola2.peek().Name)].Cpu2 - 1);
            System.out.println("Cola1: " + cola1.peek().Name + ". cpu: " + cola2.peek().Cpu2);
            q--;
            if(cola2.peek().Cpu2 == 0){
                cola2.remove();
                q = quantum;
            }
        }
    }
    
    
    //Funciones auxiliares ------------------------------------------------------
    
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
    
    public void pLlegadaCola2(){
        for (int i = 0; i < iProcesos.length; i++) {
            if(iProcesos[i].Cpu1 == 0 && iProcesos[i].Es == 0){
                cola2.add(iProcesos[i]);
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
        if (count == 0) {
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
