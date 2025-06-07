package fr.uha.montivincent.jcupnflex.sample.calculator;


import java.io.FileReader;

import com.github.jhoenicke.javacup.runtime.AdvancedSymbolFactory;

import fr.uha.montivincent.jcupnflex.sample.calculator.reader.Lexer;
import fr.uha.montivincent.jcupnflex.sample.calculator.reader.Parser;

public class Main {

	static public void main(String argv[]) {    
    try {
    	String name;
    	if (argv.length == 1) {
    		name = argv[0];
    	} else {
    		name = "test.txt";
    	}
    	AdvancedSymbolFactory csf = new AdvancedSymbolFactory();
    	Lexer l = new Lexer(new FileReader(name));
    	l.setAdvancedSymbolFactory(csf);
    	Parser p = new Parser(l, csf);
    	p.parse();      
    } catch (Exception e) {
    	e.printStackTrace();
    }
  }
}


