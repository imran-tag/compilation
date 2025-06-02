package fr.uha.hassenforder.logo.streaming;

import fr.uha.hassenforder.logo.ui.AbstractDocument;
import fr.uha.hassenforder.logo.ui.AbstractView;

public class LogoApp {
    
	private AbstractView view;
	private AbstractDocument document;

	public LogoApp () {
		document = new Document ();
		view = new View (document);
		document.setView(view);
	}
	
	public static void main (String argv []) {
		LogoApp app = new LogoApp ();
	    app.show();
	}

    public void show () {
    	view.setVisible(true);
    }
}
