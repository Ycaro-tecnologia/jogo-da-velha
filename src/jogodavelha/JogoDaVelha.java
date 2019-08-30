

package jogodavelha;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class JogoDaVelha extends JFrame {

    ImageIcon iconcirculo = new ImageIcon(getClass().getResource("circulo.jpg"));
    ImageIcon iconx = new ImageIcon(getClass().getResource("x.jpg"));
    
    JPanel pTela = new JPanel(new GridLayout(3, 3, 10, 10));
    
    final int jogador_1 = 1;
    final int jogador_2 = 2;
    
    int jogadorVez = 1;
    
    
    
     int Rodadas = 0;
    
    
    Bloco[] blocos = new Bloco[9];
    
    JLabel LInformacao = new JLabel("jogador "+ jogador_1);
    
    
    public void configurarTela() {
        add(BorderLayout.CENTER,pTela);
        add(BorderLayout.NORTH, LInformacao);
        pTela.setBackground(Color.BLACK);
        LInformacao.setFont(new Font("arial", Font.BOLD, 30));
        LInformacao.setForeground(new Color(80, 100, 60));
        LInformacao.setHorizontalAlignment(SwingConstants.CENTER);
        
        
        for(int i=0; i<9; i++) {
            Bloco bloco = new Bloco();
            blocos[i] = bloco;
            pTela.add(bloco);
            
        }
            
    }
    
    public void configurarJanela() {
        
        setTitle("Jogo Da Velha");
        setSize( 700, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
            
    }
    
    
    public JogoDaVelha() {
        
        configurarTela();
        configurarJanela();
    }
    
   
    public static void main(String[] args) {
        
        new JogoDaVelha();
    }
    
      
    public void mudarVez() {
        if(jogadorVez==1) {
            jogadorVez=2;
            LInformacao.setText("jogador 2 ");
        } else {
            jogadorVez=1;
            LInformacao.setText("jogador 1 ");
            LInformacao.setBackground(Color.BLUE);
        }
    }
    
    
    
     public boolean testarVitoria(int jog) {
          
         if(blocos[0].quem==jog && blocos[1].quem==jog && blocos[2].quem==jog) {
             return true;
         }
        
         if(blocos[3].quem==jog && blocos[4].quem==jog && blocos[5].quem==jog) {
             return true;
         }
         
         if(blocos[6].quem==jog && blocos[7].quem==jog && blocos[8].quem==jog) {
             return true;
         }
         
         if(blocos[0].quem==jog && blocos[3].quem==jog && blocos[6].quem==jog) {
             return true;
         }
         
         if(blocos[1].quem==jog && blocos[4].quem==jog && blocos[7].quem==jog) {
             return true;
         }
         
         if(blocos[2].quem==jog && blocos[5].quem==jog && blocos[8].quem==jog) {
             return true;
         }
         
         if(blocos[0].quem==jog && blocos[4].quem==jog && blocos[8].quem==jog) {
             return true;
         }
         
         if(blocos[2].quem==jog && blocos[4].quem==jog && blocos[6].quem==jog) {
             return true;
         }
         
         return false;
        
    }
   
    
    public class Bloco extends JButton {
        
        int quem = 0;
        
        public Bloco() {
            setBackground(Color.white);
            addActionListener(e-> {
               if(quem==0) {
                   if(jogadorVez==jogador_1) {
                       setIcon(iconcirculo);
                       quem = jogador_1;
                   } else {
                       setIcon(iconx);
                       quem = jogador_2;
                   }
                   if(testarVitoria(quem)) {
                       JOptionPane.showMessageDialog(null, "jogador "+quem+" Venceu!");
                       System.exit(0);
                   }
                   Rodadas++;
                   if(Rodadas==9) {
                       JOptionPane.showMessageDialog(null, "Deu Velha");
                       System.exit(0);
                   }
                   mudarVez();
               } 
            });
        
        
        
    }
    }
} 


    
    
    
    
    
    
    
    
    
    
    
    
    
    
