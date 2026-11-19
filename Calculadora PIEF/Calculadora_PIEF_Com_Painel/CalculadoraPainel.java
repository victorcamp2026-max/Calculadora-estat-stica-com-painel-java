import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField; 
import javax.swing.SwingConstants; 


import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.statistics.HistogramDataset;

public class CalculadoraPainel { 

     static ArrayList<Double> numeros = new ArrayList<>(); 

     static JLabel lblNumeros; 
     static JLabel lblResultado; 
     static JTextField txtNumero; 
     static JTextField txtFrequencia; 

     public static void main(String[] args) { 

          JFrame janela = new JFrame("Calculadora Estatística"); 

          janela.setSize(600, 580); 
          janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
          janela.setLocationRelativeTo(null); 
          janela.setResizable(false); 

          JPanel painelPrincipal = new JPanel(); 
          painelPrincipal.setLayout(new BorderLayout(10, 10)); 
          painelPrincipal.setBorder( 
              BorderFactory.createEmptyBorder(20, 20, 20, 20) 
          ); 

          painelPrincipal.setBackground(new Color(8, 77, 110)); 

          janela.add(painelPrincipal); 

          // Título da calculadora, calculadora estatística 

          JLabel lblTitulo = new JLabel( 
              "Calculadora Estatística", 
              SwingConstants.CENTER 
          ); 

          lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 24)); 
          lblTitulo.setForeground(Color.WHITE); 

          // Painel do título e botão de tutorial 

          JPanel painelTopo = new JPanel(new BorderLayout()); 

          painelTopo.add(lblTitulo, BorderLayout.CENTER); 

          painelTopo.setBackground(new Color(8, 77, 110)); 

          JButton btnTutorial = new JButton("Tutorial"); 

          btnTutorial.setBackground(Color.WHITE); 
          btnTutorial.setForeground(Color.BLACK); 
          btnTutorial.setFont(new Font("Arial", Font.BOLD, 13)); 

          painelTopo.add(btnTutorial, BorderLayout.EAST); 

          painelPrincipal.add(painelTopo, BorderLayout.NORTH); 

          // Abrir o tutorial 

          btnTutorial.addActionListener(e -> abrirTutorial(janela)); 

          // Painel Central 

          JPanel painelCentral = new JPanel(); 
          painelCentral.setLayout(new GridLayout(5, 1, 10, 10)); 

          // JLabel para digitar os números 

          JPanel painelAdicionar = new JPanel(new GridLayout(2, 2, 10, 5)); 

          JLabel lblNumero = new JLabel("Digite um número:"); 
          lblNumero.setForeground(Color.WHITE); 
          lblNumero.setFont(new Font("Arial", Font.BOLD, 17)); 
          lblNumero.setHorizontalAlignment(SwingConstants.CENTER); 

          // setHorizontalAlignment serve para mover onde você quiser o Label, para ficar mais organizado 

          txtNumero = new JTextField(); 
          txtNumero.requestFocus(); 

          JButton btnAdicionar = new JButton("Adicionar"); 

          btnAdicionar.setBackground(new Color(178, 218, 250)); 

          JButton btnRemover = new JButton("Remover último"); 

          btnRemover.setBackground(new Color(255, 127, 127)); 

          // JButton para adicionar e remover os números, é um botão 

          painelAdicionar.add(lblNumero); 
          painelAdicionar.add(txtNumero); 
          painelAdicionar.add(btnAdicionar); 
          painelAdicionar.add(btnRemover); 
          painelAdicionar.setBackground(new Color(8, 77, 110)); 

          painelCentral.add(painelAdicionar); 
          painelCentral.setBackground(new Color(8, 77, 110)); 

          // Um JLabel para mostar os números que foram adicionados no array 

          JPanel painelLista = new JPanel(new GridLayout(2, 1, 5, 5)); 
          painelLista.setBackground(new Color(8, 77, 110)); 

          JLabel lblLista = new JLabel("Números adicionados:"); 
          lblLista.setFont(new Font("Arial", Font.BOLD, 17)); 
          lblLista.setForeground(Color.WHITE); 
          lblLista.setHorizontalAlignment(SwingConstants.CENTER); 

          lblNumeros = new JLabel("Nenhum número adicionado."); 
          lblNumeros.setFont(new Font("Arial", Font.BOLD, 13)); 
          lblNumeros.setForeground(Color.WHITE); 

          painelLista.add(lblLista); 
          painelLista.add(lblNumeros); 

          painelCentral.add(painelLista); 

          // O painel de cálculo tem uma String para escolher a conta e um JComboBox para o usuário escolher el cálculo 

          JPanel painelCalculos = new JPanel(new GridLayout(2, 2, 10, 5)); 
          painelCalculos.setBackground(new Color(8, 77, 110)); 


          JLabel lblCalculo = new JLabel("Escolha o cálculo:"); 
          lblCalculo.setFont(new Font("Arial", Font.BOLD, 17)); 
          lblCalculo.setForeground(Color.WHITE); 
          lblCalculo.setHorizontalAlignment(SwingConstants.CENTER); 

          String[] calculos = { 
              "Soma", 
              "Média", 
              "Mediana", 
              "Moda", 
              "Amplitude", 
              "Variância", 
              "Desvio padrão", 
              "Frequência" 
          }; 

          JComboBox<String> cmbCalculo = new JComboBox<>(calculos); 

          painelCalculos.add(lblCalculo); 
          painelCalculos.add(cmbCalculo); 

          JLabel lblValor = new JLabel("Número para frequência:"); 
          lblValor.setFont(new Font("Arial", Font.BOLD, 17)); 
          lblValor.setForeground(Color.WHITE); 
          lblValor.setHorizontalAlignment(SwingConstants.CENTER); 


          txtFrequencia = new JTextField(); 

          painelCalculos.add(lblValor); 
          painelCalculos.add(txtFrequencia); 

          painelCentral.add(painelCalculos); 

          // Painel de botões de Ação (Calcular e Gráfico lado a lado)
          JPanel painelBotoesAcao = new JPanel(new GridLayout(1, 2, 10, 0));
          painelBotoesAcao.setBackground(new Color(8, 77, 110));

          // Botão que calcula 
          JButton btnCalcular = new JButton("CALCULAR"); 
          btnCalcular.setFont(new Font("Arial", Font.BOLD, 15)); 
          btnCalcular.setBackground(new Color(178, 218, 250)); 

          // Botão para gerar o histograma
          JButton btnGrafico = new JButton("GERAR GRÁFICO");
          btnGrafico.setFont(new Font("Arial", Font.BOLD, 15));
          btnGrafico.setBackground(new Color(178, 218, 250));

          painelBotoesAcao.add(btnCalcular);
          painelBotoesAcao.add(btnGrafico);

          painelCentral.add(painelBotoesAcao); 

          // Painel que mostra o resultado 

          JPanel painelResultado = new JPanel(new GridLayout(2, 1, 5, 5)); 

          lblResultado = new JLabel(" "); 
          lblResultado.setFont(new Font("Arial", Font.BOLD, 18)); 
          lblResultado.setHorizontalAlignment(SwingConstants.CENTER); 

          painelResultado.add(lblResultado); 
          painelResultado.setBackground(Color.WHITE); 

          painelCentral.add(painelResultado); 

          painelPrincipal.add(painelCentral, BorderLayout.CENTER); 


         Runnable acaoAdicionar = () -> { 

         // o Runnable é para o enter funcionar como adicionar

              try { 
                  double numero = Double.parseDouble( 
                      txtNumero.getText().replace(",", ".") 
                  ); 
              
              // Para poder utilizar tanto vírgula quanto ponto, coloquei esse replace para trocar a vírgula por ponto 

                  numeros.add(numero); 

                  atualizarNumeros(); 

                  txtNumero.setText(""); 

              } catch (NumberFormatException erro) { 

                  JOptionPane.showMessageDialog( 
                      janela, 
                      "Digite um número válido" 
                  ); 

              } 
              txtNumero.requestFocus();
         };

          // Função do botão adicionar e para o enter funcionar junto também
          btnAdicionar.addActionListener(e -> acaoAdicionar.run());
          txtNumero.addActionListener(e -> acaoAdicionar.run()); 

          // Função do botão remover 

          btnRemover.addActionListener(e -> { 

              if (numeros.isEmpty()) { 

                  JOptionPane.showMessageDialog( 
                      janela, 
                      "Não tem números para remover" 
                  ); 

              } else { 

                  numeros.remove(numeros.size() - 1); 

                  atualizarNumeros(); 

                  lblResultado.setText("Número removido"); 

              } 
              txtNumero.requestFocus();

          }); 

          // Botão calcular 

          btnCalcular.addActionListener(e -> { 

              if (numeros.isEmpty()) { 

                  JOptionPane.showMessageDialog( 
                      janela, 
                      "Adicione números antes de calcular." 
                  ); 

                  txtNumero.requestFocus();
                  return; 
              } 

              String calculo = (String) cmbCalculo.getSelectedItem(); 

              switch (calculo) { 

                  case "Soma": 
                      lblResultado.setText( 
                          "Resultado: " + calcularSoma() 
                      ); 
                      break; 

                  case "Média": 
                      lblResultado.setText( 
                          "Resultado: " + calcularMedia() 
                      ); 
                      break; 

                  case "Mediana": 
                      lblResultado.setText( 
                          "Resultado: " + calcularMediana() 
                      ); 
                      break; 

                  case "Moda": 
                      lblResultado.setText(calcularModa()); 
                      break; 

                  case "Amplitude": 
                      lblResultado.setText( 
                          "Resultado: " + calcularAmplitude() 
                      ); 
                      break; 

                  case "Variância": 
                      lblResultado.setText( 
                          "Resultado: " + calcularVariancia() 
                      ); 
                      break; 

                  case "Desvio padrão": 
                      lblResultado.setText( 
                          "Resultado: " + calcularDesvioPadrao() 
                      ); 
                      break; 

                  case "Frequência": 

                      try { 

                          double valor = Double.parseDouble( 
                              txtFrequencia.getText().replace(",", ".") 
                          ); 

                          lblResultado.setText( 
                              "Frequência: " + 
                              contarFrequencia(valor) 
                          ); 

                      } catch (NumberFormatException erro) { 

                          JOptionPane.showMessageDialog( 
                              janela, 
                              "Digite um número para saber a frequência dele" 
                          ); 

                      } 

                      break; 
              } 
              txtNumero.requestFocus();

          }); 

          // Ação do Botão Gerar Gráfico
          btnGrafico.addActionListener(e -> abrirGrafico(janela));

          janela.setVisible(true); 

     } 

     // Método para abrir a nova janela com o Histograma do JFreeChart
     public static void abrirGrafico(JFrame janelaPai) {
         if (numeros.isEmpty()) {
             JOptionPane.showMessageDialog(janelaPai, "Adicione números antes de gerar o gráfico.");
             return;
         }

         double[] valores = new double[numeros.size()];
         for (int i = 0; i < numeros.size(); i++) {
             valores[i] = numeros.get(i);
         }

         int qtdBins = Math.min(10, Math.max(1, (int) Math.sqrt(numeros.size()) + 1));
         HistogramDataset dataset = new HistogramDataset();
         dataset.addSeries("Frequência dos Dados", valores, qtdBins);

         JFreeChart chart = ChartFactory.createHistogram(
             "Histograma Estatístico",
             "Valores",
             "Frequência",
             dataset,
             org.jfree.chart.plot.PlotOrientation.VERTICAL,
             false, 
             true, 
             false
         );

         JFrame janelaGrafico = new JFrame("Gráfico - Histograma");
         janelaGrafico.setSize(650, 450);
         janelaGrafico.setLocationRelativeTo(janelaPai);
         janelaGrafico.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

         ChartPanel painelGrafico = new ChartPanel(chart);
         janelaGrafico.add(painelGrafico);
         janelaGrafico.setVisible(true);
     }

     // Atualizar lista de números 

     public static void atualizarNumeros() { 

         if (numeros.isEmpty()) { 

              lblNumeros.setText("Nenhum número foi adicionado"); 

         } else { 

              String lista = ""; 

              for (int i = 0; i < numeros.size(); i++) { 

                  lista += numeros.get(i) + "  "; 

              } 

              lblNumeros.setText(lista); 

         } 

     } 

     // Soma 

     public static double calcularSoma() { 

         double soma = 0; 

         for (double numero : numeros) { 

              soma += numero; 

         } 

         return soma; 

     } 

     // Média 

     public static double calcularMedia() { 

         return calcularSoma() / numeros.size(); 

     } 

     // Mediana 

     public static double calcularMediana() { 

         ArrayList<Double> copia = new ArrayList<>(numeros); 

         Collections.sort(copia); 

         // Collections.sort é para colocar o array em ordem crescente, para fazer a mediana, melhor do que usar o for, já que já existe uma função 

         int tamanho = copia.size(); 

         int meio = tamanho / 2; 

         if (tamanho % 2 != 0) { 

              return copia.get(meio); 

         } 

         return (copia.get(meio - 1) + copia.get(meio)) / 2; 

     } 

     // Moda 

     public static String calcularModa() { 

         int maiorFrequencia = 0; 

         String moda = ""; 

         for (int i = 0; i < numeros.size(); i++) { 

              int frequencia = contarFrequencia(numeros.get(i)); 

              if (frequencia > maiorFrequencia) { 

                  maiorFrequencia = frequencia; 

              } 

         } 

         if (maiorFrequencia == 1) { 

              return "Não existe moda."; 

         } 

         for (int i = 0; i < numeros.size(); i++) { 

              double numero = numeros.get(i); 

              int frequencia = contarFrequencia(numero); 

              boolean jaMostrado = false; 

              for (int j = 0; j < i; j++) { 

                  if (numeros.get(j).equals(numero)) { 

                      jaMostrado = true; 

                      break; 

                  } 

              } 

              if (!jaMostrado && frequencia == maiorFrequencia) { 

                  moda += numero + " "; 

              } 

         } 

         return "Moda: " + moda; 

     } 

     // Amplitude 

     public static double calcularAmplitude() { 

         double menor = numeros.get(0); 

         double maior = numeros.get(0); 

         for (double numero : numeros) { 

              if (numero < menor) { 

                  menor = numero; 

              } 

              if (numero > maior) { 

                  maior = numero; 

              } 

         } 

         return maior - menor; 

     } 

     // Variância 

     public static double calcularVariancia() { 

         double media = calcularMedia(); 

         double somaQuadrados = 0; 

         for (double numero : numeros) { 

              somaQuadrados += Math.pow(numero - media, 2); 

         } 

         return somaQuadrados / numeros.size(); 

     } 

     // Desvio padrão 

     public static double calcularDesvioPadrao() { 

         return Math.sqrt(calcularVariancia()); 

     } 

     // Frequência 

     public static int contarFrequencia(double valor) { 

         int frequencia = 0; 

         for (double numero : numeros) { 

              if (Double.compare(numero, valor) == 0) { 

                  frequencia++; 

              } 

         } 

         return frequencia; 

     } 

// Na aula do Serginho ele deu a ideia de colocar um tutorial para pessoas que não sabem utilizar a calculadora e nem como funciona os cálculos 
// Então criei um JFrame janela a mais para fazer esse tutorial que de para acessar direto no programa 
// Além disso, conforme as aulas do primeiro semestre do Serginho e bastante pesquisa kaka, utilizei o html para não ficar tão feio o painel de tutorial 
// Poderia utilizar um OptionPane também, no entanto, ficaria muito feio, então aprendi como inserir o html no programa para melhor visualização

     public static void abrirTutorial(JFrame janela) { 

         JFrame tutorial = new JFrame( 
              "Tutorial da Calculadora" 
         ); 

         tutorial.setSize(700, 650); 

         tutorial.setLocationRelativeTo(janela); 

         tutorial.setDefaultCloseOperation( 
              JFrame.DISPOSE_ON_CLOSE 
         ); 

         JPanel painelPrincipal = new JPanel(); 

         painelPrincipal.setLayout( 
              new BorderLayout(10, 10) 
         ); 

         painelPrincipal.setBorder( 
              BorderFactory.createEmptyBorder( 
                  20, 20, 20, 20 
              ) 
         ); 

         // Título 

         JLabel lblTitulo = new JLabel( 
              "Como utilizar a calculadora?", 
              SwingConstants.CENTER 
         ); 

         lblTitulo.setFont( 
              new Font("Arial", Font.BOLD, 20) 
         ); 

         painelPrincipal.add( 
              lblTitulo, 
              BorderLayout.NORTH 
         ); 

         // Texto do tutorial 

         String texto = 

              "<html><head><style>" + 
              "body { font-family: Arial; font-size: 14px; color: #222222; }" + 
              "h2 { color: #24527a; background-color: #eaf2f8; padding: 8px; }" + 
              "p { margin-bottom: 10px; line-height: 1.5; }" + 
              "</style></head><body style='width: 560px; margin: 12px'>" + 

              "<h2>1. Como utilizar</h2>" + 

              "<p>1. Digite um número no painel de entrada para adicionar ele</p>" + 

              "<p>2. Clique em Adicionar</p>" + 

              "<p>3. Repita para adicionar outros números</p>" + 

              "<p>4. Escolha o cálculo que você deseja</p>" + 

              "<p>5. Clique em calcular para aparecer a resposta</p>" + 

              "<p>6. Ou clique em Gerar Gráfico para visualizar o histograma</p>" + 

              "<h2>2. Explicação dos cálculos</h2>" + 

              "<p><b>Soma:</b> Soma todos os números que você adicionou</p>" + 

              "<p><b>Média:</b> Divide a soma pela quantidade de números</p>" + 

              "<p><b>Mediana:</b> Valor que fica no meio, após ordenar os números em ordem crescente." + 
              "Se for uma quantidade par, calcula a média dos dois valores do meio</p>" + 

              "<p><b>Moda:</b> Número que aparece com maior frequência</p>" + 

              "<p><b>Amplitude:</b> Diferença entre o maior e o menor número</p>" + 

              "<p><b>Variância:</b> Mede a dispersão dos números em relação a média</p>" + 

              "<p><b>Desvio padrão:</b> Indica o quanto os valores se afastam da média." + " É calculado pela raiz quadrada da variância</p>" + 

              "<p><b>Frequência:</b> Conta quantas vezes o número escolhido aparece</p>" + 

              "<h2>3. Botões</h2>" + 

              "<p><b>Adicionar:</b> Insere um número na lista</p>" + 

              "<p><b>Remover último:</b> Exclui o último número adicionado</p>" + 

              "</body></html>"; 

         JEditorPane lblTutorial = new JEditorPane(); 

         lblTutorial.setContentType("text/html"); 

         lblTutorial.setText(texto); 

         lblTutorial.setEditable(false); 

         lblTutorial.setCaretPosition(0); 

         JScrollPane painelRolagem = new JScrollPane(lblTutorial); 

         painelRolagem.setBorder( 
              BorderFactory.createEmptyBorder(5, 5, 5, 5) 
         ); 

         painelPrincipal.add( 
              painelRolagem, 
              BorderLayout.CENTER 
         ); 

         // O JScrollPane é para criar a parte que "scrolla" tanto vertical, quanto horizontal, em casos das informações serem mais "volumosas" que o próprio painel 
         // Pesquisei para aprender como fazia e aplicava no meu código 

         // Botão fechar 

         JButton btnFechar = new JButton("Fechar"); 

         btnFechar.addActionListener( 
              e -> tutorial.dispose() 
         ); 

         JPanel painelBotoes = new JPanel( 
              new FlowLayout() 
         ); 

         painelBotoes.add(btnFechar); 

         painelPrincipal.add( 
              painelBotoes, 
              BorderLayout.SOUTH 
         ); 

         tutorial.add(painelPrincipal); 

         tutorial.setVisible(true); 

     } 

}