package ru.job4j.stream;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ProductLabel {
    public List<String> generateLabels(List<Product> products) {
        return products.stream()
                .filter(Objects::nonNull)
                .filter(product -> (product.getStandard() - product.getActual() > 0)
                        || (product.getStandard() - product.getActual() == 0))
                .filter(product -> (product.getStandard() - product.getActual() < 3)
                        || (product.getStandard() - product.getActual() == 3))
                .map(product -> {
                    Label label = new Label(product.getName(), (float) (product.getPrice() * 0.5));
                    return label;
                })
                .map(label -> label.toString())
                .collect(Collectors.toList());
    }
}