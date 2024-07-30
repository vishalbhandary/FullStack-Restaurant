package com.vishal.food_catalogue.mapper;
import com.vishal.food_catalogue.dto.FoodItemDTO;
import com.vishal.food_catalogue.entity.FoodItem;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FoodItemMapper {
    FoodItemMapper INSTANCE = Mappers.getMapper(FoodItemMapper.class);
    FoodItem mapFoodItemDTOToFoodItem(FoodItemDTO foodItemDTO);
    FoodItemDTO mapFoodItemToFoodItemDto(FoodItem foodItem);

}
