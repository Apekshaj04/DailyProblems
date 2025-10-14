public class Codec {

    // Encodes a URL to a shortened URL.
    Set<String> set ;
    Map<String,String> map ;
    Codec(){
        set = new HashSet<>();
        map = new HashMap<>();
    }
    public String encode(String longUrl) {
        StringBuilder sb = new StringBuilder();
        String[] array = longUrl.trim().split("/");
        String temp = array[array.length-1];
        sb.append(temp.charAt(0));
        sb.append(temp.charAt(temp.length()-1));
        sb.append(temp.length());
        int vowels = 0;
        int consonents = 0;
        for(char c:temp.toCharArray()){
            if(c=='a'|| c=='e' || c=='i' || c=='o' || c=='u' || c=='A' || c=='E' || c=='I' || c=='O'|| c=='U'){
                vowels++;
            }
            else{
                consonents++;
            }
        }
        sb.append(vowels);
        sb.append(consonents);
        if(!set.contains(sb.toString())){
            set.add(sb.toString());
            map.put(sb.toString(),longUrl);
            return sb.toString();
        }

        for(char ch='a';ch<='z';ch++){
            String t = sb.toString()+ch;
            if(!set.contains(t)){
                set.add(t);
                map.put(t,longUrl);
                return t;
            }
        }
        for(char ch='A';ch<='Z';ch++){
            String t = sb.toString()+ch;
            if(!set.contains(t)){
                set.add(t);
                map.put(t,longUrl);
                return t;
            }
        }
        return "apeksha";
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));