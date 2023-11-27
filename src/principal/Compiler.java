package principal;

//importaciones
//import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatIntelliJLaf;
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
import java.awt.Desktop;
import java.awt.Toolkit;
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
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Compiler extends javax.swing.JFrame {

    private String title;
    private Directory directorio;

    private ArrayList<ErrorLSSL> errors; //Guarda errores de tipo léxico, sintactico y semántico

    private ArrayList<TextColor> textsColor;
    private Timer timerKeyReleased;

    private ArrayList<Token> tokens; //Guarda los tokens del análisis léxico

    //Guarda las producciones para el análisis semántico
    private ArrayList<Production> identProd; //Identificadores
    private ArrayList<Production> asigProd; //Asignaciones
    private ArrayList<Production> unarProd; //Operaciones unarias
    private ArrayList<Production> combProd; //Operaciones de combinación
    private ArrayList<Production> expProd; //Expresiones aritméticas
    private ArrayList<Production> relaProd; //Relaciones

    private HashMap<String, String> identificadores; //Guarda todos los identficadores (su nombre y valor)

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
        jLabel1 = new javax.swing.JLabel();
        InformacionBtn = new javax.swing.JButton();

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

        jLabel1.setText("Realizar análisis especifico:");

        InformacionBtn.setText("Información");
        InformacionBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InformacionBtnActionPerformed(evt);
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
                .addGroup(BackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BackPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(TokensScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(BackPanelLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(BackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(BackPanelLayout.createSequentialGroup()
                                .addGroup(BackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(BackPanelLayout.createSequentialGroup()
                                        .addComponent(LexicalBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(SyntacticBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(BackPanelLayout.createSequentialGroup()
                                        .addComponent(RunBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(26, 26, 26)
                                        .addComponent(CompileBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(BackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(InformacionBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(SemanticBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))))
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
                            .addComponent(NewBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(TokensScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(BackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BackPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ConsoleScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(BackPanelLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(BackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(BackPanelLayout.createSequentialGroup()
                                .addGroup(BackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(RunBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CompileBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(InformacionBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(35, 35, 35)
                                .addComponent(jLabel1)
                                .addGap(22, 22, 22)
                                .addComponent(LexicalBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(BackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(SyntacticBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(SemanticBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
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

    //Generar nuevo espacio para escribir código
    private void NewBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewBtnActionPerformed
        directorio.New();
        clearFields();
    }//GEN-LAST:event_NewBtnActionPerformed

    private void LexicalBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LexicalBtnActionPerformed
        if (getTitle().contains("*") || getTitle().equals(title)) {
            if (directorio.Save()) {
                clearFields();
                lexicalAnalysis();
                fillTableTokens();
                printConsole();
            }
        } else {
            clearFields();
            lexicalAnalysis();
            fillTableTokens();
            printConsole();
        }
    }//GEN-LAST:event_LexicalBtnActionPerformed

    private void SyntacticBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SyntacticBtnActionPerformed
        if (getTitle().contains("*") || getTitle().equals(title)) {
            if (directorio.Save()) {
                clearFields();
                lexicalAnalysis();
                fillTableTokens();
                syntacticAnalysis();
                printConsole();
            }
        } else {
            clearFields();
            lexicalAnalysis();
            fillTableTokens();
            syntacticAnalysis();
            printConsole();
        }
    }//GEN-LAST:event_SyntacticBtnActionPerformed

    private void SemanticBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SemanticBtnActionPerformed
        if (getTitle().contains("*") || getTitle().equals(title)) {
            if (directorio.Save()) {
                clearFields();
                lexicalAnalysis();
                fillTableTokens();
                syntacticAnalysis();
                semanticAnalysis();
                printConsole();
            }
        } else {
            clearFields();
            lexicalAnalysis();
            fillTableTokens();
            syntacticAnalysis();
            semanticAnalysis();
            printConsole();
        }
    }//GEN-LAST:event_SemanticBtnActionPerformed

    private void RunBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RunBtnActionPerformed
        CompileBtn.doClick();
        if (codeHasBeenCompiled) {
            if (!errors.isEmpty()) {
                JOptionPane.showMessageDialog(null,
                        "No se puede ejecutar el código ya que se encontró uno o más errores",
                        "Error en la compilación", JOptionPane.ERROR_MESSAGE);
            } else {
                CodeBlock codeBlock = Functions.splitCodeInCodeBlocks(tokens, "{", "}", ";");
                System.out.println(codeBlock);
                ArrayList<String> blocksOfCode = codeBlock.getBlocksOfCodeInOrderOfExec();
                System.out.println(blocksOfCode);
                executeCode(blocksOfCode, 1);

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

    private void InformacionBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InformacionBtnActionPerformed
        abrirURL("https://drive.google.com/file/d/1Q2necH-DcX7bgrnwcb5GBAaFsXYgE6jx/view?usp=sharing");
    }//GEN-LAST:event_InformacionBtnActionPerformed

    private void executeCode(ArrayList<String> blocksOfCode, int repeats) {
        for (int j = 1; j <= repeats; j++) {
            int repeatCode = -1;
            for (int i = 0; i < blocksOfCode.size(); i++) {
                String blockOfCode = blocksOfCode.get(i);
                if (repeatCode != -1) {
                    int[] posicionMarcador = CodeBlock.getPositionOfBothMarkers(blocksOfCode, blockOfCode);
                    executeCode(new ArrayList<>(blocksOfCode.subList(posicionMarcador[0], posicionMarcador[1])), repeatCode);
                    repeatCode = -1;
                    i = posicionMarcador[1];
                } else {
                    String[] sentences = blockOfCode.split(";");
                    for (String sentence : sentences) {

                        System.out.println(sentence);

                        sentence = sentence.trim();

                        //IMPRIMIR CADENAS
                        if (sentence.startsWith("show:")) {

                            if (sentence.contains("%")) {
                                System.out.println("--------------------------");
                                System.out.println("No se puede imprimir la variable");
                                System.out.println("--------------------------");
                            } else if(identificadores.get(sentence.substring(6, sentence.length())) != null){
                                
                                System.out.println("--------------------------");
                                System.out.println("VARIABLE: " + sentence.substring(6, sentence.length()));
                                
                                
                                System.out.println(identificadores.get(sentence.substring(6, sentence.length())));
                                
                                System.out.println("--------------------------");
                            } else {
                                System.out.println("--------------------------");
                                System.out.println("CADE: " + sentence.substring(7, sentence.length() - 1));
                                System.out.println("--------------------------");
                            }
                        } //REALIZAR OPERACIONES
                        else if (sentence.contains("+") || sentence.contains("-") || sentence.contains("*") || sentence.contains("/")) {
                            int resultado = 0;
                            ArrayList<Integer> numeros = new ArrayList<>();
                            int valores = 0;

                            int posicion = sentence.indexOf(":=");
                            System.out.println("--------------------------");
                            System.out.println(sentence.substring(posicion + 3));

                            String newsent = sentence.substring(posicion + 3);

                            String values = sentence.substring(posicion + 3);

                            Pattern patron1 = Pattern.compile("^([^\\s]+)");

                            Matcher matcher1 = patron1.matcher(values);
//
//                            // Iterar sobre las coincidencias encontradas
                            if (matcher1.find()) {
                                String valor2 = matcher1.group(1);
                                String valor1 = matcher1.group(1);
                                String conversion = "";
                                //aqui va while
                                while (identificadores.get(valor2) != null) {
                                    valor2 = identificadores.get(valor2);
                                }

                                conversion = newsent.replace(valor1, valor2);

                                newsent = newsent.replace(valor1, valor2);
//                                try{
//                                    conversion = Integer.parseInt(valor);
//                                    numeros.add(conversion);
//                                } catch (NumberFormatException e){
//                                    continue;
//                                }
                                System.out.println(conversion);
                            }

                            Pattern patron2 = Pattern.compile("[\\+\\-\\*\\/]\\s*(\\d+|\\w+)");

                            Matcher matcher2 = patron2.matcher(values);
//
//                            // Iterar sobre las coincidencias encontradas
                            while (matcher2.find()) {
                                String valor2 = matcher2.group(1);
                                String valor1 = matcher2.group(1);
                                String conversion = "";
                                //aqui va while
                                while (identificadores.get(valor2) != null) {
                                    valor2 = identificadores.get(valor2);
                                }
                                System.out.println(valor2);
                                conversion = newsent.replace(valor1, valor2);
                                newsent = newsent.replace(valor1, valor2);

//                                try{
//                                    conversion = Integer.parseInt(valor);
//                                    numeros.add(conversion);
//                                } catch (NumberFormatException e){
//                                    continue;
//                                }
                                System.out.println(conversion);
                            }

//                            System.out.println("Valores enteros encontrados:");
//                            for (int valor : numeros) {
//                                System.out.println("E " + valor);
//                            }
                            System.out.println(newsent);

                            String[] parts = newsent.split(" ");

                            Stack<Integer> numbers = new Stack<>();
                            Stack<Character> operators = new Stack<>();

                            for (String part : parts) {
                                if (isNumeric(part)) {
                                    numbers.push(Integer.parseInt(part));
                                } else if (isOperator(part)) {
                                    char operator = part.charAt(0);
                                    while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(operator)) {
                                        applyOperation(numbers, operators);
                                    }
                                    operators.push(operator);
                                }
                            }

                            while (!operators.isEmpty()) {
                                applyOperation(numbers, operators);
                            }

                            if (numbers.size() == 1) {
                                System.out.println("El resultado es: " + numbers.pop());
                            } else {
                                System.out.println("Expresión inválida");
                            }

                            System.out.println("***************************");
                            
                        } //OPERACIONES UNARIAS
                        else if (sentence.startsWith("INC") || sentence.startsWith("RED") || sentence.startsWith("NOT")) {
                            System.out.println("--------------------------");
                            System.out.println(sentence.substring(4, sentence.length()));

                            String valor;
                            int conversion;

                            valor = identificadores.get(sentence.substring(4, sentence.length()));

                            try {
                                conversion = Integer.parseInt(valor);
                            } catch (NumberFormatException e) {
                                continue;
                            }

                            if (sentence.startsWith("INC")) {
                                conversion++;
                            } else {
                                conversion--;
                            }

                            System.out.println(conversion);
                            System.out.println("--------------------------");

                        }

//                        sentence = sentence.trim();
//                        // Llamar código de ejecución (arduino, gráfico, etc)
//                        if (sentence.startsWith("pintar")) {
//                            String parametro;
//                            if (sentence.contains("$")) {
//                                parametro = identificadores.get(sentence.substring(9, sentence.length() - 2));
//                            } 
//                            else {
//                                parametro = sentence.substring(9, sentence.length() - 2);
//                            }
//                            System.out.println("Pintando de color " + parametro + "...");
//                        } 
//                        else if (sentence.startsWith("izquierda")) {
//                            System.out.println("Moviéndose a la izquierda...");
//                        } else if (sentence.startsWith("derecha")) {
//                            System.out.println("Moviéndose a la derecha...");
//                        } else if (sentence.startsWith("adelante")) {
//                            System.out.println("Moviéndose hacia adelante");
//                        } else if (sentence.contains("-->")) {
//                            String[] identComp = sentence.split(" ");
//                            System.out.println("Declarando identificador " + identComp[1] + " igual a " + identComp[3]);
//                        } else if (sentence.startsWith("atrás")) {
//                            System.out.println("Moviéndose hacia atrás");
//                        } else if (sentence.startsWith("repetir")) {
//                            String parametro;
//                            if (sentence.contains("$")) {
//                                parametro = identificadores.get(sentence.substring(10, sentence.length() - 2));
//                            } else {
//                                parametro = sentence.substring(10, sentence.length() - 2);
//                            }
//                            repeatCode = Integer.parseInt(parametro);
//                        }
                    }
                }
            }
        }
    }

    private static boolean isNumeric(String str) {
        return str.matches("-?\\d+");
    }

    private static boolean isOperator(String str) {
        return str.matches("[+\\-*/]");
    }

    private static int precedence(char operator) {
        if (operator == '+' || operator == '-') {
            return 1;
        } else if (operator == '*' || operator == '/') {
            return 2;
        }
        return 0;
    }

    private static void applyOperation(Stack<Integer> numbers, Stack<Character> operators) {
        if (numbers.size() >= 2 && !operators.isEmpty()) {
            int b = numbers.pop();
            int a = numbers.pop();
            char op = operators.pop();
            switch (op) {
                case '+':
                    numbers.push(a + b);
                    break;
                case '-':
                    numbers.push(a - b);
                    break;
                case '*':
                    numbers.push(a * b);
                    break;
                case '/':
                    if (b != 0) {
                        numbers.push(a / b);
                    } else {
                        System.out.println("Error: División por cero.");
                    }
                    break;
                default:
                    System.out.println("Operador no válido: " + op);
            }
        }
    }

    //MÉTODOS
    //-----------DISEÑO-----------
    //Inicialización de la ventana-------------------------------***
    private void init() {
        title = "PanemCode";
        setLocationRelativeTo(null);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/logo-panem-code.png")));
        setTitle(title);
        directorio = new Directory(this, CodeText, title, ".txt"); //--------------------------------------------

        addWindowListener(new WindowAdapter() {
            @Override
            //Ventana para preguntar si guardar o descartar código
            public void windowClosing(WindowEvent e) {
                directorio.Exit();
                System.exit(0);
            }
        });

        //Mostrar número de linea
        Functions.setLineNumberOnJTextComponent(CodeText);

        //Pintar las palabras
        timerKeyReleased = new Timer((int) (1000 * 0.3), (ActionEvent e) -> {
            timerKeyReleased.stop();
            colorAnalysis();
        });

        //Poner asterisco en nombre del proyecto
        Functions.insertAsteriskInName(this, CodeText, () -> {
            timerKeyReleased.restart();
        });

        //Inicialización de los arraylist y hashmap
        tokens = new ArrayList<>();
        errors = new ArrayList<>();
        textsColor = new ArrayList<>();
        identProd = new ArrayList<>();
        unarProd = new ArrayList<>();
        asigProd = new ArrayList<>();
        combProd = new ArrayList<>();
        expProd = new ArrayList<>();
        relaProd = new ArrayList<>();
        identificadores = new HashMap<>();

        //Predicción de palabras (Ctrl + Space)
        Functions.setAutocompleterJTextComponent(new String[]{"hola", "adios", "hasta la proxima",
            "oli"}, CodeText, () -> {
            timerKeyReleased.restart();
        }); //--------------------------------------------
    }

    //Colores en el código-------------------------------***
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

    //Limpiar panel de código-------------------------------***
    private void clearFields() {
        Functions.clearDataInTable(TokensTable);
        ConsoleText.setText("");
        ConsoleText.setForeground(new Color(0, 0, 0));
        tokens.clear();
        errors.clear();
        identProd.clear();
        asigProd.clear();
        unarProd.clear();
        combProd.clear();
        expProd.clear();
        relaProd.clear();
        identificadores.clear();
        codeHasBeenCompiled = false;
    }

    private void abrirURL(String url) {
        try {
            Desktop.getDesktop().browse(new URI(url));
        } catch (IOException | URISyntaxException ex) {
            System.out.println("Error al abrir la URL: " + ex.getMessage());
        }
    }

    //-----------COMPILACIÓN-----------
    //Realiza la compilación del código-------------------------------***
    private void compile() {
        clearFields(); //Limpiar campos

        //Partes de la compilación
        lexicalAnalysis();
        fillTableTokens();
        syntacticAnalysis();
        semanticAnalysis();

        //Imprimir en consola
        printConsole();

        codeHasBeenCompiled = true;
    }

    //Análisis léxico-------------------------------***
    private void lexicalAnalysis() {
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

    //Análisis sintáctico-------------------------------***
    private void syntacticAnalysis() {
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
            gramatica.group("EXPRESION", "(VALOR | VARIABLE) ((OPSUMA | OPRESTA | OPDIVISION | OPMULTIPLICACION) (VALOR | VARIABLE))+", expProd);
        });

        //DECLARACION DE VARIABLES
        gramatica.group("DECLARACION", "PRDECLARAR VARIABLE OPASIGNACION (VALOR | EXPRESION) COMA", true, identProd);

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
        gramatica.group("ASIGNACION", "VARIABLE OPASIGNACION (VALOR | EXPRESION | VARIABLE) COMA", true, asigProd);

        gramatica.group("ASIGNACION", "(VALOR | EXPRESION) OPASIGNACION VARIABLE", true,
                8, "ERROR SINTÁCTICO {}: Asignación no válida [#]");
        gramatica.group("ASIGNACION", "OPASIGNACION (VALOR | EXPRESION | VARIABLE)", true,
                9, "ERROR SINTÁCTICO {}: Se necesita variable para asignar valor [#]");
        gramatica.group("ASIGNACION", "VARIABLE (VALOR | EXPRESION | VARIABLE)", true,
                10, "ERROR SINTÁCTICO {}: Se espera signo de asignación [#]");
        gramatica.group("ASIGNACION", "VARIABLE OPASIGNACION", true,
                11, "ERROR SINTÁCTICO {}: Se espera valor en la asignación [#]");

        //SALIDA DE MENSAJES
        gramatica.group("MOSTRAR", "PRMOSTRAR (VALOR | VARIABLE) COMA", true);

        gramatica.delete("PRMOSTRAR", 25,
                "ERROR SINTÁCTICO {}: '[]' no está en una sentencia [#]");

        //LEER ENTRADA
        gramatica.group("LEER", "PRLEER VARIABLE COMA", true);

        gramatica.group("LEER", "PRLEER VALOR", true,
                12, "ERROR SINTÁCTICO {}: Sentencia no válida [#]");

        gramatica.delete("PRLEER", 26,
                "ERROR SINTÁCTICO {}: '[]' no está en una sentencia [#]");

        //ESTRUCTURAS RELACIONALES
        //gramatica.loopForFunExecUntilChangeNotDetected(() -> {
        gramatica.group("RELACION", "(VALOR | VARIABLE) OPRELACIONAL (VALOR | VARIABLE)", true, relaProd);

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
        gramatica.group("COMBINACION", "VARIABLE OPCOMBINADO (VALOR | VARIABLE) COMA", true, combProd);

        gramatica.group("COMBINACION", "OPCOMBINADO (VALOR | VARIABLE)", true,
                15, "ERROR SINTÁCTICO {}: Se necesita otro valor [#]");
        //-------------
        gramatica.group("COMBINACION", "VALOR OPCOMBINADO (VALOR | VARIABLE)", true,
                16, "ERROR SINTÁCTICO {}: Sentencia no válida [#]");

        //OPERACIONES UNARIAS
        gramatica.group("UNARIA", "(OPINCREMENTO | OPDECREMENTO | OPINVERSION) VARIABLE COMA", true, unarProd);

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

        gramatica.group("INICIO", "PRINICIO LLAVEABRIR (INSTRUCCION)*");

        gramatica.group("INICIO", "(INSTRUCCION)+",
                22, "ERROR SINTÁCTICO {}: Falta estructura de inicio");

        gramatica.group("FIN", "LLAVECERRAR PRFIN", true);

        gramatica.group("PROGRAMA", "INICIO FIN", true);

        gramatica.group("PROGRAMA", "INICIO", true,
                23, "ERROR SINTÁCTICO {}: Falta estructura de fin");

        gramatica.show();
    }

    //Análisis semántico-------------------------------***
    private void semanticAnalysis() {
        //System.out.println(identDataType.get("edad"));

        HashMap<String, String> identDataType = new HashMap<>();

        for (Production id : identProd) {

            //-----------METODOS
//            System.out.println(id.lexemeRank(0)); //te da la palabra en la posición indicada
//            System.out.println(id.lexemeRank(0, -1)); //te da toda la declaración
//            System.out.println(id.lexicalCompRank(0)); //te da la producción en la posición indicada
//            System.out.println(id.lexicalCompRank(0, -1)); //te da toda la producción
//            System.out.println(id.tokenRank(0)); //te da el token en la posición indicada
//            System.out.println(id.tokenRank(0, -1)); //te da toddo el token
//            System.out.println("*");
            identificadores.put(id.lexemeRank(1), id.lexemeRank(3));
            identDataType.put(id.lexemeRank(1), id.lexicalCompRank(3));

        }

        System.out.println("------ASIGNACIÓN--------");

        for (Production id : asigProd) {

            if (identificadores.get(id.lexemeRank(0)) == null) {
                errors.add(new ErrorLSSL(1, "ERROR SEMÁNTICO {}: Variable no definida [#]", id, true));
                //System.out.println("NO SE PUEDE HACER LA ASIGNACIÓN");
                //System.out.println("******************");
            } else {
                identificadores.replace(id.lexemeRank(0), id.lexemeRank(2));
                identDataType.replace(id.lexemeRank(0), id.lexicalCompRank(2));
                //System.out.println("SI SE PUEDE HACER LA ASIGNACIÓN");
                //System.out.println("******************");
            }
        }

        System.out.println("--------------");

        System.out.println("-------UNARIOS-------");

        for (Production id : unarProd) {

            if (identificadores.get(id.lexemeRank(1)) == null) {
                errors.add(new ErrorLSSL(1, "ERROR SEMÁNTICO {}: Variable no definida [#]", id, true));
                //System.out.println("NO SE ENCONTRÓ EL IDENTIFICADOR");
                //System.out.println("******************");
            } else if (!"ENTERO".equals(identDataType.get(id.lexemeRank(1))) && !"DECIMAL".equals(identDataType.get(id.lexemeRank(1)))) {
                errors.add(new ErrorLSSL(2, "ERROR SEMÁNTICO {}: El valor debe ser Entero o Decimal [#]", id, true));
                //System.out.println("EL TIPO DE DATO NO ES ENTERO NI DECIMAL");
                //System.out.println("******************");
            } else {
                //------------
//                int nuevoValor = Integer.parseInt(identificadores.get(id.lexemeRank(1)));
//                nuevoValor++;
//                String incrementar = String.valueOf(nuevoValor);
//                
//                identificadores.replace(id.lexemeRank(1), incrementar);
                //------------

                //System.out.println("SI SE PUEDE HACER LA OPERACIÓN");
                //System.out.println("******************");
            }
        }

        System.out.println("--------------");

        System.out.println("-------COMBINACION-------");

        for (Production id : combProd) {

            if (identificadores.get(id.lexemeRank(0)) == null) {
                //errors.add(new ErrorLSSL(1, "ERROR SEMÁNTICO {}: Variable no definida [#]", id, true));
                System.out.println("NO SE ENCONTRÓ EL IDENTIFICADOR");
                System.out.println("******************");
            }
            //else {
            //int nuevoValor = Integer.parseInt(identificadores.get(id.lexemeRank(1)));
            //nuevoValor++;
            //String incrementar = String.valueOf(nuevoValor);

            //identificadores.replace(id.lexemeRank(1), incrementar);
            //  System.out.println("SI SE PUEDE HACER LA OPERACIÓN");
            //  System.out.println("******************");
            //}
        }

        System.out.println("--------------");

        System.out.println("-------EXPRESIONES-------");

        for (Production id : expProd) {

        }

        System.out.println("--------------");

        System.out.println("-------RELACIONES-------");

        for (Production id : relaProd) {

            if (identificadores.get(id.lexemeRank(0)) == null) {
                errors.add(new ErrorLSSL(1, "ERROR SEMÁNTICO {}: Variable no definida [#]", id, true));
                //System.out.println("NO SE PUEDE HACER LA ASIGNACIÓN");
                //System.out.println("******************");
            } else {
//                identificadores.replace(id.lexemeRank(0), id.lexemeRank(-1));
//                identDataType.replace(id.lexemeRank(0), id.lexicalCompRank(-1));
                //System.out.println("SI SE PUEDE HACER LA ASIGNACIÓN");
                //System.out.println("******************");
            }
        }

        System.out.println("--------------");
    }

    //Llenar tabla de tokens-------------------------------***
    private void fillTableTokens() {
        AtomicInteger id = new AtomicInteger(1);

        tokens.forEach(token -> {
            Object[] data = new Object[]{id.getAndIncrement(), token.getLexicalComp(), token.getLexeme(),
                "[" + token.getLine() + "]"};
            Functions.addRowDataInTable(TokensTable, data);
        });
    }

    //Imprimir en consola-------------------------------***
    private void printConsole() {

        ConsoleText.setForeground(new Color(0, 0, 0));

        int sizeErrors = errors.size();
        if (sizeErrors > 0) {
            Functions.sortErrorsByLineAndColumn(errors);
            String strErrors = "\n";
            for (ErrorLSSL error : errors) {
                String strError = String.valueOf(error);
                strErrors += strError + "\n";
            }
            ConsoleText.setText("COMPILACIÓN COMPLETA:\n" + strErrors
                    + "\nSe encontraron errores al compilar"); //-----CAMBIAR COLOR
            ConsoleText.setForeground(new Color(153, 0, 0));
        } else {
            ConsoleText.setText("COMPILACIÓN COMPLETA:\n"
                    + "\nCompilación terminada exitosamente y sin errores ");
            ConsoleText.setForeground(new Color(0, 51, 0));
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

                try {
                    UIManager.setLookAndFeel(new FlatIntelliJLaf());
                } catch (UnsupportedLookAndFeelException ex) {
                    System.out.println("LookAndFeel no soportado: " + ex);
                }

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
    private javax.swing.JButton InformacionBtn;
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
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
