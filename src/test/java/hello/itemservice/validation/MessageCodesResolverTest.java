package hello.itemservice.validation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.validation.DefaultMessageCodesResolver;
import org.springframework.validation.MessageCodesResolver;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class MessageCodesResolverTest {
    MessageCodesResolver codesResolver = new DefaultMessageCodesResolver();
    
    @Test
    void messageCodesResolverObject() {
        String[] messageCodes = codesResolver.resolveMessageCodes("required", "item");

        System.out.println("Arrays.toString(messageCodes) = " + Arrays.toString(messageCodes));
        // 포함 및 순서까지.
        assertThat(messageCodes).containsExactly("required.item", "required");
    }
    
    @Test
    void messageCodesResolverField() {
        String[] messageCodes = codesResolver.resolveMessageCodes("required", "item", "itemName", String.class);
        System.out.println("Arrays.toString(messageCodes) = " + Arrays.toString(messageCodes));
        assertThat(messageCodes).containsExactly("required.item.itemName", "required.itemName", "required.java.lang.String", "required");
    }
}
