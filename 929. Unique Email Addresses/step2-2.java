class Solution {
    // 時間O(NM) N:配列の要素数、M:文字列の最大長
    public int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmails = new HashSet<>();
        for (String email : emails) {
            StringBuilder formattedEmail = new StringBuilder();
            for (int i = 0; i < email.length(); i++) {
                char c = email.charAt(i);
                if (c == '.') {
                    continue;
                } else if (c == '+' || c == '@') {
                    break;
                } else {
                    formattedEmail.append(c);
                }
            }
            StringBuilder formattedDomain = new StringBuilder();
            for (int i = email.length() - 1; i >= 0; i--) {
                char c = email.charAt(i);
                formattedDomain.append(c);
                if (c == '@') {
                    break;
                }
            }
            formattedDomain = formattedDomain.reverse();
            formattedEmail.append(formattedDomain);
            uniqueEmails.add(formattedEmail.toString());
        }
        return uniqueEmails.size();
    }
}
