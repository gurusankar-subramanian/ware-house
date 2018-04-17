package com.monsanto.mbt;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.Date;

public class WidgetTest {
	
	private Widget widget;
	
	@Test
	public void test_Widget(){
		widget = new Widget(1, "Red", new Date());
		widget.setColor("Red");
		widget.setSerialNumber(1);
		widget.setProductionDate(new Date());
		assertEquals(widget.getColor(), "Red");
		assertEquals(widget.getSerialNumber(), 1);
		assertEquals(widget.getProductionDate(), new Date());
		
		
	}

}
