package model.dto;

import lombok.Builder;
import lombok.Data;

@Builder
public record OrderDto(
        Integer id,
        String orderName,
        String orderDescription,
        CustomerDto customer
) {
}
