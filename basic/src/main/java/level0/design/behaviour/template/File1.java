package level0.design.behaviour.template;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
@Data
@Builder
public class File1 {
    private Long bizId;
    private String tradeType;
    private BigDecimal amount;
}
