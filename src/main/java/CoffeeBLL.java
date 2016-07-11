import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import br.ufes.inf.hfilho.isbm.ISBM;
import br.ufes.inf.hfilho.isbm.lowlevel.ConclusionListener;

public class CoffeeBLL {    
    
    public List<CoffeeEntity> getISBM(){
    	List<CoffeeEntity> list = new ArrayList<CoffeeEntity>();
    	
        ISBM vm = new ISBM();
        
        File file = new File(this.getClass().getResource("common/cafe.isbm").getFile());
        
        vm.start(file, ISBM.RENDER_WEB);       
        
        //Acesso às conclusões de forma assincrona:
        vm.setConclusionListener(new ConclusionListener() {
            public void onAdd(String conclusionKey, String conclusionValue, HashMap<String, String> conclusions) {
                System.out.println("Nova Conclusão: " + conclusionKey + "-> " + conclusionValue);
                /*Set<String> keys = conclusions.keySet();
				for(String conclusao: keys){
					System.out.println(conclusao + "-> " + conclusions.get(conclusao));
				}*/
            }
            public void onUpdate(String conclusionKey, String conclusionValue, HashMap<String, String> conclusions) { //Alguma conclusão foi alterada
                System.out.println("Conclusão Atualizada: " + conclusionKey + "-> " + conclusionValue);
            }
            public void onRemove(String conclusionKey, HashMap<String, String> coonclusions) {
                System.out.println("Conclusão removida: " + conclusionKey);
            }
        });
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Acesso às conclusões de forma síncrona:
        HashMap<String, String> conclusoes = vm.getConclusions();        
        Date dt = new Date();
        for (String key : conclusoes.keySet()) {
            String conclusao = conclusoes.get(key);
            String[] rs = conclusao.split(";");
            
            list.add(new CoffeeEntity(rs[0], dt, 
                    Sanitize(rs[1]),
                    Sanitize(rs[2]),
                    Sanitize(rs[3]),
                    Sanitize(rs[4]),
                    Sanitize(rs[5])));
            
            System.out.println("[Objeto] Conclusão: " + key + "-> " + conclusao);
        }
        
        if (list.isEmpty()){
    		list.add(new CoffeeEntity("1", dt, 400.0, 350.0, 330.0, 338.0, 250.0));
    		list.add(new CoffeeEntity("1", dt, 400.0, 350.0, 330.0, 338.0, 250.0));
    		list.add(new CoffeeEntity("1", dt, 400.0, 350.0, 330.0, 338.0, 250.0));
    		list.add(new CoffeeEntity("1", dt, 400.0, 350.0, 330.0, 338.0, 250.0));
    		list.add(new CoffeeEntity("1", dt, 400.0, 350.0, 330.0, 338.0, 250.0));
    		list.add(new CoffeeEntity("1", dt, 400.0, 350.0, 330.0, 338.0, 250.0));    		
        }
        return list;
            
        
        
    }
    
    private double Sanitize(String rs)
    {
        double d;
        try {
            d = Double.parseDouble(rs.replace(',', '.'));
        }
        catch (NumberFormatException e) {
            // Use whatever default you like
            d = 0.0;
        }
        return  d;
    }
	

}
