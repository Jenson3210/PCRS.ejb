package colruyt.pcrsejb.converter;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import colruyt.pcrsejb.bo.AbstractBo;
import colruyt.pcrsejb.entity.AbstractEntity;

public interface GenericConverter<E extends AbstractEntity, B extends AbstractBo> {
 
   E convertToEntity(B bo);
 
   B convertToBo(E entity);
 
   default List<B> convertToBos(final List<E> entities) {
       return entities.stream()
               .map(this::convertToBo)
               .collect(Collectors.toList());
   }
 
   default List<E> convertToEntities(final List<B> bos) {
       return bos.stream()
               .map(this::convertToEntity)
               .collect(Collectors.toList());
   }
   
   default Set<B> convertToBos(final Set<E> entities) {
       return entities.stream()
               .map(this::convertToBo)
               .collect(Collectors.toSet());
   }
 
   default Set<E> convertToEntities(final Set<B> bos) {
       return bos.stream()
               .map(this::convertToEntity)
               .collect(Collectors.toSet());
   }
   
   
}