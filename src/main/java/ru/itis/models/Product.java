package ru.itis.models;

import lombok.*;

@Builder
@Data
@ToString
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Product {
    Long id;
    private String name;
    private String color;
    private String size;
    private String price;
    private String type;
    private String image;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", size='" + size + '\'' +
                ", price='" + price + '\'' +
                ", type='" + type + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
