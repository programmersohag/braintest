package com.example.braintest.model.enums;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class PrivacyConverter implements AttributeConverter<Privacy, String> {
    @Override
    public String convertToDatabaseColumn(Privacy privacy) {
        if (privacy == null) {
            return null;
        }
        return privacy.getPrivacy();
    }

    @Override
    public Privacy convertToEntityAttribute(String privacyName) {
        if (privacyName == null) {
            return null;
        }

        return Stream.of(Privacy.values())
                .filter(c -> c.getPrivacy().equals(privacyName))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
