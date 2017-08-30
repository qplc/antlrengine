grammar Example;

/*------------------------------------------------------------------------
 * PARSER RULES
 *------------------------------------------------------------------------*/

//This will be the entry point of our parser.
eval returns [String value] : exp=fexpr {$value = $exp.value;} EOF ;

fexpr returns [String value] 
	: p=allfunc {$value = $p.text;}
	;

allfunc : funcsign (COMMA funcsign)* ;

paramexpr : NUMBER | STRING | TEXT DELIMETER NUMBER | TEXT DELIMETER STRING;

funcsign : TEXT ('.' TEXT)* LPAREN (paramexpr (COMMA paramexpr)*)* RPAREN ;


/*------------------------------------------------------------------------
 * LEXER RULES
 *------------------------------------------------------------------------*/

TEXT : [a-zA-Z]+ | [a-zA-Z]+ . [a-zA-Z]+ ;
NUMBER : ('0'..'9'|'0'..'9'.'0'..'9'|'.''0'..'9')* ;
STRING : '"' ('0'..'9'|'a'..'z'|'A'..'Z'|'.'|':')* '"';
LPAREN : '(' ;
RPAREN : ')' ;
DELIMETER : ':' ;
COMMA : ',' ;
WHITESPACE : [ \t\r\n] -> skip ;
