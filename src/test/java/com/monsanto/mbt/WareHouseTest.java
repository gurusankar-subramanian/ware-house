package com.monsanto.mbt;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Test;

public class WareHouseTest {
	
	@Test
	public void test_Widget(){
		WareHouse wareHouse = WareHouse.getInstance();
		Widget widget = new Widget(1, "Red", new Date());
		List<Widget> widgets = Arrays.asList(widget);
		wareHouse.setWidgets(widgets);
		assertEquals(wareHouse.getWidgets(), widgets);
	}


}
