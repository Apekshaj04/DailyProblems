class Solution {
    public String validIPAddress(String queryIP) {
        int count1 = 0;
        int count2 = 0;
        for (char c : queryIP.toCharArray()) {
            if (c == ':') {
                count2++;
            } else if (c == '.') {
                count1++;
            }
        }

        if (count1 != 3 && count2 != 7) {
            return "Neither";
        }

        String[] ip1 = queryIP.trim().split("\\.");
        String[] ip2 = queryIP.trim().split(":");
        int n1 = ip1.length;
        int n2 = ip2.length;

        if (n1 == 4) {
            for (int i = 0; i < n1; i++) {
                String word = ip1[i];
                if (word.length() == 0 || word.length() > 3) return "Neither";
                for (int j = 0; j < word.length(); j++) {
                    if (!Character.isDigit(word.charAt(j))) {
                        return "Neither";
                    }
                }
                if (word.length() > 1 && word.charAt(0) == '0') {
                    return "Neither";
                }
                int num = Integer.parseInt(word);
                if (num < 0 || num > 255) {
                    return "Neither";
                }
            }
            return "IPv4";
        } else if (n2 == 8) {
            for (int i = 0; i < n2; i++) {
                String word = ip2[i];
                if (word.length() < 1 || word.length() > 4) return "Neither";
                for (int j = 0; j < word.length(); j++) {
                    char c = word.charAt(j);
                    if (!(Character.isDigit(c) || (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F'))) {
                        return "Neither";
                    }
                }
            }
            return "IPv6";
        } else {
            return "Neither";
        }
    }
}
