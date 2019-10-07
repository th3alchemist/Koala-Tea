package com.KoalaTea.model.restModel;

import java.util.ArrayList;

public class SpoonacularRecipeResponse {

	
	    ArrayList<SpoonacularRecipe> results;
	    private String baseUri;
	    private int offset;
	    private int number;
	    private int totalResults;
	    private int processingTimeMs;
	    private long expires;
	    private boolean isStale;
		public SpoonacularRecipeResponse() {
			super();
			// TODO Auto-generated constructor stub
		}
		public SpoonacularRecipeResponse(ArrayList<SpoonacularRecipe> results, String baseUri, int offset, int number, int totalResults,
				int processingTimeMs, long expires, boolean isStale) {
			super();
			this.results = results;
			this.baseUri = baseUri;
			this.offset = offset;
			this.number = number;
			this.totalResults = totalResults;
			this.processingTimeMs = processingTimeMs;
			this.expires = expires;
			this.isStale = isStale;
		}
		public ArrayList<SpoonacularRecipe> getResults() {
			return results;
		}
		public void setResults(ArrayList<SpoonacularRecipe> results) {
			this.results = results;
		}
		public String getBaseUri() {
			return baseUri;
		}
		public void setBaseUri(String baseUri) {
			this.baseUri = baseUri;
		}
		public int getOffset() {
			return offset;
		}
		public void setOffset(int offset) {
			this.offset = offset;
		}
		public int getNumber() {
			return number;
		}
		public void setNumber(int number) {
			this.number = number;
		}
		public int getTotalResults() {
			return totalResults;
		}
		public void setTotalResults(int totalResults) {
			this.totalResults = totalResults;
		}
		public int getProcessingTimeMs() {
			return processingTimeMs;
		}
		public void setProcessingTimeMs(int processingTimeMs) {
			this.processingTimeMs = processingTimeMs;
		}
		public long getExpires() {
			return expires;
		}
		public void setExpires(long expires) {
			this.expires = expires;
		}
		public boolean isStale() {
			return isStale;
		}
		public void setStale(boolean isStale) {
			this.isStale = isStale;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((baseUri == null) ? 0 : baseUri.hashCode());
			result = prime * result + (int) (expires ^ (expires >>> 32));
			result = prime * result + (isStale ? 1231 : 1237);
			result = prime * result + number;
			result = prime * result + offset;
			result = prime * result + processingTimeMs;
			result = prime * result + ((results == null) ? 0 : results.hashCode());
			result = prime * result + totalResults;
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			SpoonacularRecipeResponse other = (SpoonacularRecipeResponse) obj;
			if (baseUri == null) {
				if (other.baseUri != null)
					return false;
			} else if (!baseUri.equals(other.baseUri))
				return false;
			if (expires != other.expires)
				return false;
			if (isStale != other.isStale)
				return false;
			if (number != other.number)
				return false;
			if (offset != other.offset)
				return false;
			if (processingTimeMs != other.processingTimeMs)
				return false;
			if (results == null) {
				if (other.results != null)
					return false;
			} else if (!results.equals(other.results))
				return false;
			if (totalResults != other.totalResults)
				return false;
			return true;
		}
		@Override
		public String toString() {
			return "wrapper [results=" + results + ", baseUri=" + baseUri + ", offset=" + offset + ", number=" + number
					+ ", totalResults=" + totalResults + ", processingTimeMs=" + processingTimeMs + ", expires="
					+ expires + ", isStale=" + isStale + "]";
		}
}