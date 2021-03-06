package siplapro;
/**
 *
 * @author reyes
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;

public class run {
    int Time = 0;
    int blockfifo = 1;
    int maxHist = 0;
    
    Queue <procesos> cola1 = new LinkedList<>();
    Queue <procesos> cola2 = new LinkedList<>();
    String historial0[] = new String[200];

    int quantum=0;
    int q=0;
    int senalRepar = 1;
    
    procesos[] iProcesos;
    procesos[] oProcesos;
    
    public void planner(procesos Procesos[],procesos pro[], int quantum, String combo){
        this.quantum = quantum;
        q = quantum;
        iProcesos = Procesos;
        oProcesos = pro;
        maxiHist();
        
        for (int i = 0; i < historial0.length; i++) {
            historial0[i] = "*";
        }
        while(unfin() && Time<100){                         //unfin sera false cuando las cpu y e/s de todos los procesos sean 0
            System.out.println("------------------------------------------------");
            System.out.println("Tiempo: " + Time);
            pLlegada();                                 //Esta funcion encola los procesos que van llegando a cola1
            encolarEs();                        //Esta funcion encola los procesos que acaben e/s en la cola que corresponda
            runES();                                //Esta funcion resta las e/s si el proceso ya ejecuto la cpu1
            
            if (!cola1.isEmpty() && blockfifo==1) {                 //La cola1 tiene mayor prioridad por tanto se ejecuta primero si tiene algun proceso
                System.out.println("RR");
                rr();
            }else if(!cola2.isEmpty()){             //Si la cola1 no tiene procesos y la cola2 si, cola2 ejecuta sus procesos. 
                if(combo.equals("SJN")){
                System.out.println("SJN");
                    if (senalRepar == 1) {
                        sjn();
                    }
                }else if(combo.equals("HRN")){
                System.out.println("HRN");
                    if (senalRepar == 1) {
                        hrn();
                    }
                }else if(combo.equals("FCFS")){
                    System.out.println("FCFS");
                }
                fifo();
            }
            System.out.println("Estado Cola1: ");
            showProCola(cola1);
            System.out.println("Estado Cola2: ");
            showProCola(cola2);
            System.out.println("------------------------------------------------");
            Time++;                             // En cada iteracion de while el tiempo aumenta
            tFinal();
        }
        respuestas();
        for (int i = 0; i < iProcesos.length; i++) {
            System.out.println("El proceso " + oProcesos[i].Name + ", termino en: " + oProcesos[i].Tfinal);
        }
        String historial[] = new String[Time];
        for (int i = 0; i < Time; i++) {
            historial[i] = historial0[i];
        }

        tabular(historial);
        System.out.println("Termino");
    }
    
    
    public void rr(){
        if( q>0 && cola1.peek().Cpu1 > 0){
            iProcesos[proCola(cola1.peek().Name)].setCpu1(iProcesos[proCola(cola1.peek().Name)].Cpu1 - 1);
            iProcesos[proCola(cola1.peek().Name)].setpCola("Cola1");
            System.out.println("Cola1: " + cola1.peek().Name + ". cpu1: " + cola1.peek().Cpu1);
            historial0[Time] = cola1.peek().Name;
            q--;
            if(q==0 && cola1.peek().Cpu1 > 0){
                cola2.add(cola1.peek());
                cola1.remove();
                q = quantum;
            }else if(cola1.peek().Cpu1 == 0){
                cola1.remove();
                q = quantum;
            }
        }else if( q>0 && cola1.peek().Cpu1 == 0 && cola1.peek().Cpu2 > 0){
            iProcesos[proCola(cola1.peek().Name)].setCpu2(iProcesos[proCola(cola1.peek().Name)].Cpu2 - 1);
            iProcesos[proCola(cola1.peek().Name)].setpCola("Cola1");
            System.out.println("Cola1: " + cola1.peek().Name + ". cpu2: " + cola1.peek().Cpu2);
            historial0[Time] = cola1.peek().Name;
            q--;
            if(q==0 && cola1.peek().Cpu2 > 0){
                cola2.add(cola1.peek());
                cola1.remove();
                q = quantum;
            }else if(cola1.peek().Cpu2 == 0){
                cola1.remove();
                q = quantum;
            }
        }
    }
    
    public void fifo(){
        if( cola2.peek().Cpu1 != 0){
            iProcesos[proCola(cola2.peek().Name)].setCpu1(iProcesos[proCola(cola2.peek().Name)].Cpu1 - 1);
            iProcesos[proCola(cola2.peek().Name)].setpCola("Cola2");
            System.out.println("Cola2: " + cola2.peek().Name + ". cpu: " + cola2.peek().Cpu1);
            historial0[Time] = cola2.peek().Name;
            blockfifo = 0;
            q--;
            senalRepar = 0;
            if(cola2.peek().Cpu1 == 0){
                cola2.remove();
                senalRepar = 1;
                blockfifo = 1;
            }
            q = quantum;
        }else if(cola2.peek().Cpu1 == 0 && cola2.peek().Cpu2 != 0){
            iProcesos[proCola(cola2.peek().Name)].setCpu2(iProcesos[proCola(cola2.peek().Name)].Cpu2 - 1);
            iProcesos[proCola(cola2.peek().Name)].setpCola("Cola2");
            System.out.println("Cola2: " + cola2.peek().Name + ". cpu: " + cola2.peek().Cpu2);
            historial0[Time] = cola2.peek().Name;
            blockfifo = 0;
            q--;
            senalRepar = 0;
            if(cola2.peek().Cpu2 == 0){
                cola2.remove();
                senalRepar = 1;
                blockfifo = 1;
            }
            q = quantum;
        }
    }
    
    public void sjn(){
        int icpu1 = 999;
        int icpu2 = 999;
        int count1 = 0; 
        int count2 = 0;
        for (int i = 0; i < cola2.size(); i++) {
            if (cola2.peek().Cpu1 > 0) {
                if (icpu1 > cola2.peek().Cpu1) {
                    icpu1 = cola2.peek().Cpu1;
                    count1 = i;     
                }
            }
            cola2.add(cola2.peek());
            cola2.remove();
        }
       // System.out.println("Se escogio el proceso como el menor cpu1: P" + count1 + ". con cpu1: " + icpu1);
        
        for (int i = 0; i < cola2.size(); i++) {
            if (cola2.peek().Cpu1 == 0 && cola2.peek().Cpu2 > 0) {
                if (icpu2 > cola2.peek().Cpu2) {
                    icpu2 = cola2.peek().Cpu2;
                    count2 = i;
                    
                }
            }
            cola2.add(cola2.peek());
            cola2.remove();
        }
        //System.out.println("Se escogio el proceso como el menor cpu2: P" + count2 + ". con cpu1: " + icpu2);
        
       // System.out.println("count1: " + count1 + ", count2: " + count2);
        
        if (icpu1 == icpu2) {
            if (count1 < count2) {
                System.out.println("El proceso que pondra de primero es: " + count1);
                reparar(count1);
            }else{
                System.out.println("El proceso que pondra de primero es: " + count2);
                reparar(count2);
            }
        }else if (icpu1 < icpu2) {
            System.out.println("El proceso que pondra de primero es: " + count1);
            reparar(count1);
        }else if(icpu1 > icpu2){
            System.out.println("El proceso que pondra de primero es: " + count2);
            reparar(count2);
        }
        System.out.println("El menor proceso es: " + cola2.peek().Name);
        System.out.println("Estado Cola despues de reparar: ");
        showProCola(cola2);
    }

    public void hrn(){
        int div1 = cola2.size();
        int div2 = cola2.size();
        int count1 = 0; 
        int count2 = 0;
        float p1 = 0;
        float p2 = 0;
        for (int i = 0; i < cola2.size(); i++) {
            if (cola2.peek().Cpu1 > 0) {
                float p0 = (float) (div1 + cola2.peek().Cpu1)/cola2.peek().Cpu1;
                
                if (p0 > p1) {
                    p1 = p0;
                    count1 = i;
                    div1--;
                }
            }
            cola2.add(cola2.peek());
            cola2.remove();
        }
        //System.out.println("Se escogio el proceso con HRN como el mayor cpu1: P" + count1 + ". con HRN: " + p1);
        
        for (int i = 0; i < cola2.size(); i++) {
            if (cola2.peek().Cpu1 == 0 && cola2.peek().Cpu2 > 0) {
                float p0 = (float) (div2 + cola2.peek().Cpu2)/cola2.peek().Cpu2;
                
                if (p0 > p2) {
                    p2 = p0;
                    count2 = i;
                    div2--;
                }
            }
            cola2.add(cola2.peek());
            cola2.remove();
        }
       // System.out.println("Se escogio el proceso con HRN como el mayor cpu2: P" + count2 + ". con HRN: " + p2);
        
       // System.out.println("count1: " + count1 + ", count2: " + count2);
        
        if (p1 == p2) {
            if (count1 < count2) {
                reparar(count1);
            }else{
                reparar(count2);
            }
        }else if (p1 < p2) {
            reparar(count2);
        }else if(p1 > p2){
            reparar(count1);
        }
        System.out.println("El mayor HRN proceso es: " + cola2.peek().Name);
    }
    
    //Funciones auxiliares ------------------------------------------------------

    public void reparar(int count){
        System.out.println("Inicio reparacion!!!!!!");
        
        System.out.println("El indice es: "+ count);
        Queue <procesos> cola3 = new LinkedList<>();  
        Queue <procesos> cola4 = new LinkedList<>();
        for (int i = 0; i < count; i++) { //  2
        cola3.add(cola2.peek());
        cola2.remove();
        }
        
        System.out.println("......................................1");
        System.out.println("Estado Cola2: ");
        showProCola(cola2);
        System.out.println("Estado Cola3: ");
        showProCola(cola3);
        System.out.println("Estado Cola4: ");
        showProCola(cola4);
        cola4.add(cola2.peek()); // 3
        cola2.remove();

        
        System.out.println("......................................2");
        System.out.println("Estado Cola2: ");
        showProCola(cola2);
        System.out.println("Estado Cola3: ");
        showProCola(cola3);
        System.out.println("Estado Cola4: ");
        showProCola(cola4);
        
        System.out.println("cola2.size: " + cola2.size());
        int jaja = cola2.size();
        for (int i = 0; i < jaja; i++) { //  4
            cola3.add(cola2.peek());
            cola2.remove();
        }

        
        System.out.println("......................................3");
        System.out.println("Estado Cola2: ");
        showProCola(cola2);
        System.out.println("Estado Cola3: ");
        showProCola(cola3);
        System.out.println("Estado Cola4: ");
        showProCola(cola4);
        
        cola2.add(cola4.peek()); //  5
        cola4.remove();

        
        System.out.println("......................................4");
        System.out.println("Estado Cola2: ");
        showProCola(cola2);
        System.out.println("Estado Cola3: ");
        showProCola(cola3);
        System.out.println("Estado Cola4: ");
        showProCola(cola4);
        int jajaja = cola3.size();
        for (int i = 0; i < jajaja; i++) { //  6
            cola2.add(cola3.peek());
            cola3.remove();
        }
        
    }
    
    public void maxiHist(){
        for (int i = 0; i < oProcesos.length; i++) {
            maxHist += oProcesos[i].Cpu1 + oProcesos[i].Cpu2 + oProcesos[i].Es;
        }   
    }
    
    public void showCola(Queue <procesos> cola){
        for (int i = 0; i < cola.size(); i++) {
            System.out.println(cola.peek().Name);
            cola.add(cola.peek());
            cola.remove();
        }
    }
    
    public void tabular(String[] historial1){
        tabulado win = new tabulado();
        win.setVisible(true);
        win.cargarProcesos(oProcesos, historial1, Time);
    }
    
    public void respuestas(){
        for (int i = 0; i < oProcesos.length; i++) {
            oProcesos[i].setTser(oProcesos[i].Tfinal - (oProcesos[i].Cpu1 + oProcesos[i].Cpu2));
            oProcesos[i].setTesp(oProcesos[i].Tser - (oProcesos[i].Cpu1 + oProcesos[i].Cpu2));
            oProcesos[i].setIndSer((oProcesos[i].Cpu1 + oProcesos[i].Cpu2)/(oProcesos[i].Tser));
        }
    }
    
    public void tFinal(){
        for (int i = 0; i < iProcesos.length; i++) {
            if (iProcesos[i].Cpu2 <= 0 && oProcesos[i].Tfinal == -1) {
                oProcesos[i].setTfinal(Time);
            }
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
                System.out.println("Se encolo en cola2 despues de acabar E/S: " + iProcesos[i].Name);
            }
            if(iProcesos[i].Es == 0 && iProcesos[i].pCola.equals("Cola2") && iProcesos[i].pEs == 0){
                iProcesos[i].setpEs(1);
                cola1.add(iProcesos[i]);
                System.out.println("Se encolo en cola1 despues de acabar E/S: " + iProcesos[i].Name);
            }
            
        }
    }
    
    public void runES(){
        for (int i = 0; i < iProcesos.length; i++) {
            if(iProcesos[i].Cpu1 == 0 && iProcesos[i].Es > 0){
                iProcesos[i].setEs(iProcesos[i].Es - 1);
            }
        }
    }
    
    public int proCola(String Name){ // Funcion que retorna el indice en el array del proceso que esta en peek de cola
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
}
