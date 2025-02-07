package Infosys.Data;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;


public class DataReader {
    public List<HashMap<String, String>> jsondatatomap(String Filepath) throws IOException {
        //read json to string
        ///Users/kumarvaduganathan/Documents/WorkspaceSuhanya/seleniumframework/src/test/java/Infosys/Data/puchaseorder.json
       String jsoncontent= FileUtils.readFileToString(new File(Filepath));
      //String to hasmap Jackson Databind
        ObjectMapper mapper=new ObjectMapper();
        List<HashMap<String,String>>data=mapper.readValue(jsoncontent, new TypeReference<List<HashMap<String,String>>>() {
        });
        return data;
    }
}
