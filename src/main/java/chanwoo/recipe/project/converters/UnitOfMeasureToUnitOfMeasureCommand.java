package chanwoo.recipe.project.converters;

import chanwoo.recipe.project.commands.UnitOfMeasureCommand;
import chanwoo.recipe.project.domain.UnitOfMeasure;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class UnitOfMeasureToUnitOfMeasureCommand implements Converter<UnitOfMeasure, UnitOfMeasureCommand> {

    @Synchronized
    @Nullable
    @Override
    public UnitOfMeasureCommand convert(UnitOfMeasure source) {
       if(source == null)
           return null;

       UnitOfMeasureCommand unitOfMeasureCommand = new UnitOfMeasureCommand();

       unitOfMeasureCommand.setId(source.getId());
       unitOfMeasureCommand.setDescription(source.getDescription());

       return unitOfMeasureCommand;
    }
}
