package com.monsanto.mbt;

import java.util.HashSet;
import java.util.Set;

/**
 * Shipment class where we will store the ids of widgets which needs to be shipped 
 * @author Guru sankar 
 *
 */
public class Shipment {

	private static Shipment myObj;
	
	private static Set<Integer>  toBeReleasedIds;


	static{
        myObj = new Shipment();
        toBeReleasedIds = new HashSet<>();
    }
     
    private Shipment(){
     
    }
     
    public static Shipment getInstance(){
        return myObj;
    }
     
	public Set<Integer> getToBeReleasedIds() {
		return toBeReleasedIds;
	}

	public void setToBeReleasedIds(Set<Integer> toBeReleasedIds) {
		Shipment.toBeReleasedIds = toBeReleasedIds;
	} 


}
