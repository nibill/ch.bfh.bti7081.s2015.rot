package ch.bfh.bti7081.s2015.red.PatientApp.View;

import java.util.ArrayList;

import ch.bfh.bti7081.s2015.red.PatientApp.DbInitializer;

import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button.ClickEvent;


/**
 * its just a debug view for restoring all database data
 * @author James
 *
 */

public class RestoreView extends BaseView{

	@Override
	public void buttonClick(ClickEvent event) {
		
	}

	@Override
	public void update(Object model) {
		
	}

	@Override
	public void update(ArrayList data) {
		
	}

	@Override
	public void enter(ViewChangeEvent event) {

		DbInitializer.restore();
	}

}
