package fr.uha.hassenforder.logo.interpreter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.swing.JFileChooser;

import com.github.jhoenicke.javacup.runtime.AdvancedSymbolFactory;

import fr.uha.hassenforder.logo.ui.AbstractDocument;
import fr.uha.hassenforder.logo.reader.Lexer;
import fr.uha.hassenforder.logo.reader.Parser;

public class Document extends AbstractDocument {

	private LogoContext context;
	
	public LogoContext getContext() {
		return context;
	}

	public void setContext(LogoContext context) {
		this.context = context;
	}

	@Override
	public void onOpenDocument() {
		int state = getView().getJFileChooser().showOpenDialog(getView());
		if (state == JFileChooser.APPROVE_OPTION) {
			File f = getView().getJFileChooser().getSelectedFile();
			String filename = f.getPath();
			setFilename (filename);
			try {
		    	AdvancedSymbolFactory factory = new AdvancedSymbolFactory ();
		    	Lexer l = new Lexer(new FileReader(getFilename()));
		    	l.setAdvancedSymbolFactory(factory);
		    	Parser p = new Parser(l, factory);
				context = new LogoContext();
				p.setContext(context);
		    	p.parse();      
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				context.addError("FileNotFoundException");
			} catch (Exception e) {
				e.printStackTrace();
				context.addError("FileNotFoundException");
			}
		}
		super.onOpenDocument();
	}

}
