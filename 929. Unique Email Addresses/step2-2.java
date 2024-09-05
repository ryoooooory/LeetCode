class Solution {
    // 時間O(NM) N:配列の要素数、M:文字列の最大長
    public int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmails = new HashSet<>();
        for (String email : emails) {
            StringBuilder convertedEmail = new StringBuilder();
            for (int i = 0; i < email.length(); i++) {
                char c = email.charAt(i);
                if (c == '.') {
                    continue;
                } else if (c == '+' || c == '@') {
                    break;
                } else {
                    convertedEmail.append(c);
                }
            }
            StringBuilder convertedDomain = new StringBuilder();
            for (int i = email.length() - 1; i >= 0; i--) {
                char c = email.charAt(i);
                convertedDomain.append(c);
                if (c == '@') {
                    break;
                }
            }
            convertedDomain = convertedDomain.reverse();
            convertedEmail.append(convertedDomain);
            uniqueEmails.add(convertedEmail.toString());
        }
        return uniqueEmails.size();
    }
}
