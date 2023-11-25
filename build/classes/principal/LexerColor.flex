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

. { /* Ignore */ }