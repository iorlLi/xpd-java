package level0.thread;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;

import java.util.Objects;


@Slf4j
@Data
public class MainTest {
    public static void main(String[] args) {

        String str = "";
        boolean b = Objects.nonNull(str);
        System.out.println(b);

        boolean notEmpty = ObjectUtils.isNotEmpty(str);
        System.out.println(notEmpty);
    }
}