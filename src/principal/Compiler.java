package principal;

//importaciones

//import com.formdev.flatlaf.FlatIntelliJLaf;
import compilerTools.CodeBlock;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import compilerTools.Directory;
import compilerTools.ErrorLSSL;
import compilerTools.Functions;
import compilerTools.Grammar;
import compilerTools.Production;
import compilerTools.TextColor;
import compilerTools.Token;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Compiler extends javax.swing.JFrame {
    
    private String title;
    private Directory directorio;
    private ArrayList<Token> tokens;
    private ArrayList<ErrorLSSL> errors;
    private ArrayList<TextColor> textsColor;
    private Timer timerKeyReleased;
    private ArrayList<Production> identProd;
    private ArrayList<Production> asigProd;
    private HashMap<String, String> identificadores;
    private boolean codeHasBeenCompiled = false;

    public Compiler() {
        initComponents();
        init();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BackPanel = new javax.swing.JPanel();
        CodeScroll = new javax.swing.JScrollPane();
        CodeText = new javax.swing.JTextPane();
        ConsoleScroll = new javax.swing.JScrollPane();
        ConsoleText = new javax.swing.JTextArea();
        TokensScroll = new javax.swing.JScrollPane();
        TokensTable = new javax.swing.JTable();
        OpenBtn = new javax.swing.JButton();
        SaveBtn = new javax.swing.JButton();
        SaveAsBtn = new javax.swing.JButton();
        NewBtn = new javax.swing.JButton();
        LexicalBtn = new javax.swing.JButton();
        SyntacticBtn = new javax.swing.JButton();
        SemanticBtn = new javax.swing.JButton();
        RunBtn = new javax.swing.JButton();
        CompileBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        BackPanel.setBackground(new java.awt.Color(255, 255, 255));
        BackPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 204, 255), new java.awt.Color(204, 204, 204), new java.awt.Color(153, 153, 153), new java.awt.Color(204, 204, 204)));

        CodeScroll.setViewportView(CodeText);

        ConsoleText.setColumns(20);
        ConsoleText.setRows(5);
        ConsoleScroll.setViewportView(ConsoleText);

        TokensTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "TOKEN", "LEXEMA", "LINEA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TokensScroll.setViewportView(TokensTable);
        if (TokensTable.getColumnModel().getColumnCount() > 0) {
            TokensTable.getColumnModel().getColumn(0).setResizable(false);
            TokensTable.getColumnModel().getColumn(0).setPreferredWidth(10);
            TokensTable.getColumnModel().getColumn(1).setResizable(false);
            TokensTable.getColumnModel().getColumn(2).setResizable(false);
            TokensTable.getColumnModel().getColumn(3).setResizable(false);
            TokensTable.getColumnModel().getColumn(3).setPreferredWidth(15);
        }

        OpenBtn.setText("Abrir");
        OpenBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenBtnActionPerformed(evt);
            }
        });

        SaveBtn.setText("Guardar");
        SaveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveBtnActionPerformed(evt);
            }
        });

        SaveAsBtn.setText("Guardar como");
        SaveAsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveAsBtnActionPerformed(evt);
            }
        });

        NewBtn.setText("Nuevo");
        NewBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewBtnActionPerformed(evt);
            }
        });

        LexicalBtn.setText("Léxico");
        LexicalBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LexicalBtnActionPerformed(evt);
            }
        });

        SyntacticBtn.setText("Sintáctico");
        SyntacticBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SyntacticBtnActionPerformed(evt);
            }
        });

        SemanticBtn.setText("Semántico");
        SemanticBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SemanticBtnActionPerformed(evt);
            }
        });

        RunBtn.setText("Ejecutar");
        RunBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RunBtnActionPerformed(evt);
            }
        });

        CompileBtn.setText("Compilar");
        CompileBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CompileBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout BackPanelLayout = new javax.swing.GroupLayout(BackPanel);
        BackPanel.setLayout(BackPanelLayout);
        BackPanelLayout.setHorizontalGroup(
            BackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(BackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(CodeScroll)
                        .addComponent(ConsoleScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE))
                    .addGroup(BackPanelLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(OpenBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(SaveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(SaveAsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(NewBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(BackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TokensScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(BackPanelLayout.createSequentialGroup()
                        .addGroup(BackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(BackPanelLayout.createSequentialGroup()
                                .addComponent(LexicalBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(SyntacticBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(SemanticBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(BackPanelLayout.createSequentialGroup()
                                .addComponent(RunBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(CompileBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 58, Short.MAX_VALUE)))
                .addContainerGap())
        );
        BackPanelLayout.setVerticalGroup(
            BackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(BackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BackPanelLayout.createSequentialGroup()
                        .addComponent(CodeScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addGroup(BackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(OpenBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SaveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SaveAsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NewBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 20, Short.MAX_VALUE))
                    .addComponent(TokensScroll))
                .addGroup(BackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BackPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ConsoleScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(BackPanelLayout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(BackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LexicalBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SyntacticBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SemanticBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)
                        .addGroup(BackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(RunBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CompileBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BackPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BackPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OpenBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpenBtnActionPerformed
        if (directorio.Open()) {
            colorAnalysis();
            clearFields();
        }
    }//GEN-LAST:event_OpenBtnActionPerformed

    private void SaveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveBtnActionPerformed
        if (directorio.Save()) {
            clearFields();
        }
    }//GEN-LAST:event_SaveBtnActionPerformed

    private void SaveAsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveAsBtnActionPerformed
        if (directorio.SaveAs()) {
            clearFields();
        }
    }//GEN-LAST:event_SaveAsBtnActionPerformed

    private void NewBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewBtnActionPerformed
        directorio.New();
        clearFields();
    }//GEN-LAST:event_NewBtnActionPerformed

    private void LexicalBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LexicalBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LexicalBtnActionPerformed

    private void SyntacticBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SyntacticBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SyntacticBtnActionPerformed

    private void SemanticBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SemanticBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SemanticBtnActionPerformed

    private void RunBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RunBtnActionPerformed
        CompileBtn.doClick();
        if (codeHasBeenCompiled) {
            if (!errors.isEmpty()) {
                JOptionPane.showMessageDialog(null, 
                        "No se puede ejecutar el código ya que se encontró uno o más errores",
                        "Error en la compilación", JOptionPane.ERROR_MESSAGE);
            } else {
//                CodeBlock codeBlock = Functions.splitCodeInCodeBlocks(tokens, "{", "}", ";");
//                System.out.println(codeBlock);
//                ArrayList<String> blocksOfCode = codeBlock.getBlocksOfCodeInOrderOfExec();
//                System.out.println(blocksOfCode);

            }
        }
    }//GEN-LAST:event_RunBtnActionPerformed

    private void CompileBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CompileBtnActionPerformed
        if (getTitle().contains("*") || getTitle().equals(title)) {
            if (directorio.Save()) {
                compile();
            }
        } else {
            compile();
        }
    }//GEN-LAST:event_CompileBtnActionPerformed

    //MÉTODOS
    
    //DISEÑO
    
    //Inicialización de la ventana
    private void init() {
        title = "Compilador de PanemCode";
        setLocationRelativeTo(null);
        setTitle(title);
        directorio = new Directory(this, CodeText, title, ".txt");
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                directorio.Exit();
                System.exit(0);
            }
        });
        Functions.setLineNumberOnJTextComponent(CodeText);
        timerKeyReleased = new Timer((int) (1000 * 0.3), (ActionEvent e) -> {
            timerKeyReleased.stop();
            colorAnalysis();
        });
        Functions.insertAsteriskInName(this, CodeText, () -> {
            timerKeyReleased.restart();
        });
        tokens = new ArrayList<>();
        errors = new ArrayList<>();
        textsColor = new ArrayList<>();
        identProd = new ArrayList<>();
        asigProd = new ArrayList<>();
        identificadores = new HashMap<>();
        Functions.setAutocompleterJTextComponent(new String[]{"hola", "adios", "hasta la proxima", 
            "oli"}, CodeText, () -> {
            timerKeyReleased.restart();
        });
    }
    
    //Colores en el código
    private void colorAnalysis() {
        textsColor.clear();
        LexerColor lexerColor;
        try {
            File codigo = new File("color.encrypter");
            FileOutputStream output = new FileOutputStream(codigo);
            byte[] bytesText = CodeText.getText().getBytes();
            output.write(bytesText);
            BufferedReader entrada = new BufferedReader(new InputStreamReader(new FileInputStream(codigo), "UTF8"));
            lexerColor = new LexerColor(entrada);
            while (true) {
                TextColor textColor = lexerColor.yylex();
                if (textColor == null) {
                    break;
                }
                textsColor.add(textColor);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("El archivo no pudo ser encontrado... " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error al escribir en el archivo... " + ex.getMessage());
        }
        Functions.colorTextPane(textsColor, CodeText, new Color(40, 40, 40));
    }
    
    //Limpiar panel de código
    private void clearFields(){
        Functions.clearDataInTable(TokensTable);
        ConsoleText.setText("");
        tokens.clear();
        errors.clear();
        identProd.clear();
        asigProd.clear();
        identificadores.clear();
        codeHasBeenCompiled = false;
    }
    
    //COMPILACIÓN
    
    private void compile(){
        clearFields();
        lexicalAnalysis();
        fillTableTokens();
        syntacticAnalysis();
        semanticAnalysis();
        printConsole();
        codeHasBeenCompiled = true;
    }
    
    private void lexicalAnalysis(){
        Lexer lexer;
        try {
            File codigo = new File("code.encrypter");
            FileOutputStream output = new FileOutputStream(codigo);
            byte[] bytesText = CodeText.getText().getBytes();
            output.write(bytesText);
            BufferedReader entrada = new BufferedReader(new InputStreamReader(new FileInputStream(codigo), "UTF8"));
            lexer = new Lexer(entrada);
            while (true) {
                Token token = lexer.yylex();
                if (token == null) {
                    break;
                }
                tokens.add(token);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("El archivo no pudo ser encontrado... " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error al escribir en el archivo... " + ex.getMessage());
        }
    }
    
    private void syntacticAnalysis(){
        Grammar gramatica = new Grammar(tokens, errors);
        
        gramatica.delete(new String[]{"ERROR"}, 1);
        
        //CONCATENACION
        gramatica.loopForFunExecUntilChangeNotDetected(() -> {
            gramatica.group("CONCATENACION", "(TEXTO | VARIABLE) OPCONCATENACION (TEXTO | VARIABLE)", true);
            gramatica.group("TEXTO", "TEXTO | CONCATENACION", true);
        });
        
        //VALORES  
        gramatica.group("VALOR", "(ENTERO | DECIMAL | TEXTO | BOOLEANO)", true);
        
        //EXPRESIONES ARITMETICAS
        gramatica.loopForFunExecUntilChangeNotDetected(() -> {
            gramatica.group("EXPRESION", "(VALOR | VARIABLE) ((OPSUMA | OPRESTA | OPDIVISION | OPMULTIPLICACION) (VALOR | VARIABLE))+");
        });
        
        //DECLARACION DE VARIABLES
        gramatica.group("DECLARACION", "PRDECLARAR VARIABLE OPASIGNACION (VALOR | EXPRESION)", true, identProd);
        
        gramatica.group("DECLARACION", "PRDECLARAR (VALOR | EXPRESION) OPASIGNACION VARIABLE", true, 
                1, "ERROR SINTÁCTICO {}: Declaración no válida [#]");
        gramatica.group("DECLARACION", "PRDECLARAR OPASIGNACION (VALOR | EXPRESION)", true, 
                2, "ERROR SINTÁCTICO {}: Declaración no válida [#]");
        gramatica.group("DECLARACION", "PRDECLARAR VARIABLE (VALOR | EXPRESION)", true, 
                3, "ERROR SINTÁCTICO {}: Se espera signo de asignación [#]");
        gramatica.group("DECLARACION", "PRDECLARAR VARIABLE OPASIGNACION", true, 
                4, "ERROR SINTÁCTICO {}: Se espera valor en la declaración [#]");
        gramatica.group("DECLARACION", "PRDECLARAR VARIABLE", true, 
                5, "ERROR SINTÁCTICO {}: Declaración no válida [#]");
        gramatica.group("DECLARACION", "PRDECLARAR (VALOR | EXPRESION)", true, 
                6, "ERROR SINTÁCTICO {}: Declaración no válida [#]");
        gramatica.group("DECLARACION", "PRDECLARAR OPASIGNACION", true, 
                7, "ERROR SINTÁCTICO {}: Declaración no válida [#]");
        
        gramatica.delete("PRDECLARAR", 24, 
                "ERROR SINTÁCTICO {}: '[]' no está en una sentencia [#]");
        
        //ASIGNACIÓN DE VALORES
        gramatica.group("ASIGNACION", "VARIABLE OPASIGNACION (VALOR | EXPRESION | VARIABLE)", true, asigProd);
        
        gramatica.group("ASIGNACION", "(VALOR | EXPRESION) OPASIGNACION VARIABLE", true, 
                8, "ERROR SINTÁCTICO {}: Asignación no válida [#]");
        gramatica.group("ASIGNACION", "OPASIGNACION (VALOR | EXPRESION | VARIABLE)", true, 
                9, "ERROR SINTÁCTICO {}: Se necesita variable para asignar valor [#]");
        gramatica.group("ASIGNACION", "VARIABLE (VALOR | EXPRESION | VARIABLE)", true, 
                10, "ERROR SINTÁCTICO {}: Se espera signo de asignación [#]");
        gramatica.group("ASIGNACION", "VARIABLE OPASIGNACION", true, 
                11, "ERROR SINTÁCTICO {}: Se espera valor en la asignación [#]");
        
        //SALIDA DE MENSAJES
        gramatica.group("MOSTRAR", "PRMOSTRAR (VALOR | VARIABLE)", true);
        
        gramatica.delete("PRMOSTRAR", 25, 
                "ERROR SINTÁCTICO {}: '[]' no está en una sentencia [#]");
        
        //LEER ENTRADA
        gramatica.group("LEER", "PRLEER VARIABLE", true);
        
        gramatica.group("LEER", "PRLEER VALOR", true, 
                12, "ERROR SINTÁCTICO {}: Sentencia no válida [#]");
        
        gramatica.delete("PRLEER", 26, 
                "ERROR SINTÁCTICO {}: '[]' no está en una sentencia [#]");
        
        //ESTRUCTURAS RELACIONALES
        //gramatica.loopForFunExecUntilChangeNotDetected(() -> {
            gramatica.group("RELACION", "(VALOR | VARIABLE) OPRELACIONAL (VALOR | VARIABLE)", true);
            
            gramatica.group("RELACION", "OPRELACIONAL (VALOR | VARIABLE)", true, 
                    13, "ERROR SINTÁCTICO {}: Se necesita otro valor en la relación [#]");
            gramatica.group("RELACION", "(VALOR | VARIABLE) OPRELACIONAL", true, 
                    13, "ERROR SINTÁCTICO {}: Se necesita otro valor en la relación [#]");
            
            gramatica.group("LOGICA", "RELACION OPLOGICO RELACION (OPLOGICO RELACION)*");
            
            gramatica.group("LOGICA", "OPLOGICO RELACION (OPLOGICO RELACION)*", 
                    14, "ERROR SINTÁCTICO {}: Se necesita otro valor en la comparación [#]");
            gramatica.group("LOGICA", "RELACION OPLOGICO (OPLOGICO RELACION)*", 
                    14, "ERROR SINTÁCTICO {}: Se necesita otro valor en la comparación [#]");
            
            gramatica.group("COMPARACION", "RELACION OPCOMPARACION RELACION (OPCOMPARACION RELACION)*");
            
            gramatica.group("COMPARACION", "OPCOMPARACION RELACION (OPCOMPARACION RELACION)*", 
                    14, "ERROR SINTÁCTICO {}: Se necesita otro valor en la comparación [#]");
            gramatica.group("COMPARACION", "RELACION OPCOMPARACION (OPCOMPARACION RELACION)*", 
                    14, "ERROR SINTÁCTICO {}: Se necesita otro valor en la comparación [#]");
            
            gramatica.group("CONDICION", "RELACION | LOGICA | COMPARACION", true);
        //});
        
        //OPERACIONES DE COMBINACIÓN
        gramatica.group("COMBINACION", "VARIABLE OPCOMBINADO (VALOR | VARIABLE)", true);
        
        gramatica.group("COMBINACION", "OPCOMBINADO (VALOR | VARIABLE)", true, 
                15, "ERROR SINTÁCTICO {}: Se necesita otro valor [#]");
        //-------------
        gramatica.group("COMBINACION", "VALOR OPCOMBINADO (VALOR | VARIABLE)", true, 
                16, "ERROR SINTÁCTICO {}: Sentencia no válida [#]");
        
        //OPERACIONES UNARIAS
        gramatica.group("UNARIA", "(OPINCREMENTO | OPDECREMENTO | OPINVERSION) VARIABLE", true);
        
        gramatica.group("UNARIA", "VARIABLE (OPINCREMENTO | OPDECREMENTO | OPINVERSION)", true, 
                17, "ERROR SINTÁCTICO {}: Sentencia no válida [#]");
        gramatica.group("UNARIA", "(OPINCREMENTO | OPDECREMENTO | OPINVERSION) VALOR", true, 
                18, "ERROR SINTÁCTICO {}: Sentencia no válida [#]");
        
        //CUERPO DEL PROGRAMA
        //gramatica.loopForFunExecUntilChangeNotDetected(() -> {
            gramatica.group("INSTRUCCION", "ASIGNACION | DECLARACION | MOSTRAR | LEER | COMBINACION | UNARIA | INSTRUCCION", true);
            //gramatica.group("INICIO", "PRINICIO (INSTRUCCION)*");
            //gramatica.group("FIN", "PRFIN", true);
            //gramatica.group("PROGRAMA", "INICIO FIN", true);
        //});
        
        gramatica.loopForFunExecUntilChangeNotDetected(() -> {
            //ESTRUCTURA CONDICIONAL
            gramatica.group("EST_CONDICIONAL", "PRCHECK PARENABRIR CONDICION PARENCERRAR LLAVEABRIR PRPROBE (INSTRUCCION)+ (PRUNLIKE (INSTRUCCION)+)? LLAVECERRAR");

            //Repetición de instrucciones
            gramatica.group("INSTRUCCION", "EST_CONDICIONAL | ASIGNACION | DECLARACION | MOSTRAR | LEER | COMBINACION | UNARIA | INSTRUCCION", true);

            //ESTRUCTURA DE CICLO
            gramatica.group("EST_CICLO", "PRREPEAT LLAVEABRIR (INSTRUCCION)+ LLAVECERRAR PRUNTIL PARENABRIR CONDICION PARENCERRAR");
            
            //Repetición de instrucciones
            gramatica.group("INSTRUCCION", "EST_CICLO | EST_CONDICIONAL | ASIGNACION | DECLARACION | MOSTRAR | LEER | COMBINACION | UNARIA | INSTRUCCION", true);

            gramatica.group("EST_CICLO", "PRREPEAT LLAVEABRIR (INSTRUCCION)+ LLAVECERRAR PRUNTIL PARENABRIR CONDICION PARENCERRAR");

            gramatica.group("EST_CONDICIONAL", "PRCHECK PARENABRIR CONDICION PARENCERRAR LLAVEABRIR PRPROBE (INSTRUCCION)+ (PRUNLIKE (INSTRUCCION)+)? LLAVECERRAR");

            gramatica.group("INSTRUCCION", "EST_CICLO | EST_CONDICIONAL | ASIGNACION | DECLARACION | MOSTRAR | LEER | COMBINACION | UNARIA | INSTRUCCION", true);
            
            gramatica.group("EST_CICLO", "PRREPEAT (INSTRUCCION)+ LLAVECERRAR PRUNTIL PARENABRIR CONDICION PARENCERRAR", 
                    19, "ERROR SINTÁCTICO {}: Falta llave de apertura [#]");
            gramatica.group("EST_CICLO", "PRREPEAT LLAVEABRIR (INSTRUCCION)+ PRUNTIL PARENABRIR CONDICION PARENCERRAR", 
                    20, "ERROR SINTÁCTICO {}: Falta llave de cierre [#]");
            gramatica.group("EST_CICLO", "PRREPEAT (INSTRUCCION)+ PRUNTIL PARENABRIR CONDICION PARENCERRAR", 
                    21, "ERROR SINTÁCTICO {}: Faltan llaves [#]");
            gramatica.group("EST_CICLO", "PRREPEAT LLAVEABRIR (INSTRUCCION)+ LLAVECERRAR PRUNTIL CONDICION PARENCERRAR", 
                    22, "ERROR SINTÁCTICO {}: Falta parentesis de apertura [#]");
            gramatica.group("EST_CICLO", "PRREPEAT LLAVEABRIR (INSTRUCCION)+ LLAVECERRAR PRUNTIL PARENABRIR CONDICION", 
                    23, "ERROR SINTÁCTICO {}: Falta parentesis de cierre [#]");
            gramatica.group("EST_CICLO", "PRREPEAT LLAVEABRIR (INSTRUCCION)+ LLAVECERRAR PRUNTIL CONDICION", 
                    24, "ERROR SINTÁCTICO {}: Faltan parentesis [#]");
            
            gramatica.group("EST_CONDICIONAL", "PRCHECK CONDICION PARENCERRAR LLAVEABRIR PRPROBE (INSTRUCCION)+ (PRUNLIKE (INSTRUCCION)+)? LLAVECERRAR", 
                    22, "ERROR SINTÁCTICO {}: Falta parentesis de apertura [#]");
            gramatica.group("EST_CONDICIONAL", "PRCHECK PARENABRIR CONDICION LLAVEABRIR PRPROBE (INSTRUCCION)+ (PRUNLIKE (INSTRUCCION)+)? LLAVECERRAR", 
                    23, "ERROR SINTÁCTICO {}: Falta parentesis de cierre [#]");
            gramatica.group("EST_CONDICIONAL", "PRCHECK CONDICION LLAVEABRIR PRPROBE (INSTRUCCION)+ (PRUNLIKE (INSTRUCCION)+)? LLAVECERRAR", 
                    24, "ERROR SINTÁCTICO {}: Faltan parentesis [#]");
            gramatica.group("EST_CONDICIONAL", "PRCHECK PARENABRIR CONDICION PARENCERRAR PRPROBE (INSTRUCCION)+ (PRUNLIKE (INSTRUCCION)+)? LLAVECERRAR", 
                    19, "ERROR SINTÁCTICO {}: Falta llave de apertura [#]");
            gramatica.group("EST_CONDICIONAL", "PRCHECK PARENABRIR CONDICION PARENCERRAR LLAVEABRIR PRPROBE (INSTRUCCION)+ (PRUNLIKE (INSTRUCCION)+)?", 
                    20, "ERROR SINTÁCTICO {}: Falta llave de cierre [#]");
            gramatica.group("EST_CONDICIONAL", "PRCHECK PARENABRIR CONDICION PARENCERRAR PRPROBE (INSTRUCCION)+ (PRUNLIKE (INSTRUCCION)+)?", 
                    21, "ERROR SINTÁCTICO {}: Faltan llaves [#]");
        });
        
        gramatica.group("INICIO", "PRINICIO (INSTRUCCION)*");
        
        gramatica.group("INICIO", "(INSTRUCCION)+", 
                22, "ERROR SINTÁCTICO {}: Falta estructura de inicio");
        
        gramatica.group("FIN", "PRFIN", true);
        
        gramatica.group("PROGRAMA", "INICIO FIN", true);
        
        gramatica.group("PROGRAMA", "INICIO", true, 
                23, "ERROR SINTÁCTICO {}: Falta estructura de fin");
        
        gramatica.show();
    }
    
    private void semanticAnalysis(){
        //HashMap<String, String> identDataType = new HashMap<>();
        //identDataType.put("color", "COLOR");
        //identDataType.put("número", "NUMERO");
        for (Production id : identProd) {
            
            //-----------LAS PRODUCCIONES
            //System.out.println(id);
            //System.out.println("*");
            
            //-----------METODOS
//            System.out.println(id.lexemeRank(0)); //te da la palabra en la posición indicada
//            System.out.println(id.lexemeRank(0, -1)); //te da toda la declaración
//            System.out.println(id.lexicalCompRank(0)); //te da la producción en la posición indicada
//            System.out.println(id.lexicalCompRank(0, -1)); //te da toda la producción
//            System.out.println(id.tokenRank(0)); //te da el token en la posición indicada
//            System.out.println(id.tokenRank(0, -1)); //te da toddo el token
//            System.out.println("*");
            
            identificadores.put(id.lexemeRank(1), id.lexemeRank(-1));
            
            
            //if (!identDataType.get(id.lexemeRank(0)).equals(id.lexicalCompRank(-1))) {
              //  errors.add(new ErrorLSSL(1, " × Error semántico {}: valor no compatible con el tipo de dato [#, %]", id, true));
            //}
            //if (id.lexicalCompRank(-1).equals("COLOR") && !id.lexemeRank(-1).matches("#[0-9a-fA-F]+")) {
              //  errors.add(new ErrorLSSL(2, " × Error lógico {}: el color no es un número hexadecimal [#, %]", id, false));
            //}
            //identificadores.put(id.lexemeRank(1), id.lexemeRank(-1));
        }
//        System.out.println("--------------");
//        if(identificadores.get("alumnos_aceptados") == null){
//            System.out.println("hola");
//        } else{
//            System.out.println(identificadores.get("alumnos_rechazados"));
//        }
//        System.out.println("--------------");
        
        System.out.println("--------------");
        
        for (Production id : asigProd){
            
            if(identificadores.get(id.lexemeRank(0)) == null){
                errors.add(new ErrorLSSL(1, "ERROR SEMÁNTICO {}: Variable no definida [#]", id, true));
                System.out.println("NO SE PUEDE HACER LA ASIGNACIÓN");
                System.out.println("******************");
            } else{
                identificadores.replace(id.lexemeRank(0), id.lexemeRank(-1));
                System.out.println("SI SE PUEDE HACER LA ASIGNACIÓN");
                System.out.println("******************");
            }
        }
        
        System.out.println("--------------");
    }
    
    private void fillTableTokens(){
        AtomicInteger id = new AtomicInteger(1);
        
        tokens.forEach(token -> {
            Object[] data = new Object[]{id.getAndIncrement(), token.getLexicalComp(), token.getLexeme(), 
                "[" + token.getLine() + "]"};
            Functions.addRowDataInTable(TokensTable, data);
        });
    }
    
    private void printConsole(){
        int sizeErrors = errors.size();
        if (sizeErrors > 0) {
            Functions.sortErrorsByLineAndColumn(errors);
            String strErrors = "\n";
            for (ErrorLSSL error : errors) {
                String strError = String.valueOf(error);
                strErrors += strError + "\n";
            }
            ConsoleText.setText("Compilación terminada...\n" + strErrors 
                    + "\nLa compilación terminó con errores...");
        } else {
            ConsoleText.setText("Compilación terminada...");
        }
        //ConsoleText.setCaretPosition(0);
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Compiler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Compiler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Compiler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Compiler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Compiler().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BackPanel;
    private javax.swing.JScrollPane CodeScroll;
    private javax.swing.JTextPane CodeText;
    private javax.swing.JButton CompileBtn;
    private javax.swing.JScrollPane ConsoleScroll;
    private javax.swing.JTextArea ConsoleText;
    private javax.swing.JButton LexicalBtn;
    private javax.swing.JButton NewBtn;
    private javax.swing.JButton OpenBtn;
    private javax.swing.JButton RunBtn;
    private javax.swing.JButton SaveAsBtn;
    private javax.swing.JButton SaveBtn;
    private javax.swing.JButton SemanticBtn;
    private javax.swing.JButton SyntacticBtn;
    private javax.swing.JScrollPane TokensScroll;
    private javax.swing.JTable TokensTable;
    // End of variables declaration//GEN-END:variables
}
