package mk.ukim.finki.emt.eshop.config;

public class JwtAuthConstants {
    public static final String SECRET = "s3cr3tt0k3n";
    public static final long EXPIRATION_TIME = 864_000_000; // 10 days
    public static final String TOKEN_PREFIX = "Bearer "; //mora da ima prazno mesto megju token i bearer
    public static final String HEADER_STRING = "Authorization";

}
