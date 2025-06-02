package fr.uha.hassenforder.logo.interpreter;

import fr.uha.hassenforder.ast.evaluator.Evaluator;
import fr.uha.hassenforder.ast.evaluator.LazyEvaluator;

import java.awt.Graphics;

import fr.uha.hassenforder.logo.ui.AbstractDocument;
import fr.uha.hassenforder.logo.ui.AbstractView;
import fr.uha.hassenforder.logo.ui.GraphicTurtle;
import fr.uha.hassenforder.ast.Helper;
import fr.uha.hassenforder.ast.Node;

public class View extends AbstractView {

	public View(AbstractDocument document) {
		super(document);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void onPaint (Graphics g) {
		LogoContext context = ((Document) getDocument()).getContext();
		if ( context != null && ! context.hasErrors()) {
			Evaluator eval = new LazyEvaluator (context.getVista(), context.getFactory());
			Painter painter = new Painter (new GraphicTurtle(g), eval);
			LogoPainter logoPainter = new LogoPainter (eval, painter);
			Node bloc = context.getFactory().createNodeBloc();
			if (Helper.exist (context.getVista(), LogoContext.getInitSegmentName())) {
				bloc.getChildren().add(context.getFactory().createNodeFunctionCall(
						context.getFactory().createNodeVariable(LogoContext.getInitSegmentName()), null)
					);
			}
			logoPainter.begin();
			logoPainter.visit(bloc);
			logoPainter.end();
		}
	}
}
