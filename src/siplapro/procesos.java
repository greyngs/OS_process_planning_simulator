package siplapro;

/**
 *
 * @author reyes
 */
public class procesos {
    public String Name, pCola;
    public int Tlleg, Cpu1, Es, Cpu2, pEs;
    public float Tfinal, Tser, Tesp, IndSer;
    public boolean bloc;
    
	
    procesos(String name,int tlleg,int cpu1,int es, int cpu2){
        Name = name;
	Tlleg = tlleg;
	Cpu1 = cpu1;
	Es = es;
        pEs = 0;
	Cpu2 = cpu2;
        pCola = null;
	Tfinal = -1;
	Tser = -1;
        Tesp = -1;
        IndSer = -1;
	}
    
    public String getName(){
        return Name;
    }
    
    public void setName(String name){
        Name = name;
    }
    
    public String getpCola(){
        return pCola;
    }
    
    public void setpCola(String cola){
        pCola = cola;
    }
    
    public int getTlleg(){
	return Tlleg;
    }

    public void setTlleg(int tlleg){
	Tlleg = tlleg;
    }

    public int getCpu1(){
	return Cpu1;
    }

    public void setCpu1(int cpu1){
        Cpu1 = cpu1;
    }
    
    public int getEs(){
        return Es;
    }

    public void setEs(int es){
    	Es = es;
    }
    
    public int getpEs(){
        return pEs;
    }

    public void setpEs(int pes){
    	pEs = pes;
    }
    
    public int getCpu2(){
	return Cpu2;
    }

    public void setCpu2(int cpu2){
        Cpu2 = cpu2;
    }
    
    public float getTfinal(){
	return Tfinal;
    }

    public void setTfinal(float tfinal){
        Tfinal = tfinal;
    }
    
    public float getTser(){
	return Tser;
    }

    public void setTser(float tser){
        Tser = tser;
    }
    
    public float getTesp(){
	return Tesp;
    }

    public void setTesp(float tesp){
        Tesp = tesp;
    }
    
    public float getIndSer(){
	return IndSer;
    }

    public void setIndSer(float indser){
        IndSer = indser;
    }
}
