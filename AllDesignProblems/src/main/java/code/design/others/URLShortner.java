package code.design.others;

public class URLShortner {

    public static void main(String[] args) {

        System.out.println(shortUrlToId("z"));

    }

    /**
     * Get the Short URL by converting the id to base62 string
     * 
     * @param id
     *            the id of the url stored in the database
     * @return short url
     */
    public static String idToShortUrl(int id) {
        String digits = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

        if (id <= 0)
            return "0";
        int base = digits.length();
        String hex = "";
        while (id > 0) {
            int digit = id % base;
            hex = digits.charAt(digit) + hex;
            id = id / base;
        }
        return hex;
    }

    public static int shortUrlToId(String shortUrl) {
        String digits = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

        int val = 0;
        for (int i = 0; i < shortUrl.length(); i++) {
            char c = shortUrl.charAt(i);
            int d = digits.indexOf(c);
            val = 62 * val + d;
        }
        return val;
    }

    public static int getDecimal(String hex) {
        String digits = "0123456789ABCDEF";
        hex = hex.toUpperCase();
        int val = 0;
        for (int i = 0; i < hex.length(); i++) {
            char c = hex.charAt(i);
            int d = digits.indexOf(c);
            val = 16 * val + d;
        }
        return val;
    }
}
