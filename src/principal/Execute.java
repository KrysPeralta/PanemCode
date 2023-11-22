package principal;

//Importaciones
import JFlex.SilentExit;

public class Execute {
        public static void main(String omega[]) {
        String lexerFile = System.getProperty("user.dir") + "/src/principal/Lexer.flex",
                lexerFileColor = System.getProperty("user.dir") + "/src/principal/LexerColor.flex";
        try {
            JFlex.Main.generate(new String[]{lexerFile, lexerFileColor});
        } catch (SilentExit ex) {
            System.out.println("Error al generar el archivo flex: " + ex);
        }
    }
}
