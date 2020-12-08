package ru.itis.dto;
import lombok.*;
@Setter
@Getter
@Builder
@AllArgsConstructor
@Data
@EqualsAndHashCode
@ToString
@NonNull
public class ProductDto {
    private String name;
    private String color;
    private String size;
    private String count;
    private String price;

    public static ProductDto from(ProductDto productDto) {
        return ProductDto.builder()
                .name(productDto.getName())
                .color(productDto.getColor())
                .size(productDto.getSize())
                .count(productDto.getCount())
                .price(productDto.getPrice())
                .build();
    }
}