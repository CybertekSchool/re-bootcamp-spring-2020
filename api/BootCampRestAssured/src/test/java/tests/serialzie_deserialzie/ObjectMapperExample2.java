package tests.serialzie_deserialzie;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;
import tests.pojo.Spartan;
import tests.pojo.SpartanPojo;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class ObjectMapperExample2 {

    @Test
    public void test1() throws IOException {

        SpartanPojo p1 = new SpartanPojo("Jon","Male",1231231231L);
        p1.setId(123);
        Map<String,Object> myDataMap = new LinkedHashMap<>();

        myDataMap.put("success","a spartan is born");
        myDataMap.put("data",p1);

        System.out.println("myDataMap = " + myDataMap);

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT); // pretty print

        String jsonStr = mapper.writeValueAsString(myDataMap) ;
        System.out.println("jsonStr = " + jsonStr);


    }




}
