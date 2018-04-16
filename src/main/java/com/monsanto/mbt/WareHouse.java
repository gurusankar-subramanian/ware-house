package com.monsanto.mbt;

import java.util.ArrayList;
import java.util.List;

/**
 * WareHouse class where we will store the widgets and this is a Singleton class
 * @author Guru sankar 
 *
 */
public class WareHouse {
	private static WareHouse myObj;
	
	private static List<Widget> widgets;

	static{
        myObj = new WareHouse();
        widgets = new ArrayList<>();
    }
     
    private WareHouse(){
     
    }
     
    public static WareHouse getInstance(){
        return myObj;
    }
     
	public List<Widget> getWidgets() {
		return widgets;
	}

	public void setWidgets(List<Widget> widgets) {
		WareHouse.widgets = widgets;
	}
	 
}
