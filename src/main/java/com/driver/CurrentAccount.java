package com.driver;

public class CurrentAccount extends BankAccount{
    private String tradeLicenseId; //consists of Uppercase English characters only

    //******************Setter*************
    public void setTradeLicenseId(String tradeLicenseId) {
        this.tradeLicenseId = tradeLicenseId;
    }

    //****************Getter******************
    public String getTradeLicenseId() {
        return tradeLicenseId;
    }

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        super(name, balance, 5000);
        this.tradeLicenseId = tradeLicenseId;
        if(balance < 5000)
            throw new Exception("Insufficient Balance");


    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception


        if(!isLicenseValid(tradeLicenseId)){
            if(!isPossibleID(tradeLicenseId))
                throw new Exception("Valid License can not be generated");
            else
                tradeLicenseId = rearrange(tradeLicenseId);
        }
        else {
            this.tradeLicenseId = tradeLicenseId;
        }

    }


    public boolean isLicenseValid(String lcs){
        for(int i = 0; i < lcs.length() - 1; i++){
            if(tradeLicenseId.charAt(i) == tradeLicenseId.charAt(i + 1))
                return false;

        }
        return true;
    }

    public boolean isPossibleID(String lcs){
        int [] freq = new int[26];
        for(int i = 0; i < lcs.length(); i++){
            freq[lcs.charAt(i) - 'A']++;

            if(freq[lcs.charAt(i) - 'A'] >= (lcs.length() + 1) / 2)
                return false;
        }

        return true;

    }
    public String rearrange(String lcs){
        //String res = "";
        int n = lcs.length();
        int [] freq = new int[26];
        char maxOcc = '0';
        int maxFreq = 0;

        for(int i = 0; i < n; i++){
            char ch = lcs.charAt(i);
            freq[ch - 'A']++;

            if(freq[ch - 'A'] > maxFreq){
                maxFreq = freq[ch - 'A'];
                maxOcc = ch;
            }

        }

        char [] res = new char[n];

        int ind = 0;

        while(freq[maxOcc - 'A'] > 0){
            res[ind] = maxOcc;
            ind += 2;
            freq[maxOcc - 'A']--;
        }

        for(int i = 0; i < 26; i++){
            int f = freq[i];

            while(f > 0){
                if(ind >= n)
                    ind = 1;
                res[ind] = (char) (i + 'A');
                ind += 2;
            }
        }




        return String.valueOf(res);
    }

}
