package core;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import br.ufes.inf.hfilho.isbm.ISBM;
import br.ufes.inf.hfilho.isbm.lowlevel.ConclusionListener;

public class CoffeeBLL {    
	
	
	
    
    public List<CoffeeEntity> getISBM(){
    	List<CoffeeEntity> list = new ArrayList<CoffeeEntity>();
    	Date dt = new Date();
    	
    	list.add(new CoffeeEntity("1", dt, 400.0, 350.0, 330.0, 368.0, 250.0));
		list.add(new CoffeeEntity("1", dt, 410.0, 360.0, 340.0, 358.0, 240.0));
		list.add(new CoffeeEntity("1", dt, 420.0, 310.0, 3150.0, 438.0, 550.0));
		list.add(new CoffeeEntity("1", dt, 410.0, 370.0, 316.0, 338.0, 260.0));
		list.add(new CoffeeEntity("1", dt, 413.0, 380.0, 390.0, 338.0, 270.0));
		list.add(new CoffeeEntity("1", dt, 420.0, 390.0, 319.0, 328.0, 280.0));
		
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
