
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



%%

<YYINITIAL> {
  ","		{ return symbol(ETerminal.__REGEXP_5__); }
  "."		{ return symbol(ETerminal.__REGEXP_2__); }
  "="		{ return symbol(ETerminal.__REGEXP_1__); }
  "["		{ return symbol(ETerminal.__REGEXP_3__); }
  "]"		{ return symbol(ETerminal.__REGEXP_4__); }
  "true"		{ return symbol(ETerminal.BOOLEAN, yytext()); }
  "false"		{ return symbol(ETerminal.BOOLEAN, yytext()); }
  [ \t]		{  }
  \r\n|\r|\n		{ return symbol(ETerminal.EOLN); }
  0b[01_]+		{ return symbol(ETerminal.BIN, yytext()); }
  0o[0-7_]+		{ return symbol(ETerminal.OCTAL, yytext()); }
  [+-]?(inf|nan)		{ return symbol(ETerminal.FLOAT, yytext()); }
  0x[0-9a-fA-F_]+		{ return symbol(ETerminal.HEXA, yytext()); }
  #[^\r\n]*		{  }
  [+-]?[0-9_]+		{ return symbol(ETerminal.INTEGER, yytext()); }
  \"([^\"]|\\\")*\"		{ return symbol(ETerminal.BASIC_STRING, yytext()); }
  \'([^\']|\\\')*\'		{ return symbol(ETerminal.BASIC_STRING, yytext()); }
  '''([^']|\\.)*'''		{ return symbol(ETerminal.MULTILINE_STRING, yytext()); }
  [A-Za-z_][A-Za-z_0-9]*		{ return symbol(ETerminal.ID, yytext()); }
  \"\"\"([^"]|\\.)*\"\"\"		{ return symbol(ETerminal.MULTILINE_STRING, yytext()); }
  [0-9]{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])		{ return symbol(ETerminal.LOCALDATE, yytext()); }
  ([01][0-9]|2[0-3])(:[0-5][0-9]){2}(\.[0-9]+)?		{ return symbol(ETerminal.LOCALTIME, yytext()); }
  [+-]?[0-9_]+\.[0-9_]+		{ return symbol(ETerminal.FLOAT, yytext()); }
  [+-]?[0-9]+(\.[0-9]+)?[eE][+-]?[0-9]+		{ return symbol(ETerminal.FLOAT, yytext()); }
  [0-9]{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])T([01][0-9]|2[0-3])(:[0-5][0-9]){2}(\.[0-9]+)?(Z|[+-](0[0-9]|1[0-4]):[0-5][0-9])		{ return symbol(ETerminal.LOCALDATETIME, yytext()); }
}


[^]			 { return fallback(); }

