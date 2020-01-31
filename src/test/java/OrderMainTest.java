import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;

class OrderMainTest {

    @Test
    void serializeRecord() throws IOException {
        ObjectMapper mapper = new ObjectMapper()
                .disable(SerializationFeature.FAIL_ON_EMPTY_BEANS)
                .registerModule(new JavaTimeModule())
                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        String json = mapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(new Order(new Product("productName"), BigDecimal.TEN, LocalDate.now()));
        System.err.println(json);
        Order order = mapper.readValue(json, Order.class);
        Assertions.assertNotNull(order);


    }

    @Test
    void showTextblock() {
        var textblock = """
                This is a textblock.

                It is "sort of"   WYSIWYG
                """;

        System.err.println(textblock);
    }
}