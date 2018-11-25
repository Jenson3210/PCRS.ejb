package colruyt.pcrsejb.converter;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class ConverterUtils {
 
   protected ConverterUtils() { }
 
   public static <T> void setIfNotNull(final Supplier<T> getter, final Consumer<T> setter) {
 
       T t = getter.get();
 
       if (null != t) {
           setter.accept(t);
       }
   }
}