
%%

%package fr.uha.montivincent.jcupnflex.sample.calculator.reader
%class Lexer
%public 
%cupJHMH 


%{

    private Symbol fallback () {
		throw new Error("Unrecognized character '"+yytext()+"' -- ignored");
	}    

%}
%{
  private class Region {
  	StringBuilder tmp;
  	int fromLine;
  	int fromColumn;

public Region() {
	super();
	this.tmp = new StringBuilder();
	this.fromLine = yyline;
	this.fromColumn = yycolumn;
}
  }

 private java.util.Stack<Region> regions = new java.util.Stack<>();

 private void startRegion (int state) {
    regions.push(new Region ());
    yybegin (state);
 }

 @SuppressWarnings("unused")
 private void appendRegion (String content) {
    if (! regions.empty()) {
       Region region = regions.peek();
       region.tmp.append(content);
    }
 }

 private Region endRegion (int targetState) {
    Region region = null;
    if (! regions.empty()) {
       region = regions.pop();
    }
    yybegin (targetState);
    return region;
 }

 @SuppressWarnings("unused")
 private Symbol symbolRegion (Region region, ETerminal token) {
    if (region == null) {
       AdvancedSymbolFactory.Location position = new AdvancedSymbolFactory.Location (yyline+1, yycolumn+yylength());
       return symbolFactory.newSymbol(token, position, position, "");
    } else {
       String content = region.tmp.toString();
       AdvancedSymbolFactory.Location left = new AdvancedSymbolFactory.Location (region.fromLine+1, region.fromColumn+1);
       AdvancedSymbolFactory.Location right = new AdvancedSymbolFactory.Location (yyline+1, yycolumn+yylength());
       return symbolFactory.newSymbol(token, left, right, content);
    }
}

%}


%state COMMENT$State

%%

<YYINITIAL> {
  "."		{ return symbol(ETerminal.__REGEXP_2__); }
  "="		{ return symbol(ETerminal.__REGEXP_1__); }
  "["		{ return symbol(ETerminal.__REGEXP_3__); }
  "]"		{ return symbol(ETerminal.__REGEXP_4__); }
  ","		{ return symbol(ETerminal.COMMA, yytext()); }
  "true"		{   Boolean RESULT = true; return symbol(ETerminal.BOOLEAN, RESULT); }
  "false"		{   Boolean RESULT = false; return symbol(ETerminal.BOOLEAN, RESULT); }
  [ \t\f]		{  }
  \r\n|\r|\n		{ return symbol(ETerminal.EOLN); }
  [+-]?[0-9]+		{ return symbol(ETerminal.INTEGER, Integer.parseInt(yytext())); }
  \'([^\'\\]|\\.)*\		{ return symbol(ETerminal.QTDSTR, yytext()); }
  \"([^\"\\]|\\.)*\"		{ return symbol(ETerminal.QTDSTR, yytext()); }
  [a-zA-Z_][a-zA-Z0-9_-]*		{ return symbol(ETerminal.UNQTDSTR, yytext()); }
  [+-]?[0-9]+([eE][+-]?[0-9]+)		{ return symbol(ETerminal.DOUBLE, Float.parseFloat(yytext())); }
  \d{4}-\d{2}-\d{2}		{ return symbol(ETerminal.DATE, yytext()); }
  \d{2}:\d{2}:\d{2}(\.\d{1,6})?		{ return symbol(ETerminal.TIME, yytext()); }
  [+-]?[0-9]*\.[0-9]+([eE][+-]?[0-9]+)?		{ return symbol(ETerminal.DOUBLE, Float.parseFloat(yytext())); }
  "#"		{ startRegion (COMMENT$State); }
}

<COMMENT$State> {
  "\n"		{ Region r = endRegion (YYINITIAL); return symbolRegion (r, ETerminal.COMMENT); }
  [^]		{ appendRegion (yytext()); }
}


[^]			 { return fallback(); }

