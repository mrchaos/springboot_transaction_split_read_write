package cherry.cworld.awsproxyrds.model;

import io.micrometer.common.lang.NonNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor 
@Getter @Setter @ToString
public class User {
    private String test1;
    @NonNull private String test2;
}
