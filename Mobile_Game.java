import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.ArrayList;

import javax.sound.midi.SysexMessage;


public class Mobile_Game{
    
    // declarando variaveis
    private String titulo, categoria, pagamento, instalar;
    private double pontuacao_media, crescimento_30dias, crescimento_60dias, preco;
    private int colocacao, pontuacao_total, nota_1, nota_2, nota_3, nota_4, nota_5;

    // construtor
    public Mobile_Game(){

        this.SetTitulo("");
        this.SetCategoria("");
        this.SetPagamento("");
        this.SetInstalar("");
        this.SetColocacao(0);
        this.SetPontuacaoTotal(0);
        this.SetNota5(0);
        this.SetNota4(0);
        this.SetNota3(0);
        this.SetNota2(0);
        this.SetNota1(0);
        this.SetPontuacaoMedia(0.0);
        this.SetCrescimento30_dias(0.0);
        this.SetCrescimento60_dias(0.0);
        this.SetPreco(0.0);
    }

    // construtor
    public Mobile_Game(

        String categoria,
        String titulo,
        String pagamento,
        String instalar,
        int colocacao,
        int pontuacao_total,
        double pontuacao_media,
        double crescimento_30dias,
        double crescimento_60dias,
        double preco,
        int nota_5,
        int nota_4,
        int nota_3,
        int nota_2,
        int nota_1
    ){

        this.categoria = categoria;
        this.titulo = titulo;
        this.pagamento = pagamento;
        this.instalar = instalar;
        this.colocacao = colocacao;
        this.pontuacao_total = pontuacao_total;
        this.pontuacao_media = pontuacao_media;
        this.crescimento_30dias = crescimento_30dias;
        this.crescimento_60dias = crescimento_60dias;
        this.preco = preco;
        this.nota_5 = nota_5;
        this.nota_4 = nota_4;
        this.nota_3 = nota_3;
        this.nota_2 = nota_2;
        this.nota_1 = nota_1;

    }
    
    // Gets Protegidos
    public String getTitulo(){
        return this.titulo;
    }

    public String getCategoria(){
        return this.categoria;
    }

    public String getPagamento(){
        return this.pagamento;
    }

    public String getInstalar(){
        return this.instalar;
    }

    public int getColocacao(){
        return this.colocacao;
    }

    public int getPontuacaoTotal(){
        return this.pontuacao_total;
    }

    public int getNota5(){
        return this.nota_5;
    }

    public int getNota4(){
        return this.nota_4;
    }

    public int getNota3(){
        return this.nota_3;
    }

    public int getNota2(){
        return this.nota_2;
    }

    public int getNota1(){
        return this.nota_1;
    }

    public double getPublicacao_media(){
        return this.pontuacao_media;
    }

    public double getCrescimento_30dias(){
        return this.crescimento_30dias;
    }

    public double getCrescimento_60dias(){
        return this.crescimento_60dias;
    }

    public double getPreco(){
        return this.preco;
    }

    // Sets
    public void SetTitulo(String titulo){
        this.titulo = titulo;
    }

    public void SetCategoria(String categoria){
        this.categoria = categoria;
    }

    public void SetPagamento(String Pagamento){
        this.pagamento = pagamento;
    }

    public void SetInstalar(String instalar){
        this.instalar = instalar;
    }

    public void SetColocacao(int colocacao){
        this.colocacao = colocacao;
    }

    public void SetPontuacaoTotal(int pontuacao_total){
        this.pontuacao_total = pontuacao_total;
    }

    public void SetNota5(int nota_5){
        this.nota_5 = nota_5;
    }

    public void SetNota4(int nota_4){
        this.nota_4 = nota_4;
    }

    public void SetNota3(int nota_3){
        this.nota_3 = nota_3;
    }

    public void SetNota2(int nota_2){
        this.nota_2 = nota_2;
    }

    public void SetNota1(int nota_1){
        this.nota_1 = nota_1;
    }

    public void SetPontuacaoMedia(double pontuacao_media){
        this.pontuacao_media = pontuacao_media;
    }

    public void SetCrescimento30_dias(double crescimento_30dias){
        this.crescimento_30dias = crescimento_30dias;
    }

    public void SetCrescimento60_dias(double crescimento_60dias){
        this.crescimento_60dias = crescimento_60dias;
    }

    public void SetPreco(double preco){
        this.preco = preco;
    }
    
    public static void main(String[] args){

        // criando array de objetos
        File arquivo = new File("./android-games.csv");
        ArrayList<Mobile_Game> lista = new ArrayList<>();
        ArrayList<Mobile_Game> best_games = new ArrayList<>();
        ArrayList<Mobile_Game> best_price = new ArrayList<>();
        ArrayList<Mobile_Game> media = new ArrayList<>();
        ArrayList<Mobile_Game> Total = new ArrayList<>();

        
        
        try{    

            // scaneando arquivo
            Scanner entrada = new Scanner(arquivo);

            String linha = new String();
            entrada.nextLine();

            // limpando as variaveis
            while(entrada.hasNext()){

                linha = entrada.nextLine();

                String[] valor = linha.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

                // declarando objeto
                Mobile_Game game = new Mobile_Game();
                
                // convertendo as tipagems
                game.SetColocacao(Integer.parseInt(valor[0]));
                game.SetTitulo(valor[1]);
                game.SetPontuacaoTotal(Integer.parseInt(valor[2]));
                game.SetInstalar(valor[3]);
                game.SetPontuacaoMedia(Double.parseDouble(valor[4]));
                game.SetCrescimento30_dias(Double.parseDouble(valor[5]));
                game.SetCrescimento60_dias(Double.parseDouble(valor[6]));
                game.SetPreco(Double.parseDouble(valor[7]));
                game.SetCategoria(valor[8]);
                game.SetNota5(Integer.parseInt(valor[9]));
                game.SetNota4(Integer.parseInt(valor[10]));
                game.SetNota3(Integer.parseInt(valor[11]));
                game.SetNota2(Integer.parseInt(valor[12]));
                game.SetNota1(Integer.parseInt(valor[13]));
                game.SetPagamento(valor[14]);
                

                // alocando em uma array
                lista.add(game);

            }
        }catch(FileNotFoundException Error){
            System.out.println(Error + "deu ruim!!!!!!!!!!!");
        }

        // anexando em outra variavel
        for(int i = 0; i< lista.size();i=i+1){
            best_games.add(lista.get(i));
            best_price.add(lista.get(i));
            media.add(lista.get(i));
        }

        int x, y;
        int x2, y2;
        int x3, y3;
        int x4, y4;
        int x5, y5;

        System.out.println(lista.size());
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

        ArrayList<Mobile_Game> aux = new ArrayList<Mobile_Game>(best_games);
        ArrayList<Mobile_Game> aux_nota5 = new ArrayList<Mobile_Game>(best_games);
        ArrayList<Mobile_Game> aux_preco = new ArrayList<Mobile_Game>(best_games);
        ArrayList<Mobile_Game> aux_media = new ArrayList<Mobile_Game>(best_games);
        ArrayList<Mobile_Game> aux_total = new ArrayList<Mobile_Game>(best_games);

        System.out.println(aux.size());

        int tam = best_games.size();
        int tam2 = best_games.size();
        int tam3 = best_games.size();
        int tam4 = best_games.size();
        int tam5 = best_games.size();

        for(x = 1; x < tam; x = x + 1){
            
            aux.set(x, best_games.get(x));

            for(y = x - 1; y >= 0 && aux.get(x).getPontuacaoTotal() > best_games.get(y).getPontuacaoTotal(); y = y - 1){
                best_games.set(y + 1, best_games.get(y));
            }

            best_games.set(y + 1, aux.get(x));
        }

        for(x2 = 1; x2 < tam2; x2 = x2 + 1){
            
            aux_nota5.set(x2, best_games.get(x2));

            for(y2 = x2 - 1; y2 >= 0 && aux_nota5.get(x2).getNota5() > best_games.get(y2).getNota5(); y2 = y2 - 1){
                best_games.set(y2 + 1, best_games.get(y2));
            }

            best_games.set(y2 + 1, aux_nota5.get(x2));
        }

        for(x3 = 1; x3 < tam3; x3 = x3 + 1){
            
            aux_preco.set(x3, best_price.get(x3));

            for(y3 = x3 - 1; y3 >= 0 && aux_preco.get(x3).getPreco() > best_price.get(y3).getPreco(); y3 = y3 - 1){
                best_price.set(y3 + 1, best_price.get(y3));
            }

            best_price.set(y3 + 1, aux_preco.get(x3));
        }

        for(x4 = 1; x4 < tam4; x4 = x4 + 1){
            
            aux_media.set(x4, media.get(x4));

            for(y4 = x4 - 1; y4 >= 0 && aux_media.get(x4).getPublicacao_media() > media.get(y4).getPublicacao_media(); y4 = y4 - 1){
                media.set(y4 + 1, media.get(y4));
            }

            media.set(y4 + 1, aux_media.get(x4));
        }
        

            int cont = 1;
            int gameAction = 0;
            int gameCard = 0;
            int gameCassino = 0;
            int gameStrategy = 0;
            int gameArcade = 0;
            int gameCasual = 0;
            int gameAdventure = 0;
            int gameSports = 0;
            int gameRacing = 0;
            int gameSimulation = 0;
            int gameTrivia = 0;
            int gameBoard = 0;
            int gamePuzzle = 0;
            int gameRolePlaying = 0;
            int gameWord = 0;
            int outros = 0;

            for(int i = 0; i < 200; i = i + 1){

                System.out.println(
                  "Posicao: " + cont + " - Nome: " + best_games.get(i).getTitulo() + " Categoria: - " + best_games.get(i).getCategoria() + " Pontuação Total: - " + best_games.get(i).getPontuacaoTotal()  + " Nota 5: - " + best_games.get(i).getNota5() 
                   
                );

                cont = cont + 1;

                if(best_games.get(i).getCategoria().equals("GAME ACTION")) {
                    gameAction = gameAction + 1;
                } else if(best_games.get(i).getCategoria().equals("GAME STRATEGY")) {
                    gameStrategy = gameStrategy + 1;
                } else if(best_games.get(i).getCategoria().equals("GAME ARCADE")) {
                    gameArcade = gameArcade + 1;
                } else if(best_games.get(i).getCategoria().equals("GAME CASUAL")) {
                    gameCasual = gameCasual + 1;
                } else if(best_games.get(i).getCategoria().equals("GAME ADVENTURE")) {
                    gameAdventure = gameAdventure + 1;
                } else if(best_games.get(i).getCategoria().equals("GAME SPORTS")) {
                    gameSports = gameSports + 1;
                } else if(best_games.get(i).getCategoria().equals("GAME RACING")) {
                    gameRacing = gameRacing + 1;
                } else if(best_games.get(i).getCategoria().equals("GAME SIMULATION")) {
                    gameSimulation = gameSimulation + 1;
                } else if(best_games.get(i).getCategoria().equals("GAME TRIVIA")) {
                    gameTrivia = gameTrivia + 1;
                } else if(best_games.get(i).getCategoria().equals("GAME BOARD")) {
                    gameBoard = gameBoard + 1;
                } else if(best_games.get(i).getCategoria().equals("GAME PUZZLE")) {
                    gamePuzzle = gamePuzzle + 1;
                } else if(best_games.get(i).getCategoria().equals("GAME CARD")){
                    gameCard = gameCard + 1;
                } else if(best_games.get(i).getCategoria().equals("GAME CASINO")){
                    gameCassino = gameCassino + 1;
                } else if(best_games.get(i).getCategoria().equals("GAME ROLE PLAYING")){
                    gameRolePlaying = gameRolePlaying + 1;
                } else if(best_games.get(i).getCategoria().equals("GAME WORD")){
                    gameWord = gameWord + 1;
                } else{
                    outros = outros + 1;
                }
            }

            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

            cont = 1;
            double preco_nulo = 0;
            double preco_dif_zero = 0;
            double total_comercial = 0;

            for(int i = 0; i < 200; i = i + 1){

                System.out.println(
                  "Posicao: " + cont + " - Nome: " + best_price.get(i).getTitulo() + " Preco: - " + best_price.get(i).getPreco()
                   
                );

                if(best_price.get(i).getPreco() != 0){
                    preco_dif_zero = preco_dif_zero + 1;
                }else{
                    preco_nulo = preco_nulo + 1;
                }

                cont = cont + 1;
            }

            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

            
            total_comercial = preco_dif_zero/tam3;

            System.out.println("\n" + 
            "GAME ACTION: " + gameAction + "\n" +
            "GAME STRATEGY: " + gameStrategy + "\n" +
            "GAME ARCADE: " + gameArcade + "\n" +
            "GAME CASUAL: " + gameCasual + "\n" +
            "GAME ADVENTURE: " + gameAdventure + "\n" +
            "GAME CARD: " + gameCard + "\n" +
            "GAME SPORTS: " + gameSports + "\n" +
            "GAME RACING: " + gameRacing + "\n" +
            "GAME SIMULATION: " + gameSimulation + "\n" +
            "GAME TRIVIA: " + gameTrivia + "\n" +
            "GAME BOARD: " + gameBoard + "\n" +
            "GAME CASSINO: " + gameCassino + "\n" +
            "GAME ROLE PLAYING: " + gameRolePlaying + "\n" +
            "GAME WORD: " + gameWord + "\n" +
            "GAME Puzzle: " + gamePuzzle + "\n" +
            "OUTROS: " + outros

            );
        System.out.println("\n" + 
        
        "TOTAL COMERCIAL RELATIVO: " + total_comercial + "\n" +
        "TOTAL GAMES COBRADOS: " + preco_dif_zero + "\n" +
        "TOTAL GAMES NÃO COBRADOS: " + tam3

    );

    
    gameAction = 0;
    gameCard = 0;
    gameCassino = 0;
    gameStrategy = 0;
    gameArcade = 0;
    gameCasual = 0;
    gameAdventure = 0;
    gameSports = 0;
    gameRacing = 0;
    gameSimulation = 0;
    gameTrivia = 0;
    gameBoard = 0;
    gamePuzzle = 0;
    gameRolePlaying = 0;
    gameWord = 0;
    outros = 0;


    cont = 0;

            for(int i = 0; i < 200; i = i + 1){

                cont = cont + 1;

                System.out.println(
                  "Posicao: " + cont + " - Nome: " + media.get(i).getTitulo() + " Publicacao Media: - " + media.get(i).getPublicacao_media() +  " Publicacao Media: - " + media.get(i).getCategoria() 
                   
                );

                if(media.get(i).getCategoria().equals("GAME ACTION")) {
                    gameAction = gameAction + 1;
                } else if(media.get(i).getCategoria().equals("GAME STRATEGY")) {
                    gameStrategy = gameStrategy + 1;
                } else if(media.get(i).getCategoria().equals("GAME ARCADE")) {
                    gameArcade = gameArcade + 1;
                } else if(media.get(i).getCategoria().equals("GAME CASUAL")) {
                    gameCasual = gameCasual + 1;
                } else if(media.get(i).getCategoria().equals("GAME ADVENTURE")) {
                    gameAdventure = gameAdventure + 1;
                } else if(media.get(i).getCategoria().equals("GAME SPORTS")) {
                    gameSports = gameSports + 1;
                } else if(media.get(i).getCategoria().equals("GAME RACING")) {
                    gameRacing = gameRacing + 1;
                } else if(media.get(i).getCategoria().equals("GAME SIMULATION")) {
                    gameSimulation = gameSimulation + 1;
                } else if(media.get(i).getCategoria().equals("GAME TRIVIA")) {
                    gameTrivia = gameTrivia + 1;
                } else if(media.get(i).getCategoria().equals("GAME BOARD")) {
                    gameBoard = gameBoard + 1;
                } else if(media.get(i).getCategoria().equals("GAME PUZZLE")) {
                    gamePuzzle = gamePuzzle + 1;
                } else if(media.get(i).getCategoria().equals("GAME CARD")){
                    gameCard = gameCard + 1;
                } else if(media.get(i).getCategoria().equals("GAME CASINO")){
                    gameCassino = gameCassino + 1;
                } else if(media.get(i).getCategoria().equals("GAME ROLE PLAYING")){
                    gameRolePlaying = gameRolePlaying + 1;
                } else if(media.get(i).getCategoria().equals("GAME WORD")){
                    gameWord = gameWord + 1;
                } else{
                    outros = outros + 1;
                }
            }
                
            System.out.println( "POSICAO DOS GENEROS DOS MELHORES GAMES" + "\n" +
            "GAME ACTION: " + gameAction + "\n" +
            "GAME STRATEGY: " + gameStrategy + "\n" +
            "GAME ARCADE: " + gameArcade + "\n" +
            "GAME CASUAL: " + gameCasual + "\n" +
            "GAME ADVENTURE: " + gameAdventure + "\n" +
            "GAME CARD: " + gameCard + "\n" +
            "GAME SPORTS: " + gameSports + "\n" +
            "GAME RACING: " + gameRacing + "\n" +
            "GAME SIMULATION: " + gameSimulation + "\n" +
            "GAME TRIVIA: " + gameTrivia + "\n" +
            "GAME BOARD: " + gameBoard + "\n" +
            "GAME CASSINO: " + gameCassino + "\n" +
            "GAME ROLE PLAYING: " + gameRolePlaying + "\n" +
            "GAME WORD: " + gameWord + "\n" +
            "GAME Puzzle: " + gamePuzzle + "\n" +
            "OUTROS: " + outros

        );

        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

            
        gameAction = 0;
        gameCard = 0;
        gameCassino = 0;
        gameStrategy = 0;
        gameArcade = 0;
        gameCasual = 0;
        gameAdventure = 0;
        gameSports = 0;
        gameRacing = 0;
        gameSimulation = 0;
        gameTrivia = 0;
        gameBoard = 0;
        gamePuzzle = 0;
        gameRolePlaying = 0;
        gameWord = 0;
        int gameEducational = 0;
        int gameMusic = 0;
        outros = 0;


        cont = 0;


        for(int i = 0; i < media.size(); i = i + 1){

            cont = cont + 1;

            System.out.println(
              "Posicao: " + cont + " - Nome: " + media.get(i).getTitulo() + " Publicacao Media: - " + media.get(i).getPublicacao_media() +  " Publicacao Media: - " + media.get(i).getCategoria() 
               
            );

            if(media.get(i).getCategoria().equals("GAME ACTION")) {
                gameAction = gameAction + 1;
            } else if(media.get(i).getCategoria().equals("GAME STRATEGY")) {
                gameStrategy = gameStrategy + 1;
            } else if(media.get(i).getCategoria().equals("GAME ARCADE")) {
                gameArcade = gameArcade + 1;
            } else if(media.get(i).getCategoria().equals("GAME CASUAL")) {
                gameCasual = gameCasual + 1;
            } else if(media.get(i).getCategoria().equals("GAME ADVENTURE")) {
                gameAdventure = gameAdventure + 1;
            } else if(media.get(i).getCategoria().equals("GAME SPORTS")) {
                gameSports = gameSports + 1;
            } else if(media.get(i).getCategoria().equals("GAME RACING")) {
                gameRacing = gameRacing + 1;
            } else if(media.get(i).getCategoria().equals("GAME SIMULATION")) {
                gameSimulation = gameSimulation + 1;
            } else if(media.get(i).getCategoria().equals("GAME TRIVIA")) {
                gameTrivia = gameTrivia + 1;
            } else if(media.get(i).getCategoria().equals("GAME BOARD")) {
                gameBoard = gameBoard + 1;
            } else if(media.get(i).getCategoria().equals("GAME PUZZLE")) {
                gamePuzzle = gamePuzzle + 1;
            } else if(media.get(i).getCategoria().equals("GAME CARD")){
                gameCard = gameCard + 1;
            } else if(media.get(i).getCategoria().equals("GAME CASINO")){
                gameCassino = gameCassino + 1;
            } else if(media.get(i).getCategoria().equals("GAME ROLE PLAYING")){
                gameRolePlaying = gameRolePlaying + 1;
            } else if(media.get(i).getCategoria().equals("GAME WORD")){
                gameWord = gameWord + 1;
            } else if(media.get(i).getCategoria().equals("GAME EDUCATIONAL")){
                gameEducational = gameEducational + 1;
            } 
            else if(media.get(i).getCategoria().equals("GAME WORD")){
                gameWord = gameWord + 1;
            }else if(media.get(i).getCategoria().equals("GAME MUSIC")){
                gameMusic = gameMusic + 1;
            }
             else{
                outros = outros + 1;
            }
        }


        System.out.println( "AVALIAÇÃO MEDIA TOTAL DOS GAMES REGISTRADOS "+ "\n" +
            "GAME ACTION: " + gameAction + "\n" +
            "GAME STRATEGY: " + gameStrategy + "\n" +
            "GAME ARCADE: " + gameArcade + "\n" +
            "GAME CASUAL: " + gameCasual + "\n" +
            "GAME ADVENTURE: " + gameAdventure + "\n" +
            "GAME CARD: " + gameCard + "\n" +
            "GAME SPORTS: " + gameSports + "\n" +
            "GAME RACING: " + gameRacing + "\n" +
            "GAME SIMULATION: " + gameSimulation + "\n" +
            "GAME TRIVIA: " + gameTrivia + "\n" +
            "GAME BOARD: " + gameBoard + "\n" +
            "GAME CASSINO: " + gameCassino + "\n" +
            "GAME ROLE PLAYING: " + gameRolePlaying + "\n" +
            "GAME WORD: " + gameWord + "\n" +
            "GAME Puzzle: " + gamePuzzle + "\n" +
            "GAME Educational: " + gameEducational + "\n" +
            "GAME Music: " + gameMusic + "\n" +
            "OUTROS: " + outros

        );
    }
        
}

