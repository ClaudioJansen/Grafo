import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Grafo{
    private static final String FILE_NAME = "cidades.csv"; 
    private static final int MAX_DATA_SIZE = 9;
    private static final int MAX_CITIES_SIZE = 110;
    private static final String COMMA = ",";

    public static double distanciaEuclidiana(double x1, double x2, double y1, double y2){
        double parte1 = Math.pow(x2 - x1, 2);
        double parte2 = Math.pow(y2 - y1, 2);

        return Math.sqrt(parte1+parte2);
    }

    private static boolean nonNull(String linha) {
        return linha != null;
    }

    private static Cidade getCidade(String linha){
        String[] dataArray = new String[MAX_DATA_SIZE];
        dataArray = linha.split(COMMA);
        
        String nome = dataArray[0];
        Double latitude = Double.parseDouble(dataArray[1]);
        Double longitude = Double.parseDouble(dataArray[2]);

        Cidade cidade = new Cidade(nome, latitude, longitude);
        
        return cidade;
    }

    public static void main(String[] args) throws Exception{
        var cidades = new ArrayList<Cidade>();

        try{
            FileReader arq = new FileReader(FILE_NAME);
            BufferedReader readArq = new BufferedReader(arq);
    
            String line = readArq.readLine();

            while (line != null) {
                line = readArq.readLine();
                if(nonNull(line)){
                    Cidade cidade = getCidade(line);
                    cidades.add(cidade);
                }
            }
    
            arq.close();
        } 
        catch (IOException e){
            System.err.printf("Erro na abertura do arquivo: %s.\n",
            e.getMessage());
        }

        int[][] matrizAdjacencia = new int[cidades.size()][cidades.size()];

        for(int i = 0; i < cidades.size(); i++){
            double[] citiesDistance = new double[MAX_CITIES_SIZE];

            for(int j = 0; j < cidades.size(); j++){
                double xA = cidades.get(i).getLatitude();
                double yA = cidades.get(i).getLongitude();
                double xB = cidades.get(j).getLatitude();
                double yB = cidades.get(j).getLongitude();

                citiesDistance[j] = distanciaEuclidiana(xA, xB, yA, yB);

            }   
            
            int[] arrayPositions = new int[4];

            for(int j = 0; j < 4; j++){
                
                double menor = 1000;
                int posicao = 0;

                for(int z = 0; z < citiesDistance.length; z++){
                    if(citiesDistance[z] < menor && citiesDistance[z] != 0){
                        menor = citiesDistance[z];
                        posicao = z;
                    }
                }
                citiesDistance[posicao] = 0;
                arrayPositions[j] = posicao;

            }

            for(int j = 0; j < cidades.size(); j++){
                if(j == arrayPositions[0]){
                    matrizAdjacencia[i][j] = arrayPositions[0];
                }
                else if(j == arrayPositions[1]){
                    matrizAdjacencia[i][j] = arrayPositions[1];
                }
                else if(j == arrayPositions[2]){
                    matrizAdjacencia[i][j] = arrayPositions[2];
                }   
                else if(j == arrayPositions[3]){
                    matrizAdjacencia[i][j] = arrayPositions[3];
                }
                else{
                    matrizAdjacencia[i][j] = 0;
                }
            }

            for(int j = 0; j < 110; j++){
                System.out.print(matrizAdjacencia[i][j] + " ");
            }
            System.out.printf("\n");
            
        }

    }

}
