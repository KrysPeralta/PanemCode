package principal;

import compilerTools.Token;

%%
%class Lexer
%type Token
%line
%column
%{
    private Token token(String lexeme, String lexicalComp, int line, int column){
        return new Token(lexeme, lexicalComp, line+1, column+1);
    }
%}
Letra = [a-zA-Z]+
Digito = [0-9]+
Espacio = [ \t\f|\r|\n|\r\n]
Caden = [\"][^\"]*[\"]
Dec = [0-9]+(\.[0-9]+)
Compar = [\>\<]
Sig = [\,\'\;\.\?\¿\!\¡\#\$\-]
%%

"--#".*"--#" {/*Ignore*/}

{Espacio} {/*Ignore*/}

{Caden} {return token(yytext(), "TEXTO", yyline, yycolumn);}

("-"{Digito}+)|{Digito}+ {return token(yytext(), "ENTERO", yyline, yycolumn);}

{Dec} {return token(yytext(), "DECIMAL", yyline, yycolumn);}

true | false {return token(yytext(), "BOOLEANO", yyline, yycolumn);}

fnc | class {return token(yytext(), "RESERVADAS", yyline, yycolumn);}

"power on" {return token(yytext(), "PRINICIO", yyline, yycolumn);}

"switch out" {return token(yytext(), "PRFIN", yyline, yycolumn);}

"establish" {return token(yytext(), "PRDECLARAR", yyline, yycolumn);}

"read" {return token(yytext(), "PRLEER", yyline, yycolumn);}

"show:" {return token(yytext(), "PRMOSTRAR", yyline, yycolumn);}

"check" {return token(yytext(), "PRCHECK", yyline, yycolumn);}

"probe" {return token(yytext(), "PRPROBE", yyline, yycolumn);}

"unlike" {return token(yytext(), "PRUNLIKE", yyline, yycolumn);}

"repeat" {return token(yytext(), "PRREPEAT", yyline, yycolumn);}

"until" {return token(yytext(), "PRUNTIL", yyline, yycolumn);}

"+" {return token(yytext(), "OPSUMA", yyline, yycolumn);}

"-" {return token(yytext(), "OPRESTA", yyline, yycolumn);}

"*" {return token(yytext(), "OPMULTIPLICACION", yyline, yycolumn);}

"/" {return token(yytext(), "OPDIVISION", yyline, yycolumn);}

"^" {return token(yytext(), "OPPOTENCIA", yyline, yycolumn);}

"INC" {return token(yytext(), "OPINCREMENTO", yyline, yycolumn);}

"RED" {return token(yytext(), "OPDECREMENTO", yyline, yycolumn);}

"NOT" {return token(yytext(), "OPINVERSION", yyline, yycolumn);}

":=" {return token(yytext(), "OPASIGNACION", yyline, yycolumn);}

"+|" | "-|" | "*|" | "/|" | "^|" {return token(yytext(), "OPCOMBINADO", yyline, yycolumn);}

"=" | "<=" | ">=" | "!=" | {Compar} {return token(yytext(), "OPRELACIONAL", yyline, yycolumn);}

"AND" | "OR" {return token(yytext(), "OPLOGICO", yyline, yycolumn);}

"&" | "||" {return token(yytext(), "OPCOMPARACION", yyline, yycolumn);}

"%" {return token(yytext(), "OPCONCATENACION", yyline, yycolumn);}

{Letra}({Letra}|{Digito})* ("_" {Letra}({Letra}|{Digito})*)* {return token(yytext(), "VARIABLE", yyline, yycolumn);}

"(" {return token(yytext(), "PARENABRIR", yyline, yycolumn);}

")" {return token(yytext(), "PARENCERRAR", yyline, yycolumn);}

"{" {return token(yytext(), "LLAVEABRIR", yyline, yycolumn);}

"}" {return token(yytext(), "LLAVECERRAR", yyline, yycolumn);}

"[" {return token(yytext(), "CORABRIR", yyline, yycolumn);}

"]" {return token(yytext(), "CORCERRAR", yyline, yycolumn);}

{Digito}* "<>" | "<" {Caden}+ (,(" ")*{Caden}+)* ">" | "<" {Digito}* ">" {return token(yytext(), "ARREGLO", yyline, yycolumn);}

. { return token(yytext(), "ERROR", yyline, yycolumn); }