package com.example.hammad.turingecommerceapi.dto;

import com.example.hammad.turingecommerceapi.model.Product;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ProductDto {
    private Integer product_id;
    private String name;
    private String description;
    private Float price;
    private Float discountedPrice;
    private String thumbnail;
    private String image;
    private String image2;
    private Integer display;
    private Integer category_id;
    private Integer department_id;

    public static ProductDto convertToDto(Product product)
    {
        ProductDto productDto = new ProductDto();
        productDto.setProduct_id(product.getProduct_id());
        productDto.setName(product.getName());
        productDto.setDescription(product.getDescription());
        productDto.setPrice(product.getPrice());
        productDto.setDiscountedPrice(product.getDiscountedPrice());
        productDto.setThumbnail(product.getThumbnail());
        productDto.setImage(product.getImage());
        productDto.setImage2(product.getImage2());
        productDto.setDisplay(product.getDisplay());
        productDto.setCategory_id(product.getCategory_id().getCategory_id());
        productDto.setDepartment_id(product.getDepartment_id().getDepartment_id());
        return productDto;
    }

    public static List<ProductDto> convertToDtoList(List<Product> productList)
    {
        List<ProductDto> productDtos = new ArrayList<>();
        if(!productList.isEmpty())
        {
            for (Product p:productList
                 ) {
                   productDtos.add(convertToDto(p));
            }
        }
        return productDtos;
    }
}
