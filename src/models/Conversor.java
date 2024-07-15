package models;


import com.google.gson.annotations.SerializedName;

public record Conversor(@SerializedName("base_code") String chosenCoin,
                        @SerializedName("target_code") String toConvertCoin,
                        @SerializedName("conversion_result") double amountPrice) {
}
