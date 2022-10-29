package Connection;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.swing.table.DefaultTableModel;

public class api_nyt {

    public  String get(){
        String salida = "";
        try {
            URL url = new URL("https://api.nytimes.com/svc/topstories/v2/world.json?api-key=gZCwnKSoGDaQlZp10fMh8FUUHAfxeoqc");
            HttpURLConnection c_api = (HttpURLConnection) url.openConnection();
            c_api.setRequestMethod("GET");
            c_api.setRequestProperty("Accept","application/json");

            if(c_api.getResponseCode()==200){


                InputStreamReader entrada = new InputStreamReader(c_api.getInputStream());
                BufferedReader lectura = new BufferedReader(entrada);
                salida = lectura.readLine();
            }else{
                salida = "";
                System.out.println("No se puede conectar con la api: " + c_api.getResponseCode()    );
            }


            c_api.disconnect();
        }catch (IOException ex){
            System.out.println("Error api :" + ex.getMessage());
        }
        return salida;
    }

   public DefaultTableModel leer(){
        DefaultTableModel tabla = new DefaultTableModel();
        try{
            String encabezado[] = {"title", "abstract", "byline", "url"};
            String datos[] = new String[4];
            JSONArray arreglo = new JSONArray(get());
            for (int indice = 0; indice < arreglo.length(); indice ++){
                JSONObject atributo = arreglo.getJSONObject(indice);
                datos[1] = atributo.getString("title");
                datos[2] = atributo.getString("abstract");
                datos[3] = atributo.getString("byline");
                datos[4] = atributo.getString("url");
            }
        }catch(Exception ex){
            System.out.println("Error tabla: " + ex.getMessage());
        }
        return tabla;
    }



}
