package colruyt.pcrsejb.util.general;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;  

@Converter(autoApply = true)
public class LocalDateTimeAttributeConverter implements AttributeConverter<LocalDateTime, Date> {
	
    @Override
    public Date convertToDatabaseColumn(LocalDateTime locDate) {  
    	
    	  
    	return (locDate == null ? null : new Date(locDate.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()));
    }

    @Override
    public LocalDateTime convertToEntityAttribute(Date sqlDate) {
    	return (sqlDate == null ? null : Instant.ofEpochMilli(sqlDate.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime());
    }
}