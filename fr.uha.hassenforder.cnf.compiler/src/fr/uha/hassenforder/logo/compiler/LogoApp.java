package fr.uha.hassenforder.logo.compiler;

import java.io.FileNotFoundException;
import java.io.FileReader;

import com.github.jhoenicke.javacup.runtime.AdvancedSymbolFactory;

import fr.uha.hassenforder.ast.Helper;
import fr.uha.hassenforder.ast.Node;
import fr.uha.hassenforder.ast.evaluator.Evaluator;
import fr.uha.hassenforder.ast.evaluator.LazyEvaluator;
import fr.uha.hassenforder.logo.reader.Lexer;
import fr.uha.hassenforder.logo.reader.Parser;

public class LogoApp {
    
	private LogoContext read (String input) {
    	LogoContext context = new LogoContext();
		try {
	    	AdvancedSymbolFactory csf = new AdvancedSymbolFactory ();
	    	Lexer l = new Lexer(new FileReader(input));
	    	l.setAdvancedSymbolFactory(csf);
	    	Parser p = new Parser(l, csf);
			p.setContext(context);
	    	p.parse();      
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			context.addError("FileNotFoundException");
		} catch (Exception e) {
			e.printStackTrace();
			context.addError("Major Exception");
		}
		return context;
	}
	
	private void save (LogoContext context, String output) {
		if (context == null) return;
		if (context.hasErrors()) return;
		Evaluator eval = new LazyEvaluator (context.getVista(), context.getFactory());
		Generator generator = new Generator (output, eval);
		LogoGenerator logoGenerator = new LogoGenerator (eval, generator);
		Node bloc = context.getFactory().createNodeBloc();
		if (Helper.exist (context.getVista(), LogoContext.getInitSegmentName())) {
			bloc.getChildren().add(context.getFactory().createNodeFunctionCall(
					context.getFactory().createNodeVariable(LogoContext.getInitSegmentName()), null)
				);
		}
		logoGenerator.begin();
		logoGenerator.visit(bloc);
		logoGenerator.end();
	}

	private void work (String input, String output) {
		LogoContext scene;
		scene = read (input);
		if (scene == null) return;
		save (scene, output);
	}

	public static void main(String[] args) {
		LogoApp app = new LogoApp();

		app.work("function-java.ttl", "function-java.svg");
		app.work("interpreter.ttl", "interpreter.svg");
	}

}
