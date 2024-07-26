package Server;

public class Cache {
	 private final String data;
     private final long timestamp;
     
     private static final long CACHE_TIMEOUT = 60000;

     public Cache(String data, long timestamp) {
         this.data = data;
         this.timestamp = timestamp;
     }

     public String getData() {
         return data;
     }

     public boolean isExpired() {
         return System.currentTimeMillis() - timestamp > CACHE_TIMEOUT;
     }
     
}