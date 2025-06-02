package fr.uha.hassenforder.logo.streaming;

import fr.uha.hassenforder.logo.reader.Lexer;
import fr.uha.hassenforder.logo.reader.Parser;

import java.awt.Graphics;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.github.jhoenicke.javacup.runtime.AdvancedSymbolFactory;

import fr.uha.hassenforder.logo.ui.AbstractDocument;
import fr.uha.hassenforder.logo.ui.AbstractView;
import fr.uha.hassenforder.logo.ui.GraphicTurtle;

public class View extends AbstractView {

	public View(AbstractDocument document) {
		super(document);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void onPaint (Graphics g) {
		try {
			if (getDocument().getFilename() == null) return;
			AdvancedSymbolFactory factory = new AdvancedSymbolFactory();
	    	Lexer l = new Lexer(new FileReader(getDocument().getFilename()));
	    	l.setAdvancedSymbolFactory(factory);
	    	Parser p = new Parser(l, factory);
			p.setTurtle(new GraphicTurtle(g));
	    	p.parse();      
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
