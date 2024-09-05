class Solution {
    // 時間O(NM) N:配列の要素数、M:文字列の最大長
    public int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmails = new HashSet<>();
        for (String email : emails) {
            String[] parts = email.split("@");
            String local = parts[0].replace(".", "").split("\\+")[0];
            String domain = parts[1];
            uniqueEmails.add(local + "@" + domain);
        }
        return uniqueEmails.size();
    }
}
