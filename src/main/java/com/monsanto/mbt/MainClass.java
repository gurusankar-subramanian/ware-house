package com.monsanto.mbt;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.google.gson.Gson;

/**
 * Main class of the App
 * @author Guru sankar 
 *
 */
public class MainClass {
	
	public static void main(String[] args) {
		MainClass main = new MainClass();
		Scanner sc = new Scanner(System.in);  
		Boolean exit = false;
		while(!exit){
			
			System.out.println("Enter the next process no :: 1. create Widget  2.sort widget by color  3.sort widget by date  4. prepare shipment "
					+ " 5. check added ids in shipment "
					+ " 6. Release shipment "
					+ " 7. show widgets "
					+ " 8.exit ");  
		    int process = sc.nextInt();  
			switch(process){
			case 1:	main.createWidget(sc);
					break;
					
			case 2: if(WareHouse.getInstance().getWidgets().size() > 0){
						main.sortByColor();
						break;
					}else{
						System.out.println("There is no widget to sort ");
					}
					
			case 3: if(WareHouse.getInstance().getWidgets().size() > 0){
						main.sortByDate();
						break;
					}else{
						System.out.println("There is no widget to sort ");
					}
					break;
			case 4: main.prepareShipment(sc);
					break;
					
			case 5 : System.out.println("Widgets in shipment now ::" +  new Gson().toJson(Shipment.getInstance().getToBeReleasedIds()));	
					 break;
					 
			case 6: main.relaseShipment();	
					break;
					
			case 7 : if(WareHouse.getInstance().getWidgets().size() > 0){
						System.out.println(new Gson().toJson(WareHouse.getInstance().getWidgets()));
						break;
					}else{
						System.out.println("There is no widget to show");
					}
			case 8 : exit = true; 
					System.out.println("Bye");
					break;
					
			case 9: WareHouse wareHouse = WareHouse.getInstance();
					wareHouse.getWidgets().addAll(WidgetUtils.getSampleWidgets());
					break;
					
			default: System.out.println("*** Please enter a Valid Process number ***");		
			}
		}
		sc.close();  
		
	}
	
	public void createWidget(Scanner sc){
		WareHouse wareHouse = WareHouse.getInstance();
		System.out.println("Enter the color ");  
		String color=sc.next(); 
		System.out.println("Enter the date in this format MM-dd-yyyy ");  
		String strDate = sc.next(); 
		Date widgetDate = WidgetUtils.stringToDateConverter(strDate);
		if(!Objects.isNull(widgetDate)){
			Widget newWidget = new Widget(wareHouse.getWidgets().size()+1,color,widgetDate);
			wareHouse.getWidgets().add(newWidget);
		}else{
			System.out.println("Error :: date is not this format MM-dd-yyyy "); 
		}
		
	}
	
	public Boolean prepareShipment(Scanner sc){
		System.out.println("How many ids you want to ship? ");
		int totalNo = sc.nextInt(); 
		if(totalNo > 10){
			System.out.println("You cannot ship more than 10 widgets at a time");
		}
		else if (totalNo >= WareHouse.getInstance().getWidgets().size()+1){
			System.out.println("Warehouse doesnot have this amount of widgets, please add ");
		}
		else{
			Shipment shipment = Shipment.getInstance();
			System.out.println("Select the sequence ids you want to ship");
			for(int i = 1; i<=totalNo; i++ ){
				int id = sc.nextInt(); 
				shipment.getToBeReleasedIds().add(id);
			}
			return true;
		}
		return false;
	}
	
	void relaseShipment(){
		if(Shipment.getInstance().getToBeReleasedIds().size() > 0){
			List<Widget> widgets = WareHouse.getInstance().getWidgets().stream().filter(x-> !Shipment.getInstance().getToBeReleasedIds().contains(x.getSerialNumber())) .collect(Collectors.toList());
			WareHouse.getInstance().setWidgets(widgets);
			Shipment.getInstance().getToBeReleasedIds().clear();
			System.out.println("Widgets in ware House now  ::  " + new Gson().toJson(WareHouse.getInstance().getWidgets()));
		}else{
			 System.out.println("Shipment is empty :: " +  new Gson().toJson(Shipment.getInstance().getToBeReleasedIds()));
		}
	}
	
	void sortByColor(){
		Collections.sort(WareHouse.getInstance().getWidgets(), (p1, p2) -> p1.getColor().compareTo(p2.getColor()));
	}
	
	void sortByDate(){
		Collections.sort(WareHouse.getInstance().getWidgets(), (p1, p2) -> p1.getProductionDate().compareTo(p2.getProductionDate()));
	}
	
	
}
