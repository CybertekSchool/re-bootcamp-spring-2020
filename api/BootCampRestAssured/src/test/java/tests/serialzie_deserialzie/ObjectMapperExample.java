package tests.serialzie_deserialzie;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;
import tests.pojo.Spartan;
import tests.pojo.SpartanPojo;

import java.io.File;
import java.io.IOException;
import java.util.List;


public class ObjectMapperExample {

    @Test
    public void test1() throws IOException {

        String data = "{ \n" +
                "   \"id\" : 123 ,\n" +
                "  \"name\"   : \"Sample name\",\n" +
                "  \"gender\" : \"Male\",\n" +
                "  \"phone\"  : 1931231231\n" +
                "}" ;
        System.out.println(data);


        ObjectMapper mapper = new ObjectMapper();
        SpartanPojo sp = mapper.readValue(data, SpartanPojo.class);
        System.out.println("sp = " + sp);

        SpartanPojo sp1 = mapper.readValue(new File("data.json"), SpartanPojo.class);
        System.out.println("sp1 = " + sp1);

        File jsonArrayFile = new File("all_data.json");
        // This will return list of LinkedHashmap
        List sps = mapper.readValue(jsonArrayFile, List.class);
        System.out.println("sps = " + sps);
        System.out.println("sps.get(0).getClass() = " + sps.get(0).getClass());

        // This will return List of Spartan
        List<SpartanPojo> allSpartans = mapper.readValue(jsonArrayFile, new TypeReference<List<SpartanPojo> >() { } ) ;
        System.out.println("allSpartans = " + allSpartans);



        //-------- write object to json

        System.out.println( "sp1 as Json String " +  mapper.writeValueAsString(sp1)  );


        // ------- write with pretty print
        String str1 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(sp1);
        System.out.println("pretty json = " + str1);

        // --- enable the pretty print globally
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        String str1Pretty = mapper.writeValueAsString(sp1);
        System.out.println("str1Pretty = " + str1Pretty);



        // -------- write to a json file

        mapper.writeValue(new File("sp1.json"), sp1);


    }




}
