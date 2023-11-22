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
Op = [\+\-\*\/\^]
Compar = [\>\<]
Delimit = [\(\)\{\}\[\]]
Sig = [\,\'\;\.\?\¿\!\¡\#\$\-]
%%

"--#".*"--#" {/*Ignore*/}

{Espacio} {/*Ignore*/}

{Caden} {return token(yytext(), "Texto", yyline, yycolumn);}

("-"{Digito}+)|{Digito}+ {return token(yytext(), "Entero", yyline, yycolumn);}

{Dec} {return token(yytext(), "Decimal", yyline, yycolumn);}

true | false {return token(yytext(), "Booleano", yyline, yycolumn);}

"power on" | "switch on" | "show:" | read | check | probe | unlike | repeat | establish | 
until | fnc | class {return token(yytext(), "Reservadas", yyline, yycolumn);}

{Letra}({Letra}|{Digito})* ("_" {Letra}({Letra}|{Digito})*)* {return token(yytext(), "Variable", yyline, yycolumn);}

{Op} {return token(yytext(), "Operador", yyline, yycolumn);}

"INC" {return token(yytext(), "Incremento", yyline, yycolumn);}

"RED" {return token(yytext(), "Decremento", yyline, yycolumn);}

"NOT" {return token(yytext(), "Inversion", yyline, yycolumn);}

":=" {return token(yytext(), "Asignacion", yyline, yycolumn);}

"+|" | "-|" | "*|" | "/|" | "^|" {return token(yytext(), "Combinado", yyline, yycolumn);}

"=" | "<=" | ">=" | "!=" | {Compar} {return token(yytext(), "Relacional", yyline, yycolumn);}

"AND" | "OR" | "&" | "|" {return token(yytext(), "Logico", yyline, yycolumn);}

"%" {return token(yytext(), "Concatenacion", yyline, yycolumn);}

{Delimit} {return token(yytext(), "Delimitador", yyline, yycolumn);}

{Digito}* "<>" | "<" {Caden}+ (,(" ")*{Caden}+)* ">" | "<" {Digito}* ">" {return token(yytext(), "Arreglo", yyline, yycolumn);}

. { return token(yytext(), "ERROR", yyline, yycolumn); }