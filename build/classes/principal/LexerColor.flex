package principal;

import compilerTools.TextColor;
import java.awt.Color;

%%
%class LexerColor
%type TextColor
%char
%{
    private TextColor textColor(long start, int size, Color color){
        return new TextColor((int) start, size, color);
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

"--#".*"--#" {return textColor(yychar, yylength(), new Color(146, 146, 146));}

{Espacio} {/*Ignore*/}

{Caden} {return textColor(yychar, yylength(), new Color(251, 136, 29));}

("-"{Digito}+)|{Digito}+ {/*Ignore*/}

{Dec} {/*Ignore*/}

true | false {return textColor(yychar, yylength(), new Color(129, 41, 117));}

fnc | class {/*Ignore*/}

"power on" {return textColor(yychar, yylength(), new Color(129, 60, 41));}

"switch out" {return textColor(yychar, yylength(), new Color(129, 60, 41));}

"establish" {return textColor(yychar, yylength(), new Color(28, 78, 218));}

"read" {return textColor(yychar, yylength(), new Color(205, 20, 75));}

"show:" {return textColor(yychar, yylength(), new Color(205, 20, 75));}

"check" {/*Ignore*/}

"probe" {/*Ignore*/}

"unlike" {/*Ignore*/}

"repeat" {/*Ignore*/}

"until" {/*Ignore*/}

"+" {/*Ignore*/}

"-" {/*Ignore*/}

"*" {/*Ignore*/}

"/" {/*Ignore*/}

"^" {/*Ignore*/}

"INC" {return textColor(yychar, yylength(), new Color(133, 58, 215));}

"RED" {return textColor(yychar, yylength(), new Color(133, 58, 215));}

"NOT" {return textColor(yychar, yylength(), new Color(133, 58, 215));}

":=" {/*Ignore*/}

"+|" | "-|" | "*|" | "/|" | "^|" {/*Ignore*/}

"=" | "<=" | ">=" | "!=" | {Compar} {/*Ignore*/}

"AND" | "OR" {/*Ignore*/}

"&" | "||" {/*Ignore*/}

"%" {/*Ignore*/}

"#?" {/*Ignore*/}

";" {/*Ignore*/}

{Letra}({Letra}|{Digito})* ("_" {Letra}({Letra}|{Digito})*)* {return textColor(yychar, yylength(), new Color(254, 189, 0));}

"(" {/*Ignore*/}

")" {/*Ignore*/}

"{" {/*Ignore*/}

"}" {/*Ignore*/}

"[" {/*Ignore*/}

"]" {/*Ignore*/}

{Digito}* "<>" | "<" {Caden}+ (,(" ")*{Caden}+)* ">" | "<" {Digito}* ">" {return textColor(yychar, yylength(), new Color(58, 35, 59));}

. {/*Ignore*/}