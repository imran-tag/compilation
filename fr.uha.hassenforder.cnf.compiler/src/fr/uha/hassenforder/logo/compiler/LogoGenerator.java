package fr.uha.hassenforder.logo.compiler;

import fr.uha.hassenforder.ast.visitor.INodeVisitor;
import fr.uha.hassenforder.logo.visitor.LogoVisitor;

public class LogoGenerator extends LogoVisitor {

	public LogoGenerator(INodeVisitor nodeVisitor, INodeVisitor turtleVisitor) {
		super(nodeVisitor, turtleVisitor);
	}

}
