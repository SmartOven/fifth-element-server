package ru.fifthelementserver.traffic.transaction;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TransactionType {
    HTTP_CLIENT("http_client"),
    DOWNLOAD_MANAGER("download_manager"),
    EXO_PLAYER("exo_player");

    private final String typeString;

    public static TransactionType fromString(String typeString) {
        if (typeString == null) {
            return null;
        }
        for (TransactionType type : TransactionType.values()) {
            if (type.getTypeString().equalsIgnoreCase(typeString)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown transaction type: " + typeString);
    }

    @Override
    public String toString() {
        return typeString;
    }
}