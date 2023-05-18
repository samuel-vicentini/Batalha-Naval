package batalhanaval;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Samuel de Souza Machado Vicentini
 */

public class BatalhaNaval {           
    
    //Declaração das variáveis
    public static String arenaH [] [] = new String [10][10];
    public static String arenaC [] [] = new String [10][10];
    public static String tirosArenaC [] [] = new String [10][10];
    public static String tirosArenaH [] [] = new String [10][10];
    public static String Vermelho = "\033[0;31m"; // Cor vermelha
    public static String Verde = "\033[1;32m"; // Cor verde
    public static String Azul = "\033[1;34m"; // Cor azul
    public static String Amarelo = "\033[0;33m"; // Cor Amarelo   
    public static String ResetarCor = "\033[0m"; // Reseta cor 
          
    /**
     * @param args the command line arguments
     * @throws java.lang.InterruptedException
     */
    
    public static void main(String[] args) throws InterruptedException{
       // TODO code application logic here
       BatalhaNaval f = new BatalhaNaval();
       f.iniciar();
       f.preencheArenas();
       f.montaC();
       f.montaH();
       //f.mostraArenaC(); //Mostra a arena sorteada pelo computador
       f.mostraArenaH();
       f.jogar();
       
}
    
    public void preencheArenas (){
        // Preenche as arenas com espaços para não dar erro de "null"
        for (int l=0; l<=9;l++)
        {
            for (int c=0;c<=9;c++)
            {
                arenaH[l][c]=" ";
                arenaC[l][c]=" ";
                tirosArenaC[l][c]=" ";
                tirosArenaH[l][c]=" ";
            }    
        }   
    }
    
    public void mostraArenaH(){
        // Monta a estética da arena do humano 
        String linha = "";
        String cabecalholinha = "   | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10|";
        String divisao  = "===|=======================================|";
        for (int x=0; x<=9;x++)
        {
            if(x+1 < 10)
            {
                linha = (x+1) + "  | ";
            }
            else
            {
                linha = (x+1) + " | ";
            }
            for (int y=0;y<=9;y++)
            {
                linha = linha + arenaH[x][y]+" | ";
            }
            if(x == 0 ) 
            {
                System.out.println(cabecalholinha);
                System.out.println(divisao);
            }
            System.out.println(linha);
            linha = " ";
        }
    }
    
    public void mostraArenaC(){
        // Monta a estética da arena do Computador
        String linha = "";
        String cabecalholinha = "   | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10|";
        String divisao  = "===|=======================================|";
        for (int x=0; x<=9;x++)
        {
            if(x+1 < 10)
            {
                linha = (x+1) + "  | ";
            }
            else
            {
                linha = (x+1) + " | ";
            }
            for (int y=0;y<=9;y++)
            {
                linha = linha + arenaC[x][y]+" | ";
            }
            if(x == 0 ) 
            {
                System.out.println(cabecalholinha);
                System.out.println(divisao);
            }
            System.out.println(linha);
            linha = " ";
        }
    }
        
    public void montaC(){
        // Aqui é onde será feito o sorteio dos navios do computador e a verificação se não estão colados
        Random gera = new Random();
        BatalhaNaval f = new BatalhaNaval();
        Scanner leia = new Scanner(System.in);
        int l,c;
               
        // Porta Aviões - 4 posições:
        l= gera.nextInt(10);
        c= gera.nextInt(7);
        while (((!arenaC[l][c].equals(" ")) && (!arenaC[l][c+1].equals(" ")) && (!arenaC[l][c+2].equals(" ")) && (!arenaC[l][c+3].equals(" "))))
        {
            l = gera.nextInt(10);
            c = gera.nextInt(7);
        }
        arenaC[l][c] = "P";
        arenaC[l][c+1] = "P";
        arenaC[l][c+2] = "P";
        arenaC[l][c+3] = "P";
                               
        
        // Submarino 1 - 3 posições: 
        int saida = 0;
        while (saida == 0)
        {
            l = gera.nextInt(10);
            c = gera.nextInt(8);
            
            if ((arenaC[l][c].equals(" ")) && (arenaC[l][c+1].equals(" ")) && (arenaC[l][c+2].equals(" ")))
            {
                saida = 1;
            }
            // Verificar se não tem nada uma coluna a esquerda e uma coluna a direita (dos lados do navio)
            if ((c >= 1 && !arenaC[l][c-1].equals(" ")) || (c <=6 && !arenaC[l][c+3].equals(" ")))
            {
                saida = 0;
            }
            // Verificar se não tem nada uma linha anterior na mesma posição da coluna (em cima do navio)
            if ( l >= 1 && ( !arenaC[l-1][c].equals(" ") || !arenaC[l-1][c+1].equals(" ") || !arenaC[l-1][c+2].equals(" ")))
            {
                saida = 0;
            }
            // Verificar se não tem nada uma linha depois na mesma posição da coluna (em baixo do navio)
            if ( l <= 8 && ( !arenaC[l+1][c].equals(" ") || !arenaC[l+1][c+1].equals(" ") || !arenaC[l+1][c+2].equals(" ")))
            {
                saida = 0;
            }
        } 
        arenaC[l][c] = "S";
        arenaC[l][c+1] = "S";
        arenaC[l][c+2] = "S"; 
        
        // Submarino 2 - 3 posições:
        saida = 0;
        while (saida == 0)
        {
            l = gera.nextInt(10);
            c = gera.nextInt(8);
            
            if ((arenaC[l][c].equals(" ")) && (arenaC[l][c+1].equals(" ")) && (arenaC[l][c+2].equals(" ")))
            {
                saida = 1;
            }
            // Verificar se não tem nada uma coluna a esquerda e uma coluna a direita (dos lados do navio)
            if ((c >= 1 && !arenaC[l][c-1].equals(" ")) || (c <=6 && !arenaC[l][c+3].equals(" ")))
            {
                saida = 0;
            }
            // Verificar se não tem nada uma linha anterior na mesma posição da coluna (em cima do navio)
            if ( l >= 1 && ( !arenaC[l-1][c].equals(" ") || !arenaC[l-1][c+1].equals(" ") || !arenaC[l-1][c+2].equals(" ")))
            {
                saida = 0;
            }
            // Verificar se não tem nada uma linha depois na mesma posição da coluna (em baixo do navio)
            if ( l <= 8 && ( !arenaC[l+1][c].equals(" ") || !arenaC[l+1][c+1].equals(" ") || !arenaC[l+1][c+2].equals(" ")))
            {
                saida = 0;
            }
        } 
        arenaC[l][c] = "S";
        arenaC[l][c+1] = "S";
        arenaC[l][c+2] = "S";
        
        
        
        // Destroier 1 - 2 posições: 
        saida = 0;
        while (saida == 0) 
        {          
            l = gera.nextInt(10);
            c = gera.nextInt(9);
            
            if ((arenaC[l][c].equals(" ")) && (arenaC[l][c+1].equals(" ")))
            {
                saida = 1;
            }
            // Verificar se não tem nada uma coluna a esquerda e uma coluna a direita (dos lados do navio)
            if ((c >= 1 && !arenaC[l][c-1].equals(" ")) || (c <=6 && !arenaC[l][c+2].equals(" ")))
            {
                saida = 0;
            }
            // Verificar se não tem nada uma linha anterior na mesma posição da coluna (em cima do navio)
            if ( l >= 1 && ( !arenaC[l-1][c].equals(" ") || !arenaC[l-1][c+1].equals(" ")))
            {
                saida = 0;
            }
            // Verificar se não tem nada uma linha depois na mesma posição da coluna (em baixo do navio)
            if ( l <= 8 && ( !arenaC[l+1][c].equals(" ") || !arenaC[l+1][c+1].equals(" ")))
            {
                saida = 0;
            }
        }
        arenaC[l][c] = "D";
        arenaC[l][c+1] = "D";
        
        // Destroier 2 - 2 posições: 
        saida = 0;
        while (saida == 0) 
        {          
            l = gera.nextInt(10);
            c = gera.nextInt(9);
            
            if ((arenaC[l][c].equals(" ")) && (arenaC[l][c+1].equals(" ")))
            {
                saida = 1;
            }
            // Verificar se não tem nada uma coluna a esquerda e uma coluna a direita (dos lados do navio)
            if ((c >= 1 && !arenaC[l][c-1].equals(" ")) || (c <=6 && !arenaC[l][c+2].equals(" ")))
            {
                saida = 0;
            }
            // Verificar se não tem nada uma linha anterior na mesma posição da coluna (em cima do navio)
            if ( l >= 1 && ( !arenaC[l-1][c].equals(" ") || !arenaC[l-1][c+1].equals(" ")))
            {
                saida = 0;
            }
            // Verificar se não tem nada uma linha depois na mesma posição da coluna (em baixo do navio)
            if ( l <= 8 && ( !arenaC[l+1][c].equals(" ") || !arenaC[l+1][c+1].equals(" ")))
            {
                saida = 0;
            }
        }
        arenaC[l][c] = "D";
        arenaC[l][c+1] = "D";
       
        // Destroier 3 - 2 posições: 
        saida = 0;
        while (saida == 0) 
        {          
            l = gera.nextInt(10);
            c = gera.nextInt(9);
            
            if ((arenaC[l][c].equals(" ")) && (arenaC[l][c+1].equals(" ")))
            {
                saida = 1;
            }
            // Verificar se não tem nada uma coluna a esquerda e uma coluna a direita (dos lados do navio)
            if ((c >= 1 && !arenaC[l][c-1].equals(" ")) || (c <=6 && !arenaC[l][c+2].equals(" ")))
            {
                saida = 0;
            }
            // Verificar se não tem nada uma linha anterior na mesma posição da coluna (em cima do navio)
            if ( l >= 1 && ( !arenaC[l-1][c].equals(" ") || !arenaC[l-1][c+1].equals(" ")))
            {
                saida = 0;
            }
            // Verificar se não tem nada uma linha depois na mesma posição da coluna (em baixo do navio)
            if ( l <= 8 && ( !arenaC[l+1][c].equals(" ") || !arenaC[l+1][c+1].equals(" ")))
            {
                saida = 0;
            }
        }
        arenaC[l][c] = "D";
        arenaC[l][c+1] = "D";
        
        
        // Bote 1 - 1 posição:
        saida = 0;
        while (saida == 0) 
        {          
            l = gera.nextInt(10);
            c = gera.nextInt(10);

            if ((arenaC[l][c].equals(" ")))
            {
                saida = 1;
            }
            // Verificar se não tem nada uma coluna a esquerda e uma coluna a direita (dos lados do navio)
            if ( (c >= 1 && (!arenaC[l][c-1].equals(" ")) || (c <= 8 && !arenaC[l][c+1].equals(" "))))
            {
                saida = 0;
            }
            // Verificar se não tem nada uma linha anterior na mesma posição da coluna (em cima do navio)
            if ( l >= 1 && ( !arenaC[l-1][c].equals(" ")))
            {
                saida = 0;
            }
            // Verificar se não tem nada uma linha depois na mesma posição da coluna (em baixo do navio)
            if ( l <= 8 && ( !arenaC[l+1][c].equals(" ")))
            {
                saida = 0;
            }
        }
        arenaC[l][c] = "B";
        
        // Bote 2 - 1 posição:
        saida = 0;
        while (saida == 0) 
        {          
            l = gera.nextInt(10);
            c = gera.nextInt(10);

            if ((arenaC[l][c].equals(" ")))
            {
                saida = 1;
            }
            // Verificar se não tem nada uma coluna a esquerda e uma coluna a direita (dos lados do navio)
            if ( (c >= 1 && (!arenaC[l][c-1].equals(" ")) || (c <= 8 && !arenaC[l][c+1].equals(" "))))
            {
                saida = 0;
            }
            // Verificar se não tem nada uma linha anterior na mesma posição da coluna (em cima do navio)
            if ( l >= 1 && ( !arenaC[l-1][c].equals(" ")))
            {
                saida = 0;
            }
            // Verificar se não tem nada uma linha depois na mesma posição da coluna (em baixo do navio)
            if ( l <= 8 && ( !arenaC[l+1][c].equals(" ")))
            {
                saida = 0;
            }
        }
        arenaC[l][c] = "B";
        
        // Bote 3 - 1 posição: 
        saida = 0;
        while (saida == 0) 
        {          
            l = gera.nextInt(10);
            c = gera.nextInt(10);

            if ((arenaC[l][c].equals(" ")))
            {
                saida = 1;
            }
            // Verificar se não tem nada uma coluna a esquerda e uma coluna a direita (dos lados do navio)
            if ( (c >= 1 && (!arenaC[l][c-1].equals(" ")) || (c <= 8 && !arenaC[l][c+1].equals(" "))))
            {
                saida = 0;
            }
            // Verificar se não tem nada uma linha anterior na mesma posição da coluna (em cima do navio)
            if ( l >= 1 && ( !arenaC[l-1][c].equals(" ")))
            {
                saida = 0;
            }
            // Verificar se não tem nada uma linha depois na mesma posição da coluna (em baixo do navio)
            if ( l <= 8 && ( !arenaC[l+1][c].equals(" ")))
            {
                saida = 0;
            }
        }
        arenaC[l][c] = "B";
         
        // Bote 4 - 1 posição: 
        saida = 0;
        while (saida == 0) 
        {          
            l = gera.nextInt(10);
            c = gera.nextInt(10);

            if ((arenaC[l][c].equals(" ")))
            {
                saida = 1;
            }
            // Verificar se não tem nada uma coluna a esquerda e uma coluna a direita (dos lados do navio)
            if ( (c >= 1 && (!arenaC[l][c-1].equals(" ")) || (c <= 8 && !arenaC[l][c+1].equals(" "))))
            {
                saida = 0;
            }
            // Verificar se não tem nada uma linha anterior na mesma posição da coluna (em cima do navio)
            if ( l >= 1 && ( !arenaC[l-1][c].equals(" ")))
            {
                saida = 0;
            }
            // Verificar se não tem nada uma linha depois na mesma posição da coluna (em baixo do navio)
            if ( l <= 8 && ( !arenaC[l+1][c].equals(" ")))
            {
                saida = 0;
            }
        }
        arenaC[l][c] = "B"; 
        
   } 

    private void montaH() {
        // Aqui é onde será montada a arena de humano de acordo com as escolhas das posições dele
        BatalhaNaval f = new BatalhaNaval();
        Scanner leia = new Scanner(System.in);
        f.mostraArenaH();
        System.out.println("====================================================================");
        System.out.println("---------------------- Escolha As Posições -------------------------");
        int l=0, c=0, saida = 0;
        
        // Porta Aviões - 4 casas  
        while (saida == 0)
        {
            System.out.println("====================================================================");
            System.out.println("Digite a linha para o Porta Aviões (tamanho 4 casas) - Linha até 10");
            l = leia.nextInt();
            System.out.println("Digite a coluna para o Porta Aviões (tamanho 4 casas) - Coluna até 7");
            c = leia.nextInt();
            if (((l<1) || (l>10) || (c<1) || (c>7)))
            {
                System.out.println (Vermelho + "[Erro] Digite novamente" + ResetarCor);
            }
            else
            {
                saida = 1;
                arenaH[l-1][c-1] = "P";
                arenaH[l-1][c] = "P";
                arenaH[l-1][c+1] = "P";
                arenaH[l-1][c+2] = "P";
               
            }
        }
        f.mostraArenaH();
        
        // Submarino 1 - 3 casas 
        l = 0;
        c = 0;
        saida = 0;
        while ( saida == 0 )
        {
            System.out.println("==========================================================================");
            System.out.println("Digite a linha para o primeiro Submarino (tamanho 3 casas) - Linha até 10");
            l = leia.nextInt();
            System.out.println("Digite a coluna para o primeiro Submarino (tamanho 3 casas) - Coluna até 8");
            c = leia.nextInt();
            if (((l<1) || (l>10) || (c<1) || (c>8)))
            {
                System.out.println(Vermelho + "*************************************************");
                System.out.println(Vermelho + "[Erro] Linha ou Coluna Inválida! Digite novamente");
                System.out.println(Vermelho + "*************************************************" + ResetarCor);
                saida = 0;
            }
            else
            {
                if( (arenaH[l-1][c-1].equals(" ")) && (arenaH[l-1][c].equals(" ")) && (arenaH[l-1][c+1].equals(" ")))
                {
                    saida = 1;
                }
                if((c >= 2 && !arenaH[l-1][c-2].equals(" ")) || (c <=7 && !arenaH[l-1][c+2].equals(" ")))
                { 
                    // Verificar se não tem nada uma coluna a esquerda e uma coluna a direita
                    System.out.println(Vermelho + "*********************************************");
                    System.out.println(Vermelho + "[Erro] Existe objeto colado! Digite novamente");
                    System.out.println(Vermelho + "*********************************************" + ResetarCor);
                    saida = 0;
                }
                else if( l >= 2 && ( !arenaH[l-2][c-1].equals(" ") || !arenaH[l-2][c].equals(" ") || !arenaH[l-2][c+1].equals(" ")))
                {
                    // Verificar se não tem nada uma linha anterior na mesma posição da coluna
                    System.out.println(Vermelho + "*******************************************************");
                    System.out.println(Vermelho + "[Erro] Existe objeto na linha de cima! Digite novamente");
                    System.out.println(Vermelho + "*******************************************************" + ResetarCor);
                    saida = 0;
                }
                else if( l <= 6 && ( !arenaH[l][c-1].equals(" ") || !arenaH[l][c].equals(" ") || !arenaH[l][c+1].equals(" ")))
                {
                    // Verificar se não tem nada uma linha anterior na mesma posição da coluna
                    System.out.println(Vermelho + "********************************************************");
                    System.out.println(Vermelho + "[Erro] Existe objeto na linha de baixo! Digite novamente");
                    System.out.println(Vermelho + "********************************************************" + ResetarCor);               
                    saida = 0;
                }
            }
        } 
        arenaH[l-1][c-1] = "S";
        arenaH[l-1][c] = "S";
        arenaH[l-1][c+1] = "S"; 
        f.mostraArenaH();
                
        // Submarino 2 - 3 casas
        
        l = 0;
        c = 0;
        saida = 0;
        while ( saida == 0 )
        {
            System.out.println("==========================================================================");
            System.out.println("Digite a linha para o segundo Submarino (tamanho 3 casas) - Linha até 10");
            l = leia.nextInt();
            System.out.println("Digite a coluna para o segundo Submarino (tamanho 3 casas) - Coluna até 8");
            c = leia.nextInt();
            if (((l<1) || (l>10) || (c<1) || (c>8)))
            {
                System.out.println(Vermelho + "*************************************************");
                System.out.println(Vermelho + "[Erro] Linha ou Coluna Inválida! Digite novamente");
                System.out.println(Vermelho + "*************************************************" + ResetarCor);
                saida = 0;
            }
            else
            {
                if( (arenaH[l-1][c-1].equals(" ")) && (arenaH[l-1][c].equals(" ")) && (arenaH[l-1][c+1].equals(" ")))
                {
                    saida = 1;
                }
                if((c >= 2 && !arenaH[l-1][c-2].equals(" ")) || (c <=7 && !arenaH[l-1][c+2].equals(" ")))
                { 
                    // Verificar se não tem nada uma coluna a esquerda e uma coluna a direita
                    System.out.println(Vermelho + "*********************************************");
                    System.out.println(Vermelho + "[Erro] Existe objeto colado! Digite novamente");
                    System.out.println(Vermelho + "*********************************************" + ResetarCor);
                    saida = 0;
                }
                else if( l >= 2 && ( !arenaH[l-2][c-1].equals(" ") || !arenaH[l-2][c].equals(" ") || !arenaH[l-2][c+1].equals(" ")))
                {
                    // Verificar se não tem nada uma linha anterior na mesma posição da coluna
                    System.out.println(Vermelho + "*******************************************************");
                    System.out.println(Vermelho + "[Erro] Existe objeto na linha de cima! Digite novamente");
                    System.out.println(Vermelho + "*******************************************************" + ResetarCor);
                    saida = 0;
                }
                else if( l <= 6 && ( !arenaH[l][c-1].equals(" ") || !arenaH[l][c].equals(" ") || !arenaH[l][c+1].equals(" ")))
                {
                    // Verificar se não tem nada uma linha depois na mesma posição da coluna
                    System.out.println(Vermelho + "********************************************************");
                    System.out.println(Vermelho + "[Erro] Existe objeto na linha de baixo! Digite novamente");
                    System.out.println(Vermelho + "********************************************************" + ResetarCor);               
                    saida = 0;
                }
            }
        } 
        arenaH[l-1][c-1] = "S";
        arenaH[l-1][c] = "S";
        arenaH[l-1][c+1] = "S"; 
        f.mostraArenaH();
        
        // Destroiers:
        
        // Destroier 1 - 2 casas
        
        l = 0;
        c = 0;
        saida = 0;
        while ( saida == 0 )
        {
            System.out.println("==========================================================================");
            System.out.println("Digite a linha para o primeiro Destroier (tamanho 2 casas) - Linha até 10");
            l = leia.nextInt();
            System.out.println("Digite a coluna para o primeiro Destroier (tamanho 2 casas) - Coluna até 9");
            c = leia.nextInt();
            if (((l<1) || (l>10) || (c<1) || (c>9)))
            {
                System.out.println(Vermelho + "*************************************************");
                System.out.println(Vermelho + "[Erro] Linha ou Coluna Inválida! Digite novamente");
                System.out.println(Vermelho + "*************************************************" + ResetarCor);
                saida = 0;
            }
            else
            {
                if( (arenaH[l-1][c-1].equals(" ")) && (arenaH[l-1][c].equals(" ")))
                {
                    saida = 1;
                }
                if((c >= 2 && !arenaH[l-1][c-2].equals(" ")) || (c <=8 && !arenaH[l-1][c+1].equals(" ")))
                { 
                    // Verificar se não tem nada uma coluna a esquerda e uma coluna a direita
                    System.out.println(Vermelho + "*********************************************");
                    System.out.println(Vermelho + "[Erro] Existe objeto colado! Digite novamente");
                    System.out.println(Vermelho + "*********************************************" + ResetarCor);
                    saida = 0;
                }
                else if( l >= 2 && (!arenaH[l-2][c-1].equals(" ") || !arenaH[l-2][c].equals(" ")))
                {
                    // Verificar se não tem nada uma linha anterior na mesma posição da coluna
                    System.out.println(Vermelho + "*******************************************************");
                    System.out.println(Vermelho + "[Erro] Existe objeto na linha de cima! Digite novamente");
                    System.out.println(Vermelho + "*******************************************************" + ResetarCor);
                    saida = 0;
                }
                else if( l <= 8 &&  (!arenaH[l][c-1].equals(" ") || !arenaH[l][c].equals(" ")) )
                {
                    // Verificar se não tem nada uma linha anterior na mesma posição da coluna
                    System.out.println(Vermelho + "********************************************************");
                    System.out.println(Vermelho + "[Erro] Existe objeto na linha de baixo! Digite novamente");
                    System.out.println(Vermelho + "********************************************************" + ResetarCor);               
                    saida = 0;
                }
            }
        } 
        arenaH[l-1][c-1] = "D";
        arenaH[l-1][c] = "D";
        f.mostraArenaH();
        
        // Destroier 2 - 2 casas
        
        l = 0;
        c = 0;
        saida = 0;
        while ( saida == 0 )
        {
            System.out.println("==========================================================================");
            System.out.println("Digite a linha para o segundo Destroier (tamanho 2 casas) - Linha até 10");
            l = leia.nextInt();
            System.out.println("Digite a coluna para o segundo Destroier (tamanho 2 casas) - Coluna até 9");
            c = leia.nextInt();
            if (((l<1) || (l>10) || (c<1) || (c>9)))
            {
                System.out.println(Vermelho + "*************************************************");
                System.out.println(Vermelho + "[Erro] Linha ou Coluna Inválida! Digite novamente");
                System.out.println(Vermelho + "*************************************************" + ResetarCor);
                saida = 0;
            }
            else
            {
                if( (arenaH[l-1][c-1].equals(" ")) && (arenaH[l-1][c].equals(" ")))
                {
                    saida = 1;
                }
                if((c >= 2 && !arenaH[l-1][c-2].equals(" ")) || (c <=8 && !arenaH[l-1][c+1].equals(" ")))
                { 
                    // Verificar se não tem nada uma coluna a esquerda e uma coluna a direita
                    System.out.println(Vermelho + "*********************************************");
                    System.out.println(Vermelho + "[Erro] Existe objeto colado! Digite novamente");
                    System.out.println(Vermelho + "*********************************************" + ResetarCor);
                    saida = 0;
                }
                else if( l >= 2 && (!arenaH[l-2][c-1].equals(" ") || !arenaH[l-2][c].equals(" ")) )
                {
                    // Verificar se não tem nada uma linha anterior na mesma posição da coluna
                    System.out.println(Vermelho + "*******************************************************");
                    System.out.println(Vermelho + "[Erro] Existe objeto na linha de cima! Digite novamente");
                    System.out.println(Vermelho + "*******************************************************" + ResetarCor);
                    saida = 0;
                }
                else if( l <= 8 &&  (!arenaH[l][c-1].equals(" ") || !arenaH[l][c].equals(" ")) )
                {
                    // Verificar se não tem nada uma linha anterior na mesma posição da coluna
                    System.out.println(Vermelho + "********************************************************");
                    System.out.println(Vermelho + "[Erro] Existe objeto na linha de baixo! Digite novamente");
                    System.out.println(Vermelho + "********************************************************" + ResetarCor);               
                    saida = 0;
                }
            }
        } 
        arenaH[l-1][c-1] = "D";
        arenaH[l-1][c] = "D";
        f.mostraArenaH();
        
        // Destroier 3 - 2 casas
        
        l = 0;
        c = 0;
        saida = 0;
        while ( saida == 0 )
        {
            System.out.println("==========================================================================");
            System.out.println("Digite a linha para o terceiro Destroier (tamanho 2 casas) - Linha até 10");
            l = leia.nextInt();
            System.out.println("Digite a coluna para o terceiro Destroier (tamanho 2 casas) - Coluna até 9");
            c = leia.nextInt();
            if (((l<1) || (l>10) || (c<1) || (c>9)))
            {
                System.out.println(Vermelho + "*************************************************");
                System.out.println(Vermelho + "[Erro] Linha ou Coluna Inválida! Digite novamente");
                System.out.println(Vermelho + "*************************************************" + ResetarCor);
                saida = 0;
            }
            else
            {
                if( (arenaH[l-1][c-1].equals(" ")) && (arenaH[l-1][c].equals(" ")))
                {
                    saida = 1;
                }
                if((c >= 2 && !arenaH[l-1][c-2].equals(" ")) || (c <=8 && !arenaH[l-1][c+1].equals(" ")))
                { 
                    // Verificar se não tem nada uma coluna a esquerda e uma coluna a direita
                    System.out.println(Vermelho + "*********************************************");
                    System.out.println(Vermelho + "[Erro] Existe objeto colado! Digite novamente");
                    System.out.println(Vermelho + "*********************************************" + ResetarCor);
                    saida = 0;
                }
                else if( l >= 2 && (!arenaH[l-2][c-1].equals(" ") || !arenaH[l-2][c].equals(" ")))
                {
                    // Verificar se não tem nada uma linha anterior na mesma posição da coluna
                    System.out.println(Vermelho + "*******************************************************");
                    System.out.println(Vermelho + "[Erro] Existe objeto na linha de cima! Digite novamente");
                    System.out.println(Vermelho + "*******************************************************" + ResetarCor);
                    saida = 0;
                }
                else if( l <= 8 &&  (!arenaH[l][c-1].equals(" ") || !arenaH[l][c].equals(" ")) )
                {
                    // Verificar se não tem nada uma linha anterior na mesma posição da coluna
                    System.out.println(Vermelho + "********************************************************");
                    System.out.println(Vermelho + "[Erro] Existe objeto na linha de baixo! Digite novamente");
                    System.out.println(Vermelho + "********************************************************" + ResetarCor);               
                    saida = 0;
                }
            }
        } 
        arenaH[l-1][c-1] = "D";
        arenaH[l-1][c] = "D";
        f.mostraArenaH();
        
        // botes: 
               
        // bote 1 - 1 casa 
        
        l = 0;
        c = 0;
        saida = 0;
        while ( saida == 0 )
        {
            System.out.println("==========================================================================");
            System.out.println("Digite a linha para o primeiro Bote (tamanho 1 casa) - Linha até 10");
            l = leia.nextInt();
            System.out.println("Digite a coluna para o primeiro Bote (tamanho 1 casa) - Coluna até 10");
            c = leia.nextInt();
            if (((l<1) || (l>10) || (c<1) || (c>10)))
            {
                System.out.println(Vermelho + "*************************************************");
                System.out.println(Vermelho + "[Erro] Linha ou Coluna Inválida! Digite novamente");
                System.out.println(Vermelho + "*************************************************" + ResetarCor);
                saida = 0;
            }
            else
            {
                if( (arenaH[l-1][c-1].equals(" ")))
                {
                    saida = 1;
                }
                if( (c >= 2 && !arenaH[l-1][c-2].equals(" ")) || (c <= 8 && !arenaH[l-1][c].equals(" ")) || (c == 10 && !arenaH[l-1][c-2].equals(" ")))
                {
                    // Verificar se não tem nada uma coluna a esquerda e uma coluna a direita
                    saida = 0;
                    System.out.println(Vermelho + "*********************************************");
                    System.out.println(Vermelho + "[Erro] Existe objeto colado! Digite novamente");
                    System.out.println(Vermelho + "*********************************************" + ResetarCor);
                    
                }
                else if( l >= 2 && ( !arenaH[l-2][c-1].equals(" ")))
                {
                    // Verificar se não tem nada uma linha anterior na mesma posição da coluna
                    saida = 0;
                    System.out.println(Vermelho + "*******************************************************");
                    System.out.println(Vermelho + "[Erro] Existe objeto na linha de cima! Digite novamente");
                    System.out.println(Vermelho + "*******************************************************" + ResetarCor);
                }
                else if( l <= 9 && ( !arenaH[l][c-1].equals(" ")))
                {
                    // Verificar se não tem nada uma linha depois na mesma posição da coluna
                    saida = 0;
                    System.out.println(Vermelho + "********************************************************");
                    System.out.println(Vermelho + "[Erro] Existe objeto na linha de baixo! Digite novamente");
                    System.out.println(Vermelho + "********************************************************" + ResetarCor);               
                }
            }
        } 
        arenaH[l-1][c-1] = "B";
        f.mostraArenaH();
                
        // bote 2 - 1 casa
        
        l = 0;
        c = 0;
        saida = 0;
        while ( saida == 0 )
        {
            System.out.println("==========================================================================");
            System.out.println("Digite a linha para o segundo Bote (tamanho 1 casa) - Linha até 10");
            l = leia.nextInt();
            System.out.println("Digite a coluna para o segundo Bote (tamanho 1 casa) - Coluna até 10");
            c = leia.nextInt();
            if (((l<1) || (l>10) || (c<1) || (c>10)))
            {
                System.out.println(Vermelho + "*************************************************");
                System.out.println(Vermelho + "[Erro] Linha ou Coluna Inválida! Digite novamente");
                System.out.println(Vermelho + "*************************************************" + ResetarCor);
                saida = 0;
            }
            else
            {
                if( (arenaH[l-1][c-1].equals(" ")))
                {
                    saida = 1;
                }
                if( (c >= 2 && !arenaH[l-1][c-2].equals(" ")) || (c <= 8 && !arenaH[l-1][c].equals(" ")) || (c == 10 && !arenaH[l-1][c-2].equals(" ")))
                {
                    // Verificar se não tem nada uma coluna a esquerda e uma coluna a direita
                    saida = 0;
                    System.out.println(Vermelho + "*********************************************");
                    System.out.println(Vermelho + "[Erro] Existe objeto colado! Digite novamente");
                    System.out.println(Vermelho + "*********************************************" + ResetarCor);
                    
                }
                else if( l >= 2 && ( !arenaH[l-2][c-1].equals(" ")))
                {
                    // Verificar se não tem nada uma linha anterior na mesma posição da coluna
                    saida = 0;
                    System.out.println(Vermelho + "*******************************************************");
                    System.out.println(Vermelho + "[Erro] Existe objeto na linha de cima! Digite novamente");
                    System.out.println(Vermelho + "*******************************************************" + ResetarCor);
                }
                else if( l <= 9 && ( !arenaH[l][c-1].equals(" ")))
                {
                    // Verificar se não tem nada uma linha depois na mesma posição da coluna
                    saida = 0;
                    System.out.println(Vermelho + "********************************************************");
                    System.out.println(Vermelho + "[Erro] Existe objeto na linha de baixo! Digite novamente");
                    System.out.println(Vermelho + "********************************************************" + ResetarCor);               
                }
            }
        } 
        arenaH[l-1][c-1] = "B";
        f.mostraArenaH();
        
        // bote 3- 1 casa
       
        l = 0;
        c = 0;
        saida = 0;
        while ( saida == 0 )
        {
            System.out.println("==========================================================================");
            System.out.println("Digite a linha para o terceiro Bote (tamanho 1 casa) - Linha até 10");
            l = leia.nextInt();
            System.out.println("Digite a coluna para o terceiro Bote (tamanho 1 casa) - Coluna até 10");
            c = leia.nextInt();
            if (((l<1) || (l>10) || (c<1) || (c>10)))
            {
                System.out.println(Vermelho + "*************************************************");
                System.out.println(Vermelho + "[Erro] Linha ou Coluna Inválida! Digite novamente");
                System.out.println(Vermelho + "*************************************************" + ResetarCor);
                saida = 0;
            }
            else
            {
                if( (arenaH[l-1][c-1].equals(" ")))
                {
                    saida = 1;
                }
                if( (c >= 2 && !arenaH[l-1][c-2].equals(" ")) || (c <= 8 && !arenaH[l-1][c].equals(" ")) || (c == 10 && !arenaH[l-1][c-2].equals(" ")))
                {
                    // Verificar se não tem nada uma coluna a esquerda e uma coluna a direita
                    saida = 0;
                    System.out.println(Vermelho + "*********************************************");
                    System.out.println(Vermelho + "[Erro] Existe objeto colado! Digite novamente");
                    System.out.println(Vermelho + "*********************************************" + ResetarCor);
                    
                }
                else if( l >= 2 && ( !arenaH[l-2][c-1].equals(" ")))
                {
                    // Verificar se não tem nada uma linha anterior na mesma posição da coluna
                    saida = 0;
                    System.out.println(Vermelho + "*******************************************************");
                    System.out.println(Vermelho + "[Erro] Existe objeto na linha de cima! Digite novamente");
                    System.out.println(Vermelho + "*******************************************************" + ResetarCor);
                }
                else if( l <= 9 && ( !arenaH[l][c-1].equals(" ")))
                {
                    // Verificar se não tem nada uma linha depois na mesma posição da coluna
                    saida = 0;
                    System.out.println(Vermelho + "********************************************************");
                    System.out.println(Vermelho + "[Erro] Existe objeto na linha de baixo! Digite novamente");
                    System.out.println(Vermelho + "********************************************************" + ResetarCor);               
                }
            }
        } 
        arenaH[l-1][c-1] = "B";
        f.mostraArenaH();
        
        // bote 4 - 1 casa 
        
        l = 0;
        c = 0;
        saida = 0;
        while ( saida == 0 )
        {
            System.out.println("==========================================================================");
            System.out.println("Digite a linha para o quarto Bote (tamanho 1 casa) - Linha até 10");
            l = leia.nextInt();
            System.out.println("Digite a coluna para o quarto Bote (tamanho 1 casa) - Coluna até 10");
            c = leia.nextInt();
            if (((l<1) || (l>10) || (c<1) || (c>10)))
            {
                System.out.println(Vermelho + "*************************************************");
                System.out.println(Vermelho + "[Erro] Linha ou Coluna Inválida! Digite novamente");
                System.out.println(Vermelho + "*************************************************" + ResetarCor);
                saida = 0;
            }
            else
            {
                if( (arenaH[l-1][c-1].equals(" ")))
                {
                    saida = 1;
                }
                if( (c >= 2 && !arenaH[l-1][c-2].equals(" ")) || (c <= 8 && !arenaH[l-1][c].equals(" ")) || (c == 10 && !arenaH[l-1][c-2].equals(" ")))
                {
                    // Verificar se não tem nada uma coluna a esquerda e uma coluna a direita
                    saida = 0;
                    System.out.println(Vermelho + "*********************************************");
                    System.out.println(Vermelho + "[Erro] Existe objeto colado! Digite novamente");
                    System.out.println(Vermelho + "*********************************************" + ResetarCor);
                    
                }
                else if( l >= 2 && ( !arenaH[l-2][c-1].equals(" ")))
                {
                    // Verificar se não tem nada uma linha anterior na mesma posição da coluna
                    saida = 0;
                    System.out.println(Vermelho + "*******************************************************");
                    System.out.println(Vermelho + "[Erro] Existe objeto na linha de cima! Digite novamente");
                    System.out.println(Vermelho + "*******************************************************" + ResetarCor);
                }
                else if( l <= 9 && ( !arenaH[l][c-1].equals(" ")))
                {
                    // Verificar se não tem nada uma linha depois na mesma posição da coluna
                    saida = 0;
                    System.out.println(Vermelho + "********************************************************");
                    System.out.println(Vermelho + "[Erro] Existe objeto na linha de baixo! Digite novamente");
                    System.out.println(Vermelho + "********************************************************" + ResetarCor);               
                }
            }
        } 
        arenaH[l-1][c-1] = "B";
         
    }       
       
    private void jogar() throws InterruptedException {
        // Depois de já montado as duas arenas começa o jogo em si 
        int ganhadorHumano = 0, ganhadorC = 0, aindaNaoGanhou = 0, ganhador = 0, tiroCertoComputador = 0, linhaAcertoComputador = 0, colunaAcertoComputador = 0;
        Random gera = new Random();
        BatalhaNaval f = new BatalhaNaval();
        Scanner leia = new Scanner(System.in);
        int l = 0, c = 0;
        
        System.out.println("");
        System.out.println("");
        System.out.println(Verde + "=========================================================================" + ResetarCor);
        System.out.println("--------------------------- Vamos Jogar! --------------------------------");
        System.out.println(Verde + "=========================================================================" + ResetarCor);
                   
        while (ganhador == 0)
        {
            // Jogada do Humano
            
            System.out.println ("");
            // Coloquei esse thread sleep pra não ficar tudo tão rapido na tela
            Thread.sleep(2000);
            System.out.println(Azul + "=========================================================================" + ResetarCor);
            System.out.println("----------------------------- Sua Vez! ----------------------------------");
            System.out.println(Azul + "=========================================================================" + ResetarCor);
            System.out.println ("");
            f.tirosArenaC();
            while (ganhadorHumano == 0)
            {
                System.out.println("=========================================================================");
                System.out.println("Digite a posição Linha para atirar - Linha até 10:");
                l = leia.nextInt();
                System.out.println("Digite a posição Coluna para atirar - Coluna até 10:");
                c = leia.nextInt();
                System.out.println("=========================================================================");
                System.out.println("");
                // Verificar se o tiro é válido na arena
                if (((l>=1) && (l<=10) && (c>=1) && (c<=10)))
                {    
                    // Verificar se já dei um tiro no mesmo lugar
                    if(tirosArenaC[l-1][c-1].equals(" ")) 
                    {
                        if (arenaC[l-1][c-1].equals(" "))
                        {
                            tirosArenaC[l-1][c-1] = "A"; // água
                            f.tirosArenaC();
                            break;
                        }
                        else
                        {
                            System.out.println(Azul + "==================== Acertou, jogue novamente! ==========================" + ResetarCor);
                            System.out.println("");
                            tirosArenaC[l-1][c-1] = "X"; // acerto
                            f.tirosArenaC();
                            // Verificar se ganhou
                            aindaNaoGanhou = 0;
                            for (int x=0; x<=9;x++)
                            {
                                for (int y=0;y<=9;y++)
                                {
                                    // Ele percorre todas as posições da Arena do Computador procurandos seus navios
                                    if( !arenaC[x][y].equals(" ") )
                                    {
                                        // Verifico aonde tem um navio que o jogador humano já acertou
                                        if( !tirosArenaC[x][y].equals("X") )
                                        {
                                            aindaNaoGanhou = 1;
                                        }
                                    }
                                }
                            }
                            // Verifica se o Humano acertou todos os navios
                            if(aindaNaoGanhou == 0)
                            {
                                ganhadorHumano = 1;
                                ganhador = 1;
                            }
                        }
                    }
                    else
                    {
                        System.out.println(Vermelho + "***************************************************************************");
                        System.out.println(Vermelho + " [Erro] Já foi realizado um tiro nessa posição, favor escolher outro local!");
                        System.out.println(Vermelho + "***************************************************************************" + ResetarCor);
                        System.out.println("");
                    }
                }
                else
                {
                    System.out.println(Vermelho + "*************************************************");
                    System.out.println(Vermelho + "[Erro] Linha ou Coluna Inválida! Digite novamente");
                    System.out.println(Vermelho + "*************************************************" + ResetarCor);
                    System.out.println("");

                }
                if(ganhador == 1)
                {
                    System.out.println("");
                    System.out.println("=========================================================================");
                    System.out.println("------------------------- P A R A B É N S !------------------------------");
                    System.out.println("=========================================================================");
                    System.out.println("---------------------------- Você Venceu! -------------------------------");
                    System.out.println("=========================================================================");
                    System.out.println(""); 
                }
            }    
            if (ganhador == 0)
            {
                // Acaba while humano e começa a jogada do computador  
                Thread.sleep(2000);
                System.out.println("");
                System.out.println(Amarelo + "=========================================================================" + ResetarCor);
                System.out.println("----------------------- Tiro do Computador ------------------------------");
                System.out.println(Amarelo + "=========================================================================" + ResetarCor);
                System.out.println("");
                // Coloquei um tempo pro computador fazer a jogada, para simular mais ou menos a velocidade de um player
                Thread.sleep(1000);
                tiroCertoComputador = 0;
                linhaAcertoComputador = 0;
                colunaAcertoComputador = 0;
                while (ganhadorC == 0)
                {
                    
                    if( tiroCertoComputador == 0)
                    {
                        // Sorteia o tiro do computador
                        l = gera.nextInt(10);
                        c = gera.nextInt(10); 
                        
                        //Verifica se já jogou na mesma posição
                        while (!tirosArenaH[l][c].equals(" "))
                        {
                            l = gera.nextInt(10);
                            c = gera.nextInt(10); 
                        }
                    }
                    else
                    {
                        //Caso o computador acerte um tiro, ele já vai para a próxima coluna a direita
                        //Senão der, ele vai para a coluna a esquerda
                        l = linhaAcertoComputador;
                        if(colunaAcertoComputador <= 9)
                        {
                            c = colunaAcertoComputador;
                        }
                        else
                        {
                            c = colunaAcertoComputador - 2;
                        }
                        //Verifica se já jogou na mesma posição
                        while (!tirosArenaH[l][c].equals(" "))
                        {
                            l = gera.nextInt(10);
                            c = gera.nextInt(10); 
                        }
                    }
                    
                    if (arenaH[l][c].equals(" "))
                    {
                        tirosArenaH[l][c] = "A"; // água
                        f.tirosArenaH();
                        tiroCertoComputador = 0;
                        break;
                    }
                    else
                    {
                        tirosArenaH[l][c] = "X";// tiro certo
                        System.out.println("");
                        f.tirosArenaH();
                        System.out.println("");
                        System.out.println(Amarelo + "=========== houve um acerto, o computador irá jogar novamente! ==========" + ResetarCor);
                        System.out.println("");
                        Thread.sleep(1000);                    
                        linhaAcertoComputador = l;
                        //Caso o computador acerte um tiro, o próximo lance será no lado direito
                        colunaAcertoComputador = c+1;
                        tiroCertoComputador = 1;
                        //verificar se ganhou
                        aindaNaoGanhou = 0;
                        for (int x=0; x<=9;x++)
                        {
                            for (int y=0;y<=9;y++)
                            {
                                // Ele percorre todas as posições da Arena do Jogador procurandos seus navios
                                if( !arenaH[x][y].equals(" ") )
                                {
                                    // Verifico aonde tem um navio que o Computador ja acertou
                                    if( !tirosArenaH[x][y].equals("X") )
                                    {
                                        aindaNaoGanhou = 1;
                                    }
                                }
                            }
                        }
                        //Verifica se o computador acertou todos os navios
                        if(aindaNaoGanhou == 0)
                        {
                            ganhadorC = 1;
                            ganhador = 1;
                        }
                    }
                }
                if(ganhador == 1)
                {
                    System.out.println("");
                    System.out.println("=========================================================================");
                    System.out.println("--------------------------- Sinto muito! --------------------------------");
                    System.out.println("=========================================================================");
                    System.out.println("------------------------ O Computador Venceu! ---------------------------");
                    System.out.println("=========================================================================");
                    System.out.println("");
                }
            }
        }
   }

    private void tirosArenaH() {
        // Cria arena dos tiros do computador na arena do humano
        String linha = "";
        String cabecalholinha = "   | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10|";
        String divisao  = "===|=======================================|";
        for (int x=0; x<=9;x++)
        {
            if(x+1 < 10)
            {
                linha = (x+1) + "  | ";
            }
            else
            {
                linha = (x+1) + " | ";
            }
            for (int y=0;y<=9;y++)
            {
                linha = linha + tirosArenaH[x][y]+ " | ";
            }
            if( x == 0 ) 
            {
                System.out.println(cabecalholinha);
                System.out.println(divisao);
            }
            System.out.println(linha);
            linha = "";
        }
    
    }

    private void tirosArenaC() {
        // Cria arena dos tiros do humano na arena do computador
        String linha = "";
        String cabecalholinha = "   | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10|";
        String divisao  = "===|=======================================|";
        for (int x=0; x<=9;x++)
        {
            if(x+1 < 10)
            {
                linha = (x+1) + "  | ";
            }
            else
            {
                linha = (x+1) + " | ";
            }
            for (int y=0;y<=9;y++)
            {
                linha = linha + tirosArenaC[x][y]+ " | ";
            }
            if( x == 0 ) 
            {
                System.out.println(cabecalholinha);
                System.out.println(divisao);
            }
            System.out.println(linha);
            linha = "";
        }
    }

    private void iniciar() {
       System.out.println("====================================================================");
       System.out.println("-                                                                  -");       
       System.out.println("-                     BATALHA NAVAL EM JAVA                        -");
       System.out.println("-                                                                  -");       
       System.out.println("-               Desenvolvedor: Samuel Vicentini                    -");
       System.out.println("-                                                                  -");       
       System.out.println("-                     REGRAS IMPORTANTES!                          -");
       System.out.println("-                                                                  -");
       System.out.println("-  1-) Nesse jogo existem quatro tipos de navios: 1 Porta Aviões,  -");
       System.out.println("-      2 Submarinos, 3 Destroiers e 4 Botes.                       -");
       System.out.println("-                                                                  -");
       System.out.println("-  2-) Não é permitido colocar os navios colados um no outro.      -");
       System.out.println("-                                                                  -");
       System.out.println("-  3-) Caso acerte um navio do computador, você poderá jogar nova- -");
       System.out.println("-      mente e assim por diante.                                   -");
       System.out.println("-                                                                  -");
       System.out.println("-  4-) O primeiro a derrubar todos os navios do adversário, vence! -");
       System.out.println("-                                                                  -");
       System.out.println("-                                                                  -");
       System.out.println("-                     BOA SORTE E BOM JOGO!                        -");
       System.out.println("-                                                                  -");
       System.out.println("====================================================================");
       System.out.println("------------------------  Vamos Começar! ---------------------------");
       System.out.println("====================================================================");
       
    }
   
}