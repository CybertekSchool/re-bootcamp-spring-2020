package tests.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

/**
 * @author : akbar
 * Created At : 7/1/20
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
//@JsonIgnoreProperties(ignoreUnknown = true)
public class Spartan {

    private String name;
    private String gender;
    private long phone;

}
