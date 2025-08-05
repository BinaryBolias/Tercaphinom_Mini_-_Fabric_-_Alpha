package binarybolias.tercaphinom.recipe;


public record IngredientQuota(byte[] quota) {
	/**
	 * @param size
	 * @return a new IngredientQuota of length size with all values set to 1
	 */
	public static IngredientQuota getDefault(int size) {
		IngredientQuota newQuota = new IngredientQuota(new byte[size]);
		
		for (int i = 0; i < size; i++) {
			newQuota.quota[i] = 1;
		}
		
		return newQuota;
	}
}
